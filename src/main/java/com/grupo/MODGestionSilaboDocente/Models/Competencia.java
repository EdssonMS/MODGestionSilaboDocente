package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("COMPETENCIAS")
public class Competencia {
    @Id
    @Column("CODIGO")
    private String codigo;

    @Column("DESCRIPCION")
    private String descripcion;

    @Column("TIPO")
    private String tipo;

    @Column("NIVEL")
    private String nivel;

    public Competencia(){
    }

    public Competencia(String codigo, String descripcion, String tipo, String nivel) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
