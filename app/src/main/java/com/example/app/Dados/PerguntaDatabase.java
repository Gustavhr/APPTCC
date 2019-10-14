package com.example.app.Dados;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.Model.Perguntas;


@Database(entities = {Perguntas.class},version = 1,exportSchema = false )
public abstract class PerguntaDatabase extends RoomDatabase  {

    public abstract PerguntaDAO perguntaDAO();
    private static PerguntaDatabase INSTANCE;

    public static PerguntaDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null){
            synchronized (PerguntaDatabase.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            PerguntaDatabase.class,"PERGUNTA.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
