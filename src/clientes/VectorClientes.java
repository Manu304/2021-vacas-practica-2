package src.clientes;

import src.manejo_datos.ManejadorData;
import src.tienda.*;

public class VectorClientes {
    private Cliente[] clientes = new Cliente[50];
    private int siguienteCodigo;

    public VectorClientes() {
        siguienteCodigo = 1;
    }

    // agregar clientes
    public void agregarCliente(String nombre, int telefono) {
        if (siguienteCodigo > 50) {
            System.out.println("\nLímite de clientes alcanzado!\n");
        } else {
            clientes[(siguienteCodigo - 1)] = new Cliente(siguienteCodigo, nombre, telefono);
        }
        siguienteCodigo++;
    }

    public void agregarCliente() {
        String nombre = IngresoDatos.getTexto("Ingrese el nombre del cliente");
        int telefono = IngresoDatos.getEntero("Ingrese el número de telefono", false);
        agregarCliente(nombre, telefono);
    }

    // fin agregar clientes

    public void mostrarClientes() {
        System.out.println("\n----------CLIENTES EN MEMORABILIA-----------\n");
        for (int i = 0; i < (siguienteCodigo - 1); i++) {
            System.out.println((i+1) + ") " + clientes[i].getInformacion());
            // System.out.println("-"+i+") "+clientes[i].getId() + " nombre
            // "+clientes[i].getNombre()+ " telefono "+clientes[i].getTelefono());

        }

        System.out.println("\n\n");
    }

    //Ordenamiento
    public void ordenarPorNombre(boolean ascendente){
        boolean cambio = true;

        for (int i = 1; i < (siguienteCodigo-1); i++) {
            for (int j = 0; j < (siguienteCodigo-1-i); j++) {
                //  String.compareTo(String)
                //   [-oo , + oo]
                if (ascendente)
                    cambio= (clientes[j].getNombre().compareTo(clientes[j+1].getNombre()) > 0 );
                else 
                    cambio= (clientes[j].getNombre().compareTo(clientes[j+1].getNombre()) < 0 );

                if(cambio ){
                    //clientes i va antes que clientes j <0 descendente
                    Cliente aux = clientes[j];
                    clientes[j] = clientes[j+1];
                    clientes[j+1]= aux;
                }
            }
        }
    }

    public void modificarCliente() {
        mostrarClientes();
        int selec;
        do {
            selec = IngresoDatos.getEntero("el cliente que desea modificar", false);
            if (selec > siguienteCodigo) {
                System.out.println("ERROR. Ese cliente no se encuentra entre las opciones");
            }
        } while (selec > siguienteCodigo);
        modificarCliente(selec-1);
    }

    public void ordenClienteID(boolean ascendente){
        boolean cambio = true;
        Cliente selec = null;
        int pos = 0;

        for (int i = 0; i < ManejadorData.getDatosNetos(clientes); i++) {
            selec = clientes[i];
            pos = i;

            for (int j = i+1; j < ManejadorData.getDatosNetos(clientes); j++) {
                
                if (ascendente) {
                    cambio = selec.getId() > clientes[j].getId();
                    
                }else{
                    cambio = selec.getId() < clientes[j].getId();
                }
                if (cambio){
                    selec = clientes[j];
                    pos = j;
                }
            }
            clientes[pos] = clientes[i];
            clientes[i] = selec;
        }
    }

    public void modificarCliente(int indice){
        String nombreNnuevo = IngresoDatos.getTexto("el nombre correcto del cliente");
        int telefonoNuevo = IngresoDatos.getEntero("el telefono correcto del cliente", false);
        clientes[indice].setNombre(nombreNnuevo);
        clientes[indice].setTelefono(telefonoNuevo);
    }

}
