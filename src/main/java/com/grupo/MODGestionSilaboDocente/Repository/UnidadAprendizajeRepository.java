package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.UnidadAprendizaje;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadAprendizajeRepository extends R2dbcRepository<UnidadAprendizaje, Integer> {
}
