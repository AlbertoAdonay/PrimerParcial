package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoAlimentos extends AppCompatActivity {

    private ListView listview;
    private ArrayList<String> names;
    public static final String TAG_MENSAJE = "Msj";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_alimentos);

        listview = (ListView) findViewById(R.id.ListadoComida);

        names = new ArrayList<String>();
        names.add("Frutas");
        names.add("Verduras");
        names.add("Carnes");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(i>=0 && i<names.size()){
                Intent mensajePadre = new Intent();
                mensajePadre.putExtra(TAG_MENSAJE, "Has pulsado: "+ names.get(i));
                setResult(RESULT_OK, mensajePadre);
                finish();
            }

            }
        });
    }
}