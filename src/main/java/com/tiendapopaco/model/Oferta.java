package com.tiendapopaco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "oferta")
public class Oferta {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name = "idoferta")
   private Integer idoferta;

    @Column(name = "descuento")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    private Producto producto;

    public Oferta(){
        super();
    }

}
