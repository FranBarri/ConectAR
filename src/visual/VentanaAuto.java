package visual;

import javax.swing.JFrame;

import swing.PanelBorder;
import swing.PanelGradiente;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controladores.VentanaMapaControlador;
import controladores.VentanaRegistroControlador;
import gSon.Localidad;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class VentanaAuto extends JFrame{
	private String localidad;
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRegistro;
	private JTextField usrLocalidad;

	public VentanaAuto() {
		initialize();
	}

	public void initialize() {
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panelRegistro = new swing.PanelBorder();
	
		panelGradiente1.setColorPrimario(new java.awt.Color(146, 233, 251));
        panelGradiente1.setColorSecundario(new java.awt.Color(12, 137, 163));
        
        panelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        
        getContentPane().add(panelGradiente1, BorderLayout.CENTER);

        panelGradiente1.setLayer(panelRegistro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        JLabel lblRegistrar = new JLabel("Registrar");
        lblRegistrar.setBounds(0, 23, 230, 37);
        lblRegistrar.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblRegistro1 = new JLabel("Localidad");
        lblRegistro1.setBounds(0, 66, 230, 24);
        lblRegistro1.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistro1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelRegistro.setLayout(null);
        panelRegistro.add(lblRegistrar);
        panelRegistro.add(lblRegistro1);
        
        usrLocalidad = new JTextField();
        usrLocalidad.setBounds(24, 128, 181, 24);
        panelRegistro.add(usrLocalidad);
        usrLocalidad.setColumns(10);
        
        JLabel lblLocalidad = new JLabel("Localidad");
        lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLocalidad.setBounds(25, 113, 67, 14);
        panelRegistro.add(lblLocalidad);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setForeground(new Color(0, 0, 0));
        btnRegistrar.setBackground(new Color(0, 0, 255));
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnRegistrar.setBounds(115, 178, 90, 24);
        panelRegistro.add(btnRegistrar);
        
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(330)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(324, Short.MAX_VALUE))
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(150)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(228, Short.MAX_VALUE))
        );
        
        JButton btnMapa = new JButton("Mapa");
        btnMapa.setForeground(new Color(0, 0, 0));
        btnMapa.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnMapa.setBackground(Color.BLUE);
        btnMapa.setBounds(24, 178, 68, 24);
        panelRegistro.add(btnMapa);
        
        JLabel lblRegManual = new JLabel("\u00A1Tengo Coordenadas!");
        lblRegManual.setForeground(new Color(0, 0, 255));
        lblRegManual.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegManual.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRegManual.setBounds(24, 208, 181, 14);
        panelRegistro.add(lblRegManual);
        
        panelGradiente1.setLayout(gl_panelGradiente1);
        
        lblRegManual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblRegManual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	VentanaRegistroControlador.mostrarManual();
            	dispose();
            }
        });
        
        btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistrar.setToolTipText("Registra la primer localidad encontrada");
        btnRegistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		localidad = usrLocalidad.getText();
        		if (!localidad.isBlank()) {
        			Localidad local = VentanaRegistroControlador.buscarPorNombre(localidad);
        			if (VentanaRegistroControlador.yaIngresada(local)) {
        				JOptionPane.showMessageDialog(null, "Localidad ya ingresada.");
        			} else {
        				VentanaRegistroControlador.registrarLocalidad(local);
        				aniadirExito();
        				limpiarFields();
        			}
        		} else {
        			JOptionPane.showMessageDialog(null, "Ingrese datos apropiados.");
        		}
        	}
        });
        
        btnMapa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMapa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				VentanaMapaControlador.mostrar();
				dispose();
			}
        });
	}

	private void aniadirExito() {
		JLabel lblExito = new JLabel("\u00A1Localidad registrada con éxito!");
		lblExito.setHorizontalAlignment(SwingConstants.LEFT);
		lblExito.setForeground(new Color(0, 128, 0));
		lblExito.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExito.setBounds(24, 158, 195, 14);
		panelRegistro.add(lblExito);
	}
	private void limpiarFields() {
		usrLocalidad.setText("");
	}
}
