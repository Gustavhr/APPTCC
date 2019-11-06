package com.example.app.Dados;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app.Model.Medicao;
import com.example.app.Model.Resposta;

import java.util.List;

@Dao
public interface MedicaoDAO {

    @Insert
    void insert (Medicao medicao);

    @Update
    void update (Medicao medicao);

    @Delete
    void delete (Medicao medicao);

    @Query("SELECT * FROM MEDICAO")
    List<Medicao> getAll();

    @Query("SELECT * FROM MEDICAO WHERE idpaciente like :id")
    List<Medicao> getAllById(Integer id);

//    @Query("SELECT COUNT(*) FROM USER WHERE login =  :usuario AND senha = :senha AND tipo = :tipo ")
//    int count(String usuario,String senha ,String tipo);
//
//
    @Query("SELECT * FROM MEDICAO WHERE Data like '%' || :data || '%'")
    List<Medicao> findByData(String data);
}
