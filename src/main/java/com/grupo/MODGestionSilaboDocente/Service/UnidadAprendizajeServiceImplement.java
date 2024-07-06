package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.UnidadAprendizaje;
import com.grupo.MODGestionSilaboDocente.Repository.SemanasUnidadAprendizajeRepository;
import com.grupo.MODGestionSilaboDocente.Repository.UnidadAprendizajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UnidadAprendizajeServiceImplement implements UnidadAprendizajeService {

    @Autowired
    private UnidadAprendizajeRepository unidadAprendizajeRepository;

    @Autowired
    private SemanasUnidadAprendizajeRepository semanasUnidadAprendizajeRepository;

    @Override
    public Mono<UnidadAprendizaje> findById(Integer id) {
        return unidadAprendizajeRepository.findById(id)
                .flatMap(unidad -> semanasUnidadAprendizajeRepository.findAllByIdUnidadAprendizaje(unidad.getId())
                        .collectList()
                        .flatMap(semanas -> {
                            unidad.setSemanas(semanas);
                            return Mono.just(unidad);
                        })
                );
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return unidadAprendizajeRepository.deleteById(id);
    }
}
