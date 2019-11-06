package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.app.Adapter.HomeColetorAdapter;
import com.example.app.Adapter.HomeMedicaoAdapter;
import com.example.app.Dados.MedicaoDatabase;
import com.example.app.Dados.PacienteDatabase;
import com.example.app.Model.Medicao;
import com.example.app.Model.Paciente;
import com.example.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class HomeMedicao extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton floating;
    MedicaoDatabase medicaodb;
    HomeMedicaoAdapter homeMedicaoAdapter;
    List<Medicao> listmedicao = new ArrayList<>();
    Paciente pacienteselecionado;
    Button editarcadastro;
    PacienteDatabase pacientedb;
    Integer ID;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_medicao);
            toolbar = findViewById(R.id.homemedicaotoolbar);
            medicaodb = MedicaoDatabase.getDatabase(HomeMedicao.this);
            pacientedb = PacienteDatabase.getDatabase(HomeMedicao.this);
            floating = findViewById(R.id.homemedicaofloating);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            recyclerView = findViewById(R.id.homemedicaorecycle);

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);


            floating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(HomeMedicao.this, HomeCadastroMedicao.class);
                    intent.putExtra("idpaciente", ID);
                    HomeMedicao.this.startActivity(intent);
                }
            });


            pacienteselecionado = (Paciente) getIntent().getSerializableExtra("usuario");

            ID = pacientedb.pacienteDAO().findID(pacienteselecionado.getNome());

            searchView = findViewById(R.id.searchViewIdcoletor);


            atualizaTela();
        }
        catch(Exception ex)
        {
            Toast.makeText(this, "Houve um erro na criação da página:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }

    }

    public void pesquisaMedicao(String pacientenome)
    {
        try {
            listmedicao = medicaodb.medicaoDAO().findByData(pacientenome);
            homeMedicaoAdapter = new HomeMedicaoAdapter(HomeMedicao.this, listmedicao);
            recyclerView.setAdapter(homeMedicaoAdapter);
            homeMedicaoAdapter.notifyDataSetChanged();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Houve um erro na pesquisa:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }

    }


    public void atualizaTela()
    {
    try {
    listmedicao = medicaodb.medicaoDAO().getAllById(ID);
    homeMedicaoAdapter = new HomeMedicaoAdapter(HomeMedicao.this, listmedicao);
    RecyclerView.LayoutManager layoutManager =
            new LinearLayoutManager((getApplicationContext()));
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(homeMedicaoAdapter);
        }
    catch(Exception ex){
    Toast.makeText(this, "Houve um erro na atualização da tela:  " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menupesquisa, menu);
        MenuItem menuItem = menu.findItem(R.id.mnpesquisar);
        searchView.setMenuItem(menuItem);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        atualizaTela();
    }
}
