package com.example.app.Dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.app.Model.Usuario;

import java.util.ArrayList;

public class PerguntasDAO extends SQLiteOpenHelper {

    private  static int versao = 1;
    private static String nome="Pergunta.db";


    public PerguntasDAO(Context context){
        super(context,nome ,null,versao);
    }

    public void onCreate(SQLiteDatabase db){
        String str = "CREATE TABLE PERGUNTAS (id INTERGER  , usuario TEXT PRIMARY KEY , senha TEXT , tipousuario TEXT,nome TEXT,email TEXT);";
        db.execSQL(str);

    }


    public void onUpgrade(SQLiteDatabase db, int versaoantiga , int versaonova){
        db.execSQL("DROP TABLE IF EXISTS PERGUNTAS;");
        onCreate(db);
    }
    public long criaUsuario(String usuario, String senha,String tipousuario,String nome,String email){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario",usuario);
        cv.put("senha",senha);
        cv.put("tipousuario",tipousuario);
        cv.put("nome",nome);
        cv.put("email",email);
        long retorno = db.insert("USER",null,cv );
        return retorno;
    }
    public Integer validalogin(String usuario, String senha,String tipousuario)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM USER WHERE usuario =? AND senha =? AND tipousuario=?" , new String[]{usuario,senha,tipousuario});
        if(c.getCount()>0)
        {
            return 0;
        }
        return 1;
    }

    public void apagaUsuario(Usuario usuarios)
    {
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {usuarios.getId().toString()};
        db.delete("USER","id=?",args);
    }

    public void alteraUsuario(Usuario usuarios)
    {
        ContentValues cv = new ContentValues();
        cv.put("usuario",usuarios.getLogin());
        cv.put("senha",usuarios.getPassword());
        cv.put("tipousuario",usuarios.getTipo());
        cv.put("nome",usuarios.getNome());
        cv.put("email",usuarios.getEmail());

        String[] idAlterar = {usuarios.getId().toString()};

        getWritableDatabase().update("USER",cv,"id=?",idAlterar);
    }

    public ArrayList<Usuario> getLista()
    {
        ArrayList<Usuario> user = new ArrayList<Usuario>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM USER ORDER BY nome  ;", null);
        if(cursor.getCount()>0) {

            while (cursor.moveToNext()) {
                Usuario users = new Usuario();

                users.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                users.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                users.setLogin(cursor.getString(cursor.getColumnIndex("usuario")));
                users.setTipo(cursor.getString(cursor.getColumnIndex("tipousuario")));
                user.add(users);
            }
        }
        cursor.close();
        return user;
    }

}
