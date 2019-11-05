package com.example.app.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

import static androidx.room.ForeignKey.CASCADE;

//@Entity(tableName="ENDERECO")
@Entity(tableName="ENDERECO",foreignKeys = @ForeignKey(entity = Paciente.class,
        parentColumns = "id",
        childColumns = "id",
        onDelete = CASCADE))
public class Endereco {

    @PrimaryKey(autoGenerate = false)
    Integer id;

    //@ColumnInfo(name = "idpaciente")
    @Ignore
    Integer idpaciente;

    @NonNull
    @ColumnInfo(name = "descricao")
    String descricao;
    @NonNull
    @ColumnInfo(name = "numero")
    String numero;
    @NonNull
    @ColumnInfo(name = "bairro")
    String bairro;
    @NonNull
    @ColumnInfo(name = "cidade")
    String cidade;
    @NonNull
    @ColumnInfo(name = "CEP")
    String CEP;

    //String geolocalizacao;
    @Ignore
    List<Paciente> pacientes;


    public Endereco(String descricao, String numero, String bairro, String cidade, String CEP) {
        this.descricao = descricao;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.CEP = CEP;
    }
@Ignore
public Endereco(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

//    public String getGeolocalizacao() {
//        return geolocalizacao;
//    }
//
//    public void setGeolocalizacao(String geolocalizacao) {
//        this.geolocalizacao = geolocalizacao;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descicao) {
        this.descricao = descicao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }
}
