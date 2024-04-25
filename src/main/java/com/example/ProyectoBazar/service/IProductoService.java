
package com.example.ProyectoBazar.service;

import com.example.ProyectoBazar.model.Producto;
import java.util.List;

public interface IProductoService {
    
    //CREATE: 
    public void saveProducto(Producto prod); 
    
    //READ:
    public List<Producto>getProductos(); 
    
    //UPDATE:
    public void editProducto(Producto prod); 
    
    //DELETE: 
    public void deleteProducto(Long codigoProd); 
    
    //BUSCAR PRODUCTO POR ID:
    public Producto findProducto(Long codigoProd); 

    //BUSCAR PRODUCTOS CON BAJO STOCK: 
    public List<Producto> findProdBajoStock(Long cantidadDisponible);
    
    
   
    
}
