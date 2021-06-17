package src.tienda;

import src.clientes.VectorClientes;
import src.peliculas.VectorPelis;

public class Principal {

    public static void main(String[] args){
        Principal p = new Principal();
    }
    private String peliCliente = "1) Clientes \n2) Peliculas \n3) Volver";
    private String noExisteOpcion = "\nUps, esa opción no existe :c\n";

    private VectorClientes tablaClientes = new VectorClientes();
    private VectorPelis tablaPelis = new VectorPelis();

    public Principal(){

        int menu = 0;
        boolean salir = false;

        while(!salir){
            System.out.println("\n~~~~~~~~~~~~~~[Bienvenido a Memorabilia]~~~~~~~~~~~~\n");
            System.out.println("1) Ingreso de informacion");
            System.out.println("2) Mostrar información registrada");
            System.out.println("3) Ordenar información registrada");
            System.out.println("4) Modificar información");
            System.out.println("5) SIN DEFINIR");
            System.out.println("6) SIN DEFINIR");
            System.out.println("7) SIN DEFINIR");
            System.out.println("-1) Salir");
            System.out.println("\n");
            menu = IngresoDatos.getEntero("una opción", true);

            switch (menu) {
                case 1 -> {menuIngreso();}
                case 2 -> {menuMostrarInfo();}
                case 3 -> {menuOrdenar();}
                case 4 -> {menuModificar();}
                case 5 -> {tablaPelis.ordenPeliNombre(true); tablaPelis.mostrarPelis();}
                case 6 -> {tablaPelis.ordenPeliNombre(false); tablaPelis.mostrarPelis();}
                case 7 -> {tablaPelis.agregarPeli();}
                case -1 -> {salir = true; System.out.println("\nVuelva pronto :)\n");}
                default -> {System.out.println(noExisteOpcion);}
                    
            }
        }
    }

    public void menuIngreso(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--------------INGRESO DE INFORMACION-------------\n");
            System.out.println(peliCliente);
            opcion = IngresoDatos.getEntero("una opción", false);
            switch (opcion) {
                case 1 -> {tablaClientes.agregarCliente();}
                case 2 -> {tablaPelis.agregarPeli();}
                case 3 -> {salir = true;}
                default -> {System.out.println(noExisteOpcion);}
            }
        }
    }

    public void menuMostrarInfo(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("\n----------MOSTRAR INFORMACION REGISTRADA---------\n");
            System.out.println(peliCliente);
            opcion = IngresoDatos.getEntero("una opción", false);
            switch (opcion) {
                case 1 -> {tablaClientes.mostrarClientes();}
                case 2 -> {tablaPelis.mostrarPelis();}
                case 3 -> {salir = true;}
                default -> {System.out.println(noExisteOpcion);}
            }
        }
    }

    public void menuOrdenar(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("\n----------ORDENAR INFORMACION REGISTRADA---------\n");
            System.out.println(peliCliente);
            opcion = IngresoDatos.getEntero("una opción", false);
            switch (opcion) {
                case 1 -> {menuOpcionOrden(false);}
                case 2 -> {menuOpcionOrden(true);;}
                case 3 -> {salir = true;}
                default -> {System.out.println(noExisteOpcion);}
            }
        }
    }

    public void menuModificar(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("\n------------MODIFICACION DE INFORMACION-----------\n");
            System.out.println(peliCliente);
            opcion = IngresoDatos.getEntero("una opción", false);
            switch (opcion) {
                case 1 -> {tablaClientes.modificarCliente();}
                case 2 -> {tablaPelis.modificarPeli();}
                case 3 -> {salir = true;}
                default -> {System.out.println(noExisteOpcion);}
            }
        }
    }

    public void menuOpcionOrden(boolean esPeli){
        int opcion;
        boolean salir = false;
        String tituloTipo = "CLIENTES";
        if (esPeli) {
            tituloTipo = "PELICULAS";
        }
        while (!salir) {
            System.out.println("\n---------ORDENANDO " + tituloTipo + "-----------\n");
            System.out.println("\n----------TIPO DE ORDENAMIENTO---------\n");
            System.out.println("1) Ascendente por nombre \n2) Descendente por nombre \n3) Ascendente por ID \n4) Descendente por ID \n5) Volver");
            opcion = IngresoDatos.getEntero("una opción", false);
            switch (opcion) {
                case 1 -> {
                    System.out.println("\n-----------ORDEN ASCENDENTE (A-Z)------------\n");
                    if (esPeli) {
                        tablaPelis.ordenPeliNombre(true);
                        tablaPelis.mostrarPelis();
                    } else {
                        tablaClientes.ordenarPorNombre(true);
                        tablaClientes.mostrarClientes();
                    }
                }
                case 2 -> {
                    System.out.println("\n----------ORDEN DESCENDENTE (Z-A)------------\n");
                    if (esPeli) {
                        tablaPelis.ordenPeliNombre(false);
                        tablaPelis.mostrarPelis();
                    } else {
                        tablaClientes.ordenarPorNombre(false);
                        tablaClientes.mostrarClientes();
                    }
                }
                case 3 -> {
                    System.out.println("\n-----------ORDEN ASCENDENTE (1-N)------------\n");
                    if (esPeli) {
                        tablaPelis.ordenPeliID(true);
                        tablaPelis.mostrarPelis();
                    }else{
                        tablaClientes.ordenClienteID(true);
                        tablaClientes.mostrarClientes();
                    }
                    
                }
                case 4 -> {
                    System.out.println("\n-----------ORDEN DESCENDENTE (N-1)------------\n");
                    if (esPeli) {
                        tablaPelis.ordenPeliID(false);
                        tablaPelis.mostrarPelis();
                    }else{
                        tablaClientes.ordenClienteID(false);
                        tablaClientes.mostrarClientes();
                    }
                }
                case 5 -> {salir = true;}
                default -> {System.out.println(noExisteOpcion);}
            }
        }
    }

    
}
