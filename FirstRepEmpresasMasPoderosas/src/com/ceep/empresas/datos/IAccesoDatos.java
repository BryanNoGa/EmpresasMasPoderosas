
package com.ceep.empresas.datos;

/*
 *
 * @author braya
 */
import com.ceep.empresas.excepciones.*;
import com.ceep.empresas.dominio.Empresas;
import java.util.*;

public interface IAccesoDatos {
    
    void crear (String nombreArchivo) throws AccesoDatosEx;
    
    boolean existe(String nombreArchivo);
    
    List<Empresas> listar (String nombreArchivo) throws ExcepLectura;
    
    void escribir (Empresas empresa, String nombreArchivo, boolean anexar)throws ExcepEscritura;
    
    void borrar(String nombreArchivo)throws AccesoDatosEx;
    
}
