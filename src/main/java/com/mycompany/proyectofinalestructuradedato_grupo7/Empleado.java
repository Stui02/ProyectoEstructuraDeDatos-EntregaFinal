package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class Empleado {

    private String nombre;
    private String puesto;
    private Empleado siguiente;
    private int ganancias; // Atributo para almacenar las ganancias del empleado

    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.siguiente = null;
        this.ganancias = 0; // Inicializar las ganancias en 0
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public Empleado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Empleado siguiente) {
        this.siguiente = siguiente;
    }

    // Método para obtener las ganancias del empleado
    public int getGanancias() {
        return ganancias;
    }

    // Método para establecer el puesto del empleado
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
