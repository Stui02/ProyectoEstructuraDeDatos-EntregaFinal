package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class ListaDobleEnlazada {

    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamaño;

    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void agregarAlInicio(Object dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (esVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
        tamaño++;
    }

    public void agregarAlFinal(Object dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (esVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        tamaño++;
    }

    public Object eliminarAlInicio() {
        if (esVacia()) {
            return null;
        }
        Object dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        if (cabeza != null) {
            cabeza.setAnterior(null);
        } else {
            cola = null;
        }
        tamaño--;
        return dato;
    }

    public Object eliminarAlFinal() {
        if (esVacia()) {
            return null;
        }
        Object dato = cola.getDato();
        cola = cola.getAnterior();
        if (cola != null) {
            cola.setSiguiente(null);
        } else {
            cabeza = null;
        }
        tamaño--;
        return dato;
    }

    public int tamaño() {
        return tamaño;
    }

    public boolean esVacia() {
        return tamaño == 0;
    }

    public void insertarAlFinal(Material material) {
        NodoDoble nuevoNodo = new NodoDoble(material);
        if (esVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        tamaño++;
    }
}
