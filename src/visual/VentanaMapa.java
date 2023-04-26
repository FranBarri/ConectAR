package visual;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import controladores.VentanaMapaControlador;
import controladores.VentanaRegistroControlador;
import swing.PanelGradiente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame{
	
	private PanelGradiente panelGradiente1;
	private JMapViewer mapa;
	private ArrayList<MapMarker> marcas;
	private File imagen;
	private Image icono;
	
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
		//Cargar icono y titulo de ventana
		try {
			imagen = new File("imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("ConectAR");
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
		btnRegistro.setBackground(Color.LIGHT_GRAY);
		btnRegistro.setBounds(10, 525, 119, 24);
		panelGradiente1.add(btnRegistro);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setForeground(Color.BLACK);
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalcular.setBackground(Color.LIGHT_GRAY);
		btnCalcular.setBounds(799, 527, 73, 24);
		panelGradiente1.add(btnCalcular);
		
        btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				VentanaRegistroControlador.mostrarAuto();
				VentanaMapaControlador.cerrar();
			}
        });
        
        btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCalcular.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaMapaControlador.armarSistemaDeLineas(mapa);
        	}
        });
        
        mapa.repaint();
		VentanaMapaControlador.crearVertices(marcas);
		VentanaMapaControlador.cargarVertices(mapa, marcas);
		
        Coordinate coord = new Coordinate(-33.416097, -63.616672);
		mapa.setDisplayPosition(coord, 5);
	}
}
