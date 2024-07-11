package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("GRUPOJSON")
public class GrupoJson {
    @Id
    @Column("ID")
    private Integer id;
    @Column("DATOS")
    private String datos;

    public GrupoJson(){
    }

    public GrupoJson(Integer id, String datos) {
        this.id = id;
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
