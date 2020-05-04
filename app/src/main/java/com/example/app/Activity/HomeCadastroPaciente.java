package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.Dados.EnderecoDatabase;
import com.example.app.Dados.PacienteDatabase;
import com.example.app.Dados.RespostaDatabase;
import com.example.app.Model.Endereco;
import com.example.app.Model.Paciente;
import com.example.app.Model.Resposta;
import com.example.app.Model.Usuario;
import com.example.app.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class HomeCadastroPaciente extends AppCompatActivity {

    // TELA
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10,rg11,rg12,rgsexo;
    RadioButton rbs1,rbn1,rbs2,rbn2,rbs3,rbn3,rbs4,rbn4,rbs5,rbn5,rbs6,rbn6,rbs7,rbn7,rbs8,rbn8,rbs9,rbn9,rbs10,rbn10,rbs11,rbn11,rbs12,rbn12,rbmas,rbfem;
    EditText date1,date2,date3,date4,date5,date6,date7,date8,date9,date10,date11,date12,txtmulti;


    // RESPOSTAS
    Boolean [] respotas = new Boolean[12];
    String [] datasiniciais = new String[12];
    EditText txtnome,txttelefone,txtrua,txtnumero,txtbairro,txtcidade,txtcep,txtcpf,txtrg;
    Character sexo = ' ';


    // OBJETOS
    PacienteDatabase pacientedb;
    Paciente pacienteselecionado;
    Endereco enderecoselecionado;
    Resposta respostaselecionada;
    List<Resposta> respostaList;
    EnderecoDatabase enderecodb;
    RespostaDatabase respostaDatabase;
    Button floating;
    // DECLARAÇÃO DOS ATRIBUTOS VISUAIS QUE SERÃO ACESSADOS VIA PROGRAMAÇÃO
    private TextView txtLatitude, txtLongitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_cadastro_paciente);
            txtnome = (EditText) findViewById(R.id.txt_nome);
            txttelefone = (EditText) findViewById(R.id.txt_telefone);
            pacientedb = PacienteDatabase.getDatabase(HomeCadastroPaciente.this);
            enderecodb = EnderecoDatabase.getDatabase(HomeCadastroPaciente.this);
            respostaDatabase = RespostaDatabase.getDatabase(HomeCadastroPaciente.this);
            txtrua = (EditText) findViewById(R.id.txt_end);
            txtnumero = (EditText) findViewById(R.id.txt_num);
            txtbairro = (EditText) findViewById(R.id.txt_bairro);
            txtcidade = (EditText) findViewById(R.id.txt_cidade);
            txtcep = (EditText) findViewById(R.id.txtcep);
            txtmulti = (EditText) findViewById(R.id.txtmulti);
            txtcpf = (EditText) findViewById(R.id.txt_cpfpaciente);
            txtrg = (EditText) findViewById(R.id.txt_rgpaciente);
            floating = findViewById(R.id.floatingcadastropaciente);

            floating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    cadastraPaciente();
                }
            });

            // REFERÊNCIA AO OBJETO VISUAL
            txtLatitude = findViewById(R.id.txtLatId);
            txtLongitude = findViewById(R.id.txtLonId);
            //CRIANDO MASCARA DE TESTE
