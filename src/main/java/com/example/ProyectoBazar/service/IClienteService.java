
package com.example.ProyectoBazar.service;


import com.example.ProyectoBazar.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    //CREATE: 
    public void saveCiente(Cliente cli); 
    
    //READ:
    public List<Cliente>getClientes(); 
    
    //UPDATE:
    public void editCliente(Cliente cli); 
    
    //DELETE: 
    public void deleteCliente(Long idCliente); 
    
    //BUSCAR PRODUCTO EN PARTICULAR:
    public Cliente findCliente(Long idCliente); 
}
