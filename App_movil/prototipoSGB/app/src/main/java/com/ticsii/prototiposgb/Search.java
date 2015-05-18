package com.ticsii.prototiposgb;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Search extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        TextView txtPalabraBuscada = (TextView)findViewById(R.id.txtpalabra);
        Bundle b = this.getIntent().getExtras();
        String palabra = b.getString("palabra");
        txtPalabraBuscada.setText("Palabra buscada: " + palabra);
        Button boton = (Button) findViewById(R.id.buscar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevaPalabra = ((EditText) findViewById(R.id.txtbuscar)).getText().toString();
                if (nuevaPalabra.trim().length() >= 3) {
                    Intent busqueda = new Intent();
                    busqueda.putExtra("palabra", nuevaPalabra);
                    busqueda.setClass(Search.this, Search.class);
                    startActivity(busqueda);
                } else {
                    Toast.makeText(getApplicationContext(), "Debe ingresar al menos tres caracteres", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ArticuloPresenter presenter = new ArticuloPresenter(this);
        ArrayList<Articulo> art = presenter.buscarNombre(palabra);
        if(!art.isEmpty()){
            String[] a= new String[art.size()];
            for(int i=0; i<art.size();i++){
                a[i]= art.get(i).getNombre();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),android.R.layout.simple_list_item_1,a);
            getListView().setAdapter(adapter);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
