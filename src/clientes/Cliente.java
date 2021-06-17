package src.clientes;

import src.manejo_datos.ManejadorData;
import src.tienda.IngresoDatos;

/**
 * Cliente
 */
public class Cliente {
    private int id;
    private String nombre;
    private int telefono;

    public Cliente(String nombre, int telefono) {
        this.id = generarID();
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(String nombre) {
        this(nombre, 0);
    }

    // getters y setters

    public int getId() {
        return id;
    }

    private int generarID() {
        return IngresoDatos.aleatorio(1000, 9999);
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // fin getters y setters

    public String getInformacion() {
        String resultado = "Id: " + id + " Nombre: " + ManejadorData.llenarEspacio(nombre) + " Telefono: " + telefono;
        return resultado;
    }

}