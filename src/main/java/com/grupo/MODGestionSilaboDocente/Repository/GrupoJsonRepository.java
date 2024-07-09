package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.GrupoJson;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoJsonRepository extends ReactiveCrudRepository<GrupoJson, Integer> {
}
