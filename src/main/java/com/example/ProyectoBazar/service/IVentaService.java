
package com.example.ProyectoBazar.service;

import com.example.ProyectoBazar.dto.VentaClienteDTO;
import com.example.ProyectoBazar.model.Producto;
import com.example.ProyectoBazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    //CREATE
    public String saveVenta(Venta venta); 
    
    
    //READ
    public List<Venta>getVentas(); 
    
    
    //READ PRODUCTO POR ID: 
    public Venta findVenta(Long id); 
    
    
    //UPDATE
    public void editVenta(Venta venta); 
    
    
    //DELETE
    public void deleteVenta(Long codigoVenta); 
    
    
    public List<Producto>getProductosVenta(Long codigoVenta); 
    
    
    public String sumaDeVentas(String fechaVentaStr); 
    
    
    public VentaClienteDTO datosMayorVenta();
        
    
    
}
