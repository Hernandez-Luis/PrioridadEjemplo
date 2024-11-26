import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlanificacionPrioridad {

    // Función para ordenar los procesos por prioridad y tiempo de llegada
    public static void ordenarProcesos(ArrayList<Proceso> procesos) {
        System.out.println("\nIniciando el proceso de ordenamiento de procesos...\n");
        Collections.sort(procesos, new Comparator<Proceso>() {
            @Override
            public int compare(Proceso p1, Proceso p2) {
                System.out.println("Comparando procesos: P1(ID:" + p1.id + ", Prioridad:" + p1.prioridad + ", Llegada:" + p1.llegada + 
                                   ") vs P2(ID:" + p2.id + ", Prioridad:" + p2.prioridad + ", Llegada:" + p2.llegada + ")");
                if (p1.prioridad != p2.prioridad) {
                    return Integer.compare(p1.prioridad, p2.prioridad); // Ordenar por prioridad
                } else {
                    return Integer.compare(p1.llegada, p2.llegada); // Desempatar por tiempo de llegada
                }
            }
        });
        System.out.println("\nProcesos ordenados:");
        for (Proceso p : procesos) {
            System.out.println("ID: " + p.id + ", Prioridad: " + p.prioridad + ", Llegada: " + p.llegada);
        }
    }

    // Función para ejecutar los procesos y mostrar los resultados
    public static void ejecutarProcesos(ArrayList<Proceso> procesos) {
        System.out.println("\nIniciando ejecución de procesos...\n");
        int tiempoActual = 0;
        int[] tiempoEspera = new int[procesos.size()];
        int[] tiempoFinalizacion = new int[procesos.size()];

        System.out.println("\nOrden de ejecución de procesos:");
        System.out.printf("%-10s%-10s%-20s%-10s%-20s\n", "Proceso", "Prioridad", "Tiempo de Llegada", "Duración", "Tiempo de Finalización");

        for (int i = 0; i < procesos.size(); i++) {
            Proceso proceso = procesos.get(i);

            // System.out.println("\nProcesando el proceso ID: " + proceso.id);
            if (proceso.llegada > tiempoActual) {
                // System.out.println("Tiempo actual (" + tiempoActual + ") es menor que el tiempo de llegada (" + proceso.llegada + "). Actualizando tiempo actual.");
                tiempoActual = proceso.llegada;
            } else {
                System.out.println("Tiempo actual (" + tiempoActual + ") es suficiente para ejecutar el proceso.");
            }

            tiempoEspera[i] = tiempoActual - proceso.llegada;
            tiempoActual += proceso.duracion;
            tiempoFinalizacion[i] = tiempoActual;

            System.out.printf("P%-9d%-10d%-20d%-10d%-20d\n",
                    proceso.id, proceso.prioridad, proceso.llegada, proceso.duracion, tiempoFinalizacion[i]);
            // System.out.println("Tiempo de espera: " + tiempoEspera[i] + ", Tiempo de finalización: " + tiempoFinalizacion[i]);
        }

        // Calcular promedios
        double tiempoEsperaPromedio = 0, tiempoTurnaroundPromedio = 0;
        for (int i = 0; i < procesos.size(); i++) {
            tiempoEsperaPromedio += tiempoEspera[i];
            tiempoTurnaroundPromedio += tiempoFinalizacion[i] - procesos.get(i).llegada;
        }
        tiempoEsperaPromedio /= procesos.size();
        tiempoTurnaroundPromedio /= procesos.size();

        System.out.println("\nCálculos finales:");
        System.out.printf("Tiempo promedio de espera: %.2f\n", tiempoEsperaPromedio);
        System.out.printf("Tiempo promedio de turnaround: %.2f\n", tiempoTurnaroundPromedio);
    }

}
