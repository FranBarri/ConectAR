package controladores;

import gSon.Localidad;
import sistema.Registro;
import visual.VentanaRegistro;

public class VentanaRegistroControlador {
	
	public static VentanaRegistro ventanaRegistro = new VentanaRegistro();
	
	public static void cerrar() {
		ventanaRegistro.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaRegistro.initialize();
		ventanaRegistro.setVisible(true);
	}
	public static Localidad generarLocalidad(String nombre, String provincia, double latitud, double longitud) {
		return Registro.generarLocalidad(nombre, provincia, latitud, longitud);
	}
	
	public static void registrarLocalidad(Localidad localidad) {
		Registro.registrarLocalidad(localidad);
	}
	public static boolean yaIngresada(String nombre) {
		return Registro.yaIngresada(nombre);
	}
}
