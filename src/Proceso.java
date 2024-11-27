import java.util.*;

class Proceso {
    int id;
    int tiempoLlegada;
    int tiempoEjecucion;
    int prioridad;
    int tiempoRestante;
    boolean completado; /* El estado en el que se encuentra el proceso */

    Proceso(int id, int tiempoLlegada, int tiempoEjecucion, int prioridad) {
        this.id = id;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEjecucion = tiempoEjecucion;
        this.prioridad = prioridad;
        this.tiempoRestante = tiempoEjecucion;
        this.completado = false;
    }

    @Override
    public String toString() {
        return "P" + id + " (Llegada: " + tiempoLlegada + ", Ejecución: " + tiempoEjecucion + 
               ", Prioridad: " + prioridad + ")";
    }
}


