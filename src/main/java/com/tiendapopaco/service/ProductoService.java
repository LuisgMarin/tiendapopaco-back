package com.tiendapopaco.service;

import com.tiendapopaco.dto.ProductoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductoService {
    ResponseEntity<String> crearProducto(ProductoDto productoDto);
    ResponseEntity<List<ProductoDto>> getAllProducto();

    ResponseEntity<ProductoDto> getById(Integer id);

    ResponseEntity<String> updateProducto(ProductoDto productoDto);

    ResponseEntity<String> deleteProducto(Integer id);

}
