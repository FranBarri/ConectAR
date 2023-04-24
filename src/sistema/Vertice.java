package sistema;

import java.util.HashSet;
import java.util.LinkedList;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import gSon.Localidad;

public class Vertice {
    private Localidad localidad;
    private MapMarkerDot vertice;
	private HashSet<Localidad> vecinos;
	private LinkedList<Arista> aristas;

    public Vertice(Localidad localidad) {
        this.localidad = localidad;
		vecinos = new HashSet<Localidad>();
		aristas = new LinkedList<Arista>();
		vertice = new MapMarkerDot(localidad.getLatitud(), localidad.getLongitud());
    }
    
	private Arista auxCrearArista(Localidad localidad)
	{
		Arista arista = new Arista(this.localidad, localidad);
		return arista;
	}
	
	public MapMarkerDot getMarkerDot() {
		return vertice;
	}

    // Métodos getter y setter
    public Localidad getLocalidad() {
        return this.localidad;
	}
}

