package com.grupo.MODGestionSilaboDocente.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "SILABO")
public class Silabo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_ASIGNATURA")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "ID_DOCENTE")
    private Docente docente;

    @Column(name = "LOGROS_APRENDIZAJE")
    private String logrosAprendizaje;

    @Column(name = "CAPACIDADES")
    private String capacidades;

    @ManyToOne
    @JoinColumn(name = "ID_UNIDAD_APRENDIZAJE")
    private UnidadAprendizaje unidadAprendizaje;

    @Column(name = "ESTRATEGIA_DIDACTICA")
    private String estrategiaDidactica;

    @Column(name = "BIBLIOGRAFIA")
    private String bibliografia;

    public Silabo() {

    }

    public Silabo(Curso curso, Docente docente, String logrosAprendizaje, String capacidades, UnidadAprendizaje unidadAprendizaje, String estrategiaDidactica, String bibliografia) {
        this.curso = curso;
        this.docente = docente;
        this.logrosAprendizaje = logrosAprendizaje;
        this.capacidades = capacidades;
        this.unidadAprendizaje = unidadAprendizaje;
        this.estrategiaDidactica = estrategiaDidactica;
        this.bibliografia = bibliografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getLogrosAprendizaje() {
        return logrosAprendizaje;
    }

    public void setLogrosAprendizaje(String logrosAprendizaje) {
        this.logrosAprendizaje = logrosAprendizaje;
    }

    public String getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(String capacidades) {
        this.capacidades = capacidades;
    }

    public UnidadAprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }

    public String getEstrategiaDidactica() {
        return estrategiaDidactica;
    }

    public void setEstrategiaDidactica(String estrategiaDidactica) {
        this.estrategiaDidactica = estrategiaDidactica;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
}
