package com.ticsii.prototiposgb;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
        DBManager presenter = new DBManager(this);
        final ArrayList<Articulo> listaArticulos = presenter.buscarNombre(palabra);
        if(!listaArticulos.isEmpty()){
            Adaptador adapter = new Adaptador(this, listaArticulos);
            ListView lv = getListView();
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Articulo art =(Articulo)getListView().getItemAtPosition(position);
                    Intent detalle= new Intent();
                    detalle.putExtra("id", art.getId());
                    detalle.putExtra("nombre", art.getNombre());
                    detalle.putExtra("categoria", art.getCategoria());
                    detalle.putExtra("autor", art.getAutor());
                    detalle.putExtra("año", art.getAño());
                    detalle.putExtra("marca", art.getMarca());
                    detalle.putExtra("descripcion", art.getDescripcion());
                    detalle.setClass(Search.this, Detalle.class);
                    startActivity(detalle);
                }
            });
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
