import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlanificacionPrioridad {

    // Función para ordenar los procesos por prioridad y tiempo de llegada
    public static void ordenarProcesos(ArrayList<Proceso> procesos) {
        Collections.sort(procesos, new Comparator<Proceso>() {
            @Override
            public int compare(Proceso p1, Proceso p2) {
                if (p1.prioridad != p2.prioridad) {
                    return Integer.compare(p1.prioridad, p2.prioridad); // Ordenar por prioridad
                } else {
                    return Integer.compare(p1.llegada, p2.llegada); // Desempatar por tiempo de llegada
                }
            }
        });
    }

    // Función para ejecutar los procesos y mostrar los resultados
    public static void ejecutarProcesos(ArrayList<Proceso> procesos) {
        int tiempoActual = 0;
        int[] tiempoEspera = new int[procesos.size()];
        int[] tiempoFinalizacion = new int[procesos.size()];

        System.out.println("\nOrden de ejecución de procesos:");
        System.out.printf("%-10s%-10s%-20s%-10s%-20s\n", "Proceso", "Prioridad", "Tiempo de Llegada", "Duración", "Tiempo de Finalización");

        for (int i = 0; i < procesos.size(); i++) {
            Proceso proceso = procesos.get(i);

            // Si el proceso llega despues del tiempo actual, el sistema "espera" a que el programa este listo, pero si el 
            // proceso llego antes del tiempo actual entonces el tiempo actual no se modifica
            if (proceso.llegada > tiempoActual) {
                tiempoActual = proceso.llegada;
            }

            /*  El tiempo espera se calcula restando el tiempo actual menos el proceso de llegada, representando cuando espero el proceso 
            para iniciar su ejecucion desde que llego */
            tiempoEspera[i] = tiempoActual - proceso.llegada;
            /* El tiempo actual se actualiza, agregando el tiempo de duracion, haciendo referencia a la suma de tiempos, el tiempo actual y el tiempo 
            que ha durado el proceso anterior en ejecutarse
             */
            tiempoActual += proceso.duracion;
            /*El tiempo actual el el momento en el que el proceso anterior a finalizado su ejecucion */
            tiempoFinalizacion[i] = tiempoActual;

            // Imprimir detalles del proceso
            System.out.printf("P%-9d%-10d%-20d%-10d%-20d\n",
                    proceso.id, proceso.prioridad, proceso.llegada, proceso.duracion, tiempoFinalizacion[i]);
        }

        // Calcular promedios
        double tiempoEsperaPromedio = 0, tiempoTurnaroundPromedio = 0;
        for (int i = 0; i < procesos.size(); i++) {
            tiempoEsperaPromedio += tiempoEspera[i];
            /* El tiempo turnaround es todo el tiempo en el que el proceso pasa en el sistema, desde que lelgo hasta que finalizo */
            tiempoTurnaroundPromedio += tiempoFinalizacion[i] - procesos.get(i).llegada;
        }
        tiempoEsperaPromedio /= procesos.size();
        tiempoTurnaroundPromedio /= procesos.size();

        System.out.printf("\nTiempo promedio de espera: %.2f\n", tiempoEsperaPromedio);
        System.out.printf("Tiempo promedio de turnaround: %.2f\n", tiempoTurnaroundPromedio);
    }


}