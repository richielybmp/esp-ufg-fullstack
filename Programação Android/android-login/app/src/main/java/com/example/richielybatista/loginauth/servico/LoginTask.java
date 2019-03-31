package com.example.richielybatista.loginauth.servico;

import android.content.Context;

import com.example.richielybatista.loginauth.R;
import com.example.richielybatista.loginauth.model.UserModel;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginTask extends WebTaskBase {

    private static String SERVICE_URL = "login";
    private String email;
    private String password;

    public LoginTask(Context contexto, String email, String password) {
        super(contexto, SERVICE_URL);
        this.email = email;
        this.password = password;
    }

    @Override
    public String getRequestBody() {
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("email", email);
        requestMap.put("password", password);

        JSONObject json = new JSONObject(requestMap);
        String jsonString = json.toString();

        return  jsonString;
    }

    @Override
    public void handleResponse(String response) {
        UserModel user = new UserModel();
        try {
            JSONObject responseAsJSON = new JSONObject(response);

            String name = responseAsJSON.getString("name");
            user.setNome(name);

            String token = responseAsJSON.getString("token");
            user.setToken(token);

            String photoUrl = responseAsJSON.getString("photo_url");
            user.setPhotourl(photoUrl);

            // irá disparar onEvent que será capturado pela LoginActivity
            EventBus.getDefault().post(user);
        } catch (JSONException e) {
            if(!isSilent()){
                EventBus.getDefault().post(new Error(getContext().getString(R.string.label_error_invalid_response)));
            }
        }
    }
}
