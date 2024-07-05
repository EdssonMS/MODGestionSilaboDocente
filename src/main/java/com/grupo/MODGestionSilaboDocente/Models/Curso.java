package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;

@Table("CURSOS")
public class Curso {
    @Id
    @Column("COD_ASIGNATURA")
    private String codAsignatura;

    @Column("NOMBRE_ASIGNATURA")
    private String nombreAsignatura;

    @Column("TIPO_ASIGNATURA")
    private String tipoAsignatura;

    @Column("AREA_ESTUDIOS")
    private String areaEstudios;

    @Column("NUMERO_SEMANAS")
    private int numeroSemanas;

    @Column("HORAS_SEMANALES")
    private int horasSemanales;

    @Column("SEMESTRE_ACADEMICO")
    private String semestreAcademico;

    @Column("CICLO")
    private int ciclo;

    @Column("CREDITOS")
    private int creditos;

    @Column("MODALIDAD")
    private String modalidad;

    @Column("PREREQUISITOS")
    private String prerequisitos;

    @Column("SUMILLA")
    private String sumilla;

    @Column("EVALUACION_APRENDIZAJE")
    private String evaluacionAprendizaje;

    private List<Competencia> competencias;

    public Curso(){
    }

    public Curso(List<Competencia> competencias, String evaluacionAprendizaje, String sumilla, String prerequisitos, String modalidad, int creditos, int ciclo, String semestreAcademico, int horasSemanales, int numeroSemanas, String areaEstudios, String tipoAsignatura, String nombreAsignatura, String codAsignatura) {
        this.competencias = competencias;
        this.evaluacionAprendizaje = evaluacionAprendizaje;
        this.sumilla = sumilla;
        this.prerequisitos = prerequisitos;
        this.modalidad = modalidad;
        this.creditos = creditos;
        this.ciclo = ciclo;
        this.semestreAcademico = semestreAcademico;
        this.horasSemanales = horasSemanales;
        this.numeroSemanas = numeroSemanas;
        this.areaEstudios = areaEstudios;
        this.tipoAsignatura = tipoAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.codAsignatura = codAsignatura;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getTipoAsignatura() {
        return tipoAsignatura;
    }

    public void setTipoAsignatura(String tipoAsignatura) {
        this.tipoAsignatura = tipoAsignatura;
    }

    public String getAreaEstudios() {
        return areaEstudios;
    }

    public void setAreaEstudios(String areaEstudios) {
        this.areaEstudios = areaEstudios;
    }

    public int getNumeroSemanas() {
        return numeroSemanas;
    }

    public void setNumeroSemanas(int numeroSemanas) {
        this.numeroSemanas = numeroSemanas;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public String getSemestreAcademico() {
        return semestreAcademico;
    }

    public void setSemestreAcademico(String semestreAcademico) {
        this.semestreAcademico = semestreAcademico;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getPrerequisitos() {
        return prerequisitos;
    }

    public void setPrerequisitos(String prerequisitos) {
        this.prerequisitos = prerequisitos;
    }

    public String getSumilla() {
        return sumilla;
    }

    public void setSumilla(String sumilla) {
        this.sumilla = sumilla;
    }

    public String getEvaluacionAprendizaje() {
        return evaluacionAprendizaje;
    }

    public void setEvaluacionAprendizaje(String evaluacionAprendizaje) {
        this.evaluacionAprendizaje = evaluacionAprendizaje;
    }

    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }
}