package com.example.app.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "venta")
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;
    private Integer cantidad;
    private BigDecimal total;
    private LocalDateTime fecha;
    @PrePersist
    public void prePersist(){ this.fecha = LocalDateTime.now(); }
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Persona getPersona(){return persona;}
    public void setPersona(Persona persona){this.persona=persona;}
    public Producto getProducto(){return producto;}
    public void setProducto(Producto producto){this.producto=producto;}
    public Ubicacion getUbicacion(){return ubicacion;}
    public void setUbicacion(Ubicacion ubicacion){this.ubicacion=ubicacion;}
    public Integer getCantidad(){return cantidad;}
    public void setCantidad(Integer cantidad){this.cantidad=cantidad;}
    public BigDecimal getTotal(){return total;}
    public void setTotal(BigDecimal total){this.total=total;}
    public LocalDateTime getFecha(){return fecha;}
    public void setFecha(LocalDateTime fecha){this.fecha=fecha;}
}
