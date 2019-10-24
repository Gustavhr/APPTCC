package com.example.app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.app.Adapter.HomeColetorAdapter;
import com.example.app.Adapter.HomeSupervisorAdapter;
import com.example.app.Dados.PacienteDatabase;
import com.example.app.Dados.UserDAO;
import com.example.app.Dados.UsuarioDatabase;
import com.example.app.Model.Paciente;
import com.example.app.Model.Usuario;
import com.example.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeColetor extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton floating;
    PacienteDatabase db;
    HomeColetorAdapter homeColetorAdapter;
    List<Paciente> listpaciente = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_coletor);

            toolbar = findViewById(R.id.homecoletortoolbar);
            db = PacienteDatabase.getDatabase(HomeColetor.this);
            floating = findViewById(R.id.homecoletorfloating);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            recyclerView = findViewById(R.id.homecoletorrecycle);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            atualizaTela();

            floating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(HomeColetor.this, HomeCadastroPaciente.class);
                    startActivity(i);
                }
            });
        }
        catch (Exception ex){
                Toast.makeText(HomeColetor.this, "Houve um erro na criação da página:  " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void atualizaTela()
    {
        try {
            listpaciente = db.pacienteDAO().getAll();
            homeColetorAdapter = new HomeColetorAdapter(HomeColetor.this, listpaciente);
            RecyclerView.LayoutManager layoutManager =
                    new LinearLayoutManager((getApplicationContext()));
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(homeColetorAdapter);
        }
        catch (Exception ex)
        {
            Toast.makeText(HomeColetor.this, "Houve um erro na atualização da tela:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.homesupervisormenu, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.itemcoleta:
//                Toast.makeText(this, "Clicou coleta", Toast.LENGTH_SHORT).show();
//
//                break;
//            case  android.R.id.home:
//                Toast.makeText(this, "Clicou voltar", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        atualizaTela();
    }
}
