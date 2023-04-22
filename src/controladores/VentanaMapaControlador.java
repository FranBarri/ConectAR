package controladores;

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
}
