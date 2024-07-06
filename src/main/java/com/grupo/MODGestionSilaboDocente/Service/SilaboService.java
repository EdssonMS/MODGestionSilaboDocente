package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.Silabo;
import reactor.core.publisher.Mono;

public interface SilaboService {
    Mono<Silabo> findById(Integer id);
}
