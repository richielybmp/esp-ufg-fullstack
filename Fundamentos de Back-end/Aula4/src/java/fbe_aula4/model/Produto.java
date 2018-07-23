/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbe_aula4.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Alunoinf_2
 */
@Entity
@Table(name = "produtos")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "produtos_produtos_id_seq")
public class Produto implements Serializable{
    
    @Id
    @Column(name="produto_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
    private long produtoID;
    
    @Column
    private String nome;
    
    @Column
    private String codigo;
    
    @Column
    private float preco;

    public Produto() {
        // indicador de que o id negativo não foi persistido ainda no hibernate
        produtoID = new Long(-1);
    }

    public Produto(String nome, String codigo, float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public long getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(long produtoID) {
        this.produtoID = produtoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
