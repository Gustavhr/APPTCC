package com.example.app.Dados;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.Model.Usuario;

@Database(entities = {Usuario.class},version = 1,exportSchema = false )
public abstract class UsuarioDatabase  extends RoomDatabase {

    public abstract UsuarioDAO usuarioDAO();
    private static UsuarioDatabase INSTANCE;

    public static UsuarioDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null){
            synchronized (UsuarioDatabase.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UsuarioDatabase.class,"USER.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
