package com.tiendapopaco.service;

import com.tiendapopaco.dto.OfertaDto;
import com.tiendapopaco.dto.OfertaRequestDto;
import com.tiendapopaco.dto.ProductoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfertaService {
    ResponseEntity<String> crearOferta(OfertaRequestDto ofertaRequestDto);
    ResponseEntity<List<OfertaDto>> getAllOferta();

    ResponseEntity<OfertaDto> getById(Integer id);

    ResponseEntity<String> updateOferta(OfertaRequestDto ofertaRequestDto);

    ResponseEntity<String> deleteOferta(Integer id);

}
