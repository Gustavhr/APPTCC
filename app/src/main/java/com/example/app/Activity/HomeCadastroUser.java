package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.app.Dados.UserDAO;
import com.example.app.Dados.UsuarioDatabase;
import com.example.app.Model.Usuario;
import com.example.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeCadastroUser extends AppCompatActivity {


    EditText txt_username, txt_senha,txt_senha2,txt_nome,txt_email;
    Button bt_registrar;
    Spinner user;
    UserDAO db;
    HomeSupervisor homeSupervisor;
    Usuario usuarioselecionado;
    UsuarioDatabase userdb;
    FloatingActionButton floating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            userdb = UsuarioDatabase.getDatabase(HomeCadastroUser.this);
            setContentView(R.layout.activity_home_cadastro_user);
            user = (Spinner) findViewById(R.id.spinnerusercadastro);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.user, android.R.layout.simple_spinner_item);

            txt_username = (EditText) findViewById(R.id.txt_userlogin);
            txt_senha = (EditText) findViewById(R.id.txt_usersenha);
            txt_senha2 = (EditText) findViewById(R.id.txt_usersenha2);
            floating = findViewById(R.id.floatingcadastrouser);
            txt_nome = (EditText) findViewById(R.id.txt_usernome);
            txt_email = (EditText) findViewById(R.id.txt_useremail);
            user.setAdapter(adapter);
            floating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    cadastraUser();
                }
            });
            usuarioselecionado = (Usuario) getIntent().getSerializableExtra("usuario");

            if (usuarioselecionado != null) {
                txt_username.setText(usuarioselecionado.getLogin());
                txt_senha.setText(usuarioselecionado.getPassword());
                txt_senha2.setText(usuarioselecionado.getPassword());
                txt_nome.setText(usuarioselecionado.getNome());
                txt_email.setText(usuarioselecionado.getEmail());


            }
        }
        catch(Exception ex){
            Toast.makeText(this, "Houve um erro na criação da página:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastraUser(){
        try {
            String usuario = txt_username.getText().toString();
            String s1 = txt_senha.getText().toString();
            String s2 = txt_senha2.getText().toString();
            String item = user.getSelectedItem().toString();
            String nome = txt_nome.getText().toString();
            String email = txt_email.getText().toString();
            //VALIDACAO DE MESMO USUARIO
            if (usuario.equals("")) {
                Toast.makeText(HomeCadastroUser.this, "Digite o usuário", Toast.LENGTH_SHORT).show();
            } else if (validaUsuario(usuario)) {
                Toast.makeText(HomeCadastroUser.this, "O usuário já existe", Toast.LENGTH_SHORT).show(); }
            else if (s1.equals("") || s2.equals("")) {
                Toast.makeText(HomeCadastroUser.this, "Digite a senha", Toast.LENGTH_SHORT).show();
            } else if (!s1.equals(s2)) {
                Toast.makeText(HomeCadastroUser.this, "Senhas diferentes", Toast.LENGTH_SHORT).show();
            } else if (item.equals("")) {
                Toast.makeText(HomeCadastroUser.this, "Escolha o tipo de usuário", Toast.LENGTH_SHORT).show();
            } else if (nome.equals("")) {
                Toast.makeText(HomeCadastroUser.this, "Insira o nome", Toast.LENGTH_SHORT).show();
            } else if (email.equals("")) {
                Toast.makeText(HomeCadastroUser.this, "Insira o email", Toast.LENGTH_SHORT).show();
            } else {

                if (usuarioselecionado == null) {
                    Usuario userr = new Usuario();
                    userr.setNome(nome);
                    userr.setEmail(email);
                    userr.setLogin(usuario);
                    userr.setPassword(s1);
                    userr.setTipo(item);
                    userdb.usuarioDAO().insert(userr);
                    Toast.makeText(HomeCadastroUser.this, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    usuarioselecionado.setLogin(usuario);
                    usuarioselecionado.setPassword(s1);
                    usuarioselecionado.setTipo(item);
                    usuarioselecionado.setNome(nome);
                    usuarioselecionado.setEmail(email);
                    userdb.usuarioDAO().update(usuarioselecionado);
                    Toast.makeText(HomeCadastroUser.this, "Cadastro alterado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();

                }


//                    long retorno = db.criaUsuario(usuario,s1,item,nome,email);
//                    if(retorno >0){
//                        Toast.makeText(HomeCadastroUser.this,"Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
//                        homeSupervisor = new HomeSupervisor();
//
//                        finish();
//                    }
//                    else{
//                        Toast.makeText(HomeCadastroUser.this,"Registro invalido", Toast.LENGTH_SHORT).show();
//
//                    }
            }
        }
        catch (NumberFormatException ex){
            Toast.makeText(this, "Existem campos com dados em formato incorreto", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){
            Toast.makeText(this, "Houve algum erro no cadastro: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
   Boolean validaCampo(String campo)
   {
       if(campo == null || campo.equals(""))
           return false;
       return true;
   }

    Boolean validaUsuario(String campo)
    {
        Integer aux = userdb.usuarioDAO().validaLogin(campo);
        if(aux>0)
            return true;
        return false;
    }
}
