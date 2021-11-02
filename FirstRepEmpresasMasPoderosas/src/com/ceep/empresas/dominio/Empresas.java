package com.ceep.empresas.dominio;

/**
 * @author braya
 */

public class Empresas {
    
    private String nombre;
    private String pais;
    private String sector;
    private String capBursatil;
    private String cantidadEmpleados;

    public Empresas() {
    }

    public Empresas(String nombre, String pais, String sector, String capBursatil, String cantidadEmpleados) {
        this();
        this.nombre = nombre;
        this.pais = pais;
        this.sector = sector;
        this.capBursatil = capBursatil;
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCapBursatil() {
        return capBursatil;
    }

    public void setCapBursatil(String capBursatil) {
        this.capBursatil = capBursatil;
    }

    public String getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(String cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    @Override
    public String toString() {
        return nombre + "   " + pais + "   " + sector + "   " + capBursatil + "   " + cantidadEmpleados;
    }
    
}
