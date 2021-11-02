package test;

/**
 * @author braya
 */
/*
Hacer un programa donde metamos datos en 2-4 columnas con datos separtados por ;

nombreProducto; cantidad; precio; fecha

utilzar función split para separar

splitea un string por el caráter que le indico

productos.nombreScanner.split(";")

Utilizar:
	PrintWriter
	FileWriter
	BufferedReader
	FileReader

Métodos:
1) inicializar
2) agregarProducto
3) buscarProducto
4) listarProducto
5) calcularTotalPrecio
6) borrar producto
7) mayor números de produstos (máxi cantidad) 
8) contador de productos

Usar las diferentes capas

Hacer diagramas de clases

LISTA EMPRESAS PARA AGREGAR
Alibaba China Comercio minorista de Internet 643 117600
Berkshire Hath	Estados Unidos	Servicios financieros diversificados 566 270858
TSMC Taiwán Semiconductores 563 30000
Visa Inc Estados Unidos Servicios financieros diversificados 566 20500
*/

import com.ceep.empresas.negocio.*;
import java.util.Scanner;
        
public class Test {
    
    public static void main(String[] args) {
        
        var nombreArchivo = "empresas.txt";
        IListaEmpresas empresa = new ListaEmpresasImp();
        
        menu(nombreArchivo, empresa);
        
    }
    
    public static void menu(String nombreArchivo,IListaEmpresas lista){
           int opcion;
        Scanner menu = new Scanner(System.in);
        while(true){
            System.out.println("MENU");
            System.out.println("====");
            System.out.println("1.- Iniciar Lista.");
            System.out.println("2.- Agregar empresa.");
            System.out.println("3.- Listar Empresas.");
            System.out.println("4.- Buscar empresa.");
            System.out.println("5.- Empresa mas cara.");
            System.out.println("6.- Calcular total empleados.");
            System.out.println("7.- Cantidad de empresas.");
            System.out.println("8.- Borrar empresa.");
            System.out.println("9.- Borrar catalogo.");
            System.out.println("0.- Salir");
            System.out.println("Elige una opcion");
        
        opcion = menu.nextInt();
        switch (opcion) {
            case 1:
                crearLista(nombreArchivo,lista);
                break;
            case 2:
                agregarEmpresa(nombreArchivo,lista);
                break;
            case 3:
                System.out.println("***********LISTA DEL CATALOGO***********");
                System.out.println("=============================================================");
                System.out.println("=============================================================");
                System.out.println("NOMBRE EMPRESA\t PAIS DE LA EMPRESA\t SECTOR DE LA EMPRESA\t CAPITAL BURSATIL\t NUMERO DE EMPLEADOS");
                listar(nombreArchivo,lista);
                System.out.println("\n==============================================================");
                break;
            case 4:
                buscarEmpresa(nombreArchivo,lista);
                Scanner ent =  new Scanner(System.in);
                System.out.println("Introduce el nombre de la empresa: ");
                lista.buscar(nombreArchivo, nombreArchivo);
                break;
            case 5:
                buscarEmpresaCara(nombreArchivo, lista);
                break;
            case 6:
                calcularEmpleados(nombreArchivo, lista);
                break;
            case 7:
                cantidadEmpresas(nombreArchivo, lista);
                break;
            case 8:
                borrarEmpresa(nombreArchivo, lista);
                break;
            case 9:
                borrarLista(nombreArchivo, lista);
                break;
            case 0:
                System.out.println("Gracias por utilizar la aplicación");
                return;
            default:
                System.out.println("Debe seleccionar una opción entre 0 y 5");
            }
        }
    }
    
    public static void crearLista(String nombreArchivo, IListaEmpresas lista) {
        lista.inicializar(nombreArchivo);
    }
    
