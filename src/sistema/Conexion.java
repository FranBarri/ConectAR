package sistema;

public class Conexion implements Comparable<Conexion> {
    private Vertice origen;
    private Vertice destino;
    private double costo;

    public Conexion(Vertice origen, Vertice destino, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public int compareTo(Conexion otraArista) {
        return Double.compare(this.costo, otraArista.getCosto());
    }
}
