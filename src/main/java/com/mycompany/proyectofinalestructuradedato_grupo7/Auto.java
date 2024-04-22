package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class Auto {

    private String modelo;
    private Material materiales;
    private ListaDobleEnlazada listaMateriales; 

    public Auto(String modelo) {
        this.modelo = modelo;
        this.materiales = null;
        this.listaMateriales = new ListaDobleEnlazada(); 
    }

    public void agregarMaterial(Material material) {
        listaMateriales.insertarAlFinal(material); 
    }

    public String getModelo() {
        return modelo;
    }

    public Material getMateriales() {
        return materiales;
    }

    public ListaDobleEnlazada getListaMateriales() {
        return listaMateriales;
    }
}