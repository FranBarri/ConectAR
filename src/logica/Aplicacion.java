package logica;

import java.util.*;

public class Aplicacion {
    private List<Vertice> localidades;
    private Grafo grafo;
    
    public Aplicacion() {
        this.localidades = new ArrayList<Vertice>();
        this.grafo = new Grafo(0);
    }
    
    public void agregarLocalidad(Vertice localidad) {
        localidades.add(localidad);
        int n = localidades.size();
        Grafo nuevoGrafo = new Grafo(n);
        this.grafo = nuevoGrafo;
    }
    
    private double calcularDistancia(double latitud1, double longitud1, double latitud2, double longitud2) {
        // código para calcular la distancia entre dos puntos en la Tierra
        // usando la fórmula de Haversine
    	throw new RuntimeException("falta implementar");
    }
    
    private double calcularCosto(double distancia, String provincia1, String provincia2) {
        // código para calcular el costo de una conexión en función de la distancia y
        // las provincias involucradas
    	throw new RuntimeException("falta implementar");
    }
    
    // otros métodos de la aplicación, como resolver el problema del árbol generador mínimo,
    // mostrar la solución en un mapa, guardar y cargar datos en archivos, etc.
}
