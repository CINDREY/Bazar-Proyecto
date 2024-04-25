
package com.example.ProyectoBazar.repository;

import com.example.ProyectoBazar.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{

    public List<Producto> findByCantidadDisponibleLessThan(Long cantidadDisponible);
    
}
