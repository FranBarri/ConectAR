package sistema;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import gSon.GenerarGson;
import gSon.ListaLocalidades;
import gSon.Localidad;

public class Registro {
	
	public static Localidad generarLocalidad(String nombre, String provincia, double latitud, double longitud) {
		Localidad localidad = new Localidad(nombre, provincia, latitud, longitud);
		return localidad;
	}
	public static void registrarLocalidad(Localidad localidad) {
	    GenerarGson gsonGenerator = new GenerarGson();

	    // Agregar una nueva localidad a la lista de localidades
	    ListaLocalidades lista = gsonGenerator.getListaDesdeJson();
	    lista.agregarLocalidad(localidad.getNombre(), localidad.getProvincia(), localidad.getLatitud(), localidad.getLongitud());

	    // Generar un archivo JSON con la lista de localidades
	    gsonGenerator.generarJson(lista);
	}
	
	public static void crearVertices(ArrayList<MapMarker> marcas) {
	    GenerarGson gsonGenerator = new GenerarGson();

	    ListaLocalidades listaLocalidades = gsonGenerator.getListaDesdeJson();
	    List<Localidad> localidades = listaLocalidades.getLista();
	    
	    for (Localidad localidad : localidades) {
	    	Coordinate coordenadas = new Coordinate(localidad.getLatitud(), localidad.getLongitud());
			MapMarker marca = new MapMarkerDot(localidad.getNombre(), coordenadas);
	    	marcas.add(marca);
	    }
	}
	public static void cargarVertices(JMapViewer mapa, ArrayList<MapMarker> marcas) {
		mapa.removeAllMapMarkers();
		for (MapMarker marca : marcas) {
			mapa.addMapMarker(marca);			
		}
	}
	public static boolean yaIngresada(Localidad localidad) {
	    GenerarGson gsonGenerator = new GenerarGson();

	    ListaLocalidades lista = gsonGenerator.getListaDesdeJson();
	    List<Localidad> localidades = lista.getLista();
	    for (Localidad local : localidades) {
	    	if (localidad.getLatitud() == (local.getLatitud()) && localidad.getLongitud() == (local.getLongitud())) {
	    		return true;
	    	}
	    }
	    return false;
	}
}
