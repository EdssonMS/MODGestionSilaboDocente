package com.grupo.MODGestionSilaboDocente.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "DOCUMENTOS")
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;

    @Lob
    @Column(name = "CONTENIDO")
    private byte[] contenido;

    @Column(name = "FORMATO")
    private String formato;

    public Documentos(){

    }

    public Documentos(String nombreArchivo, byte[] contenido, String formato) {
        this.nombreArchivo = nombreArchivo;
        this.contenido = contenido;
        this.formato = formato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_archivo() {
        return nombreArchivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombreArchivo = nombre_archivo;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}