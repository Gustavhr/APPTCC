package com.example.app.Model;

import java.util.Date;

public class Resposta {

    Integer idpaciente,idpergunta;
    Boolean repost;
    Date datainicio,datavisita;
    Perguntas perguntas;
    Paciente paciente;

    public Resposta(Integer idpaciente, Integer idpergunta, Boolean repost, Date datainicio, Date datavisita, Perguntas perguntas, Paciente paciente) {
        this.idpaciente = idpaciente;
        this.idpergunta = idpergunta;
        this.repost = repost;
        this.datainicio = datainicio;
        this.datavisita = datavisita;
        this.perguntas = perguntas;
        this.paciente = paciente;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Integer getIdpergunta() {
        return idpergunta;
    }

    public void setIdpergunta(Integer idpergunta) {
        this.idpergunta = idpergunta;
    }

    public Boolean getRepost() {
        return repost;
    }

    public void setRepost(Boolean repost) {
        this.repost = repost;
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

    public Perguntas getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(Perguntas perguntas) {
        this.perguntas = perguntas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