    public static void agregarEmpresa(String nombreArchivo, IListaEmpresas lista){
        
       lista.agregar("Apple Inc", "Estados Unidos", "Tecnologia,Hardaware", "2035", "147000", nombreArchivo);
       lista.agregar("Facebook Inc", "Estados Unidos", "Servicios y medios interactivos", "733", "52534", nombreArchivo);
       lista.agregar("Aramco", "Arabia Saudi", "Petroleo", "1836", "76000", nombreArchivo);
       lista.agregar("Microsoft Corp", "Estados Unidos", "Tecnología, Software", "1752", "168263", nombreArchivo);
       lista.agregar("Samsung", "Corea del Sur", "Tecnología, Hardware", "439", "548000", nombreArchivo);
       lista.agregar("Amazon.Com Inc", "Estados Unidos", "Comercio Minorista de Internet", "1557", "1300000", nombreArchivo);
       lista.agregar("Alphabet Inc", "Estados Unidos", "Servicios y medios interactivos", "1368", "135000", nombreArchivo);
       lista.agregar("Tesla Inc", "Estados Unidos", "Automoviles", "648", "48016", nombreArchivo);
       lista.agregar("Tencent", "China", "Servicios y medios interactivos", "819", "85858", nombreArchivo);
       
       Scanner ent = new Scanner(System.in);
       Scanner ent2 = new Scanner(System.in);
       int opt;
       while (true){
           System.out.println("SUBMENU DE AGREGAR");
           System.out.println("====");
           System.out.println("1.- Agregar uno nuevo.");
           System.out.println("0.- Salir.");
           opt = ent2.nextInt();
           switch(opt){
               case 1:
                   System.out.println("Acontinuación introduzca Los datos de la nueva empresa.");
                   System.out.println("Escriba el nombre de la empresa");
                   var nombre = ent.nextLine();
                   System.out.println(nombre);
                   System.out.println("Escriba el pais de residencia de la empresa");
                   var pais = ent.nextLine();
                   System.out.println(pais);
                   System.out.println("Escriba al sector al que pertenece");
                   var sector = ent.nextLine();
                   System.out.println(sector);
                   System.out.println("Escriba el capital bursatil de la empresa");
                   var capital = ent.nextLine();
                   System.out.println(capital);
                   System.out.println("Escriba la cantidad de empleados de la empresa");
                   var numEmpleados = ent.nextLine();
                   System.out.println(numEmpleados);
                   lista.agregar(nombre, pais, sector, capital, numEmpleados, nombreArchivo);
                   break;
               case 0:
                   return;
           }
       }
        
    }
    public static void listar(String nombreArchivo, IListaEmpresas lista){
        lista.listar(nombreArchivo);
    }
    public static void buscarEmpresa(String nombreArchivo, IListaEmpresas lista){
       Scanner ent = new Scanner(System.in);
       Scanner ent2 = new Scanner(System.in);
       int opt;
       while (true){
           System.out.println("\tSUBMENU DE BUSCAR");
           System.out.println("\t====");
           System.out.println("\t1.- Buscar una empresa.");
           System.out.println("\t0.- Salir.");
           opt = ent2.nextInt();
           switch(opt){
               case 1:
                   System.out.println("Acontinuación introduzca algun dato de la empresa.");
                   var datoBuscar = ent.nextLine();
                   lista.buscar(datoBuscar, nombreArchivo);
                   break;
               case 0:
                   return;
           }
       }
    }
    public static void buscarEmpresaCara(String nombreArchivo, IListaEmpresas lista){
        lista.empresaMasValiosa(nombreArchivo);
    }
    public static void calcularEmpleados(String nombreArchivo, IListaEmpresas lista){
        System.out.println("La cantidad de Empleados de las empresas mas grandes son: ");
        System.out.println(lista.calcularEmpleados(nombreArchivo));
    }
    public static void cantidadEmpresas(String nombreArchivo, IListaEmpresas lista){
        System.out.println("La cantidad de empresas que tenemos en nuestro fichero es:");
        System.out.println("\t"+lista.cantidadEmpresas(nombreArchivo));
    }
    public static void borrarEmpresa(String nombreArchivo, IListaEmpresas lista){
       Scanner ent = new Scanner(System.in);
       Scanner ent2 = new Scanner(System.in);
       int opt;
       while (true){
           System.out.println("\tSUBMENU DE BORRAR");
           System.out.println("\t====");
           System.out.println("\t1.- Borrar una empresa.");
           System.out.println("\t0.- Salir.");
           opt = ent2.nextInt();
           switch(opt){
               case 1:
                   System.out.println("Acontinuación introduzca el nombre de la empresa que desea borrar.");
                   var datoBuscar = ent.nextLine();
                   lista.borrarEmpresa(datoBuscar, nombreArchivo);
                   break;
               case 0:
                   return;
           }
       }
    }
    public static void borrarLista(String nombreArchivo, IListaEmpresas lista){
        lista.borrar(nombreArchivo);
    }
}
