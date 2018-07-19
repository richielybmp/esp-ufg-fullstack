package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getLocalizedMessage());
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/ApiFuncionarioDB", "postgres", "1234");

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return connection;
    }

}
