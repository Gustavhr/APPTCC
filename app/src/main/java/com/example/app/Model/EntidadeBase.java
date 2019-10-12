package com.example.app.Model;

import android.icu.text.RelativeDateTimeFormatter;

import java.util.Date;

public class EntidadeBase {

    Date datacriacao;
    Date dataultimatuaalizacao;
    Integer Idusuario;
    Usuario UsuarioUltimaAtualizacao;

    public EntidadeBase(Date datacriacao, Date dataultimatuaalizacao, Integer idusuario, Usuario usuarioUltimaAtualizacao) {
        this.datacriacao = datacriacao;
        this.dataultimatuaalizacao = dataultimatuaalizacao;
        Idusuario = idusuario;
        UsuarioUltimaAtualizacao = usuarioUltimaAtualizacao;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getDataultimatuaalizacao() {
        return dataultimatuaalizacao;
    }

    public void setDataultimatuaalizacao(Date dataultimatuaalizacao) {
        this.dataultimatuaalizacao = dataultimatuaalizacao;
    }

    public Integer getIdusuario() {
        return Idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        Idusuario = idusuario;
    }

    public Usuario getUsuarioUltimaAtualizacao() {
        return UsuarioUltimaAtualizacao;
    }

    public void setUsuarioUltimaAtualizacao(Usuario usuarioUltimaAtualizacao) {
        UsuarioUltimaAtualizacao = usuarioUltimaAtualizacao;
    }
}
