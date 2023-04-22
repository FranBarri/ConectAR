package sistema;

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
}
