package com.example.app.dto;
public class VentaRequest {
    private Long personaId;
    private Long productoId;
    private Long ubicacionId;
    private Integer cantidad;
    public Long getPersonaId(){return personaId;}
    public void setPersonaId(Long personaId){this.personaId=personaId;}
    public Long getProductoId(){return productoId;}
    public void setProductoId(Long productoId){this.productoId=productoId;}
    public Long getUbicacionId(){return ubicacionId;}
    public void setUbicacionId(Long ubicacionId){this.ubicacionId=ubicacionId;}
    public Integer getCantidad(){return cantidad;}
    public void setCantidad(Integer cantidad){this.cantidad=cantidad;}
}
