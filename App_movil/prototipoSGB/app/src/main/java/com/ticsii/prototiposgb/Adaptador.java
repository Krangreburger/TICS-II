package com.ticsii.prototiposgb;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Adaptador extends ArrayAdapter<Articulo> {

    private final Context context;
    private final ArrayList<Articulo> itemsArrayList;

    public Adaptador(Context context, ArrayList<Articulo> itemsArrayList) {

        super(context, R.layout.activity_elemento, itemsArrayList);


        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_elemento, parent, false);

        TextView nombreView = (TextView) rowView.findViewById(R.id.txtnombre);
        TextView autorView = (TextView) rowView.findViewById(R.id.txtautor);
        TextView añoView = (TextView) rowView.findViewById(R.id.txtaño);

        nombreView.setText(itemsArrayList.get(position).getNombre());
        autorView.setText(itemsArrayList.get(position).getAutor());
        añoView.setText(String.valueOf(itemsArrayList.get(position).getAño()));



        return rowView;
    }


}
