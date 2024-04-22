package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class Pedido {

    private String tipo;
    private Pedido siguiente;
    private Pedido anterior;

    public Pedido(String tipo) {
        this.tipo = tipo;
        this.siguiente = null;
        this.anterior = null;
    }

    public Pedido getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Pedido siguiente) {
        this.siguiente = siguiente;
    }

    public Pedido getAnterior() {
        return anterior;
    }

    public void setAnterior(Pedido anterior) {
        this.anterior = anterior;
    }

    public String getTipo() {
        return tipo;
    }
}
