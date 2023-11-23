package com.tiendapopaco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {

    private Integer idproducto;
    private String nombre;
    private String descripcion;
    private String img;
    private Double precio;
}
