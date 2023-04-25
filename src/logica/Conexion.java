package logica;

public class Conexion implements Comparable<Conexion> {
	private Localidad origen;
    private Localidad destino;
    private double costoPorKilometro;
    private double porcentajeAumento;
    private double costoFijo;

    public Conexion(Localidad origen, Localidad destino, double costo) {
        this.origen = origen;
        this.destino = destino;
        
    }

    public Localidad getOrigen() {
        return origen;
    }

    public Localidad getDestino() {
        return destino;
    }

    public double calcularCosto() {
    	// código para calcular el costo de una conexión en función de la distancia y
        // las provincias involucradas
        double distancia = calcularDistancia(origen.getLatitud(), origen.getLongitud(), destino.getLatitud(), destino.getLongitud());
        double costo = distancia * costoPorKilometro;
        costo += costo * porcentajeAumento / 100;
        costo += costoFijo;
        return costo;
    }

    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
    	// código para calcular la distancia entre dos puntos en la Tierra
        // usando la fórmula de Haversine
        double radioTierra = 6371; // en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = radioTierra * c;
        return distancia;
    }


    @Override
    public int compareTo(Conexion otraArista) {
        return Double.compare(this.calcularCosto(), otraArista.calcularCosto());
    }
}
