package com.example.app.Dados;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app.Model.Perguntas;
import com.example.app.Model.Usuario;

import java.util.List;

@Dao
public interface PerguntaDAO {


    @Insert
    void insert (Perguntas perguntas);

    @Update
    void update (Perguntas perguntas);

    @Delete
    void delete (Perguntas perguntas);

    @Query("SELECT * FROM PERGUNTA")
    List<Perguntas> getAll();

//    @Query("SELECT COUNT(*) FROM USER WHERE login =  :usuario AND senha = :senha AND tipo = :tipo ")
//    int count(String usuario,String senha ,String tipo);
//
//
//    @Query("SELECT * FROM USER WHERE login like '%' || :login || '&'")
//    List<Usuario> findByLogin(String login);

}
