package fbe_Aula2;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/alunos")   //define o caminho para o serviço
public class Recurso {
    
    @GET //acesso via get
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aluno> todos(){
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(new Aluno(1, "Japão"));
        alunos.add(new Aluno(2, "Coréia do Sul"));
        return alunos;
    }
    
    @POST //acesso via post
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response nomeCompleto(Aluno aluno){
        //aluno.setNome(aluno.getNome() + " 2018.");
        //return Response.ok().build();
        return Response.ok().build();
        //return Response.status(Response.Status.FORBIDDEN).build();
    }
    
}
