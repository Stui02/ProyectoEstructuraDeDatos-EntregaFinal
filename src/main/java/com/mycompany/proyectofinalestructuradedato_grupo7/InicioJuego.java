package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class InicioJuego {

    // Componentes del juego
    private FabricaAutos fabrica;
    private AscensoEmpresa ascensoEmpresa;

    // Tiempo de juego en segundos
    private static final int TIEMPO_JUEGO_SEGUNDOS = 120;
    // Tiempo de espera entre pedidos en segundos
    private static final int TIEMPO_ENTRADA_ORDEN_SEGUNDOS = 12;

    // Tiempo de inicio y fin del juego
    private long startTime;
    private long endTime;

    // Constructor
    public InicioJuego(int cantidadPedidos) {
        // Establecer tiempo de inicio y fin del juego
        startTime = System.currentTimeMillis();
        endTime = startTime + (TIEMPO_JUEGO_SEGUNDOS * 1000);
        // Inicializar la fábrica de autos con parámetros predeterminados
        fabrica = new FabricaAutos(3, 0, 3, 3);
        // Generar pedidos aleatorios y recibirlos en la fábrica
        generarPedidosAleatorios(cantidadPedidos);
        // Inicializar el ascenso de empleados
        ascensoEmpresa = new AscensoEmpresa();
    }

    // Método para generar pedidos aleatorios y recibirlos en la fábrica
    private void generarPedidosAleatorios(int cantidadPedidos) {
        for (int i = 0; i < cantidadPedidos; i++) {
            Pedido pedido = generarPedidoAleatorio();
            fabrica.recibirPedido(pedido);
        }
    }

    // Método para generar un pedido aleatorio
    private Pedido generarPedidoAleatorio() {
        String tipoPedido = ""; // Inicialización con un valor predeterminado

        // Generar un número aleatorio para determinar el tipo de pedido
        int tipoAleatorio = (int) (Math.random() * 5);
        switch (tipoAleatorio) {
            case 0:
                tipoPedido = "SUV de lujo";
                break;
            case 1:
                tipoPedido = "Pick-up de alta gama";
                break;
            case 2:
                tipoPedido = "Sedan de lujo";
                break;
            case 3:
                tipoPedido = "Maquinaria de alta gama para trabajos pesados";
                break;
            case 4:
                tipoPedido = "Superauto Deportivo";
                break;
        }

        // Crear y devolver un nuevo pedido con el tipo generado aleatoriamente
        return new Pedido(tipoPedido);
    }

    // Método principal del juego
    public void jugar() {
        // Ciclo principal del juego
        while (System.currentTimeMillis() < endTime) {
            // Generar materiales en la cinta transportadora de la fábrica
            fabrica.generarMateriales();
            // Construir autos con los materiales disponibles y los pedidos recibidos
            fabrica.construirAutos();

            // Imprimir información en tiempo real sobre el estado de la fábrica
            System.out.println("Dinero acumulado: " + fabrica.getDinero());
            System.out.println("Ordenes perdidas: " + fabrica.getOrdenesPerdidas());
            System.out.println("---------------------------------------");

            // Imprimir los pedidos recibidos en tiempo real
            imprimirPedidosRecibidos();
            
            // Iniciar el ascenso de los empleados
            ascensoEmpresa.comenzarAscenso();

            // Esperar un tiempo antes de recibir el siguiente pedido
            try {
                Thread.sleep(TIEMPO_ENTRADA_ORDEN_SEGUNDOS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para imprimir los pedidos recibidos en tiempo real
    private void imprimirPedidosRecibidos() {
        System.out.println("Pedidos recibidos en tiempo real:");
        // Obtener la lista de pedidos recibidos en la fábrica
        ListaCircular listaPedidos = fabrica.getListaPedidos();
        if (listaPedidos != null) {
            // Recorrer la lista de pedidos y mostrar cada tipo de pedido
            NodoCircular nodoActual = listaPedidos.getInicio();
            while (nodoActual != null) {
                Pedido pedidoActual = nodoActual.getPedido();
                System.out.println("- " + pedidoActual.getTipo());
                nodoActual = nodoActual.getSiguiente();
            }
        } else {
            System.out.println("No hay pedidos recibidos en tiempo real.");
        }
    }
}