package com.grupo.MODGestionSilaboDocente.DTO;

import java.util.List;

public class SilaboDTO {
    private String idAsignatura;
    private String idDocente;
    private String logrosAprendizaje;
    private String estrategiaDidactica;
    private String bibliografia;
    private List<Integer> unidadesAprendizajeIds;

    public SilaboDTO(){
    }

    public SilaboDTO(String idAsignatura, String idDocente, String logrosAprendizaje, String estrategiaDidactica, String bibliografia, List<Integer> unidadesAprendizajeIds) {
        this.idAsignatura = idAsignatura;
        this.idDocente = idDocente;
        this.logrosAprendizaje = logrosAprendizaje;
        this.estrategiaDidactica = estrategiaDidactica;
        this.bibliografia = bibliografia;
        this.unidadesAprendizajeIds = unidadesAprendizajeIds;
    }

    // Getters and Setters
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

    public List<Integer> getUnidadesAprendizajeIds() {
        return unidadesAprendizajeIds;
    }

    public void setUnidadesAprendizajeIds(List<Integer> unidadesAprendizajeIds) {
        this.unidadesAprendizajeIds = unidadesAprendizajeIds;
    }
}
