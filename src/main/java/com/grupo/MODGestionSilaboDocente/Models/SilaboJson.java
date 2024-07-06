package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("SILABOJSON")
public class SilaboJson {

    @Id
    private Integer id;
    private String datos;

    public SilaboJson() {
    }

    public SilaboJson(String datos) {
        this.datos = datos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}
