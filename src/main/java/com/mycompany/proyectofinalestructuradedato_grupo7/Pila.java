package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class Pila {

    private static final int CAPACIDAD = 100;
    private Pedido[] elementos;
    private int tope;

    public Pila() {
        elementos = new Pedido[CAPACIDAD];
        tope = -1;
    }

    public void push(Pedido pedido) {
        if (tope < CAPACIDAD - 1) {
            tope++;
            elementos[tope] = pedido;
        } else {
            System.out.println("La pila está llena");
        }
    }

    public Pedido pop() {
        if (!isEmpty()) {
            Pedido pedido = elementos[tope];
            tope--;
            return pedido;
        } else {
            System.out.println("La pila está vacía");
            return null;
        }
    }

    public boolean isEmpty() {
        return tope == -1;
    }
}
