package com.tiendapopaco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfertaRequestDto {
    private Integer idproducto;
    private Double descuento;

}
