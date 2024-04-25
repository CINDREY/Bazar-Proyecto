
package com.example.ProyectoBazar.controller;

import com.example.ProyectoBazar.model.Cliente;
import com.example.ProyectoBazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienServ; 
    
    @PostMapping("/clientes/crear")
    public void saveCliente(@RequestBody Cliente cli){
      clienServ.saveCiente(cli);
    }
    
    
    @GetMapping("/clientes")
    public List<Cliente>getClientes(){
        List<Cliente>listaClientes = clienServ.getClientes(); 
        return listaClientes; 
    }
    
    @GetMapping("/clientes/{idCliente}")
    public Cliente findCliente(@PathVariable Long idCliente){
        Cliente cli = clienServ.findCliente(idCliente); 
        return cli; 
    }
    
    
    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public void deleteCliente(@PathVariable Long idCliente){
        clienServ.deleteCliente(idCliente);
        
    }
    
    
    @PutMapping("/clientes/editar/{idCliente}")
    public void editCliente(@PathVariable Long idCliente,
                            @RequestBody Cliente cli){
        Cliente clienteEditado = clienServ.findCliente(idCliente); 
        clienteEditado.setNombre(cli.getNombre());
        clienteEditado.setApellido(cli.getApellido());
        clienteEditado.setDni(cli.getDni());
        
        this.saveCliente(clienteEditado);
        
    }
    
    
}
