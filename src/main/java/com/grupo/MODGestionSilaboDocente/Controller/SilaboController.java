package com.grupo.MODGestionSilaboDocente.Controller;

import com.grupo.MODGestionSilaboDocente.Models.*;
import com.grupo.MODGestionSilaboDocente.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
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

    // ENDPOINTS GET (READ) PARA LLENAR EL SILABO
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

    //BORRAR TABLA DE DB, NO BORRA EL JSON DEL SILABO
    // ENDPOINTS DELETE (DELETE)
    @DeleteMapping("/silabo/{id}")
    public Mono<ResponseEntity<Void>> deleteSilabo(@PathVariable Integer id) {
        return silaboService.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    //RETORNAR TODOS LOS SILABOS QUE ESTEN REGISTRADOS JSON
    @GetMapping("/silabo/json")
    public Flux<SilaboJson> getAllSilaboJson() {
        return silaboJsonService.findAll();
    }


    // ===================== SILABO CRUD ==========================================================
    // Endpoint para guardar un JSON de sílabo
    @PostMapping("/silabo/json")
    public Mono<SilaboJson> saveSilaboJson(@RequestBody String json) {
        System.out.println("Recibido JSON: " + json);
        return silaboJsonService.save(json);
    }

    // Endpoint para obtener un JSON de sílabo por ID
    @GetMapping("/silabo/json/{id}")
    public Mono<String> getSilaboJson(@PathVariable Integer id) {
        return silaboJsonService.findById(id);
    }

    // Endpoint para actualizar un JSON de sílabo por ID
    @PutMapping("/silabo/json/{id}")
    public Mono<SilaboJson> updateSilaboJson(@PathVariable Integer id, @RequestBody String json) {
        return silaboJsonService.update(id, json);
    }

    // Endpoint para eliminar un JSON de sílabo por ID
    @DeleteMapping("/silabo/json/{id}")
    public Mono<Void> deleteSilaboJson(@PathVariable Integer id) {
        return silaboJsonService.deleteById(id);
    }

    // ===================== UNIDAD APRENDIZAJE CRUD ==========================================================
    // Endpoint para crear una nueva Unidad de Aprendizaje
    @PostMapping("/unidadesAprendizaje")
    public Mono<UnidadAprendizaje> createUnidadAprendizaje(@RequestBody UnidadAprendizaje unidadAprendizaje) {
        return unidadAprendizajeService.save(unidadAprendizaje);
    }

    // Endpoint para obtener una Unidad de Aprendizaje por ID
    @GetMapping("/unidadesAprendizaje/{id}")
    public Mono<UnidadAprendizaje> getUnidadAprendizaje(@PathVariable Integer id) {
        return unidadAprendizajeService.findById(id);
    }

    // Endpoint para obtener todas las Unidades de Aprendizaje
    @GetMapping("/unidadesAprendizaje")
    public Flux<UnidadAprendizaje> getAllUnidadesAprendizaje() {
        return unidadAprendizajeService.findAll();
    }

    // Endpoint para actualizar una Unidad de Aprendizaje por ID
    @PutMapping("/unidadesAprendizaje/{id}")
    public Mono<UnidadAprendizaje> updateUnidadAprendizaje(@PathVariable Integer id, @RequestBody UnidadAprendizaje unidadAprendizaje) {
        return unidadAprendizajeService.update(id, unidadAprendizaje);
    }

    // Endpoint para eliminar una Unidad de Aprendizaje por ID
    @DeleteMapping("/unidadesAprendizaje/{id}")
    public Mono<Void> deleteUnidadAprendizaje(@PathVariable Integer id) {
        return unidadAprendizajeService.deleteById(id);
    }
}
