package com.grupo.MODGestionSilaboDocente.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Table("SILABO")
public class Silabo {

    @Id
    @Column("ID")
    private Integer id;

    @Column("ID_ASIGNATURA")
    private String idAsignatura;

    @Column("ID_DOCENTE")
    private String idDocente;

    @Column("LOGROS_APRENDIZAJE")
    private String logrosAprendizaje;

    @Column("ESTRATEGIA_DIDACTICA")
    private String estrategiaDidactica;

    @Column("BIBLIOGRAFIA")
    private String bibliografia;

    private Curso curso;
    private Docente docente;
    private List<UnidadAprendizaje> unidadesAprendizaje;

    public Silabo(){
    }

    public Silabo(Integer id, String idAsignatura, String idDocente, String logrosAprendizaje, String estrategiaDidactica, String bibliografia, Curso curso, Docente docente, List<UnidadAprendizaje> unidadesAprendizaje) {
        this.id = id;
        this.idAsignatura = idAsignatura;
        this.idDocente = idDocente;
        this.logrosAprendizaje = logrosAprendizaje;
        this.estrategiaDidactica = estrategiaDidactica;
        this.bibliografia = bibliografia;
        this.curso = curso;
        this.docente = docente;
        this.unidadesAprendizaje = unidadesAprendizaje;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public String getLogrosAprendizaje() {
        return logrosAprendizaje;
    }

    public void setLogrosAprendizaje(String logrosAprendizaje) {
        this.logrosAprendizaje = logrosAprendizaje;
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

    public List<UnidadAprendizaje> getUnidadesAprendizaje() {
        return unidadesAprendizaje;
    }

    public void setUnidadesAprendizaje(List<UnidadAprendizaje> unidadesAprendizaje) {
        this.unidadesAprendizaje = unidadesAprendizaje;
    }
}
