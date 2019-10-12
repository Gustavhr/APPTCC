package com.example.app.Dados;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.Model.Paciente;


@Database(entities = {Paciente.class},version = 1,exportSchema = false )
public abstract class PacienteDatabase extends RoomDatabase{

    public abstract PacienteDAO pacienteDAO();
    private static PacienteDatabase INSTANCE;

    public static PacienteDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null){
            synchronized (PacienteDatabase.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            PacienteDatabase.class,"PACIENTE.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
