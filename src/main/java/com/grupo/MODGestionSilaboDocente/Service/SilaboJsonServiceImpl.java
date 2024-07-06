package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.SilaboJson;
import com.grupo.MODGestionSilaboDocente.Repository.SilaboJsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        SilaboJson silaboJson = new SilaboJson(json);
        return silaboJsonRepository.save(silaboJson);
    }

    @Override
    public Mono<String> findById(Integer id) {
        return silaboJsonRepository.findById(id)
                .map(SilaboJson::getDatos);
    }
}
