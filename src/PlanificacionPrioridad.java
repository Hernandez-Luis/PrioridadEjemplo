import java.util.List;

public class PlanificacionPrioridad {

    public static void planificacionPrioridadPreemptiva(List<Proceso> procesos) {
        System.out.println("\n--- Planificación por prioridad preemptiva ---");
        int tiempo = 0;
        int procesosCompletados = 0;

        while (procesosCompletados < procesos.size()) {
            Proceso procesoElegido = null;

            // Buscar el proceso con la mayor prioridad que haya llegado y no esté completado
            for (Proceso p : procesos) {
                if (p.tiempoLlegada <= tiempo && !p.completado) {
                    if (procesoElegido == null || p.prioridad < procesoElegido.prioridad) {
                        procesoElegido = p;
                    }
                }
            }

            /* Realiza la impresion de los estados de cada proceso por cada segundo transcurrio dentro del proceso */
            if (procesoElegido != null) {
                System.out.println("Segundo " + tiempo + ": Ejecutando " + procesoElegido);
                procesoElegido.tiempoRestante--;
                if (procesoElegido.tiempoRestante == 0) {
                    procesoElegido.completado = true;
                    procesosCompletados++;
                    System.out.println("Proceso " + procesoElegido + " completado.\n");
                }
            } else {
                System.out.println("Segundo " + tiempo + ": CPU en estado inactivo.");
            }

            tiempo++;
        }
    }

    public static void planificacionPrioridadNoPreemptiva(List<Proceso> procesos) {
        System.out.println("\n--- Planificación por prioridad no preemptiva ---");
        int tiempo = 0;
        int procesosCompletados = 0;

        while (procesosCompletados < procesos.size()) {
            Proceso procesoElegido = null;

            // Buscar el proceso con la mayor prioridad que haya llegado y no esté completado
            for (Proceso p : procesos) {
                if (p.tiempoLlegada <= tiempo && !p.completado) {
                    if (procesoElegido == null || p.prioridad < procesoElegido.prioridad) {
                        procesoElegido = p;
                    }
                }
            }

            /* Realiza la impresion de los estados de cada proceso por cada segundo transcurrio dentro del proceso */
            if (procesoElegido != null) {
                System.out.println("Segundo " + tiempo + ": Ejecutando " + procesoElegido);
                tiempo += procesoElegido.tiempoEjecucion;
                procesoElegido.completado = true;
                procesosCompletados++;
                System.out.println("Proceso " + procesoElegido + " completado.");
            } else {
                System.out.println("Segundo " + tiempo + ": CPU en estado inactivo.");
                tiempo++;
            }
        }
    }

    
}