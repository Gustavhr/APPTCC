package com.example.app.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "RESPOSTA")
public class Resposta {



    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "idpaciente")
    Integer idpaciente;
    @ColumnInfo(name = "idpergunta")
    Integer idpergunta;
    @NonNull
    @ColumnInfo(name = "resp")
    Boolean repost;
    @Nullable
    @ColumnInfo(name = "datainicio")
    String datainicio;
    @NonNull
    @ColumnInfo(name = "datavisita")
    String datavisita;
    @Ignore
    Perguntas perguntas;
    @Ignore
    Paciente paciente;

    public Resposta(Integer idpaciente, Integer idpergunta, Boolean repost, String datainicio, String datavisita) {
        this.idpaciente = idpaciente;
        this.idpergunta = idpergunta;
        this.repost = repost;
        this.datainicio = datainicio;
        this.datavisita = datavisita;

    }
    @Ignore
    public Resposta(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getDatavisita() {
        return datavisita;
    }

    public void setDatavisita(String datavisita) {
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
