package com.tiendapopaco.controller;


import com.tiendapopaco.dto.ProductoDto;
import com.tiendapopaco.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/producto")
public class ControllerProducto {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    @RequestMapping(value = "/crear")
    public ResponseEntity<String> registrarProducto(@RequestBody ProductoDto productoDto){
        ResponseEntity<String> response = productoService.crearProducto(productoDto);
        return response;
    }
    @GetMapping
    @RequestMapping(value = "/consultar")
    public ResponseEntity<List<ProductoDto>> getAllProducto(){
        ResponseEntity<List<ProductoDto>> response = productoService.getAllProducto();
        return response;
    }

    @GetMapping
    @RequestMapping(value = "/consultar/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable Integer id){
        ResponseEntity<ProductoDto> response = productoService.getById(id);
        return response;
    }

    @PostMapping
    @RequestMapping(value = "/editar")
    public ResponseEntity<String> updateProducto(@RequestBody  ProductoDto productoDto){
        ResponseEntity<String> response = productoService.updateProducto(productoDto);
        return response;
    }
    @DeleteMapping
    @RequestMapping(value = "/eliminar/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Integer id){
        ResponseEntity<String> response = productoService.deleteProducto(id);
        return response;
    }
}
