
package com.example.ProyectoBazar.repository;

import com.example.ProyectoBazar.model.Venta;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{
    
    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fechaVenta = :fechaVenta")
    Double sumTotalByFechaVenta(LocalDate fechaVenta);
    Integer countByFechaVenta(LocalDate fechaVenta);
    
    Venta findFirstByOrderByTotalDesc(); 
    
}
