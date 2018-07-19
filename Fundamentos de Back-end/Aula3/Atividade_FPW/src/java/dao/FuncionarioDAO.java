/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Funcionario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Alunoinf_2
 */
public interface FuncionarioDAO {
    public void excluiFuncionario(Connection conn, String cpf);
    public void adicionaFuncionario(Connection conn, Funcionario funcionario);
    public void atualizaFuncionario(Connection conn, Funcionario funcionario);
    public Funcionario buscaFuncionario(Connection conn, String cpf);
    public List<Funcionario> listaFuncionarios(Connection conn);
}
