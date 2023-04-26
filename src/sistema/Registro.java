package sistema;

import gSon.GenerarGson;
import gSon.ListaLocalidades;
import gSon.Localidad;

public class Registro {
    private static GenerarGson gsonGenerator = new GenerarGson();
    public static ListaLocalidades listaLocalidades = gsonGenerator.getListaDesdeJson();
    
	public static Localidad generarLocalidad(String nombre, String provincia, double latitud, double longitud) {
		Localidad localidad = new Localidad(nombre, provincia, latitud, longitud);
		return localidad;
	}
	public static void registrarLocalidad(Localidad localidad) {
	    listaLocalidades.agregarLocalidad(localidad.getNombre(), localidad.getProvincia(), localidad.getLatitud(), localidad.getLongitud());
	    gsonGenerator.generarJson(listaLocalidades);
	}
	
	public static ListaLocalidades getListaLocalidades() {
		return listaLocalidades;
	}

}
