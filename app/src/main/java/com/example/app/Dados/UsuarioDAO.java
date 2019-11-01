package com.example.app.Dados;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app.Model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Insert
    void insert (Usuario user);

    @Update
    void update (Usuario user);

    @Delete
    void delete (Usuario user);

    @Query("SELECT * FROM USER")
    List<Usuario> getAll();

    @Query("SELECT COUNT(*) FROM USER WHERE login =  :usuario AND senha = :senha AND tipo = :tipo ")
    int count(String usuario,String senha ,String tipo);


    @Query("SELECT * FROM USER WHERE login like '%' || :login || '%'")
    List<Usuario> findByLogin(String login);

    @Query("SELECT * FROM USER WHERE nome like '%' ||:nome|| '%'")
    List<Usuario> findByNome(String nome);

    @Query("SELECT * FROM USER WHERE login = :login ")
    int validaLogin(String login);

}
