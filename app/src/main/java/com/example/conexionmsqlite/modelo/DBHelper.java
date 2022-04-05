package com.example.conexionmsqlite.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private  static  final String DATABASE_NOMBRE="baseSQL.db";
    private static final int DATABASE_VERSION=1;
    public static final String TABLA_PERSONAS="personas";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE " + TABLA_PERSONAS + " (" +
                "id_persona INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT ," +
                "email TEXT NOT NULL," +
                "telefono TEXT, " +
                "edad INTEGER " +
                ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqld=" DROP TABLE " + TABLA_PERSONAS ;
        //Borra las tablas
        sqLiteDatabase.execSQL(sqld);
        onCreate(sqLiteDatabase);
    }

    public void noQuery(String nsql){
        this.getWritableDatabase().execSQL(nsql);
    }

    public Cursor query(String sql){
        return this.getReadableDatabase().rawQuery(sql, null);
    }
}
