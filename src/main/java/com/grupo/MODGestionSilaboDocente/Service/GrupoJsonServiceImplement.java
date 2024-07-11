package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.GrupoJson;
import com.grupo.MODGestionSilaboDocente.Repository.GrupoJsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GrupoJsonServiceImplement implements GrupoJsonService {

    @Autowired
    private GrupoJsonRepository grupoJsonRepository;

    @Override
    public Mono<GrupoJson> save(String json) {
        GrupoJson grupoJson = new GrupoJson();
        grupoJson.setDatos(json);
        return grupoJsonRepository.save(grupoJson);
    }

    @Override
    public Mono<String> findById(Integer id) {
        return grupoJsonRepository.findById(id)
                .map(GrupoJson::getDatos);
    }

    @Override
    public Mono<GrupoJson> update(Integer id, String json) {
        return grupoJsonRepository.findById(id)
                .flatMap(existingGrupoJson -> {
                    existingGrupoJson.setDatos(json);
                    return grupoJsonRepository.save(existingGrupoJson);
                });
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return grupoJsonRepository.deleteById(id);
    }

    @Override
    public Flux<GrupoJson> findAll() {
        return grupoJsonRepository.findAll();
    }
}
