package src.categorias;

public class Categoria {
    private int contador;
    private String nombre;

    public Categoria(String nombre){
        this.nombre = nombre;
        this.contador = 1;
    }

    public Categoria(){
        this("Sin categoria");
    }

    public void incrementarContador(){
        contador++;
    }

    public void decrementarContador(){
        contador--;
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

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
