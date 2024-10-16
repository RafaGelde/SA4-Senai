package org.example.Interf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao() throws SQLException {

        final String URL = "jdbc:mysql://localhost:3306/primeiraapi";
        final String USER = "root";
        final String PASSWORD = "Rafaelgelde277353";

        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }

}
