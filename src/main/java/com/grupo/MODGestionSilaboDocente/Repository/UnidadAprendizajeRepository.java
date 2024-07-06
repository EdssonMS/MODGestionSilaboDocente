package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.UnidadAprendizaje;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UnidadAprendizajeRepository extends ReactiveCrudRepository<UnidadAprendizaje, Integer> {
    Mono<UnidadAprendizaje> findById(Integer id);
}
