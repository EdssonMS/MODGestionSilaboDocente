package com.grupo.MODGestionSilaboDocente.Repository;

import com.grupo.MODGestionSilaboDocente.Models.Docente;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends R2dbcRepository<Docente, String> {
}
