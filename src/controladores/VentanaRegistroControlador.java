package controladores;

import java.awt.EventQueue;

import gSon.Localidad;
import sistema.Geonames;
import sistema.Registro;
import visual.VentanaAuto;
import visual.VentanaMapa;
import visual.VentanaRegistroManual;

public class VentanaRegistroControlador {
	
	
	public static VentanaAuto ventanaAuto;
	public static VentanaRegistroManual ventanaRegistroManual;
	
	public VentanaRegistroControlador() {
		inicializarVentanaRegistro();
	}
	
	private static void inicializarVentanaRegistro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAuto = new VentanaAuto();
					mostrarAuto();
					ventanaRegistroManual = new VentanaRegistroManual();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void cerrarManual() {
		ventanaRegistroManual.setVisible(false);
	}
	public static void cerrarAuto() {
		ventanaAuto.setVisible(false);
	}
	public static void mostrarManual() {
		ventanaRegistroManual.initialize();
		ventanaRegistroManual.setVisible(true);
	}
	public static void mostrarAuto() {
		ventanaAuto.initialize();
		ventanaAuto.setVisible(true);
	}
	public static Localidad generarLocalidad(String nombre, String provincia, double latitud, double longitud) {
		return Registro.generarLocalidad(nombre, provincia, latitud, longitud);
	}
	
	public static void registrarLocalidad(Localidad localidad) {
		Registro.registrarLocalidad(localidad);
	}
	public static Localidad buscarPorNombre(String nombre) {
		try {
			return Geonames.buscarPorNombre(nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
