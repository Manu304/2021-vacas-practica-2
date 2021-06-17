package src.peliculas;

import src.categorias.Categoria;
import src.manejo_datos.ManejadorData;
import src.tienda.IngresoDatos;

public class Pelicula {
    int id, anio, contador;
    String nombre;
    boolean disponible;
    Categoria categoria;

    public Pelicula(int anio, String nombre, Categoria categoria) {
        this.id = generarID();
        this.anio = anio;
        this.contador = 0;
        this.nombre = nombre;
        this.disponible = true;
        this.categoria = categoria;
    }



    public Pelicula(String nombre) {
        this(0, nombre, new Categoria());
    }

    private int generarID() {
        return IngresoDatos.aleatorio(1000, 9999);
    }

    public String getInformacion(boolean contador) {
        String base = "ID: " + id + " Nombre: " + ManejadorData.llenarEspacio(nombre);
        String extra;
        if (!contador) {
            extra = " Año: " + anio + "      Categoria: " + ManejadorData.llenarEspacio(categoria.getNombre())
                    + " Estado: " + getDisponibilidad();
        } else {
            extra = " Prestada: " + contador + " veces.";
        }
        return base + extra + "\n";
    }

    private String getDisponibilidad() {
        String disponibilidad;
        if (disponible) {
            disponibilidad = "Disponible";
        } else {
            disponibilidad = "No disponible";
        }
        return disponibilidad;
    }

    public int getId() {
        return id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getContador() {
        return contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nombre;
    }

}