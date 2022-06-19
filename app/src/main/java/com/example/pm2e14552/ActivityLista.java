package com.example.pm2e14552;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import com.example.pm2e14552.Tablas.Personas;
import com.example.pm2e14552.Transacciones.TransaccionesPersonas;


public class ActivityLista extends AppCompatActivity
{
    SQLiteConexion conexion;
    ListView listaPersona;
    EditText id, nombre, numero, nota;

    ArrayList<Personas> lista;
    ArrayList<String> ArregloPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        conexion= new SQLiteConexion(this, TransaccionesPersonas.NameDataBase, null, 1);
        listaPersona=(ListView)findViewById(R.id.listviewpersonas_lista);

        ObtenerLista();
        ArrayAdapter adp= new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, ArregloPersona);
        listaPersona.setAdapter(adp);

        listaPersona.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String info=" ID " + lista.get(position).getId()+"\n";
                info+= "Nombre : " +lista.get(position).getNombre();
                Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();

                Intent Compartir= new Intent();
                Compartir.setAction(Intent.ACTION_SEND);
                Compartir.putExtra(Intent.EXTRA_TEXT,info);
                Compartir.setType("text/plain");

                Intent share= Intent.createChooser(Compartir, null);
                startActivity(share);
            }
        });

        Button btnconsulta=(Button)findViewById(R.id.btnbuscar_lista);
        btnconsulta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Buscar();
            }
        });

        Button btna=(Button)findViewById(R.id.btnatras_lista);
        btna.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ObtenerLista()
    {
        SQLiteDatabase db= conexion.getReadableDatabase();

        Personas listPersonas=null;

        lista= new ArrayList<Personas>();

        Cursor cursor= db.rawQuery("SELECT * FROM "+ TransaccionesPersonas.tablapersonas, null);

        while (cursor.moveToNext())
        {
            listPersonas= new Personas();
            listPersonas.setId(cursor.getInt(0));
            listPersonas.setNombre(cursor.getString(1));
            listPersonas.setNumero(cursor.getInt(2));
            listPersonas.setNota(cursor.getString(3));

            lista.add(listPersonas);
        }
        LLenarLista();
    }

    private void LLenarLista()
    {
        ArregloPersona=new ArrayList<String>();
        for (int i=0; i < lista.size(); i++)
        {
            ArregloPersona.add(lista.get(i).getId() + " | "
                    +lista.get(i).getPais()+ " | "
                    +lista.get(i).getNombre()+ " | "
                    +lista.get(i).getNumero());
        }
    }

    private void Buscar()
    {
        SQLiteDatabase bd= conexion.getWritableDatabase();
        String [] parames= {id.getText().toString()};
        String [] fields= {TransaccionesPersonas.nombre, TransaccionesPersonas.numero, TransaccionesPersonas.nota};

        String condicion= TransaccionesPersonas.id + "=?";

        try
        {
            Cursor cdata = bd.query(TransaccionesPersonas.tablapersonas, fields, condicion, parames, null, null, null);
            cdata.moveToFirst();

            nombre.setText(cdata.getString(0));
            numero.setText(cdata.getString(1));
            nota.setText(cdata.getString(2));
            Toast.makeText(getApplicationContext(), "Consulta Exitosa", Toast.LENGTH_LONG).show();

        }
        catch (Exception ex)
        {
            limpiar();
            Toast.makeText(getApplicationContext(), "Consulta No Encontrados", Toast.LENGTH_LONG).show();

        }
    }

    private void limpiar() {
        nombre.setText("null");
        numero.setText("null");
        nota.setText("null");
    }
}