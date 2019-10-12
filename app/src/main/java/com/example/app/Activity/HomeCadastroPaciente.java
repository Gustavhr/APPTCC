package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.app.Dados.EnderecoDatabase;
import com.example.app.Dados.PacienteDatabase;
import com.example.app.Model.Endereco;
import com.example.app.Model.Paciente;
import com.example.app.Model.Usuario;
import com.example.app.R;

import java.util.ArrayList;
import java.util.Date;

public class HomeCadastroPaciente extends AppCompatActivity {

    // TELA
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10,rg11,rg12,rgsexo;
    RadioButton rbs1,rbn1,rbs2,rbn2,rbs3,rbn3,rbs4,rbn4,rbs5,rbn5,rbs6,rbn6,rbs7,rbn7,rbs8,rbn8,rbs9,rbn9,rbs10,rbn10,rbs11,rbn11,rbs12,rbn12,rbmas,rbfem;
    EditText date1,date2,date3,date4,date5,date6,date7,date8,date9,date10,date11,date12,txtmulti;


    // RESPOSTAS
    Boolean [] respotas = new Boolean[12];
    String [] datasiniciais = new String[12];
    EditText txtnome,txttelefone,txtrua,txtnumero,txtbairro,txtcidade,txtcep;
    Character sexo;


    // OBJETOS
    PacienteDatabase pacientedb;
    Paciente pacienteselecionado;
    Endereco enderecoselecionado;
    EnderecoDatabase enderecodb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cadastro_paciente);
        txtnome = (EditText) findViewById(R.id.txt_nome);
        txttelefone = (EditText) findViewById(R.id.txt_telefone);
        pacientedb = PacienteDatabase.getDatabase(HomeCadastroPaciente.this);
        enderecodb = EnderecoDatabase.getDatabase(HomeCadastroPaciente.this);
        txtrua = (EditText) findViewById(R.id.txt_end);
        txtnumero = (EditText) findViewById(R.id.txt_num);
        txtbairro = (EditText) findViewById(R.id.txt_bairro);
        txtcidade = (EditText) findViewById(R.id.txt_cidade);
        txtcep  = (EditText) findViewById(R.id.txtcep);
        txtmulti = (EditText) findViewById(R.id.txtmulti);




// DATAS
        date1 = findViewById(R.id.data1);
        date2 = findViewById(R.id.data2);
        date3 = findViewById(R.id.data3);
        date4 = findViewById(R.id.data4);
        date5 = findViewById(R.id.data5);
        date6 = findViewById(R.id.data6);
        date7 = findViewById(R.id.data7);
        date8 = findViewById(R.id.data8);
        date9 = findViewById(R.id.data9);
        date10 = findViewById(R.id.data10);
        date11 = findViewById(R.id.data11);
        date12 = findViewById(R.id.data12);
