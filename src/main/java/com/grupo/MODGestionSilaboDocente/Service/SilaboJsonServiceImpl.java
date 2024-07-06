package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.SilaboJson;
import com.grupo.MODGestionSilaboDocente.Repository.SilaboJsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SilaboJsonServiceImpl implements SilaboJsonService {

    private final SilaboJsonRepository silaboJsonRepository;

    @Autowired
    public SilaboJsonServiceImpl(SilaboJsonRepository silaboJsonRepository) {
        this.silaboJsonRepository = silaboJsonRepository;
    }

    @Override
    public Mono<SilaboJson> save(String json) {
        System.out.println("Guardando JSON: " + json);
        SilaboJson silaboJson = new SilaboJson(json);
        return silaboJsonRepository.save(silaboJson)
                .doOnError(e -> System.err.println("Error al guardar el silabo: " + e.getMessage()));
    }

    @Override
    public Mono<String> findById(Integer id) {
        return silaboJsonRepository.findById(id)
                .map(SilaboJson::getDatos);
    }

    @Override
    public Mono<SilaboJson> update(Integer id, String json) {
        return silaboJsonRepository.findById(id)
                .flatMap(existingSilaboJson -> {
                    existingSilaboJson.setDatos(json);
                    return silaboJsonRepository.save(existingSilaboJson);
                });
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return silaboJsonRepository.deleteById(id);
    }

    @Override
    public Flux<SilaboJson> findAll() {
        return silaboJsonRepository.findAll();
    }
}
