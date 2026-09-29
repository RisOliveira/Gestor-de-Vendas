package org.telaCadastro.repository;

import org.telaCadastro.model.Cliente;
import org.telaCadastro.util.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteReposity {

    public ClienteReposity(){}

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM CLIENTE ORDER BY NOME LIMIT ?";

        try (
                Connection conn = ConnectionFactory.getConnection();

                PreparedStatement stmt = conn.prepareStatement(sql);
                ){

            // parametro fixado mas futuramente deverá ser feito de forma dinâmica
            stmt.setInt(1,5);

            // Dataframe com o retorno da query
            ResultSet rs = stmt.executeQuery();

            // Enquanto houver próximo ele abastece uma lista de clientes
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));

                clientes.add(cliente);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientes;
    }
}
