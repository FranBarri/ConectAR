package visual;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import controladores.DisenioMapa;
import controladores.VentanaMapaControlador;
import controladores.VentanaRegistroControlador;
import sistema.Conexion;
import sistema.Localidad;
import swing.PanelGradiente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import swing.PanelBorder;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame{
	private PanelGradiente panelGradiente1;
	private JMapViewer mapa;
	private JMapViewer mapaAGM;
	private JPanel panel;
	private List<Localidad> listaLocalidades;
	private List<Conexion> conexiones;
	private ArrayList<MapMarker> marcas;
	private boolean cambios;
	private String mensaje;
	private File imagen;
	private Image icono;
	
	public VentanaMapa() {
		initialize();
	}

	public void initialize() {
		listaLocalidades = VentanaRegistroControlador.getLista();
		marcas = new ArrayList<MapMarker>();
		conexiones = new ArrayList<Conexion>();
		cambios = false;
		mensaje = "";
//		aristas = new ArrayList<MapPolygon>();
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
		
        PanelBorder panelMapa = new PanelBorder();
        panelMapa.setLayout(null);
        panelMapa.setBackground(Color.WHITE);
        panelMapa.setBounds(10, 11, 862, 488);
        panelGradiente1.add(panelMapa);
        
        mapa = new JMapViewer();
        mapa.setBounds(10, 11, 842, 316);
        panelMapa.add(mapa);
        mapa.setZoomControlsVisible(false);
        Coordinate coord = new Coordinate(-33.416097, -63.616672);
		DisenioMapa.crearVertices(marcas, listaLocalidades);
        DisenioMapa.cargarVertices(mapa, marcas);
        
        JLabel lblCostoTotal = new JLabel("Costo Total");
        lblCostoTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblCostoTotal.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblCostoTotal.setBounds(10, 330, 842, 37);
        panelMapa.add(lblCostoTotal);
        
        JLabel lblCostoKM = new JLabel("Costo por KM");
        lblCostoKM.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCostoKM.setBounds(20, 362, 176, 20);
        panelMapa.add(lblCostoKM);
        
        JLabel lblCambio = new JLabel("Costo Fijo entre Provincias");
        lblCambio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCambio.setBounds(20, 432, 176, 17);
        panelMapa.add(lblCambio);
        
        JLabel lblTotal = new JLabel("Total");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTotal.setBounds(20, 458, 95, 28);
        panelMapa.add(lblTotal);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        panel_1.setBounds(10, 454, 842, 3);
        panelMapa.add(panel_1);
        
        JTextArea txtrPorcentajeTenerMs = new JTextArea();
        txtrPorcentajeTenerMs.setText("Costo con \r\nAumento");
        txtrPorcentajeTenerMs.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtrPorcentajeTenerMs.setEditable(false);
        txtrPorcentajeTenerMs.setBounds(18, 386, 128, 39);
        panelMapa.add(txtrPorcentajeTenerMs);
        
        JLabel lblPrecioKM = new JLabel("$ 0");
        lblPrecioKM.setHorizontalAlignment(SwingConstants.TRAILING);
        lblPrecioKM.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrecioKM.setBounds(737, 366, 105, 14);
        panelMapa.add(lblPrecioKM);
        
        JLabel lblPrecioPorcentaje = new JLabel("$ 0");
        lblPrecioPorcentaje.setHorizontalAlignment(SwingConstants.TRAILING);
        lblPrecioPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrecioPorcentaje.setBounds(737, 400, 105, 14);
        panelMapa.add(lblPrecioPorcentaje);
        
        JLabel lblPrecioCambio = new JLabel("$ 0");
        lblPrecioCambio.setHorizontalAlignment(SwingConstants.TRAILING);
        lblPrecioCambio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrecioCambio.setBounds(737, 436, 105, 14);
        panelMapa.add(lblPrecioCambio);
        
        JLabel lblPrecioTotal = new JLabel("$ 0");
        lblPrecioTotal.setHorizontalAlignment(SwingConstants.TRAILING);
        lblPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPrecioTotal.setBounds(569, 458, 263, 28);
        panelMapa.add(lblPrecioTotal);
        mapa.setDisplayPosition(coord, 5);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(Color.BLACK);
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEliminar.setBackground(Color.LIGHT_GRAY);
        btnEliminar.setBounds(140, 525, 119, 24);
        panelGradiente1.add(btnEliminar);
        btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JButton btnRegistro = new JButton("Nueva Localidad");
        btnRegistro.setForeground(new Color(0, 0, 0));
        btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnRegistro.setBackground(Color.LIGHT_GRAY);
        btnRegistro.setBounds(10, 525, 119, 24);
        panelGradiente1.add(btnRegistro);
        btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setForeground(Color.BLACK);
        btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnCalcular.setBackground(Color.LIGHT_GRAY);
        btnCalcular.setBounds(799, 525, 73, 24);
        panelGradiente1.add(btnCalcular);
        btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JButton btnActualizar = new JButton("Refrescar Mapa");
        btnActualizar.setForeground(Color.BLACK);
        btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnActualizar.setBackground(Color.LIGHT_GRAY);
        btnActualizar.setBounds(270, 525, 119, 24);
        panelGradiente1.add(btnActualizar);
        btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JButton btnGuardar = new JButton("Guardar Mapa");
        btnGuardar.setForeground(Color.BLACK);
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnGuardar.setBackground(Color.LIGHT_GRAY);
        btnGuardar.setBounds(400, 525, 119, 24);
        panelGradiente1.add(btnGuardar);
        btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnRegistro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (cambios) {
        			JOptionPane.showMessageDialog(null, "No puedes registrar nuevas localidades luego de calcular el costo.");
        		} else {
        			VentanaRegistroControlador.mostrarAuto();
        			VentanaMapaControlador.cerrar();
        		}
        	}
        });  
        
        btnEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String localidadAEliminar = JOptionPane.showInputDialog(null, "Ingrese la localidad que quiere eliminar:", "", JOptionPane.PLAIN_MESSAGE);
        		if (localidadAEliminar != null) {
        			if (!mensaje.isBlank()) {
        				panelGradiente1.remove(panel);
        			}
        			mensaje = "eliminado";
        			agregarExito(mensaje);
        			listaLocalidades = VentanaRegistroControlador.eliminarLocalidad(localidadAEliminar);
        			marcas.clear();
        			mapa.removeAllMapPolygons();
        			mapa.removeAllMapMarkers();
        			DisenioMapa.crearVertices(marcas, listaLocalidades);
        			DisenioMapa.cargarVertices(mapa, marcas);        			
        		}
        	}
        });
        
        btnActualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mapa.removeAllMapMarkers();
        		listaLocalidades = VentanaRegistroControlador.getLista();
        		DisenioMapa.crearVertices(marcas, listaLocalidades);
                DisenioMapa.cargarVertices(mapa, marcas);
        	}
        });
        
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!mensaje.isBlank()) {
        			panelGradiente1.remove(panel);
        		}
        		mensaje = "guardado";
        		agregarExito(mensaje);
        		VentanaRegistroControlador.guardarJson(listaLocalidades);
        	}
        });
        
        btnCalcular.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cambios = true;
        		conexiones = DisenioMapa.crearConexiones(listaLocalidades);
        		mapa.removeAllMapPolygons();
        		mapaAGM = mapa;
