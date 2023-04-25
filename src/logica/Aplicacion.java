package logica;

import java.util.*;

public class Aplicacion {
    private List<Localidad> localidades;
    private Grafo grafo;
    
    public Aplicacion() {
        this.localidades = new ArrayList<Localidad>();
        this.grafo = new Grafo(0);
    }
    
    public void agregarLocalidad(Localidad localidad) {
        localidades.add(localidad);
        int n = localidades.size();
        Grafo nuevoGrafo = new Grafo(n);
        this.grafo = nuevoGrafo;
    }
    
    
    // otros m�todos de la aplicaci�n, como resolver el problema del �rbol generador m�nimo,
    // mostrar la soluci�n en un mapa, guardar y cargar datos en archivos, etc.
}
