/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Produto;

/**
 * REST Web Service
 *
 * @author Alunoinf_2
 */
@Path("produtos")
public class ProdutosResource {

    @Context
    private UriInfo context;
    private List<Produto> produtos;
    private Gson gson = new Gson();
    /**
     * Creates a new instance of ProdutosResource
     */
    public ProdutosResource() {
        produtos = new ArrayList<>();
        produtos.add(new Produto("Leite", 01, 2.35));
        produtos.add(new Produto("Refrigerante", 02, 4.5));
        produtos.add(new Produto("Bolacha", 03, 1.75));
        produtos.add(new Produto("Amaciante", 04, 2.50));
        produtos.add(new Produto("Fralda", 05, 25.99));
    }

    /**
     * Retrieves representation of an instance of resources.ProdutosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return gson.toJson(produtos);
    }
    
    @Path("{produtocodigo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAluno(@PathParam("produtocodigo")int codigo){
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return gson.toJson(produto);
            }
        }
        return null;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(Produto produto) {
        produtos.add(produto);
        return gson.toJson(produto);
    }
}
