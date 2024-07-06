package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.UnidadAprendizaje;
import reactor.core.publisher.Mono;

public interface UnidadAprendizajeService {
    Mono<UnidadAprendizaje> findById(Integer id);
    Mono<Void> deleteById(Integer id);
}
