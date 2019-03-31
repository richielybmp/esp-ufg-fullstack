package com.example.richielybatista.loginauth.servico;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.example.richielybatista.loginauth.R;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class WebTaskBase extends AsyncTask<Void, Void, Void> {

    private static String BASE_URL = "http://private-2bb041-sandromoreira.apiary-mock.com";
    private static int TIMEOUT = 15;
    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_INVALID_REQUEST = 403;

    private Context contexto;
    private String serviceURL;

    private Error error;
    private String responseString;
    private int responseCode;
    private boolean silent;
    private String image;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public WebTaskBase(Context contexto, String serviceURL) {
        this.contexto = contexto;
        this.serviceURL = serviceURL;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        if (!isOnline(contexto)){
            error = new Error(contexto.getString(R.string.error_connection));
            responseString = null;
            return null;
        }

        doRegularCall();

        return null;
    }

    private void doRegularCall() {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, getRequestBody());

        client.setConnectTimeout(TIMEOUT, TimeUnit.SECONDS);
        client.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);

        Request request = new Request.Builder()
                .url(BASE_URL + "/" + serviceURL)
                .post(body)
                .build();

        Response response = null;

        try{
            response = client.newCall(request).execute();
            responseCode = response.code();
            responseString = response.body().string();
        }
        catch (Exception e){
            error = new Error(contexto.getString(R.string.error_connection));
        }
    }

    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if(error!= null && !silent){
            EventBus.getDefault().post(error);
        }
        else{
            switch (getResponseCode()){
                case RESPONSE_OK:
                    try {
                        JSONObject responseJSON = new JSONObject(responseString);
                        String errorMessage = responseJSON.getString("erro");

                        if(!silent){
                            EventBus.getDefault().post(new Error(errorMessage));
                        }
                    } catch (JSONException e) {
                        handleResponse(responseString);
                    } catch (NullPointerException e) {
                        handleResponse("");
                    }
                    break;

                case RESPONSE_INVALID_REQUEST:
                    EventBus.getDefault().post(new Error(contexto.getString(R.string.error_request)));
                    break;
            }
        }
    }

    public abstract String getRequestBody();

    public abstract void handleResponse(String response);

    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Context getContext() {
        return contexto;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public boolean isSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }
}
