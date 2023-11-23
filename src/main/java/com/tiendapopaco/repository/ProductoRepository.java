package com.tiendapopaco.repository;

import com.tiendapopaco.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, String> {

    Optional<Producto> findByIdproducto(Integer idproducto);

}
