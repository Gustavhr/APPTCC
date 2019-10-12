package com.example.app.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "USER")
public class Usuario implements Serializable {

    @PrimaryKey(autoGenerate = true)
    Long id;

    @NonNull
    @ColumnInfo(name = "nome")
    String nome;
    @NonNull
    @ColumnInfo(name = "login")
    String login;
    @NonNull
    @ColumnInfo(name = "senha")
    String password;
    @NonNull
    @ColumnInfo(name = "email")
    String email ;
    @NonNull
    @ColumnInfo(name = "tipo")
    String tipo;

    public Usuario(String nome, String login, String password,String email,String tipo) {
        this.nome = nome;
        this.login = login;
        this.password = password;
        this.email=email;
        this.tipo=tipo;
    }
    @Ignore
    public Usuario()
    {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String matricula) {
        this.login = matricula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
