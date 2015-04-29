package com.ticsii.prototiposgb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by flarenaster on 28-04-15.
 */
public class DBmanager extends SQLiteOpenHelper{

    private static final String DB_NAME = "SGB";
    private static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;

    public DBmanager(Context context) {
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

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Articulo.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
