package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.Curso;
import com.grupo.MODGestionSilaboDocente.Repository.CompetenciaRepository;
import com.grupo.MODGestionSilaboDocente.Repository.CursoCompetenciaRepository;
import com.grupo.MODGestionSilaboDocente.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CursoServiceImplement implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoCompetenciaRepository cursoCompetenciaRepository;

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Override
    public Mono<Curso> findById(String id) {
        return cursoRepository.findById(id)
                .flatMap(curso -> {
                    return cursoCompetenciaRepository.findAllByCodAsignatura(id)
                            .flatMap(cursoCompetencia -> competenciaRepository.findById(cursoCompetencia.getCodigoCompetencia()))
                            .collectList()
                            .flatMap(competencias -> {
                                curso.setCompetencias(competencias);
                                return Mono.just(curso);
                            });
                });
    }

}
