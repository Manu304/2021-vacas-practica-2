package src.tienda;

import src.clientes.VectorClientes;
import src.peliculas.VectorPelis;

public class Principal {

    public static void main(String[] args){
        Principal p = new Principal();
    }

    private VectorClientes tablaClientes = new VectorClientes();
    private VectorPelis tablaPelis = new VectorPelis();

    public Principal(){

        int menu = 0;
        boolean salir = false;

        while(!salir){
            System.out.println("\nBienvenido a Memorabilia \n");
            System.out.println("1) Ingreso de clientes");
            System.out.println("2) Mostrar clientes");
            System.out.println("3) Ordenar Clientes Ascente");
            System.out.println("4) Ordenar Clientes Descendente");
            System.out.println("5) Ordenar Peliculas Ascendente");
            System.out.println("6) Ordenar peliculas descendente");
            System.out.println("7) Ingresar Peliculas");
            System.out.println("-1) Salir");
            System.out.println("\n");
            menu = IngresoDatos.getEntero("la opción", true);

            switch (menu) {
                case 1 -> {tablaClientes.agregarCliente();}
                case 2 -> {tablaClientes.mostrarClientes();}
                case 3 -> {tablaClientes.ordenarPorNombre(true);}
                case 4 -> {tablaClientes.ordenarPorNombre(false);}
                case 5 -> {tablaPelis.ordenPeliNombre(true); tablaPelis.mostrarPelis();}
                case 6 -> {tablaPelis.ordenPeliNombre(false); tablaPelis.mostrarPelis();}
                case 7 -> {tablaPelis.agregarPeli();}
                case -1 -> {salir = true; System.out.println("\nVuelva pronto :)\n");}
                default -> {System.out.println("\nUps, esa opción no existe :c\n");}
                    
            }



        }

    }

    
}
