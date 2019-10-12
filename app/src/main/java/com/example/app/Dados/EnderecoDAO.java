package com.example.app.Dados;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app.Model.Endereco;
import com.example.app.Model.Paciente;

import java.util.List;

@Dao
public interface EnderecoDAO {

    @Insert
    void insert (Endereco endereco);

    @Update
    void update (Endereco endereco);

    @Delete
    void delete (Endereco endereco);

    @Query("SELECT * FROM ENDERECO")
    List<Endereco> getAll();

    //    @Query("SELECT COUNT(*) FROM USER WHERE login =  :usuario AND senha = :senha AND tipo = :tipo ")
//    int count(String usuario,String senha ,String tipo);
//
//
    @Query("SELECT * FROM ENDERECO WHERE idpaciente like :id ")
    Endereco findbyid(Integer id);
}
