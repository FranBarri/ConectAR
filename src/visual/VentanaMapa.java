package visual;

import java.awt.EventQueue;

import javax.swing.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class VentanaMapa {

	private JFrame frame;
	private JPanel panelMapa;
	private JMapViewer _mapa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMapa window = new VentanaMapa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMapa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelMapa = new JPanel();
		panelMapa.setBounds(0, 0, 734, 561);
		frame.getContentPane().add(panelMapa);

		_mapa = new JMapViewer();
		_mapa.setBounds(10, 5, 714, 545);
		_mapa.setDisplayPosition(new Coordinate(-34.521, -58.7008), 15);
		panelMapa.setLayout(null);
				
		panelMapa.add(_mapa);

	}

}
