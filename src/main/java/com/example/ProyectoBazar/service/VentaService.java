
package com.example.ProyectoBazar.service;

import com.example.ProyectoBazar.dto.VentaClienteDTO;
import com.example.ProyectoBazar.model.Producto;
import com.example.ProyectoBazar.model.Venta;
import com.example.ProyectoBazar.repository.IProductoRepository;
import com.example.ProyectoBazar.repository.IVentaRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
   
    
    @Autowired
    private IVentaRepository ventaRepo;
    
    @Autowired
    private IProductoRepository produRepo; 
    
    @Override
    @Transactional
    public String saveVenta(Venta venta) {
        Venta nuevaVenta = new Venta(); 
        
        nuevaVenta.setCodigoVenta(venta.getCodigoVenta());
        nuevaVenta.setFechaVenta(venta.getFechaVenta());
        nuevaVenta.setTotal(venta.getTotal());
        nuevaVenta.setListaProductos(venta.getListaProductos());
        nuevaVenta.setUnCliente(venta.getUnCliente());
        
         
         for(Producto produ : venta.getListaProductos()){
             Producto productoActualizado = produRepo.findById(produ.getCodigoProd()).orElse(null); 
         
             if(productoActualizado.getCantidadDisponible() < produ.getCantidadDisponible()){
                 return "cantidad insuficiente del producto"; 
             }
             
             productoActualizado.setCantidadDisponible(productoActualizado.getCantidadDisponible() - produ.getCantidadDisponible());
             produRepo.save(productoActualizado);
         
                 
                 }
              
             ventaRepo.save(nuevaVenta); 
             
         return "Venta realizada"; 
    }
            
    

    @Override
    public List<Venta> getVentas() {
        List<Venta>listaVentas= ventaRepo.findAll(); 
        return listaVentas; 
    }

    @Override
    public Venta findVenta(Long id) {
        return ventaRepo.findById(id).orElse(null); 
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta); 
    }

    @Override
    public void deleteVenta(Long codigoVenta) {
        ventaRepo.deleteById(codigoVenta);
        
    }

    @Override
    public List<Producto> getProductosVenta(Long codigoVenta) {
        Venta venta = this.findVenta(codigoVenta); 
        List<Producto>listaProductos = venta.getListaProductos(); 
        return listaProductos; 
    }

    @Override
    public String sumaDeVentas(String fechaVentaStr) {
        LocalDate fechaVenta = LocalDate.parse(fechaVentaStr); 
        
        Double sumaMontos = ventaRepo.sumTotalByFechaVenta(fechaVenta); 
        Integer cantidadVentas = ventaRepo.countByFechaVenta(fechaVenta); 
        
        return "la suma de ventas del día de la fecha fue de: " + sumaMontos +
                " y la cantidad de ventas de: " + cantidadVentas + "en el día"; 
        
        
        }

    @Override
    public VentaClienteDTO datosMayorVenta() {
        Venta ventaMayor = ventaRepo.findFirstByOrderByTotalDesc(); 
        
        if(ventaMayor != null){
            VentaClienteDTO venCliDto = new VentaClienteDTO(); 
            venCliDto.setCodigoVenta(ventaMayor.getCodigoVenta());
            venCliDto.setTotal(ventaMayor.getTotal());
            venCliDto.setCantProductos(ventaMayor.getListaProductos().size());
            venCliDto.setNombre(ventaMayor.getUnCliente().getNombre());
            venCliDto.setApellido(ventaMayor.getUnCliente().getApellido());
            
            return venCliDto; 
            
        } else{
           return null; 
        }
        
    }
    
    
    
    
    
    
        
}
