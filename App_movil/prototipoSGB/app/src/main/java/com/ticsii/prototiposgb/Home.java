package com.ticsii.prototiposgb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by flarenaster on 28-04-15.
 */
public class Home extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //DBmanager helper= new DBmanager(this);

        Button boton = (Button) findViewById(R.id.buscar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevaPalabra = ((EditText) findViewById(R.id.txtbuscar)).getText().toString();
                if (nuevaPalabra.trim().length() >= 3) {
                    Intent busqueda = new Intent();
                    busqueda.putExtra("palabra", nuevaPalabra);
                    busqueda.setClass(Home.this, Search.class);
                    startActivity(busqueda);
                } else {
                    Toast.makeText(getApplicationContext(), "Debe ingresar al menos tres caracteres", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}