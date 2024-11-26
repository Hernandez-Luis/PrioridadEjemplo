// Clase para representar un proceso
class Proceso {
    int id;           // Identificador del proceso
    int llegada;      // Tiempo de llegada
    int duracion;     // Duración de la ráfaga de CPU
    int prioridad;    // Prioridad (menor valor = mayor prioridad)

    public Proceso(int id, int llegada, int duracion, int prioridad) {
        this.id = id;
        this.llegada = llegada;
        this.duracion = duracion;
        this.prioridad = prioridad;
    }
}


