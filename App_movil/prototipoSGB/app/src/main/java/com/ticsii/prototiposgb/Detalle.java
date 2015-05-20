package com.ticsii.prototiposgb;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Detalle extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        TextView txtid = (TextView)findViewById(R.id.txtid);
        TextView txtnombre = (TextView)findViewById(R.id.txtnombre);
        TextView txtcategoria = (TextView)findViewById(R.id.txtcategoria);
        TextView txtautor = (TextView)findViewById(R.id.txtautor);
        TextView txtaño = (TextView)findViewById(R.id.txtaño);
        TextView txtestado = (TextView)findViewById(R.id.txtestado);
        TextView txtmarca = (TextView)findViewById(R.id.txtmarca);
        TextView txtdescripcion = (TextView)findViewById(R.id.txtdescripcion);

        Bundle b = this.getIntent().getExtras();

        txtid.setText("ID: " + String.valueOf(b.getInt("id")));
        txtnombre.setText("TITULO/MODELO: " + b.getString("nombre"));
        txtcategoria.setText("CATEGORÍA: " + String.valueOf(b.getInt("categoria")));
        txtautor.setText("AUTOR: " + b.getString("autor"));
        txtaño.setText("AÑO: " + String.valueOf(b.getInt("año")));
        txtestado.setText("ESTADO: " + String.valueOf(b.getInt("estado")));
        txtmarca.setText("EDITORIAL/MARCA: " + b.getString("marca"));
        txtdescripcion.setText("DESCRIPCIÓN: " + b.getString("descripcion"));

        Button boton = (Button) findViewById(R.id.btn_reservar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Reservas no habilitadas", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
