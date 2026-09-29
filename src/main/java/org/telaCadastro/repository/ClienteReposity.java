package org.telaCadastro.repository;

import org.telaCadastro.model.Cliente;
import org.telaCadastro.util.database.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteReposity {

    public ClienteReposity(){}

    public void salvar(Cliente cliente){
        String sql = "INSERT INTO CLIENTE (NOME, CPF, DATANASC,TELEFONE, EMAIL, RUA, NUMERO, COMPL, BAIRRO, CIDADE, ESTADO, PAIS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDataNasc().toString());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getRua());
            stmt.setString(7, cliente.getNumero());
            stmt.setString(8, cliente.getCompl());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getCidade());
            stmt.setString(11, cliente.getEstado());
            stmt.setBoolean(12, cliente.getPais());
        }
        catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!\n" + e);
        }

    }


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
            JOptionPane.showMessageDialog(null, "Erro ao listar os clientes!\n" + e);
            throw new RuntimeException(e);
        }

        return clientes;
    }
}
