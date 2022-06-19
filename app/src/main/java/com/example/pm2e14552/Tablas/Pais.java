package com.example.pm2e14552.Tablas;

public class Pais
{
    public Integer id;
    public String codigoPostal;
    public String nombrePais;

    public Pais(Integer id, String codigoPostal, String nombrePais)
    {
        this.id = id;
        this.codigoPostal = codigoPostal;
        this.nombrePais = nombrePais;
    }

    public Integer getId() {
        return id;
    }
    public void setId(String id) {
        id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombrePais() {
        return nombrePais;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Pais()
    {

    }
}
