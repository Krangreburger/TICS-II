package com.ticsii.prototiposgb;

/**
 * Created by flarenaster on 24-05-15.
 */
public class Persona {
    public static final String TABLE_NAME = "persona";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_ROL = "rol";
    public static final String FIELD_SUBSCRIPCION = "subscripcion";
    public static final String FIELD_NOMBRE= "nombre";
    public static final String FIELD_APELLIDO = "apellido";
    public static final String FIELD_RUT = "rut";
    public static final String FIELD_CORREO = "correo";
    public static final String FIELD_TELEFONO = "telefono";
    public static final String FIELD_DIRECCION = "direccion";
    public static final String FIELD_PASSWORD = "password";

    public static final String CREATE_DB_TABLE = "create table " + TABLE_NAME + "( " +
            FIELD_ID + " integer primary key autoincrement," +
            FIELD_ROL + " integer,  "  +
            FIELD_SUBSCRIPCION + " integer," +
            FIELD_NOMBRE + " text," +
            FIELD_APELLIDO + " text," +
            FIELD_RUT + " text," +
            FIELD_CORREO + " text," +
            FIELD_TELEFONO + " integer," +
            FIELD_DIRECCION + " text," +
            FIELD_PASSWORD + " text"+
            " )";

    private int id;
    private int rol;
    private int subscripcion;
    private String nombre;
    private String apellido;
    private String rut;
    private String correo;
    private int telefono;
    private String direccion;
    private String password;

    public Persona(int id, int rol, int subscripcion, String nombre, String apellido, String rut, String correo, int telefono, String direccion, String password) {
        this.id = id;
        this.rol = rol;
        this.subscripcion = subscripcion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getSubscripcion() {
        return subscripcion;
    }

    public void setSubscripcion(int subscripcion) {
        this.subscripcion = subscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