//        		mapaAGM = DisenioMapa.mostrarAristas(mapaAGM, listaLocalidades);
        		mapaAGM = DisenioMapa.mostrarAGM(mapa, listaLocalidades, conexiones);
        		panelMapa.remove(mapa);
        		panelMapa.add(mapaAGM);
        		//Esta bien esta forma de mostrar los costos? O tendria que ser de forma individual?
        		DecimalFormat df = new DecimalFormat("#.##");
        		lblPrecioKM.setText("$ " + df.format(DisenioMapa.mostrarCostoPorKM(listaLocalidades, conexiones)));
        		lblPrecioPorcentaje.setText("$ " + df.format(DisenioMapa.mostrarCostoConAumento(listaLocalidades, conexiones)));
        		lblPrecioCambio.setText("$ " + df.format(DisenioMapa.mostrarCostoFijo(listaLocalidades, conexiones)));
        		lblPrecioTotal.setText("$ " + df.format(DisenioMapa.mostrarCostoTotal(listaLocalidades, conexiones)));
        		
        	}
        });

	}
	private void agregarExito(String mensaje) {
        panel = new JPanel();
        panel.setBounds(20, 502, 200, 20);
        panelGradiente1.add(panel);
        panel.setLayout(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 280, 20);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textArea.setEditable(false);
        panel.add(textArea);
        if (mensaje == "eliminado") {
        	textArea.setText("¡Localidad eliminada con éxito!");
        }
        if (mensaje == "guardado") {
            panel.setBounds(20, 502, 180, 20);
        	textArea.setText("¡Mapa guardado con éxito!");
        }
	}
}
