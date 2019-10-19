package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app.Adapter.HomeColetorAdapter;
import com.example.app.Adapter.HomeMedicaoAdapter;
import com.example.app.Dados.MedicaoDatabase;
import com.example.app.Model.Medicao;
import com.example.app.Model.Paciente;
import com.example.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medicao);
        toolbar = findViewById(R.id.homemedicaotoolbar);
        medicaodb = MedicaoDatabase.getDatabase(HomeMedicao.this);
        floating = findViewById(R.id.homemedicaofloating);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.homemedicaorecycle);
        editarcadastro = (Button) findViewById(R.id.btneditarcadastropaciente);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        atualizaTela();

        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeMedicao.this, HomeCadastroMedicao.class);
                startActivity(i);
            }
        });



        pacienteselecionado = (Paciente) getIntent().getSerializableExtra("usuario");

        editarcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeMedicao.this, HomeCadastroPaciente.class);
                intent.putExtra("usuariocadastrado",pacienteselecionado);
                HomeMedicao.this.startActivity(intent);

            }
        });



    }


    public void atualizaTela()
    {
        listmedicao = medicaodb.medicaoDAO().getAll();
        homeMedicaoAdapter = new HomeMedicaoAdapter(HomeMedicao.this,listmedicao);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeMedicaoAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        atualizaTela();
    }
}
