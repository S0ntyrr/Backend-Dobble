package com.example.app.dto;
import java.math.BigDecimal;
public class ProductoVentasDTO {
    private Long productoId; private String nombre; private Long totalCantidad; private BigDecimal totalRecaudado;
    public ProductoVentasDTO(Long productoId, String nombre, Long totalCantidad, BigDecimal totalRecaudado){
        this.productoId=productoId; this.nombre=nombre; this.totalCantidad=totalCantidad; this.totalRecaudado=totalRecaudado;
    }
    public Long getProductoId(){return productoId;} public String getNombre(){return nombre;} public Long getTotalCantidad(){return totalCantidad;} public BigDecimal getTotalRecaudado(){return totalRecaudado;}
}
