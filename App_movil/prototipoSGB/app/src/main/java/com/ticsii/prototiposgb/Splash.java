package com.ticsii.prototiposgb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;


public class Splash extends ActionBarActivity {

    private boolean estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cargarPreferencias();
        if(estado){
            Intent intent = new Intent(Splash.this, Login.class);
            startActivity(intent);
            finish();
        }
        else{
            procesoCarga proceso = new procesoCarga();
            proceso.execute();
        }
    }

    private void cargarPreferencias(){
        SharedPreferences misPreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        estado=misPreferencias.getBoolean("isLoad", false);
    }

    private void guardarPereferencias(boolean valor){
        SharedPreferences misPreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putBoolean("isLoad", valor);
        editor.commit();
    }

    private class procesoCarga extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog;

        ArrayList<Articulo> articulo = new ArrayList<Articulo>(
                Arrays.asList(
                    new Articulo("La Biblia", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("Control Remoto", 3 ,null, 2015, 0, "Sony", 1000, "Mejor que la biblia"),
                    new Articulo("La Biblia 2: Reloaded", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("Control Remoto 2", 3 ,null, 2015, 0, "Sony", 1000, "Mejor que la biblia"),
                    new Articulo("La Biblia 3: De Vacaciones", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("Control Remoto 3", 3 ,null, 2015, 0, "Sony", 1000, "Mejor que la biblia"),
                    new Articulo("La Biblia 4: Misión Siria", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("Control Remoto 4", 3 ,null, 2015, 0, "Sony", 1000, "Mejor que la biblia"),
                    new Articulo("La Biblia 5: Mahoma Aparece, Amigo o Enemigo", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("Control Remoto 5", 3 ,null, 2015, 0, "Sony", 1000, "Mejor que la biblia"),
                    new Articulo("La Biblia 6: Crisis en Tierras Infinitas", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("Control Remoto 6", 3 ,null, 2015, 0, "Sony", 1000, "Mejor que la biblia"),
                    new Articulo("La Biblia 7: JC, un Nuevo Despertar", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("Control Remoto 7", 3 ,null, 2015, 0, "Sony", 1000, "Mejor que la biblia"),
                    new Articulo("La Biblia 8: JC, Superando Límites", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("La Biblia 9: En el Espacio", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("La Biblia X Parte 1: El Ministerio de Mal", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("La Biblia X Parte 2: La Última Esperanza, Gokú ha Llegado", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta"),
                    new Articulo("La Biblia Ultimate", 1 ,"Diosito", 1998, 0, "ACME", 1500, "La verdad absoluta")
                )
        );

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Splash.this);
            dialog.setTitle("Iniciando SGB");
            dialog.setMessage("Cargando DB");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            guardarPereferencias(true);
            if(dialog.isShowing()){
                dialog.dismiss();
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);
                finish();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            DBManager helper = new DBManager(Splash.this);
            for(int i = 0 ; i<articulo.size();i++){
                Articulo art = new Articulo();
                art = articulo.get(i);
                helper.insertarArticulo(art);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }
}
