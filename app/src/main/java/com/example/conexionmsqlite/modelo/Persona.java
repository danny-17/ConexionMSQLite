package com.example.conexionmsqlite.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Persona {

    private int id, edad;
    private String nombre, apellido, email, telefono;

    public Persona(int id, int edad, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Persona(){
        this.telefono="0987548707";
    }

    public void guardar(Context context){
        DBHelper dbHelper = new DBHelper(context);
        String nsql = "INSERT INTO personas (id_persona, nombre, apellido, email, telefono, edad) " +
                "VALUES ("+null+", '"+getNombre()+"', '"+getApellido()+"', '"+getEmail()+"', '"+getTelefono()+"',"+getEdad()+")";

        dbHelper.noQuery(nsql);
        dbHelper.close();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
