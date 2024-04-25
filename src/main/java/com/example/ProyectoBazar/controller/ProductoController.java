
package com.example.ProyectoBazar.controller;

import com.example.ProyectoBazar.model.Producto;
import com.example.ProyectoBazar.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    private IProductoService prodServ; 
    
    @PostMapping("/productos/crear")
    public void SaveProducto(@RequestBody Producto prod){
        prodServ.saveProducto(prod);
    }
    
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return prodServ.getProductos(); 
    }
    
    @GetMapping("/producto/{codigoProd}")
    public Producto findProducto(@PathVariable Long codigoProd){
        Producto prod = prodServ.findProducto(codigoProd); 
        return prod; 
    }
    
    @DeleteMapping("/productos/eliminar/{codigoProd}")
    public void DeleteProducto(@PathVariable Long codigoProd){
        prodServ.deleteProducto(codigoProd);
    }
    
    @PutMapping("/productos/editar/{codigoProd}")
    public void editProducto(@PathVariable Long codigoProd, 
                             @RequestBody Producto prod){
        Producto prodActual = prodServ.findProducto(codigoProd); 
        prodActual.setNombreProd(prod.getNombreProd());
        prodActual.setMarca(prod.getMarca());
        prodActual.setCosto(prod.getCosto());
        prodActual.setCantidadDisponible(prod.getCantidadDisponible());
        
        prodServ.editProducto(prodActual);
        
    }
    
    @GetMapping("/productos/faltaStock")
    public List<Producto>getProdBajoStock(){
        List<Producto>listaProduBajoStock = prodServ.findProdBajoStock(5L); 
        return listaProduBajoStock;          
    }
    
   
    
}
