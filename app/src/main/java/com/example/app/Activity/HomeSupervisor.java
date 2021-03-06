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
import com.miguelcatalan.materialsearchview.MaterialSearchView;

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
    private MaterialSearchView searchView;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_supervisor);
        toolbar = findViewById(R.id.homesupervisortoolbar);
        db = UsuarioDatabase.getDatabase(HomeSupervisor.this);
        floating = findViewById(R.id.homesupervisorfloating);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        recyclerView = findViewById(R.id.homesupervisorrecycle);
        searchView = findViewById(R.id.searchViewId);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pesquisaUsuarios(newText);
                return true;
            }
        });
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
    catch(Exception ex)
    {
        Toast.makeText(this, "Houve um erro na criação da página:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
    }
    }

    public void pesquisaUsuarios(String usuarionome)
    {
        try {
            listusuario = db.usuarioDAO().findByNome(usuarionome);
            supervisorAdapter = new HomeSupervisorAdapter(HomeSupervisor.this, listusuario);
            recyclerView.setAdapter(supervisorAdapter);
            supervisorAdapter.notifyDataSetChanged();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Houve um erro na pesquisa:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }

    }


public void atualizaTela()
{
    try {
        listusuario = db.usuarioDAO().getAll();
        supervisorAdapter = new HomeSupervisorAdapter(HomeSupervisor.this, listusuario);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(supervisorAdapter);
    }
    catch(Exception ex)
    {
        Toast.makeText(this, "Houve um erro na atualização da tela:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
    }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homesupervisormenu, menu);
        MenuItem menuItem = menu.findItem(R.id.mnpesquisarsupervisor);
        searchView.setMenuItem(menuItem);
            return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemcoleta:
                Intent i = new Intent(HomeSupervisor.this, HomeColetor.class);
                startActivity(i);

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
