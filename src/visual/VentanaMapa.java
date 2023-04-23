package visual;

import javax.swing.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import controladores.VentanaMapaControlador;
import controladores.VentanaRegistroControlador;
import swing.PanelGradiente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame{
	
	private PanelGradiente panelGradiente1;
	private JMapViewer mapa;
	private ArrayList<MapMarker> marcas;
	
	public VentanaMapa() {
		iniciar();
	}

	public void iniciar() {
		marcas = new ArrayList<MapMarker>();
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null); //Centra la ventana en pantalla
		setResizable(false);
		
		panelGradiente1 = new swing.PanelGradiente();
	
		panelGradiente1.setColorPrimario(new java.awt.Color(146, 233, 251));
        panelGradiente1.setColorSecundario(new java.awt.Color(12, 137, 163));
        panelGradiente1.setBounds(0, 0, 900, 600);

        getContentPane().add(panelGradiente1, BorderLayout.CENTER);
				
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVolver.setBackground(Color.BLUE);
		btnVolver.setBounds(782, 525, 90, 24);
		panelGradiente1.add(btnVolver);
		
		JButton btnCargarVertices = new JButton("Cargar Localidades");
		btnCargarVertices.setForeground(new Color(0, 0, 0));
		btnCargarVertices.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCargarVertices.setBackground(Color.BLUE);
		btnCargarVertices.setBounds(641, 525, 131, 24);
		panelGradiente1.add(btnCargarVertices);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 862, 481);
		panelGradiente1.add(panel);
		panel.setLayout(null);
		
		mapa = new JMapViewer();
		mapa.setBounds(10, 11, 842, 459);
		panel.add(mapa);
		mapa.setZoomControlsVisible(false);
		VentanaMapaControlador.crearVertices(marcas);
		VentanaMapaControlador.cargarVertices(mapa, marcas);
		
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				VentanaRegistroControlador.mostrar();
				dispose();
			}
        });

        btnCargarVertices.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaMapaControlador.crearVertices(marcas);
        		VentanaMapaControlador.cargarVertices(mapa, marcas);
        	}
        });
        Coordinate coord = new Coordinate(-38.416097, -63.616672);
		mapa.setDisplayPosition(coord, 5);
	}
}
