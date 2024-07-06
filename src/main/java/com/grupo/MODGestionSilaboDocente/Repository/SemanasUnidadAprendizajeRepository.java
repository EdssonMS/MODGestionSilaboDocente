package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.SemanasUnidadAprendizaje;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SemanasUnidadAprendizajeRepository extends R2dbcRepository<SemanasUnidadAprendizaje, Integer> {
    Flux<SemanasUnidadAprendizaje> findAllByIdUnidadAprendizaje(Integer idUnidadAprendizaje);
}
