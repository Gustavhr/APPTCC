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

import com.example.app.Activity.HomeCadastroMedicao;
import com.example.app.Activity.HomeCadastroPaciente;
import com.example.app.Activity.HomeColetor;
import com.example.app.Activity.HomeMedicao;
import com.example.app.Dados.MedicaoDatabase;
import com.example.app.Dados.PacienteDatabase;
import com.example.app.Model.Medicao;
import com.example.app.Model.Paciente;
import com.example.app.R;

import java.util.List;

public class HomeMedicaoAdapter extends RecyclerView.Adapter<HomeMedicaoAdapter.MedicaoViewHolder>{

    private List<Medicao> lista;
    private Context context;

    public HomeMedicaoAdapter(Context context,List<Medicao> lista)
    {
        this.lista=lista;
        this.context=context;
    }

    @NonNull
    @Override
    public MedicaoViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medicaocelula,parent,false );
        return new MedicaoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicaoViewHolder viewH, final int position)
    {
        final Medicao medicao  = lista.get(position);
        viewH.txtpasist.setText(String.valueOf(medicao.getPasist()));
        viewH.txtpadist.setText(String.valueOf(medicao.getPadist()));
        viewH.txtfc.setText(String.valueOf(medicao.getFC()));
        viewH.txtcoment.setText(medicao.getComentario());




        viewH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Medicao medicaoselecionada = lista.get(position);
                Intent intent = new Intent(context, HomeCadastroMedicao.class);
                intent.putExtra("medicao",medicaoselecionada);
                context.startActivity(intent);
            }
        });


        viewH.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v)
            {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Confirmar exclusão");
                dialog.setMessage("Deseja excluir ?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Medicao medicaoselecionada = lista.get(position);
                        MedicaoDatabase db = MedicaoDatabase.getDatabase(context);
                        db.medicaoDAO().delete(medicaoselecionada);
                        Toast.makeText(context, "Registro excluido com sucesso", Toast.LENGTH_SHORT).show();

                        HomeMedicao homeMedicao = (HomeMedicao) context;
                        homeMedicao.atualizaTela();

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

    public class MedicaoViewHolder extends RecyclerView.ViewHolder{

        TextView txtpasist,txtpadist,txtfc,txtcoment;

        public MedicaoViewHolder(View itemView)
        {
            super(itemView);


            txtpasist = itemView.findViewById(R.id.cdpasist);
            txtpadist = itemView.findViewById(R.id.cdpadist);
            txtfc = itemView.findViewById(R.id.cdfc);
            txtcoment = itemView.findViewById(R.id.cdcoment);



        }
    }


}
