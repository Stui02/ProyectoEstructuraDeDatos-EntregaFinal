package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class FabricaAutos {

    private Pedido inicio;
    private Pedido fin;
    private int dinero;
    private int ordenesPerdidas;
    private int maxEspacios;
    private int capacidadCinta;
    private cintaTransportadora cintaTransportadora;
    private ListaCircular listaPedidos; // Agregar Lista Circular

    public FabricaAutos(int dineroInicial, int ordenesPerdidasInicial, int maxEspacios, int capacidadCinta) {
        this.dinero = dineroInicial;
        this.ordenesPerdidas = ordenesPerdidasInicial;
        this.maxEspacios = maxEspacios;
        this.capacidadCinta = capacidadCinta;
        this.cintaTransportadora = new cintaTransportadora(capacidadCinta);
        this.listaPedidos = new ListaCircular(); 
    }

    public void recibirPedido(Pedido pedido) {
        if (inicio == null) {
            inicio = pedido;
            fin = pedido;
        } else {
            fin.setSiguiente(pedido);
            fin = pedido;
        }
        listaPedidos.agregarAlFinal(pedido); 
    }

    public Pedido atenderPedido() {
        if (inicio == null) {
            return null;
        }
        Pedido pedido = inicio;
        inicio = inicio.getSiguiente();
        pedido.setSiguiente(null);
        listaPedidos.eliminarAlInicio();
        return pedido;
    }

    private int generarNumeroAleatorio(int maximo) {
        return (int) (Math.random() * maximo);
    }

    public void generarMateriales() {
        while (cintaTransportadora.getCantidad() < cintaTransportadora.getCapacidad()) {
            int valorAleatorio = generarNumeroAleatorio(100);
            Material nuevoMaterial = new Material("Material" + valorAleatorio, valorAleatorio);
            cintaTransportadora.agregarMaterial(nuevoMaterial);
        }
    }

    public cintaTransportadora getCintaTransportadora() {
        return cintaTransportadora;
    }

    public void construirAutos() {
        Pedido pedidoActual = inicio;
        while (pedidoActual != null && cintaTransportadora.getCantidad() > 0) {
            Auto nuevoAuto = new Auto(pedidoActual.getTipo()); 
            Material materialActual = cintaTransportadora.obtenerMaterial();
            while (materialActual != null) {
                nuevoAuto.agregarMaterial(materialActual);
                materialActual = cintaTransportadora.obtenerMaterial();
            }
            dinero += calcularGananciaPorTipo(nuevoAuto.getModelo());
            pedidoActual = pedidoActual.getSiguiente();
        }
    }

    public int calcularGanancia(Auto auto) {
        int ganancia = 0;
        Material materiales = auto.getMateriales();
        while (materiales != null) {
            ganancia += materiales.getValor();
            materiales = materiales.getSiguiente();
        }
        return ganancia;
    }

    public int calcularGananciaPorTipo(String tipoAuto) {
        switch (tipoAuto) {
            case "Sedan de lujo":
                return 5000;
            case "SUV de lujo":
                return 10000;
            case "Pick-up de alta gama":
                return 12000;
            case "Maquinaria de alta gama para trabajos pesados":
                return 17500;
            case "Superauto Deportivo":
                return 20000;
            default:
                return 0;
        }
    }

    public int getDinero() {
        return dinero;
    }

    public int getOrdenesPerdidas() {
        return ordenesPerdidas;
    }

    public ListaCircular getListaPedidos() {
        return listaPedidos;
    }
}
