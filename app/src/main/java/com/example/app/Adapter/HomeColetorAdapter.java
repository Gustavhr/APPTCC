package com.example.app.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Activity.HomeCadastroPaciente;
import com.example.app.Activity.HomeCadastroUser;
import com.example.app.Activity.HomeColetor;
import com.example.app.Activity.HomeMedicao;
import com.example.app.Activity.HomeSupervisor;
import com.example.app.Dados.PacienteDatabase;
import com.example.app.Dados.UsuarioDatabase;
import com.example.app.Model.Paciente;
import com.example.app.Model.Usuario;
import com.example.app.R;

import java.util.List;

public class HomeColetorAdapter  extends RecyclerView.Adapter<HomeColetorAdapter.ColetorViewHolder>{
    private List<Paciente> lista;
    private Context context;

    public HomeColetorAdapter(Context context,List<Paciente> lista)
    {
        this.lista=lista;
        this.context=context;
    }

    @NonNull
    @Override
    public ColetorViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coletorcelula,parent,false );
        return new ColetorViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ColetorViewHolder viewH, final int position)
    {
        final Paciente paciente  = lista.get(position);
        viewH.txtnome.setText(paciente.getNome());




//        viewH.txtnome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Paciente pacienteselecionado = lista.get(position);
//                Intent intent = new Intent(context, HomeCadastroPaciente.class);
//                intent.putExtra("usuario",pacienteselecionado);
//                context.startActivity(intent);
        viewH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paciente pacienteselecionado = lista.get(position);
                Intent intent = new Intent(context, HomeMedicao.class);
                intent.putExtra("usuario",pacienteselecionado);
                context.startActivity(intent);
            }
        });


        viewH.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v)
            {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Confirmar exclusão");
                dialog.setMessage("Deseja excluir o usuário: " + paciente.getNome() + "?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Paciente pacienteselecionado = lista.get(position);
                        PacienteDatabase db = PacienteDatabase.getDatabase(context);
                        db.pacienteDAO().delete(pacienteselecionado);
                        Toast.makeText(context, "Registro excluido com sucesso", Toast.LENGTH_SHORT).show();

                        HomeColetor homeColetor = (HomeColetor) context;
                        homeColetor.atualizaTela();

                    }
                });
                dialog.setNegativeButton("Não",null);
                dialog.create();
                dialog.show();

                return true;
            }
        });

    }

    public int getItemCount(){
        return this.lista.size();
    }

    public class ColetorViewHolder extends RecyclerView.ViewHolder{

        TextView txtnome,txttelefone;

        public ColetorViewHolder(View itemView)
        {
            super(itemView);


            txtnome = itemView.findViewById(R.id.cdcoletornome);



        }
    }

}
