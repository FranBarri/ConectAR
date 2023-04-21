package controladores;

import gSon.Localidad;
import sistema.Registro;

public class VentanaRegistroControlador {
	public static Localidad generarLocalidad(String nombre, String provincia, double latitud, double longitud) {
		return Registro.generarLocalidad(nombre, provincia, latitud, longitud);
	}
	
	public static void registrarLocalidad(Localidad localidad) {
		Registro.registrarLocalidad(localidad);
	}
}
