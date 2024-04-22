package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class AscensoEmpresa {

    private Empleado primerEmpleado;
    private Pila pilaPedidos;
    private int numeroRonda = 1;

    public AscensoEmpresa() {
        // Inicializar los empleados
        agregarEmpleado("Valeria", "Gerente Regional 1");
        agregarEmpleado("Christopher", "Gerente Regional 1");
        agregarEmpleado("Martina", "Gerente Regional 2");
        agregarEmpleado("Jugador", "Gerente Regional 2");
        agregarEmpleado("Veronica", "Gerente Regional 3");
        agregarEmpleado("Isabel", "Gerente Regional 3");
        agregarEmpleado("Andrew", "Gerente Regional 4");
        agregarEmpleado("Daniel", "Gerente Regional 4");

        // Hacer que el último empleado apunte de nuevo al primer empleado para formar la lista circular
        if (primerEmpleado != null) {
            Empleado ultimoEmpleado = primerEmpleado;
            while (ultimoEmpleado.getSiguiente() != null) {
                ultimoEmpleado = ultimoEmpleado.getSiguiente();
            }
            ultimoEmpleado.setSiguiente(primerEmpleado);
        }

        // Inicializar la Pila de Pedidos
        pilaPedidos = new Pila();
    }

    public void comenzarAscenso() {
        // Primera ronda
        System.out.println("Ronda " + numeroRonda + ":\n");
        realizarRonda();
        numeroRonda++; // Incrementamos el número de ronda

        // Segunda ronda
        System.out.println("\nRonda " + numeroRonda + ":\n");
        realizarRonda();
        numeroRonda++; // Incrementamos el número de ronda

        // Ronda final
        System.out.println("\nRonda " + numeroRonda + ":\n");
        realizarRonda();
        System.out.println("¡Ascenso completado!\n\n");
    }

    private void realizarRonda() {
        // Realizar la ronda
        Empleado actual = primerEmpleado;
        do {
            System.out.println(actual.getNombre() + " vs " + actual.getSiguiente().getNombre() + " por " + actual.getPuesto());
            actual = actual.getSiguiente().getSiguiente();
        } while (actual != primerEmpleado);

        // Agregar un pedido a la Pila de Pedidos al final de la ronda
        pilaPedidos.push(generarPedidoAleatorio());
    }

    private void agregarEmpleado(String nombre, String puesto) {
        Empleado nuevoEmpleado = new Empleado(nombre, puesto);
        if (primerEmpleado == null) {
            primerEmpleado = nuevoEmpleado;
        } else {
            Empleado actual = primerEmpleado;
            while (actual.getSiguiente() != primerEmpleado) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoEmpleado);
        }
        // Hacer que el nuevo empleado apunte al primer empleado para formar la lista circular
        nuevoEmpleado.setSiguiente(primerEmpleado);
    }

    private void determinarAscensos() {
        // Calcular las ganancias totales
        int gananciasTotales = calcularGananciasTotales();

        // Determinar los ascensos basados en las ganancias totales
        if (gananciasTotales >= 275000) {
            promoverGerenteGeneral();
        } else if (gananciasTotales >= 125000) {
            promoverGerenteProduccion();
        } else if (gananciasTotales >= 90000) {
            promoverGerenteRegional();
        }
    }

    private int calcularGananciasTotales() {
        // Aquí debes calcular las ganancias totales sumando las ganancias de todos los empleados
        // Esta es solo una implementación de ejemplo, debes ajustarla según tus necesidades
        int gananciasTotales = 0;
        Empleado actual = primerEmpleado;
        do {
            gananciasTotales += actual.getGanancias();
            actual = actual.getSiguiente();
        } while (actual != primerEmpleado);
        return gananciasTotales;
    }

    private void promoverGerenteGeneral() {
        Empleado actual = primerEmpleado;
        Empleado jugador = null;
        do {
            if (actual.getNombre().equals("Jugador")) {
                jugador = actual;
                break;
            }
            actual = actual.getSiguiente();
        } while (actual != primerEmpleado);

        // Si se encuentra al jugador, se promueve
        if (jugador != null) {
            // Si el puesto actual del jugador es Gerente Regional 2, se promueve a Gerente General
            if (jugador.getPuesto().equals("Gerente Regional 2")) {
                jugador.setPuesto("Gerente General");
                System.out.println(jugador.getNombre() + " ha sido promovido a Gerente General.");
            } else {
                System.out.println("El jugador no está en la posición adecuada para la promoción.");
            }
        } else {
            System.out.println("No se encontró al jugador en la lista de empleados.");
        }
    }

    private void promoverGerenteProduccion() {
        Empleado actual = primerEmpleado;
        Empleado empleado = null;
        do {
            if (actual.getNombre().equals("Jugador")) { // Cambia "Jugador" al nombre del empleado que deseas promover
                empleado = actual;
                break;
            }
            actual = actual.getSiguiente();
        } while (actual != primerEmpleado);

        // Si se encuentra al empleado, se promueve
        if (empleado != null) {
            // Si el puesto actual del empleado es Gerente Regional 1, se promueve a Gerente de Producción
            if (empleado.getPuesto().equals("Gerente Regional 1")) {
                empleado.setPuesto("Gerente Producción");
                System.out.println(empleado.getNombre() + " ha sido promovido a Gerente de Producción.");
            } else {
                System.out.println("El empleado no está en la posición adecuada para la promoción.");
            }
        } else {
            System.out.println("No se encontró al empleado en la lista de empleados.");
        }
    }

    private void promoverGerenteRegional() {
        Empleado actual = primerEmpleado;
        Empleado empleado = null;
        do {
            if (actual.getNombre().equals("Jugador")) { // Cambia "Jugador" al nombre del empleado que deseas promover
                empleado = actual;
                break;
            }
            actual = actual.getSiguiente();
        } while (actual != primerEmpleado);

        // Si se encuentra al empleado, se promueve
        if (empleado != null) {
            // Si el puesto actual del empleado es Gerente de Producción, se promueve a Gerente Regional 1
            if (empleado.getPuesto().equals("Gerente Producción")) {
                empleado.setPuesto("Gerente Regional 1");
                System.out.println(empleado.getNombre() + " ha sido promovido a Gerente Regional 1.");
            } else {
                System.out.println("El empleado no está en la posición adecuada para la promoción.");
            }
        } else {
            System.out.println("No se encontró al empleado en la lista de empleados.");
        }
    }

    private Pedido generarPedidoAleatorio() {
        // Generar un pedido aleatorio
        // Esta es solo una implementación de ejemplo, debes ajustarla según tus necesidades
        int tipoAleatorio = (int) (Math.random() * 4);
        String tipoPedido;
        switch (tipoAleatorio) {
            case 0:
                tipoPedido = "sedan de lujo";
                break;
            case 1:
                tipoPedido = "suv de lujo";
                break;
            case 2:
                tipoPedido = "pick-up de alta gama";
                break;
            case 3:
                tipoPedido = "maquinaria de alta gama para trabajos pesados";
                break;
            default:
                tipoPedido = "sedan de lujo";
                break;
        }
        return new Pedido(tipoPedido);
    }
}
