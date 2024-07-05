package com.grupo.MODGestionSilaboDocente.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "UNIDAD_APRENDIZAJE")
public class UnidadAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;

    @Column(name = "LOGRO_UNIDAD")
    private String logroUnidad;

    @ManyToOne
    @JoinColumn(name = "ID_SEMANAS_UNIDAD_APRENDIZAJE")
    private SemanasUnidadAprendizaje semanasUnidadAprendizaje;

    // Constructores
    public UnidadAprendizaje() {

    }

    public UnidadAprendizaje(String nombreUnidad, String logroUnidad, SemanasUnidadAprendizaje semanasUnidadAprendizaje) {
        this.nombreUnidad = nombreUnidad;
        this.logroUnidad = logroUnidad;
        this.semanasUnidadAprendizaje = semanasUnidadAprendizaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public SemanasUnidadAprendizaje getSemanasUnidadAprendizaje() {
        return semanasUnidadAprendizaje;
    }

    public void setSemanasUnidadAprendizaje(SemanasUnidadAprendizaje semanasUnidadAprendizaje) {
        this.semanasUnidadAprendizaje = semanasUnidadAprendizaje;
    }
}
