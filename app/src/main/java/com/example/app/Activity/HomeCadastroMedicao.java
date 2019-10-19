package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.app.Dados.MedicaoDatabase;
import com.example.app.Model.Medicao;
import com.example.app.R;

public class HomeCadastroMedicao extends AppCompatActivity {

    RadioGroup rgrotina,rgpedido;
    RadioButton rbrs,rbrn,rbps,rbpn;
    EditText txtpasist,txtpadist,txtfc,txtcoment;
    Boolean pedido,rotina;
    Medicao medicaoselecionada;

    MedicaoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cadastro_medicao);

        txtpadist = (EditText) findViewById(R.id.txt_padist);
        txtpasist = (EditText) findViewById(R.id.txt_pasist);
        txtfc = (EditText) findViewById(R.id.txt_fc);
        txtcoment = (EditText) findViewById(R.id.txt_comentario);
        db = MedicaoDatabase.getDatabase(HomeCadastroMedicao.this);
        rgrotina = findViewById(R.id.rgrotina);
        rgpedido = findViewById(R.id.rgpedido);
        rbrs = findViewById(R.id.rbrotinasim);
        rbrn = findViewById(R.id.rbrotinanao);
        rbps = findViewById(R.id.rbpedidosim);
        rbpn = findViewById(R.id.rbpedidonao);

        rgrotina.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbrotinasim){
                   rotina = true;
                }
                if(i==R.id.rbrotinanao)
                {
                   rotina = false;
                }
            }
        });

        rgpedido.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbpedidosim){
                    pedido = true;
                }
                if(i==R.id.rbpedidonao)
                {
                    pedido = false;
                }
            }
        });


        medicaoselecionada = (Medicao) getIntent().getSerializableExtra("medicao");

        if(medicaoselecionada!=null){
//            Integer ID = pacientedb.pacienteDAO().findID(pacienteselecionado.getNome());
//            enderecoselecionado = (Endereco) enderecodb.enderecoDAO().findbyid(ID);
            txtcoment.setText(medicaoselecionada.getComentario());
            txtfc.setText(String.valueOf(medicaoselecionada.getFC()));
            txtpasist.setText(String.valueOf(medicaoselecionada.getPasist()));
            txtpadist.setText(String.valueOf(medicaoselecionada.getPadist()));

            Boolean pedidoaux,rotinaaux;
            pedidoaux = medicaoselecionada.getPedido();
            rotinaaux = medicaoselecionada.getRotina();

            if(pedidoaux==true)
            {
                rbps.setChecked(true);
            }
            else{
                rbpn.setChecked(true);
            }

            if(rotinaaux==true)
            {
                rbrs.setChecked(true);
            }
            else{
                rbrn.setChecked(true);
            }
        }


    }

    public void OnClickCadastrar(View view)
    {


        // INSERCAO
        if(valida())
        {
            String pasiststring = txtpasist.getText().toString();
            int pasist=Integer.parseInt(pasiststring);
            String padiststring = txtpadist.getText().toString();
            int padist=Integer.parseInt(padiststring);
            String fcstring = txtfc.getText().toString();
            int fc=Integer.parseInt(fcstring);
            String comentario = txtcoment.getText().toString();


            //INSERCAO
            if(medicaoselecionada==null) {

                //SALVA PACIENTE
               Medicao medicao = new Medicao();
                medicao.setComentario(comentario);
                medicao.setFC(fc);
                medicao.setPadist(padist);
                medicao.setPasist(pasist);
                medicao.setPedido(pedido);
                medicao.setRotina(rotina);
                db.medicaoDAO().insert(medicao);


                Toast.makeText(this, "Boa", Toast.LENGTH_SHORT).show();
                finish();
            }
            //UPDATE
            else
            {
                //ALTERA PACIENTE
                medicaoselecionada.setComentario(comentario);
                medicaoselecionada.setFC(fc);
                medicaoselecionada.setPadist(padist);
                medicaoselecionada.setPasist(pasist);
                medicaoselecionada.setPedido(pedido);
                medicaoselecionada.setRotina(rotina);
                db.medicaoDAO().update(medicaoselecionada);
                Toast.makeText(HomeCadastroMedicao.this,"Cadastro alterado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }

        }
        else
        {
            Toast.makeText(this, "Favor preencher todos os campos", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean valida()
    {
        Boolean valida = true;
        int count = 0;
        if(txtpadist.toString() =="" || txtpasist.toString() =="" || txtfc.toString()=="" || txtcoment.toString()=="" ||
           rotina == null || pedido ==null)
        {
            valida = false;
        }
        return valida;
    }
}