// RADIOS
        rgsexo = findViewById(R.id.rgsexo);
        rbmas = findViewById(R.id.rbmasc);
        rbfem = findViewById(R.id.rbfem);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        rg4 = findViewById(R.id.rg4);
        rg5 = findViewById(R.id.rg5);
        rg6 = findViewById(R.id.rg6);
        rg7 = findViewById(R.id.rg7);
        rg8 = findViewById(R.id.rg8);
        rg9 = findViewById(R.id.rg9);
        rg10 = findViewById(R.id.rg10);
        rg11 = findViewById(R.id.rg11);
        rg12 = findViewById(R.id.rg12);

        rbs1 = findViewById(R.id.rbs1);
        rbn1 = findViewById(R.id.rbn1);
        rbs2 = findViewById(R.id.rbs2);
        rbn2 = findViewById(R.id.rbn2);
        rbs3 = findViewById(R.id.rbs3);
        rbn3 = findViewById(R.id.rbn3);
        rbs4 = findViewById(R.id.rbs4);
        rbn4 = findViewById(R.id.rbn4);
        rbs5 = findViewById(R.id.rbs5);
        rbn5 = findViewById(R.id.rbn5);
        rbs6 = findViewById(R.id.rbs6);
        rbn6 = findViewById(R.id.rbn6);
        rbs7 = findViewById(R.id.rbs7);
        rbn7 = findViewById(R.id.rbn7);
        rbs8 = findViewById(R.id.rbs8);
        rbn8 = findViewById(R.id.rbn8);
        rbs9 = findViewById(R.id.rbs9);
        rbn9 = findViewById(R.id.rbn9);
        rbs10 = findViewById(R.id.rbs10);
        rbn10= findViewById(R.id.rbn10);
        rbs11 = findViewById(R.id.rbs11);
        rbn11 = findViewById(R.id.rbn11);
        rbs12 = findViewById(R.id.rbs12);
        rbn12 = findViewById(R.id.rbn12);


        rgsexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbmasc){
                   sexo = 'M';
                }
                if(i==R.id.rbfem)
                {
                    sexo = 'F';
                }
            }
        });


        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if(i==R.id.rbs1){
                        date1.setEnabled(true);
                        respotas[0]=true;
                        datasiniciais[0]=date1.getText().toString();
                    }
                    if(i==R.id.rbn1)
                    {
                        date1.setEnabled(false);
                        date1.setText("");
                        respotas[0]=false;
                        datasiniciais[0]="";
                    }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs2){
                    date2.setEnabled(true);
                    respotas[1]=true;
                    datasiniciais[1]=date2.getText().toString();
                }
                if(i==R.id.rbn2)
                {
                    date2.setEnabled(false);
                    date2.setText("");
                    respotas[1]=false;
                    datasiniciais[1]="";
                }
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs3){
                    date3.setEnabled(true);
                    respotas[2]=true;
                    datasiniciais[2]=date3.getText().toString();
                }
                if(i==R.id.rbn3)
                {
                    date3.setEnabled(false);
                    date3.setText("");
                    respotas[2]=false;
                    datasiniciais[2]="";
                }
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs4){
                    date4.setEnabled(true);
                    respotas[3]=true;
                    datasiniciais[3]=date4.getText().toString();
                }
                if(i==R.id.rbn4)
                {
                    date4.setEnabled(false);
                    date4.setText("");
                    respotas[3]=false;
                    datasiniciais[3]="";
                }
            }
        });
        rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs5){
                    date5.setEnabled(true);
                    respotas[4]=true;
                    datasiniciais[4]=date5.getText().toString();
                }
                if(i==R.id.rbn5)
                {
                    date5.setEnabled(false);
                    date5.setText("");
                    respotas[4]=false;
                    datasiniciais[4]="";
                }
            }
        });
        rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs6){
                    date6.setEnabled(true);
                    respotas[5]=true;
                    datasiniciais[5]=date6.getText().toString();
                }
                if(i==R.id.rbn6)
                {
                    date6.setEnabled(false);
                    date6.setText("");
                    respotas[5]=false;
                    datasiniciais[5]="";
                }
            }
        });
        rg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs7){
                    date7.setEnabled(true);
                    respotas[6]=true;
                    datasiniciais[6]=date7.getText().toString();
                }
                if(i==R.id.rbn7)
                {
                    date7.setEnabled(false);
                    date7.setText("");
                    respotas[6]=false;
                    datasiniciais[6]="";
                }
            }
        });
        rg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs8){
                    date8.setEnabled(true);
                    respotas[7]=true;
                    datasiniciais[7]=date8.getText().toString();
                }
                if(i==R.id.rbn8)
                {
                    date8.setEnabled(false);
                    date8.setText("");
                    respotas[7]=false;
                    datasiniciais[7]="";
                }
            }
        });
        rg9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs9){
                    date9.setEnabled(true);
                    respotas[8]=true;
                    datasiniciais[8]=date9.getText().toString();
                }
                if(i==R.id.rbn9)
                {
                    date9.setEnabled(false);
                    date9.setText("");
                    respotas[8]=false;
                    datasiniciais[8]="";
                }
            }
        });
        rg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs10){
                    date10.setEnabled(true);
                    respotas[9]=true;
                    datasiniciais[9]=date10.getText().toString();
                }
                if(i==R.id.rbn10)
                {
                    date10.setEnabled(false);
                    date10.setText("");
                    respotas[9]=false;
                    datasiniciais[9]="";
                }

            }
        });
        rg11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs11){
                    date11.setEnabled(true);
                    respotas[10]=true;
                    datasiniciais[10]=date11.getText().toString();
                }
                if(i==R.id.rbn11)
                {
                    date11.setEnabled(false);
                    date11.setText("");
                    respotas[10]=false;
                    datasiniciais[10]="";
                }
            }
        });
        rg12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbs12){
                    date12.setEnabled(true);
                    txtmulti.setEnabled(true);
                    respotas[11]=true;
                    datasiniciais[11]=date12.getText().toString();

                }
                if(i==R.id.rbn12)
                {
                    date12.setEnabled(false);
                    txtmulti.setEnabled(false);
                    date12.setText("");
                    txtmulti.setText("");
                    respotas[11]=false;
                    datasiniciais[11]="";
                }
            }
        });

        pacienteselecionado = (Paciente) getIntent().getSerializableExtra("usuario");

        if(pacienteselecionado!=null){
            Integer ID = pacientedb.pacienteDAO().findID(pacienteselecionado.getNome());
            enderecoselecionado = (Endereco) enderecodb.enderecoDAO().findbyid(ID);
            txtnome.setText(pacienteselecionado.getNome());
            txttelefone.setText(pacienteselecionado.getTelefone());
            Character sexaux = pacienteselecionado.getSexo();
            if(sexaux=='M')
            {
                rbmas.setChecked(true);
            }
            else{
                rbfem.setChecked(true);
            }
            txtrua.setText(enderecoselecionado.getDescricao());
            txtbairro.setText(enderecoselecionado.getBairro());
            txtcidade.setText(enderecoselecionado.getCidade());
            txtcep.setText(enderecoselecionado.getCEP());
            txtnumero.setText(enderecoselecionado.getNumero());
        }


    }

    public void OnClickCadastrar(View view)
        {
            datasiniciais[0]=date1.getText().toString();
            datasiniciais[1]=date2.getText().toString();
            datasiniciais[2]=date3.getText().toString();
            datasiniciais[3]=date4.getText().toString();
            datasiniciais[4]=date5.getText().toString();
            datasiniciais[5]=date6.getText().toString();
            datasiniciais[6]=date7.getText().toString();
            datasiniciais[7]=date8.getText().toString();
            datasiniciais[8]=date9.getText().toString();
            datasiniciais[9]=date10.getText().toString();
            datasiniciais[10]=date11.getText().toString();
            datasiniciais[11]=date12.getText().toString();

            // INSERCAO
                if(valida())
                {
                    String nome = txtnome.getText().toString();
                    String telefone = txttelefone.getText().toString();
                    String rua = txtrua.getText().toString();
                    String numero = txtnumero.getText().toString();
                    String bairro = txtbairro.getText().toString();
                    String cidade = txtcidade.getText().toString();
                    String cep = txtcep.getText().toString();

                    //INSERCAO
                    if(pacienteselecionado==null) {

                        //SALVA PACIENTE
                        Paciente paciente = new Paciente();
                        paciente.setNome(nome);
                        paciente.setTelefone(telefone);
                        paciente.setSexo(sexo);
                        pacientedb.pacienteDAO().insert(paciente);
                        Integer id = pacientedb.pacienteDAO().findID(nome);
                        //SALVA ENDEREÇO
                        Endereco endereco = new Endereco();
                        endereco.setDescricao(rua);
                        endereco.setBairro(bairro);
                        endereco.setCEP(cep);
                        endereco.setCidade(cidade);
                        endereco.setNumero(numero);
                        endereco.setIdpaciente(id);
                        enderecodb.enderecoDAO().insert(endereco);
                        Toast.makeText(this, "Boa", Toast.LENGTH_SHORT).show();
                        finish();
                    }
    //UPDATE
                    else
                    {
                       //ALTERA PACIENTE
                        pacienteselecionado.setNome(nome);
                        pacienteselecionado.setTelefone(telefone);
                        pacienteselecionado.setSexo(sexo);
                        pacientedb.pacienteDAO().update(pacienteselecionado);

                        //ALTERA ENDEREÇO
                        enderecoselecionado.setCidade(cidade);
                        enderecoselecionado.setDescricao(rua);
                        enderecoselecionado.setCEP(cep);
                        enderecoselecionado.setBairro(bairro);
                        enderecoselecionado.setNumero(numero);
                        enderecodb.enderecoDAO().update(enderecoselecionado);

                        Toast.makeText(HomeCadastroPaciente.this,"Cadastro alterado com sucesso", Toast.LENGTH_SHORT).show();
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
//         int count = 0;
//        for (Boolean checked: this.respotas
//             ) {
//            if(checked == null)
//            {
//                valida = false;
//            }
//            else if(checked==true )
//            {
//                if(datasiniciais[count].equals("")) {
//                    valida = false;
//                }
//            }
//            count++;
//        }
        return valida;
    }
}
