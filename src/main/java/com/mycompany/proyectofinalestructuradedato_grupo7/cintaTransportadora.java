package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class cintaTransportadora {

    private Material cabeza;
    private Material cola;
    private int capacidad;
    private int cantidad;

    public cintaTransportadora(int capacidad) {
        this.cabeza = null;
        this.cola = null;
        this.capacidad = capacidad;
        this.cantidad = 0;
    }

    public boolean agregarMaterial(Material material) {
        if (cantidad < capacidad) {
            if (cabeza == null) {
                cabeza = material;
                cola = material;
            } else {
                cola.setSiguiente(material);
                material.setAnterior(cola);
                cola = material;
            }
            cantidad++;
            return true;
        } else {
            return false;
        }
    }

    public Material obtenerMaterial() {
        if (cabeza != null) {
            Material material = cabeza;
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) {
                cabeza.setAnterior(null);
            }
            cantidad--;
            return material;
        } else {
            return null;
        }
    }

    public Material getCabeza() {
        return cabeza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

}
