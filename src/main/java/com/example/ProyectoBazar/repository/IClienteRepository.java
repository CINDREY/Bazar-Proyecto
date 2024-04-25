
package com.example.ProyectoBazar.repository;

import com.example.ProyectoBazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
}
