
package com.example.ProyectoBazar.controller;

import com.example.ProyectoBazar.dto.VentaClienteDTO;
import com.example.ProyectoBazar.model.Producto;
import com.example.ProyectoBazar.model.Venta;
import com.example.ProyectoBazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService ventaServ; 
    
    
    @PostMapping("/ventas/crear")
    public void saveVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta); 
    }
    
    
    @GetMapping("/ventas")
    public List<Venta>getVentas(){
        List<Venta>ventasTotales = ventaServ.getVentas(); 
        return ventasTotales; 
    }
    
    
    @GetMapping("/ventas/{codigoVenta}")
    public Venta codigoVenta(@PathVariable Long codigoVenta){
        Venta venta = ventaServ.findVenta(codigoVenta);
        return venta; 
    }
    
    
    @DeleteMapping("/ventas/eliminar/{codigoVenta}")
        public void deleteVenta(@PathVariable Long codigoVenta){
            ventaServ.deleteVenta(codigoVenta);
        }
        
    @PutMapping("/ventas/editar/{codigoVenta}")
    public void editVenta(@PathVariable Long codigoVenta,
                          @RequestBody Venta venta){
        Venta ventaEditada = ventaServ.findVenta(codigoVenta);
        ventaEditada.setFechaVenta(venta.getFechaVenta());
        ventaEditada.setTotal(venta.getTotal());
        ventaEditada.setListaProductos(venta.getListaProductos());
        ventaEditada.setUnCliente(venta.getUnCliente());

        ventaServ.editVenta(ventaEditada);
    }
    
    
    @GetMapping("/ventas/productos/{codigoVenta}")
    public List<Producto>getProdVendidos(@PathVariable Long codigoVenta){
    return ventaServ.getProductosVenta(codigoVenta); 
    }
    
    
    @GetMapping("/ventas/fecha")
    public String sumaDeVentas(@RequestParam String fechaVentaStr){
        return ventaServ.sumaDeVentas(fechaVentaStr); 
        
    }
    
    @GetMapping("/ventas/mayorVenta")
    public VentaClienteDTO datosMayorVenta(){
        return ventaServ.datosMayorVenta();
    }
    
    
}
