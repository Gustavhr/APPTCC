package com.example.app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.app.Dados.UserDAO;
import com.example.app.Dados.UsuarioDatabase;
import com.example.app.Adapter.HomeSupervisorAdapter;
import com.example.app.Model.Usuario;
import com.example.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeSupervisor extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Usuario> usuarios;
    FloatingActionButton floating;
    UserDAO userdao;
    Usuario user;
    UsuarioDatabase db;
    HomeSupervisorAdapter supervisorAdapter;
    List<Usuario> listusuario = new ArrayList<>();

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_supervisor);
        toolbar = findViewById(R.id.homesupervisortoolbar);
        db = UsuarioDatabase.getDatabase(HomeSupervisor.this);
        floating = findViewById(R.id.homesupervisorfloating);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    recyclerView = findViewById(R.id.homesupervisorrecycle);

        atualizaTela();


//        user = new Usuario();
//        toolbar.setTitle("Bem vindo "+user.getNome());



        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeSupervisor.this, HomeCadastroUser.class);
                startActivity(i);
            }
        });


    }

public void atualizaTela()
{
    listusuario = db.usuarioDAO().getAll();
    supervisorAdapter = new HomeSupervisorAdapter(HomeSupervisor.this,listusuario);
    RecyclerView.LayoutManager layoutManager =
            new LinearLayoutManager((getApplicationContext()));
            recyclerView.setLayoutManager(layoutManager);
           recyclerView.setAdapter(supervisorAdapter);



//    userdao = new UserDAO(this);
//    usuarios = userdao.getLista();
//
//    HomeSupervisorAdapter homeadapter = new HomeSupervisorAdapter(usuarios, getApplicationContext(), new HomeSupervisorAdapter.OnItemClickListener() {
//        @Override
//        public void onItemClick(Usuario usuarios) {
//            //            Usuario users = (Usuario) usuarios;
//            Toast.makeText(HomeSupervisor.this, ""+usuarios.getNome(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(HomeSupervisor.this ,HomeCadastroUser.class);
//            intent.putExtra("usuario",usuarios.getLogin());
//            startActivity(intent);
//        }
//    });
//    recyclerView.setAdapter(homeadapter);
//
//    RecyclerView.LayoutManager layoutM = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//    recyclerView.setLayoutManager(layoutM);




}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homesupervisormenu, menu);
            return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemcoleta:
                Toast.makeText(this, "Clicou coleta", Toast.LENGTH_SHORT).show();

                break;
            case  android.R.id.home:
                Toast.makeText(this, "Clicou voltar", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        atualizaTela();
    }
}
