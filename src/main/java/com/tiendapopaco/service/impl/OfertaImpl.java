package com.tiendapopaco.service.impl;

import com.tiendapopaco.dto.OfertaDto;
import com.tiendapopaco.dto.OfertaRequestDto;
import com.tiendapopaco.dto.ProductoDto;
import com.tiendapopaco.model.Oferta;
import com.tiendapopaco.repository.OfertaRepository;
import com.tiendapopaco.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaImpl implements OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    public ResponseEntity<String> crearOferta(OfertaRequestDto ofertaRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<OfertaDto>> getAllOferta() {
        List<Oferta> ofertas = (List<Oferta>) ofertaRepository.findAll();
        List<OfertaDto> ofertaDtos = new ArrayList<>();

        for (Oferta oferta : ofertas) {
            OfertaDto ofertaDto = new OfertaDto();
            ofertaDto.setIdoferta(oferta.getIdoferta());
            ofertaDto.setNombre(oferta.getNombre());

            ProductoDto productoDto = new ProductoDto();
            productoDto.setIdproducto(oferta.getProducto().getIdproducto());
            productoDto.setNombre(oferta.getProducto().getNombre());
            productoDto.setDescripcion(oferta.getProducto().getDescripcion());
            productoDto.setImg(oferta.getProducto().getImg());
            productoDto.setPrecio(oferta.getProducto().getPrecio());

            ofertaDto.setProducto(productoDto);
            ofertaDtos.add(ofertaDto);
        }

        return ResponseEntity.ok(ofertaDtos);
    }

    @Override
    public ResponseEntity<OfertaDto> getById(Integer id) {
        Optional<Oferta> ofertaOptional = ofertaRepository.findByIdoferta(id);
        if (!ofertaOptional.isPresent(  )) {
            return ResponseEntity.notFound().build();
        }

        Oferta oferta = ofertaOptional.get();
        OfertaDto ofertaDto = new OfertaDto();
        ofertaDto.setIdoferta(oferta.getIdoferta());
        ofertaDto.setNombre(oferta.getNombre());

        ProductoDto productoDto = new ProductoDto();
        productoDto.setIdproducto(oferta.getProducto().getIdproducto());
        productoDto.setNombre(oferta.getProducto().getNombre());
        productoDto.setDescripcion(oferta.getProducto().getDescripcion());
        productoDto.setImg(oferta.getProducto().getImg());
        productoDto.setPrecio(oferta.getProducto().getPrecio());

        ofertaDto.setProducto(productoDto);

        return ResponseEntity.ok(ofertaDto);
    }

    @Override
    public ResponseEntity<String> updateOferta(OfertaRequestDto ofertaRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteOferta(Integer id) {
        return null;
    }
}
