/*
package com.example.app;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.Usuario;

public class HomeSupervisorViewH extends RecyclerView.ViewHolder {

    TextView nome,login,email,tipo;


    public HomeSupervisorViewH(@NonNull View itemView) {
        super(itemView);

        nome = itemView.findViewById(R.id.cdsupervisornome);
        login = itemView.findViewById(R.id.cdsupervisorlogin);
        email = itemView.findViewById(R.id.cdsupervisoremail);
        tipo = itemView.findViewById(R.id.cdsupervisortipo);

    }

    public void bind(final Usuario item, final HomeSupervisorAdapter.OnItemClickListener listener)
    {
       itemView.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view)
           {
               listener.onItemClick(item);
           }
       });
    }


}
*/
