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
import model.Aluno;

/**
 *
 * @author Alunoinf_2
 */
@ManagedBean
public class AlunosMB {

    /**
     * Creates a new instance of AlunosMB
     */
    public AlunosMB() {
    }

//    public String getAlunosMatriculados(){
//        Client cli = Client.create(); // Para consumir o recurso
//        WebResource webRes =
//            cli.resource("http://localhost:8080/FBE_Aula22/webresources/alunos/");
// }
//        return webRes.get(String.class);
    
    public List<Aluno> getAlunosMatriculados() {
        Client cli = Client.create(); // Para consumir o recurso
        WebResource webRes
                = cli.resource("http://localhost:8080/FBE_Aula22/webresources/alunos/");
        String json = webRes.get(String.class);
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Aluno>>() {
        }.getType());
    }

}
