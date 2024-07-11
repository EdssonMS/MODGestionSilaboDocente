package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.SilaboUnidadAprendizaje;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SilaboUnidadAprendizajeRepository extends ReactiveCrudRepository<SilaboUnidadAprendizaje, Integer> {
    Flux<SilaboUnidadAprendizaje> findAllByIdSilabo(Integer idSilabo);
    @Query("DELETE FROM silabo_unidad_aprendizaje WHERE ID_SILABO = :id")
    Mono<Void> deleteBySilaboId(Integer id);
}
