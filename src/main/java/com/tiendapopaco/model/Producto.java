package com.tiendapopaco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "producto")
public class Producto {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name = "idproducto")
   private Integer idproducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "img")
    private String img;

    @Column(name = "precio")
    private Double precio;

    public Producto(){
        super();
    }

}
