package com.grupo.MODGestionSilaboDocente.Models;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "docentes")
public class Docente {

    @Id @Column("cod_docente")
    private String codDocente;

    @Column("nombre")
    private String nombre;

    @Column("apellido")
    private String apellido;

    @Column("numero_telefono")
    private String numeroTelefono;

    @Column("correo")
    private String correo;

    public Docente(){

    }

    public Docente(String codDocente, String nombre, String apellido, String numeroTelefono, String correo) {
        this.codDocente = codDocente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
    }

    public String getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(String codDocente) {
        this.codDocente = codDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}