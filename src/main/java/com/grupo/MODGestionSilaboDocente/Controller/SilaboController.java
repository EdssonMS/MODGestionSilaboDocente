package com.grupo.MODGestionSilaboDocente.Controller;

import com.grupo.MODGestionSilaboDocente.Models.*;
import com.grupo.MODGestionSilaboDocente.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class SilaboController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private UnidadAprendizajeService unidadAprendizajeService;

    @Autowired
    private SilaboService silaboService;

    private final SilaboJsonService silaboJsonService;

    @Autowired
    public SilaboController(SilaboJsonService silaboJsonService) {
        this.silaboJsonService = silaboJsonService;
    }


    // ENDPOINTS GET (READ)
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

    @GetMapping("/unidad-aprendizaje/{id}")
    public Mono<UnidadAprendizaje> getUnidadAprendizajeById(@PathVariable Integer id) {
        return unidadAprendizajeService.findById(id);
    }

    @GetMapping("/silabo/{id}")
    public Mono<Silabo> getSilaboById(@PathVariable Integer id) {
        return silaboService.findById(id);
    }

    //ENDPOINTS POST (CREATE)
        //UnidadAprendizaje
        //Silabo

    //ENDPOINTS PUT (UPDATE)
        //UnidadAprendizaje
        //Silabo


    // ENDPOINTS DELETE (DELETE)
    @DeleteMapping("/unidad-aprendizaje/{id}")
    public Mono<ResponseEntity<Void>> deleteUnidadAprendizaje(@PathVariable Integer id) {
        return unidadAprendizajeService.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    @DeleteMapping("/silabo/{id}")
    public Mono<ResponseEntity<Void>> deleteSilabo(@PathVariable Integer id) {
        return silaboService.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    //RETORNAR TODOS LOS SILABOS QUE ESTEN REGISTRADOS


    // Endpoint para guardar un JSON de sílabo
    @PostMapping("/silabo/json")
    public Mono<SilaboJson> saveSilaboJson(@RequestBody String json) {
        return silaboJsonService.save(json);
    }

    // Endpoint para obtener un JSON de sílabo por ID
    @GetMapping("/silabo/json/{id}")
    public Mono<String> getSilaboJson(@PathVariable Integer id) {
        return silaboJsonService.findById(id);
    }
}
