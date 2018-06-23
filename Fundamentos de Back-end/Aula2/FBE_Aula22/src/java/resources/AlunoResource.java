/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Aluno;

/**
 * REST Web Service
 *
 * @author Alunoinf_2
 */
@Path("alunos")
public class AlunoResource {

    @Context
    private UriInfo context;

    private List<Aluno> alunos;
    
    private Gson gson = new Gson();

    /**
     * Creates a new instance of AlunoResource
     */
    public AlunoResource() {
        alunos = new ArrayList<>(); //vamos criar uma lista
        alunos.add(new Aluno(1, "Ana")); 
        alunos.add(new Aluno(2, "Bruno"));
    }

    /**
     * Retrieves representation of an instance of resources.AlunoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(alunos);
    }

    @Path("{alunoid}")
    @GET
    @Produces("application/json")
    public String getAluno(@PathParam("alunoid") String id){
        for (Aluno aluno : alunos) {
            if(aluno.getId() == Integer.valueOf(id)){
                return gson.toJson(aluno); 
            }
        }
        return null; 
    }
    
    /**
     * PUT method for updating or creating an instance of AlunoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
}
