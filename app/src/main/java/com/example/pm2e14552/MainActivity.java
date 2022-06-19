package com.example.pm2e14552;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pm2e14552.Transacciones.TransaccionesPersonas;

public class MainActivity extends AppCompatActivity
{
    Spinner pais;
    String codpais;
    EditText  nombres, telefono, nota;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncontactos_main = (Button)findViewById(R.id.btncontactos_main);
        Button btnsalvar_main = (Button)findViewById(R.id.btnsalvar_main);

        pais = (Spinner)findViewById(R.id.spinnerpais_main);
        codpais = pais.getSelectedItem().toString();
        nombres = (EditText)findViewById(R.id.txtnombre_main);
        telefono = (EditText)findViewById(R.id.txtnumero_main);
        nota = (EditText)findViewById(R.id.txtnota_main);

        btncontactos_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    Intent intent = new Intent(getApplicationContext(), ActivityLista.class);
                    startActivity(intent);
                }
                catch (Exception ex)
                {
                    ex.toString();
                }

            }
        });

        btnsalvar_main.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AgregarPersonas();
            }
        });
    }

    private void AgregarPersonas()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, TransaccionesPersonas.NameDataBase, null, 3);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(TransaccionesPersonas.pais, codpais);
        valores.put(TransaccionesPersonas.nombre, nombres.getText().toString());
        valores.put(TransaccionesPersonas.numero, telefono.getText().toString());
        valores.put(TransaccionesPersonas.nota, nota.getText().toString());

        Long resultado = bd.insert(TransaccionesPersonas.tablapersonas, TransaccionesPersonas.id, valores);
        Toast.makeText(getApplicationContext(), "Se ingreso: " + resultado.toString(), Toast.LENGTH_LONG).show();

        bd.close();
        limpiar();
    }

    private void limpiar()
    {
        nombres.setText(null);
        telefono.setText(null);
        nota.setText(null);
    }

    public void clickNew(View v)
    {
        Intent intent= new Intent(this, ActivityPais.class);
        startActivity(intent);
    }
}