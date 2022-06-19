package com.example.pm2e14552;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm2e14552.Transacciones.TransaccionesPais;
public class ActivityPais extends AppCompatActivity
{
    EditText codigo, nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        Button btnguardar_pais = (Button) findViewById(R.id.btnguardar_pais);
        codigo = (EditText) findViewById(R.id.txtcodigo_pais);
        nombre = (EditText) findViewById(R.id.txtpais_pais);

        btnguardar_pais.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AgregarPais();
            }
        });
    }

    private void AgregarPais()
    {
        SQLiteConexion conexion= new SQLiteConexion(this, TransaccionesPais.NameDataBase, null, 1);
        SQLiteDatabase bd= conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(TransaccionesPais.codigo, codigo.getText().toString());
        valores.put(TransaccionesPais.nombre, nombre.getText().toString());

        Long resultado = bd.insert(TransaccionesPais.tablapais,TransaccionesPais.id ,valores);

        Toast.makeText(getApplicationContext(), "Se ingreso: "   + resultado.toString(), Toast.LENGTH_LONG).show();

        bd.close();
    }
}