/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbe_aula4.resources;

import com.google.gson.Gson;
import fbe_aula4.dao.ProdutoDAO;
import fbe_aula4.dao.impl.ProdutoDAOImpl;
import fbe_aula4.model.Produto;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Alunoinf_2
 */
@Path("produtos")
public class ProdutosResource {

    private final ProdutoDAO produtoDAO = new ProdutoDAOImpl();
    Gson gson = new Gson();
    /**
     * Creates a new instance of ProdutosResource
     */
    public ProdutosResource() {
    }

    /**
     * Retrieves representation of an instance of resources.ProdutosResource
     *
     * @return //http://localhost:8080/FBE_Aula3/resources/produtos
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String strProdutos = "";

        try {
            produtos = produtoDAO.getProdutos();
            strProdutos = gson.toJson(produtos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (produtos.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(strProdutos).build();
        }
    }

    @GET
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProdutoPorCodigo(@PathParam("codigo") String codigo) {
        String prod = "";
        Produto produto = new Produto();
        try {
            produto = produtoDAO.getProduto(codigo);
            prod = gson.toJson(produto);
        } catch (Exception e) {
        }

        if (produto.getCodigo().isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(prod).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of ProdutosResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putProduto(String produto) {
        boolean result = false;
        Produto produto_temp = new Produto();
        
        try {
            produto_temp = gson.fromJson(produto, Produto.class);
            result = produtoDAO.putProduto(produto_temp);
        } catch (Exception e) {
        }
        
        if (result) {
            return Response.ok().build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduto(String produto, @Context UriInfo uriInfo){
        boolean result = false;
        URI uri;
        Produto novoProduto = new Produto();
        
        try {
            novoProduto = gson.fromJson(produto, Produto.class);
            result = produtoDAO.addProduto(novoProduto);
        } catch (Exception e) {
        }
        
        if (result) {
            uri = uriInfo.getAbsolutePathBuilder().path(novoProduto.getCodigo()).build();
            return Response.created(uri).build();
        }
        else{
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
        }
    }
    
    @Path("delete/{codigo}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeProduto(@PathParam("codigo") String codigo){
        boolean result = false;
        
        try {
            result = produtoDAO.removeProduto(codigo);
        } catch (Exception e) {
        }
        
        if (result) {
            return Response.ok().build();
        }
        else{
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
        }
    }
}
