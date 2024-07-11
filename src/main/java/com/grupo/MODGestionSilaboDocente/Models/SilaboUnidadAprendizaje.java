package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("SILABO_UNIDAD_APRENDIZAJE")
public class SilaboUnidadAprendizaje {

    @Id
    @Column("ID")
    private Integer id;

    @Column("ID_SILABO")
    private Integer idSilabo;

    @Column("ID_UNIDAD_APRENDIZAJE")
    private Integer idUnidadAprendizaje;

    public SilaboUnidadAprendizaje(){
    }

    public SilaboUnidadAprendizaje(Integer id, Integer idSilabo, Integer idUnidadAprendizaje) {
        this.id = id;
        this.idSilabo = idSilabo;
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSilabo() {
        return idSilabo;
    }

    public void setIdSilabo(Integer idSilabo) {
        this.idSilabo = idSilabo;
    }

    public Integer getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }
}
