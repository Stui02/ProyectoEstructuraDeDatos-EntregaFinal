package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class Material {

    private String nombre;
    private int valor;
    private Material siguiente;
    private Material anterior;

    public Material(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public Material getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Material siguiente) {
        this.siguiente = siguiente;
    }

    public Material getAnterior() {
        return anterior;
    }

    public void setAnterior(Material anterior) {
        this.anterior = anterior;
    }
}