//            SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
//            MaskTextWatcher mtw = new MaskTextWatcher(txtcpf, smf);
//            txtcpf.addTextChangedListener(mtw);
//            smf = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
//            mtw = new MaskTextWatcher(txttelefone, smf);
//            txttelefone.addTextChangedListener(mtw);



            //FIM MASCARA

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
            rbn10 = findViewById(R.id.rbn10);
            rbs11 = findViewById(R.id.rbs11);
            rbn11 = findViewById(R.id.rbn11);
            rbs12 = findViewById(R.id.rbs12);
            rbn12 = findViewById(R.id.rbn12);


            rgsexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbmasc) {
                        sexo = 'M';
                    }
                    if (i == R.id.rbfem) {
                        sexo = 'F';
                    }
                }
            });


            rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs1) {
                        date1.setEnabled(true);
                        respotas[0] = true;
                        datasiniciais[0] = date1.getText().toString();
                    }
                    if (i == R.id.rbn1) {
                        date1.setEnabled(false);
                        date1.setText("");
                        respotas[0] = false;
                        datasiniciais[0] = "";
                    }
                }
            });

            rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs2) {
                        date2.setEnabled(true);
                        respotas[1] = true;
                        datasiniciais[1] = date2.getText().toString();
                    }
                    if (i == R.id.rbn2) {
                        date2.setEnabled(false);
                        date2.setText("");
                        respotas[1] = false;
                        datasiniciais[1] = "";
                    }
                }
            });
            rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs3) {
                        date3.setEnabled(true);
                        respotas[2] = true;
                        datasiniciais[2] = date3.getText().toString();
                    }
                    if (i == R.id.rbn3) {
                        date3.setEnabled(false);
                        date3.setText("");
                        respotas[2] = false;
                        datasiniciais[2] = "";
                    }
                }
            });
            rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs4) {
                        date4.setEnabled(true);
                        respotas[3] = true;
                        datasiniciais[3] = date4.getText().toString();
                    }
                    if (i == R.id.rbn4) {
                        date4.setEnabled(false);
                        date4.setText("");
                        respotas[3] = false;
                        datasiniciais[3] = "";
                    }
                }
            });
            rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs5) {
                        date5.setEnabled(true);
                        respotas[4] = true;
                        datasiniciais[4] = date5.getText().toString();
                    }
                    if (i == R.id.rbn5) {
                        date5.setEnabled(false);
                        date5.setText("");
                        respotas[4] = false;
                        datasiniciais[4] = "";
                    }
                }
            });
            rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs6) {
                        date6.setEnabled(true);
                        respotas[5] = true;
                        datasiniciais[5] = date6.getText().toString();
                    }
                    if (i == R.id.rbn6) {
                        date6.setEnabled(false);
                        date6.setText("");
                        respotas[5] = false;
                        datasiniciais[5] = "";
                    }
                }
            });
            rg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs7) {
                        date7.setEnabled(true);
                        respotas[6] = true;
                        datasiniciais[6] = date7.getText().toString();
                    }
                    if (i == R.id.rbn7) {
                        date7.setEnabled(false);
                        date7.setText("");
                        respotas[6] = false;
                        datasiniciais[6] = "";
                    }
                }
            });
            rg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs8) {
                        date8.setEnabled(true);
                        respotas[7] = true;
                        datasiniciais[7] = date8.getText().toString();
                    }
                    if (i == R.id.rbn8) {
                        date8.setEnabled(false);
                        date8.setText("");
                        respotas[7] = false;
                        datasiniciais[7] = "";
                    }
                }
            });
            rg9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs9) {
                        date9.setEnabled(true);
                        respotas[8] = true;
                        datasiniciais[8] = date9.getText().toString();
                    }
                    if (i == R.id.rbn9) {
                        date9.setEnabled(false);
                        date9.setText("");
                        respotas[8] = false;
                        datasiniciais[8] = "";
                    }
                }
            });
            rg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs10) {
                        date10.setEnabled(true);
                        respotas[9] = true;
                        datasiniciais[9] = date10.getText().toString();
                    }
                    if (i == R.id.rbn10) {
                        date10.setEnabled(false);
                        date10.setText("");
                        respotas[9] = false;
                        datasiniciais[9] = "";
                    }

                }
            });
            rg11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs11) {
                        date11.setEnabled(true);
                        respotas[10] = true;
                        datasiniciais[10] = date11.getText().toString();
                    }
                    if (i == R.id.rbn11) {
                        date11.setEnabled(false);
                        date11.setText("");
                        respotas[10] = false;
                        datasiniciais[10] = "";
                    }
                }
            });
            rg12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.rbs12) {
                        date12.setEnabled(true);
                        txtmulti.setEnabled(true);
                        respotas[11] = true;
                        datasiniciais[11] = date12.getText().toString();

                    }
                    if (i == R.id.rbn12) {
                        date12.setEnabled(false);
                        txtmulti.setEnabled(false);
                        date12.setText("");
                        txtmulti.setText("");
                        respotas[11] = false;
                        datasiniciais[11] = "";
                    }
                }
            });

            pacienteselecionado = (Paciente) getIntent().getSerializableExtra("usuariocadastrado");

            if (pacienteselecionado != null) {
                Integer ID = pacientedb.pacienteDAO().findID(pacienteselecionado.getNome());
                enderecoselecionado = (Endereco) enderecodb.enderecoDAO().findbyid(ID);
                txtnome.setText(pacienteselecionado.getNome());
                txttelefone.setText(pacienteselecionado.getTelefone());
                txtcpf.setText(pacienteselecionado.getCpf());
                txtrg.setText(pacienteselecionado.getRg());
                Character sexaux = pacienteselecionado.getSexo();
                if (sexaux == 'M') {
                    rbmas.setChecked(true);
                } else {
                    rbfem.setChecked(true);
                }
                txtrua.setText(enderecoselecionado.getDescricao());
                txtbairro.setText(enderecoselecionado.getBairro());
                txtcidade.setText(enderecoselecionado.getCidade());
                txtcep.setText(enderecoselecionado.getCEP());
                txtnumero.setText(enderecoselecionado.getNumero());


                respostaList = respostaDatabase.respostaDAO().getById(ID);
                Resposta respost = new Resposta();
                for (int i = 0; i < 12; i++) {
                    respost = respostaList.get(i);
                    if (respost.getRepost() == true) {
                        marcaRadio(i, true, respost.getDatainicio());
                    } else {
                        marcaRadio(i, false, "");
                    }
                }
            }

            // INICIO MASCARAS
            SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
            MaskTextWatcher mtw = new MaskTextWatcher(txtcpf, smf);
            txtcpf.addTextChangedListener(mtw);
            smf = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
            mtw = new MaskTextWatcher(txttelefone, smf);
            txttelefone.addTextChangedListener(mtw);
            smf = new SimpleMaskFormatter("NN/NN/NNNN");
            mtw = new MaskTextWatcher(date1, smf);
            date1.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date2, smf);
            date2.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date3, smf);
            date3.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date4, smf);
            date4.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date5, smf);
            date5.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date6, smf);
            date6.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date7, smf);
            date7.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date8, smf);
            date8.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date9, smf);
            date9.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date10, smf);
            date10.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date11, smf);
            date11.addTextChangedListener(mtw);
            mtw = new MaskTextWatcher(date12, smf);
            date12.addTextChangedListener(mtw);
            smf = new SimpleMaskFormatter("NNNNN-NNN");
            mtw = new MaskTextWatcher(txtcep, smf);
            txtcep.addTextChangedListener(mtw);
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Houve um erro na criação da página: " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }


    // METODO PARA EXECUTAR A AÇÃO DO BOTÃO
    public void onClickGetLocation(View view){
        // GERENCIADOR DO ANDROID
        PackageManager pm = this.getPackageManager();
        // VERIFICA SE O GPS ESTÁ HABILITADO
        if(pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS)){
            // VERIFICA SE O USUÁRIO TEM PERMISSÃO DE USAR O GPS
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED){
                // ABRE A JANELA PEDINDO PERMISSÃO PARA ACESSAR O GPS
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION },0
                );
            }else {
                // RECUPERA A INFORMAÇÃO DE LOCALIZAÇÃO
                LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                double  longitude = 0;
                double latitude = 0;
                //tratamento para n estourar erro se localização for null
                if(location != null)
                {
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();
                }
                // EXIBE A INFORMAÇÃO DE LOCALIAÇÃO NA TELA PARA O USUÁRIO
                txtLatitude.setText(String.valueOf(latitude));
                txtLongitude.setText(String.valueOf(longitude));
            }
        }else{
            Toast.makeText(this, "Não é possível usar o GPS!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void marcaRadio(Integer i,Boolean resp,String date)
    {
        try {
            if (i == 0) {
                if (resp == true) {
                    rbs1.setChecked(true);
                    date1.setText(date);
                } else {
                    rbn1.setChecked(true);
                    date1.setText(date);
                }
            } else if (i == 1) {
                if (resp == true) {
                    rbs2.setChecked(true);
                    date2.setText(date);
                } else {
                    rbn2.setChecked(true);
                    date2.setText(date);
                }
            } else if (i == 2) {
                if (resp == true) {
                    rbs3.setChecked(true);
                    date3.setText(date);
                } else {
                    rbn3.setChecked(true);
                    date3.setText(date);
                }
            } else if (i == 3) {
                if (resp == true) {
                    rbs4.setChecked(true);
                    date4.setText(date);
                } else {
                    rbn4.setChecked(true);
                    date4.setText(date);
                }
            } else if (i == 4) {
                if (resp == true) {
                    rbs5.setChecked(true);
                    date5.setText(date);
                } else {
                    rbn5.setChecked(true);
                    date5.setText(date);
                }
            } else if (i == 5) {
                if (resp == true) {
                    rbs6.setChecked(true);
                    date6.setText(date);
                } else {
                    rbn6.setChecked(true);
                    date6.setText(date);
                }
            } else if (i == 6) {
                if (resp == true) {
                    rbs7.setChecked(true);
                    date7.setText(date);
                } else {
                    rbn7.setChecked(true);
                    date7.setText(date);
                }
            } else if (i == 7) {
                if (resp == true) {
                    rbs8.setChecked(true);
                    date8.setText(date);
                } else {
                    rbn8.setChecked(true);
                    date8.setText(date);
                }
            } else if (i == 8) {
                if (resp == true) {
                    rbs9.setChecked(true);
                    date9.setText(date);
                } else {
                    rbn9.setChecked(true);
                    date9.setText(date);
                }
            } else if (i == 9) {
                if (resp == true) {
                    rbs10.setChecked(true);
                    date10.setText(date);
                } else {
                    rbn10.setChecked(true);
                    date10.setText(date);
                }
            } else if (i == 10) {
                if (resp == true) {
                    rbs11.setChecked(true);
                    date11.setText(date);
                } else {
                    rbn11.setChecked(true);
                    date11.setText(date);
                }
            } else if (i == 11) {
                if (resp == true) {
                    rbs12.setChecked(true);
                    date12.setText(date);
                } else {
                    rbn12.setChecked(true);
                    date12.setText(date);
                }
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Houve um erro na validação dos radios buttons " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastraPaciente() {
        try {
            datasiniciais[0] = date1.getText().toString();
            datasiniciais[1] = date2.getText().toString();
            datasiniciais[2] = date3.getText().toString();
            datasiniciais[3] = date4.getText().toString();
            datasiniciais[4] = date5.getText().toString();
            datasiniciais[5] = date6.getText().toString();
            datasiniciais[6] = date7.getText().toString();
            datasiniciais[7] = date8.getText().toString();
            datasiniciais[8] = date9.getText().toString();
            datasiniciais[9] = date10.getText().toString();
            datasiniciais[10] = date11.getText().toString();
            datasiniciais[11] = date12.getText().toString();

            // INSERCAO
            if (valida()) {
                String nome = txtnome.getText().toString();
                String telefone = txttelefone.getText().toString();
                String rua = txtrua.getText().toString();
                String numero = txtnumero.getText().toString();
                String bairro = txtbairro.getText().toString();
                String cidade = txtcidade.getText().toString();
                String cep = txtcep.getText().toString();
                String cpf = txtcpf.getText().toString();
                String rg = txtrg.getText().toString();
                //INSERCAO
                if (pacienteselecionado == null) {

                    //SALVA PACIENTE
                    Paciente paciente = new Paciente();
                    paciente.setNome(nome);
                    paciente.setTelefone(telefone);
                    paciente.setSexo(sexo);
                    paciente.setCpf(cpf);
                    paciente.setRg(rg);
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

                    // VE SE FAZ UM FOR MUDANDO O VETOR DE RESPOSTA E DATA
                    // SALVA RESPOSTA
                    Resposta resposta = new Resposta();
                    Date currentTime = Calendar.getInstance().getTime();
                    for (int i = 0; i < 12; i++) {
                        resposta.setIdpaciente(id);
                        resposta.setIdpergunta(i);
                        resposta.setRepost(respotas[i]);
                        resposta.setDatainicio(datasiniciais[i]);
                        resposta.setDatavisita(currentTime.toString());
                        respostaDatabase.respostaDAO().insert(resposta);

                    }

                    Toast.makeText(this, "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                //UPDATE
                else {
                    //ALTERA PACIENTE
                    pacienteselecionado.setNome(nome);
                    pacienteselecionado.setTelefone(telefone);
                    pacienteselecionado.setSexo(sexo);
                    pacienteselecionado.setCpf(cpf);
                    pacienteselecionado.setRg(rg);
                    pacientedb.pacienteDAO().update(pacienteselecionado);

                    //ALTERA ENDEREÇO
                    enderecoselecionado.setCidade(cidade);
                    enderecoselecionado.setDescricao(rua);
                    enderecoselecionado.setCEP(cep);
                    enderecoselecionado.setBairro(bairro);
                    enderecoselecionado.setNumero(numero);
                    enderecodb.enderecoDAO().update(enderecoselecionado);

                    //ALTERA RESPOSTAS
                    if (rbs1.isChecked())
                        respostaList.get(0).setRepost(true);
                    else
                        respostaList.get(0).setRepost(false);
                    respostaList.get(0).setDatainicio(date1.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(0));

                    if (rbs2.isChecked())
                        respostaList.get(1).setRepost(true);
                    else
                        respostaList.get(1).setRepost(false);
                    respostaList.get(1).setDatainicio(date2.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(1));

                    if (rbs3.isChecked())
                        respostaList.get(2).setRepost(true);
                    else
                        respostaList.get(2).setRepost(false);
                    respostaList.get(2).setDatainicio(date3.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(2));

                    if (rbs4.isChecked())
                        respostaList.get(3).setRepost(true);
                    else
                        respostaList.get(3).setRepost(false);
                    respostaList.get(3).setDatainicio(date4.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(3));

                    if (rbs5.isChecked())
                        respostaList.get(4).setRepost(true);
                    else
                        respostaList.get(4).setRepost(false);
                    respostaList.get(4).setDatainicio(date5.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(4));

                    if (rbs6.isChecked())
                        respostaList.get(5).setRepost(true);
                    else
                        respostaList.get(5).setRepost(false);
                    respostaList.get(5).setDatainicio(date6.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(5));

                    if (rbs7.isChecked())
                        respostaList.get(6).setRepost(true);
                    else
                        respostaList.get(6).setRepost(false);
                    respostaList.get(6).setDatainicio(date7.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(6));

                    if (rbs8.isChecked())
                        respostaList.get(7).setRepost(true);
                    else
                        respostaList.get(7).setRepost(false);
                    respostaList.get(7).setDatainicio(date8.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(7));

                    if (rbs9.isChecked())
                        respostaList.get(8).setRepost(true);
                    else
                        respostaList.get(8).setRepost(false);
                    respostaList.get(8).setDatainicio(date9.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(8));

                    if (rbs10.isChecked())
                        respostaList.get(9).setRepost(true);
                    else
                        respostaList.get(9).setRepost(false);
                    respostaList.get(9).setDatainicio(date10.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(9));

                    if (rbs11.isChecked())
                        respostaList.get(10).setRepost(true);
                    else
                        respostaList.get(10).setRepost(false);
                    respostaList.get(10).setDatainicio(date11.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(10));

                    if (rbs12.isChecked())
                        respostaList.get(11).setRepost(true);
                    else
                        respostaList.get(11).setRepost(false);
                    respostaList.get(11).setDatainicio(date12.getText().toString());
                    respostaDatabase.respostaDAO().update(respostaList.get(11));


                    Toast.makeText(HomeCadastroPaciente.this, "Cadastro alterado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }

            } else {
                Toast.makeText(this, "Favor preencher todos os campos", Toast.LENGTH_SHORT).show();
            }

        }
        catch (NumberFormatException ex)
        {
            Toast.makeText(this, "Existem campos com dados em formato incorreto", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Houve algum erro no cadastro:  " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public boolean valida()
    {
        try {
            Boolean valida = true;
            int count = 0;
            for (Boolean checked : this.respotas
            ) {
                if (checked == null) {
                    valida = false;
                } else if (checked == true) {
                    if (datasiniciais[count].equals("")) {
                        valida = false;
                    }
                }
                count++;
            }
            if(sexo.equals(' ')){
                valida=false;
            }
            return valida;
        }
        catch(Exception ex)
        {
            Toast.makeText(this,"Houve um erro na validação:   " + ex.getMessage() , Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
