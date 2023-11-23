package com.tiendapopaco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfertaDto {

    private Integer idoferta;
    private String nombre;
    private ProductoDto producto;

}
