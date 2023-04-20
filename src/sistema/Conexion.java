package sistema;

public class Conexion implements Comparable<Conexion> {
    private Localidad origen;
    private Localidad destino;
    private double costo;

    public Conexion(Localidad origen, Localidad destino, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    public Localidad getOrigen() {
        return origen;
    }

    public Localidad getDestino() {
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

