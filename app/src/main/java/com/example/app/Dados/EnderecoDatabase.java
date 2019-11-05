package com.example.app.Dados;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.Model.Endereco;
import com.example.app.Model.Paciente;

@Database(entities = {Endereco.class,Paciente.class},version = 1,exportSchema = false )
public abstract class EnderecoDatabase extends RoomDatabase {

    public abstract EnderecoDAO enderecoDAO();
    private static EnderecoDatabase INSTANCE;

    public static EnderecoDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null){
            synchronized (EnderecoDatabase.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            EnderecoDatabase.class,"ENDERECO.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
