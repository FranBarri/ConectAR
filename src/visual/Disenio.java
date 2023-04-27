package visual;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import gSon.Localidad;

public class Disenio {

	public static void crearVertices(ArrayList<MapMarker> marcas, List<Localidad> localidades) {
	    for (Localidad localidad : localidades) {
	    	Coordinate coordenadas = new Coordinate(localidad.getLatitud(), localidad.getLongitud());
			MapMarker marca = new MapMarkerDot(localidad.getNombre(), coordenadas);
	    	marcas.add(marca);
	    }
	}
	public static void cargarVertices(JMapViewer mapa, ArrayList<MapMarker> marcas) {
		for (MapMarker marca : marcas) {
			mapa.addMapMarker(marca);			
		}
	}
	public static JMapViewer mostrarAristasAGM(JMapViewer mapa, List<Localidad> localidades) {
		ArrayList<Coordinate> coords = new ArrayList<>();
		JMapViewer mapaRet = mapa;
		for (Localidad local : localidades) {
			coords.add(new Coordinate(local.getLatitud(), local.getLongitud()));
			MapPolygon polygon = new MapPolygonImpl(coords);
			polygon.getStyle().setBackColor(null);
			polygon.getStyle().setColor(Color.BLUE);
			mapaRet.addMapPolygon(polygon);
		}
		return mapaRet;
	}
}
