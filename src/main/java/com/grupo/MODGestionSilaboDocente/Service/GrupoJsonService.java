package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.GrupoJson;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GrupoJsonService {
    Mono<GrupoJson> save(String json);
    Mono<String> findById(Integer id);
    Mono<GrupoJson> update(Integer id, String json);
    Mono<Void> deleteById(Integer id);
    Flux<GrupoJson> findAll();
}
