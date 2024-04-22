package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class ListaCircular {
    
    private NodoCircular inicio;
    private NodoCircular cabeza;
    private int tamaño;

    public ListaCircular() {
        this.inicio = null;
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void agregarAlFinal(Pedido pedido) {
        NodoCircular nuevoNodo = new NodoCircular(pedido);
        if (esVacia()) {
            nuevoNodo.setSiguiente(nuevoNodo);
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza.getSiguiente());
            cabeza.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    public Pedido eliminarAlInicio() {
        if (esVacia()) {
            return null;
        }
        Pedido dato = cabeza.getSiguiente().getPedido();
        if (cabeza.getSiguiente() == cabeza) {
            cabeza = null;
        } else {
            cabeza.setSiguiente(cabeza.getSiguiente().getSiguiente());
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
    
    public NodoCircular getInicio() {
        return inicio;
    }
}