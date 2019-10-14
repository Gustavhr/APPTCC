package com.example.app.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.Date;

@Entity(tableName = "RESPOSTA")
public class Resposta {

    @ColumnInfo(name = "idpaciente")
    Integer idpaciente;
    @ColumnInfo(name = "idpergunta")
    Integer idpergunta;
    @NonNull
    @ColumnInfo(name = "resp")
    Boolean repost;
    @Nullable
    @ColumnInfo(name = "datainicio")
    Date datainicio;
    @NonNull
    @ColumnInfo(name = "datavisita")
    Date datavisita;
    @Ignore
    Perguntas perguntas;
    @Ignore
    Paciente paciente;

    public Resposta(Integer idpaciente, Integer idpergunta, Boolean repost, Date datainicio, Date datavisita) {
        this.idpaciente = idpaciente;
        this.idpergunta = idpergunta;
        this.repost = repost;
        this.datainicio = datainicio;
        this.datavisita = datavisita;

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
