import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Proceso> procesos = new ArrayList<>();

        System.out.print("Ingrese el número de procesos: ");
        int n = scanner.nextInt();

        // Leer detalles de los procesos
        for (int i = 0; i < n; i++) {
            System.out.println("\nIngrese los detalles del proceso " + (i + 1) + ":");
            System.out.print("Tiempo de llegada: ");
            int llegada = scanner.nextInt();
            System.out.print("Duración de la ráfaga de CPU: ");
            int duracion = scanner.nextInt();
            System.out.print("Prioridad (menor número = mayor prioridad): ");
            int prioridad = scanner.nextInt();

            procesos.add(new Proceso(i + 1, llegada, duracion, prioridad));
        }

        // Ordenar los procesos y ejecutarlos
        PlanificacionPrioridad.ordenarProcesos(procesos);
        PlanificacionPrioridad.ejecutarProcesos(procesos);

        scanner.close();
    }
}