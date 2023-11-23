package com.tiendapopaco.repository;

import com.tiendapopaco.model.Oferta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta, String> {

    Optional<Oferta> findByIdoferta(Integer idoferta);

}
