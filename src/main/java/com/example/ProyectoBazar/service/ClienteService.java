
package com.example.ProyectoBazar.service;

import com.example.ProyectoBazar.model.Cliente;
import com.example.ProyectoBazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository clienteRepo; 

    @Override
    public void saveCiente(Cliente cli) {
        clienteRepo.save(cli); 
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente>listaClientes = clienteRepo.findAll(); 
        return listaClientes; 
    }

    @Override
    public void editCliente(Cliente cli) {
        this.saveCiente(cli);
    }

    @Override
    public void deleteCliente(Long idCliente) {
        clienteRepo.deleteById(idCliente);
    }

    @Override
    public Cliente findCliente(Long idCliente) {
        return clienteRepo.findById(idCliente).orElse(null); 
        
    }
    
}
