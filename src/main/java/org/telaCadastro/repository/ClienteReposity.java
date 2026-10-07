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
        String sql = "INSERT INTO CLIENTE (CLI_NOME, CLI_CPF, CLI_DTNASC,CLI_TELEFONE, CLI_EMAIL, CLI_RUA, CLI_NUMERO, CLI_COMPL, CLI_BAIRRO, CLI_CIDADE, CLI_ESTADO, CLI_NACIONALIDADE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

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

            stmt.executeUpdate();
        }
        catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!\n" + e);
        }

    }

    public void editar(Cliente cliente){
        String sql = "UPDATE CLIENTE SET CLI_NOME = ?, CLI_CPF = ?, CLI_DATANASC = ?, CLI_TELEFONE = ?, CLI_EMAIL = ?, CLI_RUA = ?, CLI_NUMERO = ?, CLI_COMPL = ?, CLI_BAIRRO = ?, CLI_CIDADE = ?, CLI_ESTADO = ?, CLI_PAIS = ? WHERE ID = ?";
        try (
                Connection conn = ConnectionFactory.getConnection();

                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            // Parametro para identificar cliente
            stmt.setInt(13, (int) cliente.getId());

            // Dados Atualizados
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

        String sql = "SELECT * FROM CLIENTE ORDER BY CLI_NOME LIMIT ?";

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
                cliente.setNome(rs.getString("CLI_NOME"));
                cliente.setCpf(rs.getString("CLI_CPF"));
                cliente.setTelefone(rs.getString("CLI_TELEFONE"));
                cliente.setRua(rs.getString("CLI_RUA"));
                cliente.setNumero(rs.getString("CLI_NUMERO"));
                clientes.add(cliente);

            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os clientes!\n" + e);
            throw new RuntimeException(e);
        }

        return clientes;
    }
}
