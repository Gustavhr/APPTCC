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
        super.onCreate(savedInstanceState);
        userdb = UsuarioDatabase.getDatabase(HomeCadastroUser.this);
        setContentView(R.layout.activity_home_cadastro_user);
        user = (Spinner) findViewById(R.id.spinnerusercadastro);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.user,android.R.layout.simple_spinner_item);
//       db = new UserDAO(this);
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

        if(usuarioselecionado!=null){
            txt_username.setText(usuarioselecionado.getLogin());
            txt_senha.setText(usuarioselecionado.getPassword());
            txt_senha2.setText(usuarioselecionado.getPassword());
            txt_nome.setText(usuarioselecionado.getNome());
            txt_email.setText(usuarioselecionado.getEmail());


        }
//        Intent intent = this.getIntent();
//
//        String login = intent.getStringExtra("usuario");
//        this.usuario = db.SelecionaUsuario(login);
//        if(this.usuario != null)
//        {
//            txt_username.setText(usuario.getLogin());
//            txt_senha.setText(usuario.getPassword());
//            txt_senha2.setText(usuario.getPassword());
//            txt_nome.setText(usuario.getNome());
//            txt_email.setText(usuario.getEmail());
//
//
//        }
//
   }

    public void cadastraUser(){
        String usuario = txt_username.getText().toString();
        String s1 = txt_senha.getText().toString();
        String s2 = txt_senha2.getText().toString();
        String item = user.getSelectedItem().toString();
        String nome = txt_nome.getText().toString();
        String email = txt_email.getText().toString();
        if(usuario.equals("")){
            Toast.makeText(HomeCadastroUser.this,"Digite o usuário", Toast.LENGTH_SHORT).show();
        }
        else if(s1.equals("")||s2.equals("")){
            Toast.makeText(HomeCadastroUser.this,"Digite a senha", Toast.LENGTH_SHORT).show();
        }
        else if(!s1.equals(s2)){
            Toast.makeText(HomeCadastroUser.this,"Senhas diferentes", Toast.LENGTH_SHORT).show();
        }
        else if(item.equals("")){
            Toast.makeText(HomeCadastroUser.this,"Escolha o tipo de usuário", Toast.LENGTH_SHORT).show();
        }
        else if(nome.equals("")){
            Toast.makeText(HomeCadastroUser.this,"Insira o nome", Toast.LENGTH_SHORT).show();
        }
        else if(email.equals("")){
            Toast.makeText(HomeCadastroUser.this,"Insira o email", Toast.LENGTH_SHORT).show();
        }
        else{

            if(usuarioselecionado == null)
            {
                Usuario userr = new Usuario();
                userr.setNome(nome);
                userr.setEmail(email);
                userr.setLogin(usuario);
                userr.setPassword(s1);
                userr.setTipo(item);
                userdb.usuarioDAO().insert(userr);
                Toast.makeText(HomeCadastroUser.this,"Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
            else    {
                usuarioselecionado.setLogin(usuario);
                usuarioselecionado.setPassword(s1);
                usuarioselecionado.setTipo(item);
                usuarioselecionado.setNome(nome);
                usuarioselecionado.setEmail(email);
                userdb.usuarioDAO().update(usuarioselecionado);
                Toast.makeText(HomeCadastroUser.this,"Cadastro alterado com sucesso", Toast.LENGTH_SHORT).show();
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
   Boolean validaCampo(String campo)
   {
       if(campo == null || campo.equals(""))
           return false;
       return true;
   }
}
