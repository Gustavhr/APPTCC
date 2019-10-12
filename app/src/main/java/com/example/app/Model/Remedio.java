package com.example.app.Model;

import java.util.List;

public class Remedio {


    Integer id;
    String descricao;
    List<PacienteRemedio> paciente;

    public Remedio(Integer id, String descricao, List<Paciente> paciente) {
        this.id = id;
        this.descricao = descricao;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<PacienteRemedio> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<PacienteRemedio> paciente) {
        this.paciente = paciente;
    }
}


