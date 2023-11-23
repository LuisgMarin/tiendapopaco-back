package com.tiendapopaco.controller;


import com.tiendapopaco.dto.OfertaDto;
import com.tiendapopaco.dto.ProductoDto;
import com.tiendapopaco.service.OfertaService;
import com.tiendapopaco.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/oferta")
public class ControllerOferta {

    @Autowired
    private OfertaService ofertaService;

    @GetMapping
    @RequestMapping(value = "/consultar")
    public ResponseEntity<List<OfertaDto>> getAllOferta(){
        ResponseEntity<List<OfertaDto>> response = ofertaService.getAllOferta();
        return response;
    }

    @GetMapping
    @RequestMapping(value = "/consultar/{id}")
    public ResponseEntity<OfertaDto> getOfertaById(@PathVariable Integer id){
        ResponseEntity<OfertaDto> response = ofertaService.getById(id);
        return response;
    }

    @DeleteMapping
    @RequestMapping(value = "/eliminar/{id}")
    public ResponseEntity<String> deleteOferta(@PathVariable Integer id){
        ResponseEntity<String> response = ofertaService.deleteOferta(id);
        return response;
    }
}
