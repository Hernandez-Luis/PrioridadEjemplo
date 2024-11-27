import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Nombre del alumno: Luis Alberto Hernandez Ramirez
 * Grupo: 703
 * Nombre del profesor: Rubén García Hernández
 * Materia: Sitemas Operativos II
 * Algoritmo asignado: Planificaion basada en prioridades
 */

public class Main {
    public static void main(String[] args) {

        PlanificacionPrioridad planificacionPrioridad = new PlanificacionPrioridad();
        Scanner scanner = new Scanner(System.in);
        List<Proceso> procesos = new ArrayList<>();

        System.out.println("Ingrese el número de procesos:");
        int numeroProcesos = scanner.nextInt();

        for (int i = 1; i <= numeroProcesos; i++) {
            System.out.println("Ingrese los detalles para el proceso " + i + ":");
            System.out.print("Tiempo de llegada: ");
            int tiempoLlegada = scanner.nextInt();
            System.out.print("Tiempo de ejecución: ");
            int tiempoEjecucion = scanner.nextInt();
            System.out.print("Prioridad (menor valor = mayor prioridad): ");
            int prioridad = scanner.nextInt();

            procesos.add(new Proceso(i, tiempoLlegada, tiempoEjecucion, prioridad));
        }

        System.out.println("\nProcesos ingresados:");
        for (Proceso p : procesos) {
            System.out.println(p);
        }

        System.out.println("\nSeleccione el modo de planificación:");
        System.out.println("1. Preemptiva");
        System.out.println("2. No preemptiva");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            planificacionPrioridad.planificacionPrioridadPreemptiva(procesos);
        } else if (opcion == 2) {
            planificacionPrioridad.planificacionPrioridadNoPreemptiva(procesos);
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}

/*
DATOS QUE SE PUEDEN REGISTRAR PARA VISUALIZAR DE MEJOR MANERA LOS PROCESOS

 P1 (Llegada: 0 ---  Ejecucion: 4 --- Prioridad: 1)
 P2 (Llegada: 7 ---  Ejecucion: 6 --- Prioridad: 2)
 P3 (Llegada: 9 ---  Ejecucion: 5 --- Prioridad: 1)
 */