package src.peliculas;

import src.categorias.Categoria;
import src.tienda.IngresoDatos;

public class VectorPelis {
    private final int CANTIDAD = 50;
    Pelicula[] peliculas = new Pelicula[CANTIDAD];
    Categoria[] categorias = new Categoria[CANTIDAD];
    int indiceCategoria;
    private int indicePeli;
    public VectorPelis(){
        indicePeli = 1;

    }

    public void agregarPeli(int anio, String nombre, Categoria categoria){
       if (indicePeli > CANTIDAD) {
           System.out.println("\nLímite de peliculas alcanzado!");
       } else{
           peliculas[indicePeli-1] = new Pelicula(indicePeli, anio, nombre, categoria);

       }
       indicePeli++;
    }

    public void agregarPeli(){
        String nombre = IngresoDatos.getTexto("el nombre de la pelicula");
        int anio = IngresoDatos.getEntero("el año de estreno de la pelicula", false);
        String nombreCategoria = IngresoDatos.getTexto("la categoria de la pelicula");
        agregarCategoria(nombreCategoria);
        int indiceCateg = getIndiceDato(nombreCategoria);
        agregarPeli(anio, nombre, categorias[indiceCateg]);

    }

    public void mostrarPelis(){
        System.out.println("\n------PELICULAS EN MEMORABILIA------\n");
        for (int i = 0; i < indicePeli - 1; i++) {
            System.out.println(peliculas[i].getInformacion(false));
        }
    }

    public void agregarCategoria(String nombre){
        if (indiceCategoria > categorias.length) {
            System.out.println("\nLímite de categorias alcanzado!\n");
        }else{
            
            if (buscarCategoria(nombre)) {
                int indice = getIndiceDato(nombre);
                categorias[indice].incrementarContador();
            } else {
                categorias[indiceCategoria] = new Categoria(nombre);
                indiceCategoria++;
            }
        }
        
    }

    private boolean buscarCategoria(String nombre){
        boolean correcto = false;
        if (categorias[0] != null) {
            for (int i = 0; i < IngresoDatos.getDatosNetos(categorias); i++) {
                if (categorias[i].getNombre().equals(nombre)) {
                    correcto = true;
                }
            }
        }
        return correcto;
    }

    public void ordenPeliNombre(boolean ascendente){
        boolean cambio = true;
        Pelicula selec = null;
        int pos = 0;

        for (int i = 0; i < IngresoDatos.getDatosNetos(peliculas); i++) {
            selec = peliculas[i];
            pos = i;

            for (int j = i+1; j < IngresoDatos.getDatosNetos(peliculas); j++) {
                
                if (ascendente) {
                    cambio = selec.getNombre().compareTo(peliculas[j].getNombre()) > 0;
                    
                }else{
                    cambio = selec.getNombre().compareTo(peliculas[j].getNombre()) < 0;
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

    private int getIndiceDato(String nombre){
        int indice = 0;
        if (categorias[0] != null) {
            while ((indice < IngresoDatos.getDatosNetos(categorias)) && !(categorias[indice].getNombre().equals(nombre))) {
                indice++;
            }
        }
        return indice;
    }
}
