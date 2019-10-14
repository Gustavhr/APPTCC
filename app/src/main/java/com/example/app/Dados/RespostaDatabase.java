package com.example.app.Dados;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.Model.Resposta;


@Database(entities = {Resposta.class},version = 1,exportSchema = false )
public abstract class RespostaDatabase extends RoomDatabase {

    public abstract RespostaDAO respostaDAO();
    private static RespostaDatabase INSTANCE;

    public static RespostaDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null){
            synchronized (RespostaDatabase.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            RespostaDatabase.class,"RESPOSTA.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
