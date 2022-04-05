package com.example.conexionmsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.conexionmsqlite.modelo.DBHelper;
import com.example.conexionmsqlite.modelo.Persona;

import java.util.ArrayList;

public class Activity_Lista extends AppCompatActivity {

    ListView lista;
    Button buscar;
    EditText txt_buscador;
    ArrayAdapter arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista = findViewById(R.id.lista_persona);
        buscar=findViewById(R.id.btn_buscar);
        txt_buscador=findViewById(R.id.txt_buscar_persona);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar(Activity_Lista.this, txt_buscador.getText().toString());
            }
        });

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        lista.setAdapter(arrayAdapter);

        buscar(this,null);
    }

    public void buscar(Context context, String puntero){
        DBHelper dbHelper = new DBHelper(context);

        String nsql = null;

        SQLiteDatabase open= dbHelper.getReadableDatabase();
        Cursor fila= null;

        if (puntero==null){
            nsql="SELECT * FROM personas";
            fila=open.rawQuery(nsql,null );
        }else{
            nsql="SELECT * FROM personas WHERE id_persona="+ puntero;
            fila=open.rawQuery(nsql,null );
        }

        if (fila.moveToFirst()){
            do{
                Persona mipersona = new Persona();
                mipersona.setNombre(fila.getString(1));
                mipersona.setApellido(fila.getString(2));
                String nombre=fila.getString(1);
                String apellido=fila.getString(2);
                arrayList.add(nombre + " " + apellido);
            }while (fila.moveToNext());

        }
        System.out.println("TAMAÑO ARRAY" + arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("NOMBRE: " + arrayList.get(i).toString());
        }
        arrayAdapter.notifyDataSetChanged();
        dbHelper.close();

    }
}