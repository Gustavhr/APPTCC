package com.example.app.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(tableName="PACIENTE")

public class Paciente implements Serializable {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    Integer idendereco;

    @NonNull
    @ColumnInfo(name = "nome")
    String nome;
    @NonNull
    @ColumnInfo(name = "telefone")
    String telefone;

    @NonNull
    @ColumnInfo(name="sexo")
    Character sexo;
    @Ignore
//    @NonNull
//    @ColumnInfo(name = "datanascimento")
    String datanascimento;

//    Endereco endereco;
//    List<PacienteRemedio> pacienteremedio;
//    List<Resposta> respostas;


    public Paciente(String nome, String telefone,Character sexo) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        //this.datanascimento = datanascimento;
        //this.endereco = endereco;
    }
    @Ignore
    public Paciente(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(Integer idendereco) {
        this.idendereco = idendereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
//
    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
//
//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
}
