package com.example.app.model;
import jakarta.persistence.*;
@Entity
@Table(name = "ubicacion")
public class Ubicacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double latitud;
    private Double longitud;
    private String direccion;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public Double getLatitud(){return latitud;}
    public void setLatitud(Double latitud){this.latitud=latitud;}
    public Double getLongitud(){return longitud;}
    public void setLongitud(Double longitud){this.longitud=longitud;}
    public String getDireccion(){return direccion;}
    public void setDireccion(String direccion){this.direccion=direccion;}
}
