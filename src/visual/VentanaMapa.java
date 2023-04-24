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
import java.awt.Cursor;
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

	//Preguntar por borrando puntos que se agregan en una sesion, pero los ya guardados no se borran
	//y mapa volviendo a sus coords previas cuando registro y vuelvo a mapa
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
				
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 862, 481);
        panelGradiente1.add(panel);
        panel.setLayout(null);
        
        mapa = new JMapViewer();
        mapa.setBounds(10, 11, 842, 459);
        panel.add(mapa);
        mapa.setZoomControlsVisible(false);
		
		JButton btnRegistro = new JButton("Nueva Localidad");
		btnRegistro.setForeground(new Color(0, 0, 0));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBackground(Color.BLUE);
		btnRegistro.setBounds(10, 525, 119, 24);
		panelGradiente1.add(btnRegistro);
		
		btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setForeground(Color.BLACK);
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalcular.setBackground(Color.BLUE);
		btnCalcular.setBounds(799, 527, 73, 24);
		panelGradiente1.add(btnCalcular);
		
		
        btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				VentanaRegistroControlador.mostrarAuto();
				dispose();
			}
        });

		VentanaMapaControlador.crearVertices(marcas);
		VentanaMapaControlador.cargarVertices(mapa, marcas);
		
        Coordinate coord = new Coordinate(-38.416097, -63.616672);
		mapa.setDisplayPosition(coord, 5);
	}
}
