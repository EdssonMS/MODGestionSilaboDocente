package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.Competencia;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CompetenciaRepository extends ReactiveCrudRepository<Competencia, String> {

    @Query("SELECT c.* FROM COMPETENCIAS c JOIN CURSOS_COMPETENCIAS cc ON c.CODIGO = cc.CODIGO_COMPETENCIA WHERE cc.COD_ASIGNATURA = :codigoCurso")
    Flux<Competencia> findByCursoCodigo(String codigoCurso);

}
