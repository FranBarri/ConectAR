package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;

import swing.PanelBorder;
import swing.PanelGradiente;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaRegistro {
	
	private JFrame frame;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRegistro;
	private JTextField usrLocalidad;
	private JTextField usrProvincia;
	private JTextField usrLatitud;
	private JTextField usrLongitud;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
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
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelGradiente1 = new swing.PanelGradiente();
		panelRegistro = new swing.PanelBorder();
	
		panelGradiente1.setColorPrimario(new java.awt.Color(146, 233, 251));
        panelGradiente1.setColorSecundario(new java.awt.Color(12, 137, 163));
        
        panelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        
        frame.getContentPane().add(panelGradiente1);

        panelGradiente1.setLayer(panelRegistro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(324)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(330, Short.MAX_VALUE))
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(58)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(125, Short.MAX_VALUE))
        );
        
        JLabel lblRegistro = new JLabel("Registro");
        lblRegistro.setBounds(0, 23, 230, 37);
        lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblRegistro1 = new JLabel("Localidad");
        lblRegistro1.setBounds(0, 66, 230, 24);
        lblRegistro1.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistro1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelRegistro.setLayout(null);
        panelRegistro.add(lblRegistro);
        panelRegistro.add(lblRegistro1);
        
        usrLocalidad = new JTextField();
        usrLocalidad.setBounds(24, 128, 181, 24);
        panelRegistro.add(usrLocalidad);
        usrLocalidad.setColumns(10);
        
        JLabel lblLocalidad = new JLabel("Localidad");
        lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLocalidad.setBounds(25, 113, 67, 14);
        panelRegistro.add(lblLocalidad);
        
        usrProvincia = new JTextField();
        usrProvincia.setColumns(10);
        usrProvincia.setBounds(24, 178, 181, 24);
        panelRegistro.add(usrProvincia);
        
        JLabel lblProvincia = new JLabel("Provincia");
        lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProvincia.setBounds(25, 163, 67, 14);
        panelRegistro.add(lblProvincia);
        
        usrLatitud = new JTextField();
        usrLatitud.setColumns(10);
        usrLatitud.setBounds(24, 228, 181, 24);
        panelRegistro.add(usrLatitud);
        
        JLabel lblLatitud = new JLabel("Latitud");
        lblLatitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLatitud.setBounds(25, 213, 67, 14);
        panelRegistro.add(lblLatitud);
        
        usrLongitud = new JTextField();
        usrLongitud.setColumns(10);
        usrLongitud.setBounds(24, 280, 181, 24);
        panelRegistro.add(usrLongitud);
        
        JLabel lblLongitud = new JLabel("Longitud");
        lblLongitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLongitud.setBounds(25, 257, 67, 27);
        panelRegistro.add(lblLongitud);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRegistrar.setBounds(88, 337, 117, 24);
        panelRegistro.add(btnRegistrar);
        panelGradiente1.setLayout(gl_panelGradiente1);
	}
}
