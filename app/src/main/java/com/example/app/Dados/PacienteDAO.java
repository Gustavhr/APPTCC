package com.example.app.Dados;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app.Model.Paciente;
import com.example.app.Model.Usuario;

import java.util.List;

@Dao
public interface PacienteDAO {

    @Insert
    void insert (Paciente paciente);

    @Update
    void update (Paciente paciente);

    @Delete
    void delete (Paciente paciente);

    @Query("SELECT * FROM paciente")
    List<Paciente> getAll();

//    @Query("SELECT COUNT(*) FROM USER WHERE login =  :usuario AND senha = :senha AND tipo = :tipo ")
//    int count(String usuario,String senha ,String tipo);
//
//
    @Query("SELECT id FROM paciente WHERE nome like :name ")
    int findID(String name);

    @Query("SELECT * FROM paciente WHERE nome like '%' ||:nome|| '%'")
    List<Paciente> findByNome(String nome);



}
