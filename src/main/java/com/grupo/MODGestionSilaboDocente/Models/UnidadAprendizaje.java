package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("UNIDAD_APRENDIZAJE")
public class UnidadAprendizaje {

    @Id
    @Column("ID")
    private Integer id;

    @Column("NOMBRE_UNIDAD")
    private String nombreUnidad;

    @Column("LOGRO_UNIDAD")
    private String logroUnidad;

    private List<SemanasUnidadAprendizaje> semanas;

    public UnidadAprendizaje(){
    }

    public UnidadAprendizaje(Integer id, String nombreUnidad, String logroUnidad, List<SemanasUnidadAprendizaje> semanas) {
        this.id = id;
        this.nombreUnidad = nombreUnidad;
        this.logroUnidad = logroUnidad;
        this.semanas = semanas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getLogroUnidad() {
        return logroUnidad;
    }

    public void setLogroUnidad(String logroUnidad) {
        this.logroUnidad = logroUnidad;
    }

    public List<SemanasUnidadAprendizaje> getSemanas() {
        return semanas;
    }

    public void setSemanas(List<SemanasUnidadAprendizaje> semanas) {
        this.semanas = semanas;
    }
}