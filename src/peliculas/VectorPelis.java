package src.peliculas;

import src.categorias.Categoria;
import src.manejo_datos.ManejadorData;
import src.tienda.IngresoDatos;

public class VectorPelis {
    private final int CANTIDAD = 50;
    Pelicula[] peliculas = new Pelicula[CANTIDAD];
    Categoria[] categorias = new Categoria[CANTIDAD];
    int indiceCategoria;
    private int indicePeli;

    public VectorPelis() {
        indicePeli = 1;
        indiceCategoria = 0;

    }

    public void agregarPeli(int anio, String nombre, Categoria categoria) {
        if (indicePeli > CANTIDAD) {
            System.out.println("\nLímite de peliculas alcanzado!");
        } else {
            peliculas[indicePeli - 1] = new Pelicula(anio, nombre, categoria);

        }
        indicePeli++;
    }

    public void agregarPeli() {
        System.out.println("\n-----------INGRENSANDO NUEVA PELICULA----------\n");
        String nombre = IngresoDatos.getTexto("el nombre de la pelicula");
        int anio = IngresoDatos.getEntero("el año de estreno de la pelicula", false);
        String nombreCategoria = IngresoDatos.getTexto("la categoria de la pelicula");
        agregarCategoria(nombreCategoria);
        int indiceCateg = getIndiceDato(nombreCategoria);
        agregarPeli(anio, nombre, categorias[indiceCateg]);

    }

    public void mostrarPelis() {
        System.out.println("\n----------PELICULAS EN MEMORABILIA-----------\n");
        for (int i = 0; i < indicePeli - 1; i++) {
            System.out.println("(" + (i + 1) + ") " + peliculas[i].getInformacion(false));
        }
    }

    public void agregarCategoria(String nombre) {
        if (indiceCategoria > categorias.length) {
            System.out.println("\nLímite de categorias alcanzado!\n");
        } else {

            if (buscarCategoria(nombre)) {
                int indice = getIndiceDato(nombre);
                categorias[indice].incrementarContador();
            } else {
                categorias[indiceCategoria] = new Categoria(nombre);
                indiceCategoria++;
            }
        }

    }

    public void modificarPeli() {
        int indice;
        mostrarPelis();
        do {
            indice = IngresoDatos.getEntero("la pelicula que desea modificar", false);
            if (indice > (indicePeli - 1)) {
                System.out.println("\nERROR. Esa pelicula no se encuentra entre las opciones.\n");
            }
        } while (indice > (indicePeli - 1));
        modificarPeli(indice - 1);
    }

    public void modificarPeli(int indice) {
        String nuevoNombre = IngresoDatos.getTexto("el nombre correcto de la pelicula");
        int nuevoAnio = IngresoDatos.getEntero("el año correcto de estreno de la pelicula", false);
        String nuevaCategoria = IngresoDatos.getTexto("la categoria correcta de la pelicula");
        modificarCategoria(peliculas[indice].getCategoria().getNombre(), nuevaCategoria);
        int indiceCategoria = getIndiceDato(nuevaCategoria);
        peliculas[indice].setNombre(nuevoNombre);
        peliculas[indice].setAnio(nuevoAnio);
        peliculas[indice].setCategoria(categorias[indiceCategoria]);
    }

    public void modificarCategoria(String categoriaActual, String nuevaCategoria) {
        int indiceCategoria = getIndiceDato(categoriaActual);
        if (categorias[indiceCategoria].getContador() > 1) {
            categorias[indiceCategoria].decrementarContador();
        } else {
            categorias[indiceCategoria] = null;
            ManejadorData.eliminarVacios(categorias);
            indiceCategoria--;
        }
        agregarCategoria(nuevaCategoria);
    }

    private boolean buscarCategoria(String nombre) {
        boolean correcto = false;
        if (categorias[0] != null) {
            for (int i = 0; i < indiceCategoria; i++) {
                if (categorias[i].getNombre().equals(nombre)) {
                    correcto = true;
                }
            }
        }
        return correcto;
    }

    public void ordenPeliNombre(boolean ascendente) {
        ManejadorData.ordenarNombre(peliculas, ascendente);
    }

    public void ordenPeliID(boolean ascendente){
        boolean cambio = true;
        Pelicula selec = null;
        int pos = 0;

        for (int i = 0; i < ManejadorData.getDatosNetos(peliculas); i++) {
            selec = peliculas[i];
            pos = i;

            for (int j = i+1; j < ManejadorData.getDatosNetos(peliculas); j++) {
                
                if (ascendente) {
                    cambio = selec.getId() > peliculas[j].getId();
                    
                }else{
                    cambio = selec.getId() < peliculas[j].getId();
                }
                if (cambio){
                    selec = peliculas[j];
                    pos = j;
                }
            }
            peliculas[pos] = peliculas[i];
            peliculas[i] = selec;
        }
    }

    private int getIndiceDato(String nombre) {
        int indice = 0;
        if (categorias[0] != null) {
            while ((indice < indiceCategoria) && !(categorias[indice].getNombre().equals(nombre))) {
                indice++;
            }
        }
        return indice;
    }
}
