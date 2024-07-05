package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CURSOS_COMPETENCIAS")
public class CursoCompetencia {
    @Id
    @Column("ID")
    private Long id;

    @Column("COD_ASIGNATURA")
    private String codAsignatura;

    @Column("CODIGO_COMPETENCIA")
    private String codigoCompetencia;

    public CursoCompetencia(){
    }

    public CursoCompetencia(Long id, String codAsignatura, String codigoCompetencia) {
        this.id = id;
        this.codAsignatura = codAsignatura;
        this.codigoCompetencia = codigoCompetencia;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getCodigoCompetencia() {
        return codigoCompetencia;
    }

    public void setCodigoCompetencia(String codigoCompetencia) {
        this.codigoCompetencia = codigoCompetencia;
    }
}

