package com.example.primerparcial.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerparcial.R;

import java.util.List;

public class AdaptadorEncuestados extends RecyclerView.Adapter<ViewHolderEncuestados> {
    private List<Encuestados> listaEncuestados;

    public AdaptadorEncuestados(List<Encuestados> data){
        this.listaEncuestados = data;
    }
    @NonNull
    @Override
    public ViewHolderEncuestados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creamos la vista que representa el item
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_encuestado,parent,false);
        ViewHolderEncuestados vhEncuesta = new ViewHolderEncuestados(vista);
        return vhEncuesta;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEncuestados holder, int position) {
        //Enlazamos los datos con el ViewHolder
        holder.getTxtNombre().setText(this.listaEncuestados.get(position).getNombre());
        holder.getTxtEdad().setText(this.listaEncuestados.get(position).getEdad());
        holder.getTxtAlimentos().setText(this.listaEncuestados.get(position).getAlimento());
    }

    @Override
    public int getItemCount() {
        return this.listaEncuestados.size();
    }
}
