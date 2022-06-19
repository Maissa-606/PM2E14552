package com.example.pm2e14552;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ActivityModificar extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
    }

    EditText text= (EditText) findViewById(R.id.txtnombre_modificar);
    EditText text1=(EditText)findViewById(R.id.txtnumero_modificar);

    String dato= getIntent().getStringExtra("Result");
}