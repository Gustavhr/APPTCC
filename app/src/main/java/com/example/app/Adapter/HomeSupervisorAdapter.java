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

import com.example.app.Activity.HomeCadastroUser;
import com.example.app.Activity.HomeSupervisor;
import com.example.app.Dados.UsuarioDatabase;
import com.example.app.Model.Usuario;
import com.example.app.R;

import java.util.List;

public class HomeSupervisorAdapter extends RecyclerView.Adapter<HomeSupervisorAdapter.MyViewHolder>{

//ArrayList<Usuario> usuarios;
//Context context;
//OnItemClickListener listerner;
//
//    public HomeSupervisorAdapter(ArrayList<Usuario> usuarios, Context context, OnItemClickListener listener) {
//        this.usuarios = usuarios;
//        this.context = context;
//        this.listerner=listener;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.supervisorcelula,parent,false);
//        HomeSupervisorViewH viewh = new HomeSupervisorViewH(view);
//        return viewh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        HomeSupervisorViewH viewh = (HomeSupervisorViewH) holder;
//
//       Usuario user = usuarios.get(position);
//
//        viewh.nome.setText(user.getNome());
//        viewh.login .setText(user.getLogin());
//        viewh.email.setText(user.getEmail());
//        viewh.tipo.setText(user.getTipo());
//
//        viewh.bind(usuarios.get(position),listerner);
//    }
//
//    @Override
//    public int getItemCount() {
//        return usuarios.size();
//    }
//
//    public interface OnItemClickListener{
//        void onItemClick(Usuario usuarios);
//    }

    private List<Usuario> lista;
    private Context context;

    public HomeSupervisorAdapter(Context context,List<Usuario> lista)
    {
        this.lista=lista;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType)
    {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.supervisorcelula,parent,false );
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewH,final int position)
    {
        final Usuario usuario = lista.get(position);
        viewH.txtnome.setText(usuario.getNome());
        viewH.txtlogin .setText(usuario.getLogin());
        viewH.txtemail.setText(usuario.getEmail());
        viewH.txttipo.setText(usuario.getTipo());



        viewH.txtnome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuarioselecionado = lista.get(position);
                Intent intent = new Intent(context, HomeCadastroUser.class);
                intent.putExtra("usuario",usuarioselecionado);
                context.startActivity(intent);
            }
        });


            viewH.txtnome.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v)
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle("Confirmar exclusão");
                    dialog.setMessage("Deseja excluir o usuário: " + usuario.getLogin() + "?");

                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Usuario usuarioselecionado = lista.get(position);
                            UsuarioDatabase db = UsuarioDatabase.getDatabase(context);
                            db.usuarioDAO().delete(usuarioselecionado);
                            Toast.makeText(context, "Registro excluido com sucesso", Toast.LENGTH_SHORT).show();

                            HomeSupervisor homeSupervisor = (HomeSupervisor) context;
                            homeSupervisor.atualizaTela();

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

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtlogin,txtnome,txtemail,txttipo;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            txtlogin = itemView.findViewById(R.id.cdsupervisorlogin);
            txtnome = itemView.findViewById(R.id.cdsupervisornome);
            txtemail = itemView.findViewById(R.id.cdsupervisoremail);
            txttipo = itemView.findViewById(R.id.cdsupervisortipo);

        }
    }


}
