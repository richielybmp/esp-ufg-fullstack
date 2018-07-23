/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbe_aula4.dao;

import fbe_aula4.model.Produto;
import java.util.List;

/**
 *
 * @author Alunoinf_2
 */
public interface ProdutoDAO {
    public List<Produto> getProdutos();

    public Produto getProduto(String codigo);

    public boolean removeProduto(String codigo);

    public boolean putProduto(Produto produto);

    public boolean addProduto(Produto novoProduto);
}
