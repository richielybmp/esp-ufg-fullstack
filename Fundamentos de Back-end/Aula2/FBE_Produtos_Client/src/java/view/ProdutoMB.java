/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Produto;

/**
 *
 * @author Alunoinf_2
 */
@ManagedBean
public class ProdutoMB {

    /**
     * Creates a new instance of ProdutoMB
     */

    public List<Produto> getEstoqueDeProdutos() {
        Client cli = Client.create();
        WebResource url = cli.resource("http://localhost:8080/FBE_API_Produtos/webresources/produtos");
        String json = url.get(String.class);
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Produto>>() {
        }.getType());
    }

}
