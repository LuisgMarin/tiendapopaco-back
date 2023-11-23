package com.tiendapopaco.service.impl;

import com.tiendapopaco.dto.ProductoDto;
import com.tiendapopaco.model.Producto;
import com.tiendapopaco.repository.ProductoRepository;
import com.tiendapopaco.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ResponseEntity<String> crearProducto(ProductoDto productoDto) {

        try {

            Optional<Producto> productoVerificar =
                    productoRepository.findByIdproducto(productoDto.getIdproducto());
            if (!productoVerificar.isPresent()) {
                Producto producto = new Producto();
                producto.setNombre(productoDto.getNombre());
                producto.setDescripcion(productoDto.getDescripcion());
                producto.setImg(productoDto.getImg());
                producto.setPrecio(productoDto.getPrecio());
                productoRepository.save(producto);
                return ResponseEntity.ok("Se ha creado el candidato");
            }else {
                return ResponseEntity.badRequest().body("El numero de cedula ya existe");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al crear el candidato");
         }

    }

    @Override
    public ResponseEntity<List<ProductoDto>> getAllProducto() {
        List<Producto> list = (List<Producto>) productoRepository.findAll();

        List<ProductoDto> listDtos = new ArrayList<>();

        for(Producto producto : list){
            ProductoDto productoDto = new ProductoDto();
            productoDto.setIdproducto(producto.getIdproducto());
            productoDto.setNombre(producto.getNombre());
            productoDto.setDescripcion(producto.getDescripcion());
            productoDto.setImg(producto.getImg());
            productoDto.setPrecio(producto.getPrecio());
            listDtos.add(productoDto);
        }

        return ResponseEntity.ok(listDtos);
    }

    @Override
    public ResponseEntity<ProductoDto> getById(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findByIdproducto(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            ProductoDto productoDto = new ProductoDto();
            productoDto.setNombre(producto.getNombre());
            productoDto.setDescripcion(producto.getDescripcion());
            productoDto.setImg(producto.getImg());
            productoDto.setPrecio(producto.getPrecio());
            return ResponseEntity.ok(productoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> updateProducto(ProductoDto productoDto) {
        try {
            Optional<Producto> productoVerificar =
                    productoRepository.findByIdproducto(productoDto.getIdproducto());
            if (!productoVerificar.isPresent()) {
                Producto producto = new Producto();
                producto.setNombre(productoDto.getNombre());
                producto.setDescripcion(productoDto.getDescripcion());
                producto.setImg(productoDto.getImg());
                producto.setPrecio(productoDto.getPrecio());
                productoRepository.save(producto);
                return ResponseEntity.ok("Se ha editado el producto");
            }else {
                return ResponseEntity.badRequest().body("El idproduct no existe para editar");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al editar el producto");
        }
    }

    @Override
    public ResponseEntity<String> deleteProducto(Integer id) {
        try {
            if (productoRepository.existsById(String.valueOf(id))) {
                productoRepository.deleteById(String.valueOf(id));
                return ResponseEntity.ok("Producto eliminado exitosamente");
            } else {
                return ResponseEntity.badRequest().body("El idproducto no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el producto");
        }
    }
}
