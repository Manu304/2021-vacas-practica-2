package src.peliculas;

import src.categorias.Categoria;

public class Pelicula {
    int id, anio, contador;
    String nombre;
    boolean disponible;
    Categoria categoria;

    public Pelicula(int id, int anio, String nombre, Categoria categoria) {
        this.id = id;
        this.anio = anio;
        this.contador = 0;
        this.nombre = nombre;
        this.disponible = true;
        this.categoria = categoria;
    }

    public Pelicula(int id, String nombre) {
        this(id, 0, nombre, new Categoria());
    }

    public String getInformacion(boolean contador) {
        String base = "ID: " + id + "\nNombre: " + nombre;
        String extra;
        if (!contador) {
            extra = "\nAño: " + anio + "\nCategoria: " + categoria + "\nEstado: " + getDisponibilidad();
        } else {
            extra = "\nPrestada: " + contador + " veces.";
        }
        return base + extra;
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
}