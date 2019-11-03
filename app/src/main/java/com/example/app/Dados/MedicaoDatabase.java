package com.example.app.Dados;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.Model.Medicao;
import com.example.app.Model.Paciente;
import com.example.app.Model.Resposta;

@Database(entities = {Medicao.class,Paciente.class},version = 1,exportSchema = false )
public abstract class MedicaoDatabase extends RoomDatabase {
    public abstract MedicaoDAO medicaoDAO();
    private static MedicaoDatabase INSTANCE;

    public static MedicaoDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null){
            synchronized (MedicaoDatabase.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MedicaoDatabase.class,"MEDICAO.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
