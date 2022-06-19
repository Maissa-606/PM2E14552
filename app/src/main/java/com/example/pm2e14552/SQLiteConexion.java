package com.example.pm2e14552;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pm2e14552.Transacciones.TransaccionesPersonas;
public class SQLiteConexion extends SQLiteOpenHelper
{
    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TransaccionesPersonas.CreateTablePersonas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(TransaccionesPersonas.DropTablePersonas);
        onCreate(db);
    }
}
