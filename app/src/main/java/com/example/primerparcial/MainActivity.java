package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void nuevoEncuestado_onClick(View v){
        Intent frmEncuesta = new Intent(this,Encuesta.class);
        startActivity(frmEncuesta);
    }
    public void btnListaEncuestado_onClick(View v){
        Intent frmListaEncuestado = new Intent(this, ListaEncuestados.class);
        startActivity(frmListaEncuestado);
    }
    //********************************
    /*private void guardarDatos(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mExampleList);
    }*/
}