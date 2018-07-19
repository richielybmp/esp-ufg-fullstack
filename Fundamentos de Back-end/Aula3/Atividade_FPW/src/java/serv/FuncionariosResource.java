/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.impl.FuncionarioDAOImpl;
import dto.Funcionario;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import manager.AccessManager;

/**
 * REST Web Service
 *
 * @author Alunoinf_2
 */
@Path("funcionarios")
public class FuncionariosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FuncionariosResource
     */
    public FuncionariosResource() {
    }

    /**
     * Retrieves representation of an instance of serv.FuncionariosResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaFuncionarios() {
        List<Funcionario> funcionarios = new AccessManager().listaFuncionarios();
        Gson g = new Gson();
        if (!funcionarios.isEmpty()) {
            return Response.ok(g.toJson(funcionarios)).build();
        } else {
            return Response.ok("null").build();
        }
    }

    @GET
    @Path("{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaFuncionario(@PathParam("cpf") String cpf) {
        Funcionario funcionario = new AccessManager().buscaFuncionario(cpf);
        Gson g = new Gson();
        if (funcionario != null) {
            return Response.ok(g.toJson(funcionario)).build();
        } else {
            return Response.ok("null").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response adicionaFuncionario(String funcionario, @Context UriInfo uriInfo) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Funcionario f = gson.fromJson(funcionario, Funcionario.class);
        if (f != null) {
            new AccessManager().adicionaFuncionario(f);
            return Response.created(uriInfo.getAbsolutePathBuilder().path(f.getCpf()).build()).build();
        } else {
            return Response.noContent().build();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizaFuncionario(String funcionario) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Funcionario f = gson.fromJson(funcionario, Funcionario.class);
        if (f != null) {
            new AccessManager().atualizaFuncionario(f);
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }

    }

    @DELETE
    @Path("{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluiFuncionario(@PathParam("cpf") String cpf) {
        if (!cpf.isEmpty()) {
            new AccessManager().excluiFuncionario(cpf);
            return Response.ok().build();
        } else {
            return Response.ok().build();
        }

    }
}
