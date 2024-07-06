package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.SilaboUnidadAprendizaje;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SilaboUnidadAprendizajeRepository extends ReactiveCrudRepository<SilaboUnidadAprendizaje, Integer> {
    Flux<SilaboUnidadAprendizaje> findAllByIdSilabo(Integer idSilabo);
}
