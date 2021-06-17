package src.tienda;

import src.clientes.VectorClientes;

public class Principal {

    public static void main(String[] args){
        Principal p = new Principal();
    }

    private VectorClientes tablaClientes = new VectorClientes();

    public Principal(){

        int menu = 0;
        boolean salir = false;

        while(!salir){
            System.out.println("\nBienvenido a Memorabilia \n");
            System.out.println("1) Ingreso de clientes");
            System.out.println("2) Mostrar clientes");
            System.out.println("3) Ordenar Clientes Ascente");
            System.out.println("4) Ordenar Clientes Descendente");
            System.out.println("-1) Salir");
            System.out.println("\n");
            menu = IngresoDatos.getEntero("Ingrese la opción", true);

            switch (menu) {
                case 1 -> {tablaClientes.agregarCliente();}
                case 2 -> {tablaClientes.mostrarClientes();}
                case 3 -> {tablaClientes.ordenarPorNombre(true);}
                case 4 -> {tablaClientes.ordenarPorNombre(false);}
                case -1 -> {salir = true; System.out.println("\nVuelva pronto :)\n");}
                default -> {System.out.println("\nUps, esa opción no existe :c\n");}
                    
            }



        }

    }

    
}
