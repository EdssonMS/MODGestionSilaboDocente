package com.grupo.MODGestionSilaboDocente.Service;

import com.grupo.MODGestionSilaboDocente.Models.Docente;
import com.grupo.MODGestionSilaboDocente.Repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DocenteServiceImplement implements DocenteService{
    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public Mono<Docente> findById(String id) {
        return docenteRepository.findById(id);
    }
}
