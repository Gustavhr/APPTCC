package com.example.app.Model;

import java.util.Date;

public class Medicao {

    Integer id,idpaciente, Pasist,PAdist,FC;
    Date datahora;
    Boolean rotina,pedido;
    String comentario;
    Paciente paciente;

    public Medicao(Integer id, Integer idpaciente, Integer pasist, Integer PAdist, Integer FC, Date datahora, Boolean rotina, Boolean pedido, String comentario, Paciente paciente) {
        this.id = id;
        this.idpaciente = idpaciente;
        Pasist = pasist;
        this.PAdist = PAdist;
        this.FC = FC;
        this.datahora = datahora;
        this.rotina = rotina;
        this.pedido = pedido;
        this.comentario = comentario;
        this.paciente = paciente;
    }

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

    public Integer getPasist() {
        return Pasist;
    }

    public void setPasist(Integer pasist) {
        Pasist = pasist;
    }

    public Integer getPAdist() {
        return PAdist;
    }

    public void setPAdist(Integer PAdist) {
        this.PAdist = PAdist;
    }

    public Integer getFC() {
        return FC;
    }

    public void setFC(Integer FC) {
        this.FC = FC;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public Boolean getRotina() {
        return rotina;
    }

    public void setRotina(Boolean rotina) {
        this.rotina = rotina;
    }

    public Boolean getPedido() {
        return pedido;
    }

    public void setPedido(Boolean pedido) {
        this.pedido = pedido;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
