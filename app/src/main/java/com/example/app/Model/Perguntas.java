package com.example.app.Model;

import java.util.List;

public class Perguntas {

    Integer id;
    String descricao;
    List<Resposta> resposta;

    public Perguntas(Integer id, String descricao, List<Resposta> resposta) {
        this.id = id;
        this.descricao = descricao;
        this.resposta = resposta;
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

    public List<Resposta> getResposta() {
        return resposta;
    }

    public void setResposta(List<Resposta> resposta) {
        this.resposta = resposta;
    }
}
