package com.example.app.Dados;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app.Model.Perguntas;
import com.example.app.Model.Resposta;

import java.util.List;

@Dao
public interface RespostaDAO {


    @Insert
    void insert (Resposta resposta);

    @Update
    void update (Resposta resposta);

    @Delete
    void delete (Resposta resposta);

    @Query("SELECT * FROM RESPOSTA")
    List<Resposta> getAll();

//    @Query("SELECT COUNT(*) FROM USER WHERE login =  :usuario AND senha = :senha AND tipo = :tipo ")
//    int count(String usuario,String senha ,String tipo);
//
//
//    @Query("SELECT * FROM USER WHERE login like '%' || :login || '&'")
//    List<Usuario> findByLogin(String login);
}
