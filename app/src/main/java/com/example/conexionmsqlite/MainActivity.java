package com.example.conexionmsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conexionmsqlite.modelo.DBHelper;
import com.example.conexionmsqlite.modelo.Persona;

public class MainActivity extends AppCompatActivity {

    Button btnCrear, btn_lista;
    Button btnGrabar;
    EditText txtID, txtNombre,txtCorreo, txtApellido, txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear=findViewById(R.id.btn_crear2);
        btn_lista=findViewById(R.id.btn_ver_lista);
        btn_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_Lista.class);
                startActivity(intent);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db!=null){
                    Toast.makeText(getApplicationContext(), "BASE CREADA", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "ERROR AL CREAR LA BASE ", Toast.LENGTH_SHORT).show();

                }
            }
        });
        
        // GRABAR
        btnGrabar=findViewById(R.id.buttonGrabar);
        //txtID=findViewById(R.id.editTextID);
        txtNombre=findViewById(R.id.editTextNombre);
        txtApellido=findViewById(R.id.editTextApellido);
        txtEdad=findViewById(R.id.editTextEdad);
        txtCorreo=findViewById(R.id.editTextCorreo);
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona p = new Persona();
                //p.setId(Integer.parseInt(txtID.getText().toString()));
                p.setNombre(txtNombre.getText().toString());
                p.setApellido(txtApellido.getText().toString());
                p.setEdad(Integer.parseInt(txtEdad.getText().toString()));
                p.setEmail(txtCorreo.getText().toString());


                p.guardar(MainActivity.this);
                Toast.makeText(getApplicationContext(), "PERSONA CREADA", Toast.LENGTH_SHORT).show();
            }
        });
    }
}