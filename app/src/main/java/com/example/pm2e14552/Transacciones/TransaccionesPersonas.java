package com.example.pm2e14552.Transacciones;

public class TransaccionesPersonas {

    public static final String tablapersonas = "personas";

    public static final String id = "id";
    public static final String pais = "pais";
    public static final String nombre = "nombre";
    public static final String numero = "numero";
    public static final String nota = "nota";

    public static final String CreateTablePersonas = "CREATE TABLE " + tablapersonas + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + pais + " TEXT, " + nombre + " TEXT, " + numero + " INTEGER, " + nota + " TEXT)";
    public static final String DropTablePersonas = "DROP TABLE IF EXISTS personas";
    public static final String NameDataBase = "dbExamen1";
}
