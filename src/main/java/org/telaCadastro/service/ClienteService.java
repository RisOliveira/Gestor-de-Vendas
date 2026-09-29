package org.telaCadastro.service;

import org.telaCadastro.model.Cliente;
import org.telaCadastro.repository.ClienteReposity;

import java.util.List;

public class ClienteService {

    public ClienteService() {
    }

    ClienteReposity clienteReposity = new ClienteReposity();

    public List<Cliente> listar(){
        return clienteReposity.listar();
    }
}
