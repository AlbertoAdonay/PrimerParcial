package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primerparcial.Adaptadores.Encuestados;

public class Encuesta extends AppCompatActivity {

    private EditText Name, Old;
    public static final int ID_ALIMENTOS=2;
    private String Nombre="";
    private String Edad="";
    private String Alimento="";
    private Encuestados Persona;

    private static int contProceso = 0;
    public int contadorOvejas = 0;
    private ProgressBar progressBar;
    private Button btnProceso;
    private Handler manejadorProcesos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        //Inicializamos las variables
        this.progressBar = findViewById(R.id.progressBar);
        this.btnProceso = findViewById(R.id.btnProceso);
        this.manejadorProcesos = new Handler();

        this.progressBar.setMax(100);
    }
    public void Procesr_Click(View v){
        //creamos un nuevo hilo para simular la descarga
        new Thread(new procesoSecundario()).start();
    }/*
    public void Contar(View v){
        this.contadorOvejas++;
        this.labelContador.setText(Integer.toString(this.contadorOvejas)+" Ovejas");
    }*/
    //PROCESO SECUNDARIO
    //*******************************************************************
    final class procesoSecundario implements Runnable{
        //run ejecuta el proceso secundario que queremos hacer
        @Override
        public void run() {
            while(contProceso < 100){
                //Metodo de espera
                metodoEspera();
                manejadorProcesos.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(contProceso);
                        //Validamos si se termino el contedo o el proceso
                        if(contProceso==100){
                            Toast.makeText(Encuesta.this, "Proceso con exito", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

        private void metodoEspera() {
            try{
                Thread.sleep(500);
                contProceso++;
            }catch (Exception e){}
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ID_ALIMENTOS){
            if(RESULT_OK == resultCode){
                String msjActivityHija = data.getStringExtra(ListadoAlimentos.TAG_MENSAJE);
                Toast.makeText(this, msjActivityHija, Toast.LENGTH_SHORT).show();
                Alimento = msjActivityHija;
            }
        }
    }

    public void listarAlimentos_onClick(View v){
        Intent frmListado = new Intent(this,ListadoAlimentos.class);
        startActivityForResult(frmListado,ID_ALIMENTOS);
    }
    public void Procesar_onClick(View v){
        Name = findViewById(R.id.txtNombre);
        Old = findViewById(R.id.txtEdad);
        Nombre = Name.getText().toString();
        Edad = Old.getText().toString();
        if(Alimento.equals("") || Nombre.equals("") || Edad.equals("")){
            Toast.makeText(this, "Debe completar los datos antes de enviar", Toast.LENGTH_SHORT).show();
        }
        else{
            new Thread(new procesoSecundario()).start();
        }


    }
}