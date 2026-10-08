package org.telaCadastro.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


    private static final String URL = "jdbc:h2:./database/clientes";
    private static final String USUARIO = "root";
    private static final String SENHA = "2507";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }


}
