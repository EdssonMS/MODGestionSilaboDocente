package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.*;
import com.grupo.MODGestionSilaboDocente.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SilaboServiceImplement implements SilaboService {

    @Autowired
    private SilaboRepository silaboRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private UnidadAprendizajeRepository unidadAprendizajeRepository;

    @Autowired
    private SemanasUnidadAprendizajeRepository semanasUnidadAprendizajeRepository;

    @Autowired
    private SilaboUnidadAprendizajeRepository silaboUnidadAprendizajeRepository;

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Override
    public Mono<Silabo> findById(Integer id) {
        return silaboRepository.findById(id)
                .flatMap(silabo -> {
                    Mono<Curso> cursoMono = cursoRepository.findById(silabo.getIdAsignatura())
                            .flatMap(curso -> {
                                Flux<Competencia> competenciasFlux = competenciaRepository.findByCursoCodigo(curso.getCodAsignatura());
                                return competenciasFlux.collectList().map(competencias -> {
                                    curso.setCompetencias(competencias);
                                    return curso;
                                });
                            });

                    Mono<Docente> docenteMono = docenteRepository.findById(silabo.getIdDocente());

                    Flux<UnidadAprendizaje> unidadesAprendizajeFlux = silaboUnidadAprendizajeRepository.findAllByIdSilabo(silabo.getId())
                            .flatMap(silaboUnidad -> unidadAprendizajeRepository.findById(silaboUnidad.getIdUnidadAprendizaje())
                                    .flatMap(unidad -> semanasUnidadAprendizajeRepository.findAllByIdUnidadAprendizaje(unidad.getId())
                                            .collectList()
                                            .map(semanas -> {
                                                unidad.setSemanas(semanas);
                                                return unidad;
                                            })
                                    )
                            );

                    return Mono.zip(cursoMono, docenteMono, unidadesAprendizajeFlux.collectList())
                            .flatMap(tuple -> {
                                silabo.setCurso(tuple.getT1());
                                silabo.setDocente(tuple.getT2());
                                silabo.setUnidadesAprendizaje(tuple.getT3());
                                return Mono.just(silabo);
                            });
                });
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return silaboUnidadAprendizajeRepository.deleteBySilaboId(id)
                .then(silaboRepository.deleteById(id));
    }

    @Override
    public Flux<Silabo> findAll() {
        return silaboRepository.findAll();
    }
}