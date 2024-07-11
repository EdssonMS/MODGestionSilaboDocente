package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.CursoCompetencia;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CursoCompetenciaRepository extends ReactiveCrudRepository<CursoCompetencia, Long> {
    Flux<CursoCompetencia> findAllByCodAsignatura(String codAsignatura);
}
