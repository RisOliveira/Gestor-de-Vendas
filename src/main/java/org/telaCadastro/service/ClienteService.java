package org.telaCadastro.service;

import javafx.scene.control.Alert;
import org.telaCadastro.model.Cliente;
import org.telaCadastro.repository.ClienteReposity;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    public ClienteService() {
    }

    ClienteReposity clienteReposity = new ClienteReposity();

    public List<String> salvar(Cliente cliente){
        List<String> erros = validar(cliente);

        if (erros.isEmpty()) {
            clienteReposity.salvar(cliente);
        }

        return erros;
    }

    private List<String> validar(Cliente cliente){

        List<String> erros = new ArrayList<>();

        if(cliente.getNome() == null){
            erros.add("O nome do cliente deve ser preenchido.");
        }

        System.out.println(erros);
        return erros;
    }

    public List<Cliente> listar(){
        return clienteReposity.listar();
    }
}
