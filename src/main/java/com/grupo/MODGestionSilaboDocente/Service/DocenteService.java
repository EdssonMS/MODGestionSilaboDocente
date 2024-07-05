package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.Docente;
import reactor.core.publisher.Mono;

public interface DocenteService {
    Mono<Docente> findById(String id);
}
