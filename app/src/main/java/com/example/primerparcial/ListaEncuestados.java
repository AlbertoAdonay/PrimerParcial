package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.primerparcial.Adaptadores.AdaptadorEncuestados;
import com.example.primerparcial.Adaptadores.Encuestados;

import java.util.ArrayList;
import java.util.List;

public class ListaEncuestados extends AppCompatActivity {

    private List<Encuestados> datosEncuestados = new ArrayList<>();
    private RecyclerView listEncuestados;
    private AdaptadorEncuestados adaptador;
    private LinearLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_encuestados);

        //Cargar los datos
        cargarEncuestados();
        this.listEncuestados = findViewById(R.id.listEncuestados);
        this.manager = new LinearLayoutManager(this);
        this.adaptador = new AdaptadorEncuestados(datosEncuestados);

        //Configuramos el RecyclerView
        this.listEncuestados.setHasFixedSize(true);
        this.listEncuestados.setLayoutManager(this.manager);
        this.listEncuestados.setAdapter(this.adaptador);
    }

    private void cargarEncuestados() {
        for(int i=0;i<5;i++){
            Encuestados nuevoEncuestado = new Encuestados();
            nuevoEncuestado.setNombre("Persona"+(Integer.toString(i+1)));
            nuevoEncuestado.setEdad("Edad"+(Integer.toString(i+1)));
            nuevoEncuestado.setAlimento("Alimento"+(Integer.toString(i+1)));
            this.datosEncuestados.add(nuevoEncuestado);
        }
    }
}