package com.example.app.Model;

import java.util.Date;

public class PacienteRemedio {

    Integer idremedio,idpaciente;
    Date datainicio,datavisita;
    Remedio remedio;
    Paciente paciente;

    public PacienteRemedio(Integer idremedio, Integer idpaciente, Date datainicio, Date datavisita, Remedio remedio, Paciente paciente) {
        this.idremedio = idremedio;
        this.idpaciente = idpaciente;
        this.datainicio = datainicio;
        this.datavisita = datavisita;
        this.remedio = remedio;
        this.paciente = paciente;
    }

    public Integer getIdremedio() {
        return idremedio;
    }

    public void setIdremedio(Integer idremedio) {
        this.idremedio = idremedio;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatavisita() {
        return datavisita;
    }

    public void setDatavisita(Date datavisita) {
        this.datavisita = datavisita;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
