package com.grupo.MODGestionSilaboDocente.DTO;

import com.grupo.MODGestionSilaboDocente.Models.SemanasUnidadAprendizaje;
import java.util.List;

public class UnidadAprendizajeDTO {
    private String nombreUnidad;
    private String logroUnidad;
    private List<SemanasUnidadAprendizaje> semanas;

    public UnidadAprendizajeDTO(){
    }

    public UnidadAprendizajeDTO(String nombreUnidad, String logroUnidad, List<SemanasUnidadAprendizaje> semanas) {
        this.nombreUnidad = nombreUnidad;
        this.logroUnidad = logroUnidad;
        this.semanas = semanas;
    }

    // Getters and Setters
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
