package src.categorias;

import src.tienda.IngresoDatos;

public class VectorCategorias {
    private final int CANTIDAD = 50;
    private Categoria[] categorias = new Categoria[CANTIDAD];
    private int indice = 0;

    public VectorCategorias(){


    }

    public void agregarCategoria(String nombre){
        if (indice > categorias.length) {
            System.out.println("\nLímite de categorias alcanzado!\n");
        }else{
            if (buscarCategoria(nombre)) {
                int indice = getIndiceDato(nombre);
                categorias[indice].incrementarContador();
            } else {
                categorias[indice] = new Categoria(nombre);
            }
        }
    }

    public void agregarCategoria(){
        String nombre = IngresoDatos.getTexto("la categoria de la pelicula");
        agregarCategoria(nombre);
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
