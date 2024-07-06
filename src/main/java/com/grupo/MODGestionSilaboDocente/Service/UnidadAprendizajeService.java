package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.UnidadAprendizaje;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UnidadAprendizajeService {
    Mono<UnidadAprendizaje> save(UnidadAprendizaje unidadAprendizaje);
    Mono<UnidadAprendizaje> findById(Integer id);
    Mono<UnidadAprendizaje> update(Integer id, UnidadAprendizaje unidadAprendizaje);
    Mono<Void> deleteById(Integer id);
    Flux<UnidadAprendizaje> findAll();
}
