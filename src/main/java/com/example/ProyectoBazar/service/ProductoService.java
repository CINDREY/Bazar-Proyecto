
package com.example.ProyectoBazar.service;

import com.example.ProyectoBazar.model.Producto;
import com.example.ProyectoBazar.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository prodRepo; 

    @Override
    public void saveProducto(Producto prod) {
        prodRepo.save(prod); 
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto>listaProductos = prodRepo.findAll(); 
        return listaProductos; 
    }

    @Override
    public void editProducto(Producto prod) {
        this.saveProducto(prod);
    }

    @Override
    public void deleteProducto(Long codigoProd) {
        prodRepo.deleteById(codigoProd);
      
   }

    @Override
    public Producto findProducto(Long codigoProd) {
        Producto prod = prodRepo.findById(codigoProd).orElse(null); 
        return prod; 
    }

    @Override
    public List<Producto> findProdBajoStock(Long cantidadDisponible) {
        List<Producto>listaProdBajoStock = prodRepo.findByCantidadDisponibleLessThan(5L);
        return listaProdBajoStock; 
    }

    
    
}
