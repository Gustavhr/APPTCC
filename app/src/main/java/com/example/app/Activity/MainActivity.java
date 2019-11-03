package com.example.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.app.Dados.UserDAO;
import com.example.app.Dados.UsuarioDatabase;
import com.example.app.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends Activity {

    Button btnregistrar,button;

    EditText txtmainlogin, txtmainsenha;
    Spinner user;
    UserDAO db;
    UsuarioDatabase userdb;
    public static final String PREFERENCES = "Config";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            db = new UserDAO(this);
            user = (Spinner) findViewById(R.id.spinnermain);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.user, android.R.layout.simple_spinner_item);
            btnregistrar = (Button) findViewById(R.id.btnmainlogin);
            userdb = UsuarioDatabase.getDatabase(MainActivity.this);

            txtmainlogin = (EditText) findViewById(R.id.txt_mainlogin);
            txtmainsenha = (EditText) findViewById(R.id.txt_mainsenha);
            user.setAdapter(adapter);

            button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, HomeCadastroUser.class);
                    startActivity(i);

                }
            }



            );


            btnregistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String senha = txtmainsenha.getText().toString();
                        String usuario = txtmainlogin.getText().toString();
                        String item = user.getSelectedItem().toString();
                        if (usuario.equals("")) {
                            Toast.makeText(MainActivity.this, "Usuário não informado!", Toast.LENGTH_SHORT).show();

                        } else if (senha.equals("")) {
                            Toast.makeText(MainActivity.this, "Senha não informada", Toast.LENGTH_SHORT).show();
                        } else if (item.equals("")) {
                            Toast.makeText(MainActivity.this, "Escolha o tipo de usuário", Toast.LENGTH_SHORT).show();
                        } else {
                            //Integer retorno = db.validalogin(usuario,senha,item);
                            Integer retorno = userdb.usuarioDAO().count(usuario, senha, item);
                            if (retorno > 0) {
                                SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES, 0);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("usuario", usuario);
                                editor.commit();

                                if (item.equals("Supervisor")) {
                                    Intent i = new Intent(MainActivity.this, HomeSupervisor.class);
                                    startActivity(i);
                                } else if (item.equals("Coletor")) {
                                    Intent i = new Intent(MainActivity.this, HomeColetor.class);
                                    startActivity(i);
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "Login falhou", Toast.LENGTH_SHORT).show();

                            }
                        }
                    } catch (NumberFormatException ex) {
                        Toast.makeText(MainActivity.this, "Existem campos com dados em formato incorreto", Toast.LENGTH_SHORT).show();
                    } catch (Exception ex) {
                        Toast.makeText(MainActivity.this, "Houve um erro no cadastro:  " + ex.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
        catch (Exception ex)
        {
            Toast.makeText(MainActivity.this, "Houve um erro na criação da página:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public void onStart(){
        super.onStart();
        txtmainlogin.setText("");
        txtmainsenha.setText("");
        user.setSelection(0);
    }
}
