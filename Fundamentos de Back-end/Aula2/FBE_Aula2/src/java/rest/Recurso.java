/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Aluno;

/**
 *
 * @author Alunoinf_2
 */
@Path("alunos")
public class Recurso {
    
    @Path("/todos")
    @GET //import javax.ws.rs.GET; - Acesso via GET!!!
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // qual o tipo de retorno
    public List<Aluno> Alunos(){
        List<Aluno> alunos = new ArrayList<Aluno>();
        
        alunos.add(new Aluno(1, "Ana"));
        alunos.add(new Aluno(2, "Bruno"));
        alunos.add(new Aluno(3, "Carlos"));
        
        return alunos;
    }  
    
    @Path("/sobrenome")
    @POST //import javax.ws.rs.POST; - Acesso via POST!!!
    @Consumes ({"application/json"}) // recebe parametros
    @Produces ({MediaType.APPLICATION_JSON})
    public Response Sobremone(Aluno aluno){
        aluno.setNome(aluno.getNome() + " da Silva");
        return Response.ok(aluno).build();
        //return Response.status(Response.Status.FORBIDDEN).build();
    }
}
