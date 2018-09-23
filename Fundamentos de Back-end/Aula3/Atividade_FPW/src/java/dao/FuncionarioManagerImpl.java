/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.Conexao;
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
public class FuncionarioManagerImpl {

    public static void excluiFuncionario(String cpf) {
        PreparedStatement ps = null;
        Connection conn = Conexao.getConnection();
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

    public static void adicionaFuncionario(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = Conexao.getConnection();
        try {
            String sql = "INSERT INTO funcionarios (nome, cpf, email, nascimento, telefone) values(?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome().trim());
            ps.setString(2, funcionario.getCpf().trim());
            ps.setString(3, funcionario.getEmail().trim());
            ps.setDate(4, funcionario.getNascimento());
            ps.setString(5, funcionario.getTelefone().trim());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            close(null, ps, conn);
        }
    }

    public static void atualizaFuncionario(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = Conexao.getConnection();
        try {
            String sql = "UPDATE funcionarios SET nome=?, email=?, nascimento=?, telefone=? WHERE cpf=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome().trim());
            ps.setString(2, funcionario.getEmail().trim());
            ps.setDate(3, funcionario.getNascimento());
            ps.setString(4, funcionario.getTelefone().trim());
            ps.setString(5, funcionario.getCpf().trim());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            close(null, ps, conn);
        }
    }

    public static Funcionario buscaFuncionario(String cpf){
        Funcionario f = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = Conexao.getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM funcionarios WHERE cpf=?");
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            while (rs.next()) {
                f = new Funcionario();
                f.setNome(rs.getString("nome").trim());
                f.setCpf(rs.getString("cpf").trim());
                f.setNascimento(rs.getDate("nascimento"));
                f.setEmail(rs.getString("email").trim());
                f.setTelefone(rs.getString("telefone").trim());
            }
        } catch (SQLException e) {
        } finally {
            close(rs, ps, conn);
        }
        return f;
    }
    
    public static List<Funcionario> listaFuncionarios() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = Conexao.getConnection();
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM funcionarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome").trim());
                f.setCpf(rs.getString("cpf").trim());
                f.setNascimento(rs.getDate("nascimento"));
                f.setEmail(rs.getString("email").trim());
                f.setTelefone(rs.getString("telefone").trim());
                funcionarios.add(f);
            }
        } catch (SQLException e) {
        } finally {
            close(rs, ps, conn);
        }
        return funcionarios;
    }

    public static void close(ResultSet rs, Statement ps, Connection conn) {
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
