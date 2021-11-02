package com.ceep.empresas.datos;

import com.ceep.empresas.dominio.Empresas;
import com.ceep.empresas.excepciones.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author braya
 */
//Para crear archivo: printwriter
//
public class AccesoDatosImp implements IAccesoDatos {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            //Crear archivo con printwriter
            var salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Archivo creado");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Archivo no encontrado");
        }
    }

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Empresas> listar(String nombreArchivo) throws ExcepLectura {
        var archivo = new File(nombreArchivo);
        List<Empresas> empresa = new ArrayList<>();
        //Crear el Split
        String separador [] = new String [4];
        
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null){
                separador = lectura.split(";");
                empresa.add(new Empresas(separador[0],separador[1],separador[2],separador[3],separador[4]));
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al Buscar el Archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error de lectura listando las empresas");
        }
        
        return empresa;
    }

    @Override
    public void escribir(Empresas empresa, String nombreArchivo, boolean anexar) throws ExcepEscritura {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(empresa.getNombre()+";"+empresa.getPais()+";"+empresa.getSector()+";"+empresa.getCapBursatil()+";"+empresa.getCantidadEmpleados());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
            System.out.println("El archivo " + archivo + " se ha borrado");
        } else {
            System.out.println("El archivo no existe.");
        }
    }
    
}
