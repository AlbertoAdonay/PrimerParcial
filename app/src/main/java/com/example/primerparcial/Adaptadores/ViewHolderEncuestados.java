package com.example.primerparcial.Adaptadores;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerparcial.R;

public class ViewHolderEncuestados extends RecyclerView.ViewHolder {

    private TextView txtNombre;
    private TextView txtEdad;
    private TextView txtAlimentos;
    public ViewHolderEncuestados(@NonNull View itemView) {
        super(itemView);
        //Inicializamos los controles
        this.txtNombre = itemView.findViewById(R.id.textViewNombre);
        this.txtEdad = itemView.findViewById(R.id.textViewEdad);
        this.txtAlimentos = itemView.findViewById(R.id.textViewAlimentos);
    }

    public TextView getTxtNombre() {
        return txtNombre;
    }

    public TextView getTxtEdad() {
        return txtEdad;
    }

    public TextView getTxtAlimentos() {
        return txtAlimentos;
    }
}
