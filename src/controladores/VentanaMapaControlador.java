package controladores;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import sistema.Registro;
import visual.VentanaMapa;

public class VentanaMapaControlador {

	public static VentanaMapa ventanaMapa = new VentanaMapa();
	
	//Eventos
	public static void cerrar() {
		ventanaMapa.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaMapa.iniciar();
		ventanaMapa.setVisible(true);
	}
	public static void crearVertices(ArrayList<MapMarker> marcas) {
		Registro.crearVertices(marcas);
	}
	public static void cargarVertices(JMapViewer mapa, ArrayList<MapMarker> marcas) {
		Registro.cargarVertices(mapa, marcas);
	}
}
