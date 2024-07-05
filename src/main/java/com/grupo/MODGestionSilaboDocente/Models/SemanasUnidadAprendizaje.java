package com.grupo.MODGestionSilaboDocente.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "SEMANAS_UNIDAD_APRENDIZAJE")
public class SemanasUnidadAprendizaje {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SEMANA")
    private int semana;

    @Column(name = "CONTENIDO")
    private String contenido;

    @Column(name = "ACTIVIDADES")
    private String actividades;

    @Column(name = "RECURSOS")
    private String recursos;

    @Column(name = "ESTRATEGIAS")
    private String estrategias;

    public SemanasUnidadAprendizaje() {

    }

    public SemanasUnidadAprendizaje(int semana, String contenido, String actividades, String recursos, String estrategias) {
        this.semana = semana;
        this.contenido = contenido;
        this.actividades = actividades;
        this.recursos = recursos;
        this.estrategias = estrategias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
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
}
