package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.Curso;
import reactor.core.publisher.Mono;

public interface CursoService {
    Mono<Curso> findById(String id);
}

