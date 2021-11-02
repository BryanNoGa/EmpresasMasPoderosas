package com.ceep.empresas.negocio;

/**
 * @author braya
 */
import com.ceep.empresas.datos.*;
import com.ceep.empresas.excepciones.*;
import com.ceep.empresas.dominio.Empresas;
import com.ceep.empresas.excepciones.ExcepEscritura;
import com.ceep.empresas.excepciones.ExcepLectura;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaEmpresasImp implements IListaEmpresas{

    private final IAccesoDatos datos;

    public ListaEmpresasImp() {
        this.datos = new AccesoDatosImp();
    }

    @Override
    public void inicializar(String nombreArchivo) {
        
        try {
            this.datos.crear(nombreArchivo);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al acceder a los datos ");
            ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void agregar(String nombre, String pais, String sector, String capBursatil, String cantidadEmpleados, String nombreArchivo) {
        
        try {
            if (this.datos.existe(nombreArchivo)) {
               this.datos.escribir(new Empresas(nombre,pais,sector,capBursatil,cantidadEmpleados), nombreArchivo, true); 
            }else {
                System.out.println("El catalogo no existe");
            }
        } catch (ExcepEscritura ex) {
            System.out.println("Errror al agregar empresa");
            ex.printStackTrace(System.out);
        } 
        
    }

    @Override
    public void listar(String nombreArchivo) {
        List<Empresas> empresas = new ArrayList<>();
        try {
            empresas = this.datos.listar(nombreArchivo);
            empresas.forEach(empresa ->{
                System.out.println("\n"+empresa);
            });
        } catch (ExcepLectura ex) {
            System.out.println("Error al leer el archivo");
            ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void buscar(String datoBuscar, String nombreArchivo) {
        List<Empresas> empresas = new ArrayList<>();
        try {
            empresas = this.datos.listar(nombreArchivo);
            int posicion = 0;
            for (int i = 0; i < empresas.size(); i++) {
                if (empresas.get(i).getNombre().equalsIgnoreCase(datoBuscar)||
                        empresas.get(i).getPais().equalsIgnoreCase(datoBuscar)||
                        empresas.get(i).getSector().equalsIgnoreCase(datoBuscar)||
                        empresas.get(i).getCapBursatil().equalsIgnoreCase(datoBuscar)||
                        empresas.get(i).getCantidadEmpleados().equalsIgnoreCase(datoBuscar)) {
                    posicion = i;
                    System.out.println("\nLa empresa "+ empresas.get(i).getNombre() + " está en la linea " + (posicion+1));
                    System.out.println("DATOS DE LA EMPRESA");
                    System.out.println(empresas.get(i));
                } 
            }
        } catch (ExcepLectura ex) {
            System.out.println("Error al buscar archivo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public int calcularEmpleados(String nombreArchivo) {
        List<Empresas> empresas = new ArrayList<>();
        int sumador = 0;
        try {
            empresas = this.datos.listar(nombreArchivo);
            for (int i=0; i <empresas.size(); i++){
                int valorNumerico = Integer.valueOf(empresas.get(i).getCantidadEmpleados());
                sumador += valorNumerico;
            }
        } catch (ExcepLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al listar el archivo");
        }
        return sumador;
    }

    @Override
    public void borrarEmpresa(String nombreEmpresa, String nombreArchivo) {
        
        List<Empresas> empresas = new ArrayList<>();
        List<Empresas> nuevoArray = new ArrayList<>();
        
        try {
            empresas = this.datos.listar(nombreArchivo);
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
            for (int i = 0; i < empresas.size(); i++) {
                if (empresas.get(i).getNombre().equalsIgnoreCase(nombreEmpresa)) {
                    empresas.remove(empresas.get(i));
                    
                } 
            }
            nuevoArray.addAll(empresas);
            System.out.println(nuevoArray.size());
            System.out.println(empresas.size());
            bw.write("");
            for (int i = 0; i < nuevoArray.size(); i++) {
                this.datos.escribir(new Empresas(nuevoArray.get(i).getNombre(),nuevoArray.get(i).getPais(),nuevoArray.get(i).getSector(),nuevoArray.get(i).getCapBursatil(),nuevoArray.get(i).getCantidadEmpleados()), nombreArchivo, true);
            }
                
        } catch (ExcepLectura ex) {
            System.out.println("Error al buscar archivo");
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo");
            ex.printStackTrace(System.out);
        } catch (ExcepEscritura ex) {
            Logger.getLogger(ListaEmpresasImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void empresaMasValiosa(String nombreArchivo) {
        List<Empresas> empresas = new ArrayList<>();
        int mayor = 0;
        System.out.println(mayor);
        try {
            empresas =  this.datos.listar(nombreArchivo);
            int valorNumerico =0;
            var nombre = "";
            for (int i=0; i <empresas.size(); i++){
                valorNumerico = Integer.valueOf(empresas.get(i).getCapBursatil());
                if (valorNumerico > mayor) {
                    mayor = valorNumerico;
                    nombre = empresas.get(i).getNombre();
                }
            }
            System.out.println("La empresa con mayor Capital Bursatil es " + nombre + " con " + mayor + " Billones de dolares");
        } catch (ExcepLectura ex) {
            System.out.println("Error al listar el archivo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public int cantidadEmpresas(String nombreArchivo) {
        
        List<Empresas> empresas = new ArrayList<>();
        try {
            empresas = this.datos.listar(nombreArchivo);
        } catch (ExcepLectura ex) {
            System.out.println("Error en la lectura");
            ex.printStackTrace(System.out);
        }

        return empresas.size();
        
    }
    
    @Override
    public void borrar(String nombreArchivo) {
        
        try {
            this.datos.borrar(nombreArchivo);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al acceder a los datos");
            ex.printStackTrace(System.out);
        }
    }

    
       
}
