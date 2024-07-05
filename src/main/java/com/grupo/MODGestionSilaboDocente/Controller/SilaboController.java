package com.grupo.MODGestionSilaboDocente.Controller;

import com.grupo.MODGestionSilaboDocente.Models.Curso;
import com.grupo.MODGestionSilaboDocente.Models.Docente;
import com.grupo.MODGestionSilaboDocente.Service.CursoService;
import com.grupo.MODGestionSilaboDocente.Service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class SilaboController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/curso/{id}")
    public Mono<Curso> getCurso(@PathVariable String id) {
        return cursoService.findById(id);
    }


    @GetMapping("/docente/{id}")
    public Mono<ResponseEntity<Docente>> getDocenteById(@PathVariable String id) {
        return docenteService.findById(id)
                .map(curso -> ResponseEntity.ok().body(curso))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
