package com.example.pm2e14552.Transacciones;

public class TransaccionesPais
{
    public static final String tablapais = "pais";

    public static final String id = "id";
    public static final String codigo = "codigo";
    public static final String nombre = "nombre";

    public static final String CreateTablePais = "CREATE TABLE " + tablapais+"(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + codigo + " TEXT, " + nombre + " TEXT)";
    public static final String DropTablePais = "DROP TABLE IF EXISTS pais";

    public static final String NameDataBase = "dbExamen1";
}
