package com.ceep.empresas.negocio;

/**
 * @author brayas
 */
public interface IListaEmpresas {
    
    void inicializar(String nombreArchivo);
    
    void agregar(String nombre, String pais, String sector, String capBursatil, String cantidadEmpleados, String nombreArchivo);
    
    void listar(String nombreArchivo);
    
    void buscar(String datoBuscar, String nombreArchivo);
    
    int calcularEmpleados(String nombreArchivo);
    
    void borrarEmpresa(String nombreEmpresa, String nombreArchivo);
    
    void empresaMasValiosa(String nombreArchivo);
    
    int cantidadEmpresas(String nombreArchivo);
    
    void borrar(String nombreArchivo);
    
}
