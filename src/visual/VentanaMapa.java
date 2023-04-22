package visual;

import javax.swing.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

import controladores.VentanaMapaControlador;
import controladores.VentanaRegistroControlador;
import swing.PanelGradiente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame{

	private PanelGradiente panelGradiente1;
	private JMapViewer _mapa;

	public VentanaMapa() {
		iniciar();
	}

	public void iniciar() {
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

		_mapa = new JMapViewer();
		_mapa.setBounds(10, 5, 862, 481);
		_mapa.setDisplayPosition(new Coordinate(-38.416097, -63.616672), 5);
		panelGradiente1.setLayout(null);
				
		panelGradiente1.add(_mapa);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVolver.setBackground(Color.BLUE);
		btnVolver.setBounds(782, 525, 90, 24);
		panelGradiente1.add(btnVolver);
		
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				VentanaRegistroControlador.mostrar();
				dispose();
			}
        });

	}

}
