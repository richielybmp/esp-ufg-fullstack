/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.Conexao;
import dao.FuncionarioDAO;
import dao.impl.FuncionarioDAOImpl;
import dto.Funcionario;
import java.util.List;

/**
 *
 * @author Alunoinf_2
 */
public class AccessManager{
    
   
    public void excluiFuncionario(String cpf) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
        funcionarioDAO.excluiFuncionario(Conexao.getConnection(), cpf);
    }

    public void adicionaFuncionario(Funcionario funcionario) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
        funcionarioDAO.adicionaFuncionario(Conexao.getConnection(), funcionario);
    }

    public void atualizaFuncionario(Funcionario funcionario) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
        funcionarioDAO.atualizaFuncionario(Conexao.getConnection(), funcionario);
    }

    public Funcionario buscaFuncionario(String cpf) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
        return funcionarioDAO.buscaFuncionario(Conexao.getConnection(), cpf);
    }

    public List<Funcionario> listaFuncionarios() {
       FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
       return funcionarioDAO.listaFuncionarios(Conexao.getConnection());
    }
    
}
