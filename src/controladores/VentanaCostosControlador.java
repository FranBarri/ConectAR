package controladores;

import java.awt.EventQueue;

import visual.VentanaCostos;

public class VentanaCostosControlador {

	static VentanaCostos ventanaCostos = new VentanaCostos();
	
//	public VentanaCostosControlador() {
//		inicializarVentanaCostos();
//	}
//	
//	public static void inicializarVentanaCostos() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ventanaCostos = new VentanaCostos();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	//Eventos
	public static void cerrar() {
		ventanaCostos.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaCostos.initialize();
		ventanaCostos.setVisible(true);
	}
}
