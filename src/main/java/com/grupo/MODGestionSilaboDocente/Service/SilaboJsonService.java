package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.SilaboJson;
import reactor.core.publisher.Mono;

public interface SilaboJsonService {

    Mono<SilaboJson> save(String json);

    Mono<String> findById(Integer id);
}
