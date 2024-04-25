
package com.example.ProyectoBazar.dto;

import com.example.ProyectoBazar.model.Producto;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaClienteDTO implements Serializable{
    
    private Long codigoVenta; 
    private Double total; 
    private int cantProductos;
    private String nombre;
    private String apellido;
    
    
}
