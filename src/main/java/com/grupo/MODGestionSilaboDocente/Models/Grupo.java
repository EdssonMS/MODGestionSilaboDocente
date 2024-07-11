package com.grupo.MODGestionSilaboDocente.Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GRUPO")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "grupo_unidad",
            joinColumns = @JoinColumn(name = "ID_GRUPO"),
            inverseJoinColumns = @JoinColumn(name = "ID_UNIDAD_APRENDIZAJE")
    )
    private Set<UnidadAprendizaje> unidadesAprendizaje;

    // Constructores
    public Grupo() {

    }

    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<UnidadAprendizaje> getUnidadesAprendizaje() {
        return unidadesAprendizaje;
    }

    public void setUnidadesAprendizaje(Set<UnidadAprendizaje> unidadesAprendizaje) {
        this.unidadesAprendizaje = unidadesAprendizaje;
    }
}
