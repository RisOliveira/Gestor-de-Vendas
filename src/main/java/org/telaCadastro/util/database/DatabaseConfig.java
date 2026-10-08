package org.telaCadastro.util.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseConfig {
    public static void inicialize(){
        String sql = "CREATE TABLE IF NOT EXISTS CLIENTE (CLI_ID INT AUTO_INCREMENT PRIMARY KEY,CLI_NOME VARCHAR(255) NOT NULL,CLI_CPF VARCHAR(15) NOT NULL,CLI_TELEFONE VARCHAR(15) NOT NULL,CLI_DTNASC DATE,CLI_EMAIL VARCHAR(255),CLI_RUA VARCHAR(255),CLI_NUMERO VARCHAR(255),CLI_COMPL VARCHAR(255),CLI_BAIRRO VARCHAR(255),CLI_CIDADE VARCHAR(255),CLI_ESTADO VARCHAR(255),CLI_NACIONALIDADE BOOLEAN)";

        try (
                Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
