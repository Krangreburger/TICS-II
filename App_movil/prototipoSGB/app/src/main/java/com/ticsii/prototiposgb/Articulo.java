package com.ticsii.prototiposgb;

/**
 * Created by flarenaster on 28-04-15.
 */
public class Articulo {
    public static final String TABLE_NAME = "articulo";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_NOMBRE = "nombre";
    public static final String FIELD_CATEGORIA= "categoria";
    public static final String FIELD_AUTOR = "autor";
    public static final String FIELD_AÑO = "año";
    public static final String FIELD_PROVEEDOR = "proveedor";
    public static final String FIELD_MARCA = "marca";
    public static final String FIELD_PRECIO = "precio";
    public static final String FIELD_DESCRIPCION = "descripcion";



    public static final String CREATE_DB_TABLE = "create table " + TABLE_NAME + "( " +
            FIELD_ID + " integer primary key autoincrement," +
            FIELD_NOMBRE + " text,  "  +
            FIELD_CATEGORIA + " integer," +
            FIELD_AUTOR + " text," +
            FIELD_AÑO + " numeric," +
            FIELD_PROVEEDOR + " integer," +
            FIELD_MARCA + " text," +
            FIELD_PRECIO + " integer," +
            FIELD_DESCRIPCION + " text"+
            " )";

    private int id;
    private int categoria;
    private int proveedor;
    private String nombre;
    private String autor;
    private int año;
    private String marca;
    private int precio;
    private String descripcion;


    public Articulo(String nombre, int categoria, String autor, int año, int proveedor, String marca, int precio, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.autor = autor;
        this.año = año;
        this.proveedor = proveedor;
        this.marca = marca;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Articulo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
