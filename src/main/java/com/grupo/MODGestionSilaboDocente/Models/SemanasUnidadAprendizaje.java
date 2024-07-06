package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("SEMANAS_UNIDAD_APRENDIZAJE")
public class SemanasUnidadAprendizaje {

    @Id
    @Column("ID")
    private Integer id;

    @Column("SEMANA")
    private Integer semana;

    @Column("CONTENIDO")
    private String contenido;

    @Column("ACTIVIDADES")
    private String actividades;

    @Column("RECURSOS")
    private String recursos;

    @Column("ESTRATEGIAS")
    private String estrategias;

    @Column("ID_UNIDAD_APRENDIZAJE")
    private Integer idUnidadAprendizaje;

    public SemanasUnidadAprendizaje(){
    }

    public SemanasUnidadAprendizaje(Integer id, Integer semana, String contenido, String actividades, String recursos, String estrategias, Integer idUnidadAprendizaje) {
        this.id = id;
        this.semana = semana;
        this.contenido = contenido;
        this.actividades = actividades;
        this.recursos = recursos;
        this.estrategias = estrategias;
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public String getEstrategias() {
        return estrategias;
    }

    public void setEstrategias(String estrategias) {
        this.estrategias = estrategias;
    }

    public Integer getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }
}
