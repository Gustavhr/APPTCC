package com.example.app.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "MEDICAO")
//@Entity(tableName = "MEDICAO",foreignKeys = @ForeignKey(entity = Paciente.class,
//        parentColumns = "id",
//        childColumns = "idpaciente",
//        onDelete = CASCADE))
public class Medicao implements Serializable {

    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "idpaciente")
    Integer idpaciente;
    @ColumnInfo(name = "pasist")
    Integer pasist;
    @ColumnInfo(name = "padist")
    Integer padist;
    @ColumnInfo(name = "FC")
    Integer FC;
    @ColumnInfo(name = "Data")
    String datahora;
    @ColumnInfo(name = "rotina")
    Boolean rotina;
    @ColumnInfo(name = "pedido")
    Boolean  pedido;
    @ColumnInfo(name = "comentario")
    String comentario;


    @Ignore
    Paciente paciente;


    public Medicao( Integer idpaciente, Integer pasist, Integer padist, Integer FC, String datahora, Boolean rotina, Boolean pedido, String comentario) {

        this.idpaciente = idpaciente;
        this.pasist = pasist;
        this.padist = padist;
        this.FC = FC;
        this.datahora = datahora;
        this.rotina = rotina;
        this.pedido = pedido;
        this.comentario = comentario;

    }
    @Ignore
public Medicao(){}
    public Integer getPasist() {
        return pasist;
    }

    public void setPasist(Integer pasist) {
        this.pasist = pasist;
    }

    public Integer getPadist() {
        return padist;
    }

    public void setPadist(Integer padist) {
        this.padist = padist;
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


    public Integer getFC() {
        return FC;
    }

    public void setFC(Integer FC) {
        this.FC = FC;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
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
