/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 
import dto.Funcionario;

/**
 *
 * @author Alunoinf_2
 */
public class FuncionarioDAOImpl implements FuncionarioDAO{

    @Override
    public void excluiFuncionario(Connection conn, String cpf) {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM funcionarios WHERE cpf=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(null, ps, conn);
        }
    }

    @Override
    public void adicionaFuncionario(Connection conn, Funcionario funcionario) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO funcionarios (nome, cpf, email, nascimento, telefone) values(?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEmail());
            ps.setDate(4, funcionario.getNascimento());
            ps.setString(5, funcionario.getTelefone());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            close(null, ps, conn);
        }
    }

    @Override
    public void atualizaFuncionario(Connection conn, Funcionario funcionario) {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE funcionarios SET nome=?, email=?, nascimento=?, telefone=? WHERE cpf=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEmail());
            ps.setDate(3, funcionario.getNascimento());
            ps.setString(4, funcionario.getTelefone());
            ps.setString(5, funcionario.getCpf());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            close(null, ps, conn);
        }
    }

    @Override
    public Funcionario buscaFuncionario(Connection conn, String cpf){
        Funcionario f = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM funcionarios WHERE cpf=?");
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            while (rs.next()) {
                f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setNascimento(rs.getDate("nascimento"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
        } finally {
            close(rs, ps, conn);
        }
        return f;
    }
    
    @Override
    public List<Funcionario> listaFuncionarios(Connection conn) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM funcionarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setNascimento(rs.getDate("nascimento"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                funcionarios.add(f);
            }
        } catch (SQLException e) {
        } finally {
            close(rs, ps, conn);
        }
        return funcionarios;
    }

    private void close(ResultSet rs, Statement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();

            } catch (SQLException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

    }

}
