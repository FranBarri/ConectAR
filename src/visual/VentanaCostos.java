package visual;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controladores.DisenioVentanaMapa;
import controladores.VentanaRegistroControlador;
import sistema.Conexion;
import sistema.Localidad;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class VentanaCostos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
	private File imagen;
	private Image icono;
    private int filasPorPagina = 10;
    private int paginaActual = 0;

    public VentanaCostos() {
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

        // Crear la tabla con las columnas
        String[] columnas = {"Conexion", "Origen", "Destino",
        		"Costo por KM", "Costo con Aumento", "Costo fijo", "Costo Total"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Font font = new Font("Tahoma", Font.BOLD, 12);
        tabla.getTableHeader().setFont(font);
        
        // Agregar la tabla a un JScrollPane para permitir el scroll vertical
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Agregar el JScrollPane al panel principal de la ventana
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panel.setLayout(gl_panel);

        // Actualizar la tabla con los datos
        actualizarTabla();
    }

    private void actualizarTabla() {
        // Obtener la lista de conexiones y agregar las filas a la tabla
    	List<Localidad> localidades = VentanaRegistroControlador.getLista();
        List<Conexion> conexiones = DisenioVentanaMapa.crearConexiones(localidades);
        int inicio = paginaActual * filasPorPagina;
        int fin = Math.min((paginaActual + 1) * filasPorPagina, conexiones.size());
        for (int i = inicio; i < fin; i++) {
            Conexion conexion = conexiones.get(i);
            modelo.addRow(new Object[]{i, conexion.getDestino().getNombre(), 
            		conexion.getCostoPorKM(), conexion.getCostoConAum(), 
            		conexion.getCostoFijo(), conexion.getCostoTotal()});
        }
        modelo.fireTableDataChanged();
    }
}
