package com.ticsii.prototiposgb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by flarenaster on 28-04-15.
 */
public class ArticuloPresenter extends SQLiteOpenHelper{

    private static final String DB_NAME = "SGB";
    private static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;

    public ArticuloPresenter(Context context) {
        super(context, DB_NAME, null, SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    private ContentValues generarValores(Articulo articulo){
        ContentValues valores = new ContentValues();
        valores.put(Articulo.FIELD_NOMBRE, articulo.getNombre());
        valores.put(Articulo.FIELD_CATEGORIA , articulo.getCategoria());
        valores.put(Articulo.FIELD_AUTOR , articulo.getAutor());
        valores.put(Articulo.FIELD_AÑO , articulo.getAño());
        valores.put(Articulo.FIELD_ESTADO , articulo.getEstado());
        valores.put(Articulo.FIELD_PROVEEDOR , articulo.getProveedor());
        valores.put(Articulo.FIELD_UBICACION , articulo.getUbicacion());
        valores.put(Articulo.FIELD_MARCA , articulo.getMarca());
        valores.put(Articulo.FIELD_PRECIO , articulo.getPrecio());
        valores.put(Articulo.FIELD_DESCRIPCION , articulo.getDescripcion());
        return valores;
    }

    public void insertarArticulo(Articulo articulo){
        db.insert(Articulo.TABLE_NAME, null,generarValores(articulo) );

    }

    public ArrayList<Articulo> buscarNombre(String palabra){
        ArrayList<Articulo> articulos = new ArrayList<>();
        String columnas[]={Articulo.FIELD_ID,Articulo.FIELD_NOMBRE, Articulo.FIELD_AUTOR};
        //Cursor c = db.query(Articulo.TABLE_NAME, columnas, null, null, null, null, null);
        String consulta = "SELECT * FROM "+Articulo.TABLE_NAME+" WHERE "+Articulo.FIELD_NOMBRE+" LIKE '%"+palabra+"%' OR "+Articulo.FIELD_AUTOR+" LIKE '%"+palabra+"%'";
        Cursor c = db.rawQuery(consulta,null);
        if(c.moveToFirst()){
            do {
                Articulo a = new Articulo();
                a.setId(c.getInt(0));
                a.setNombre(c.getString(1));
                a.setAutor(c.getString(3));
                articulos.add(a);
            }while (c.moveToNext());
        }
        return articulos;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Articulo.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
