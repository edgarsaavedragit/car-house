package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Datos del primer auto
	public static String modelo0 = "Toyota Corolla";
	public static double precio0 = 23000.0;
	public static int potencia0 = 139;
	public static String transmision0 = "Manual";
	public static int cilindrada0 = 1800;
	
	// Datos del segundo auto
	public static String modelo1 = "Honda Civic";
	public static double precio1 = 25500.0;
	public static int potencia1 = 158;
	public static String transmision1 = "Automatica";
	public static int cilindrada1 = 2000;
	
	// Datos del tercer auto
	public static String modelo2 = "Ford Mustang";
	public static double precio2 = 45000.0;
	public static int potencia2 = 450;
	public static String transmision2 = "Automatica";
	public static int cilindrada2 = 5000;
	
	// Datos del cuarto auto
	public static String modelo3 = "Mazda 3";
	public static double precio3 = 24000.0;
	public static int potencia3 = 186;
	public static String transmision3 = "Manual";
	public static int cilindrada3 = 2500;
	
	// Datos del quinto auto
	public static String modelo4 = "BMW Serie 3";
	public static double precio4 = 48000.0;
	public static int potencia4 = 255;
	public static String transmision4 = "Automatica";
	public static int cilindrada4 = 2000;
	
	// Porcentajes de descuento disponibles
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Obsequios disponibles para las compras
	public static String obsequio1 = "Moto WANXIN"; 
    public static String obsequio2 = "Viaje VIP para dos personas";       
    public static String obsequio3 = "Ford Ranger Raptor";
    
    // Cantidad óptima sugerida para stock
	public static int cantidadOptima = 10;
    
	// Cuota semanal de ventas deseada
    public static double cuotaSemanal = 200000; 
    
    // Variables globales: importe acumulado de ventas por modelo y total
    public static double importeAcumulado0, importeAcumulado1, importeAcumulado2,
    importeAcumulado3, importeAcumulado4, importeAcumuladoTotal;

    // Variables globales: porcentaje de la cuota semanal alcanzado por modelo y total
    public static double porcentajeCuota0, porcentajeCuota1, porcentajeCuota2,
    porcentajeCuota3, porcentajeCuota4, porcentajeCuotaTotal;

    // Contadores: número de ventas por modelo y total
    public static int contadorVenta0, contadorVenta1, contadorVenta2, contadorVenta3,
    contadorVenta4, contadorVentaTotal;

    // Acumulador: unidades vendidas por modelo
    public static int cantUniVendidas0, cantUniVendidas1, cantUniVendidas2,
    cantUniVendidas3, cantUniVendidas4;
	
	// Premio sorpresa
	public static String premioSorpresa = "Un polo";
	
	// Componentes del menú de la aplicación
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnNewMenu;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmVender;
	private JMenuItem mntmDescuentos;
	private JMenuItem mntmObsequios;
	private JMenuItem mntmAcerca;
	private JLabel lblNewLabel;
	private JLabel lblCar;
	private JLabel lblVenta;

	/**
	 * Método principal: inicia la aplicación y configura la apariencia.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor: configura la ventana principal y los menús.
	 */
	public Tienda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tienda.class.getResource("/img/auto.png")));
		setTitle("CAR HOUSE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		// Configura la barra de menú y los ítems
		menuProyecto = new JMenuBar();
		setJMenuBar(menuProyecto);
		
		// Menú Archivo
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Tienda.class.getResource("/img/salir.png")));
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		// Menú Mantenimiento
		mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuProyecto.add(mnNewMenu);
		
		mntmConsultar = new JMenuItem("Consultar auto");
		mntmConsultar.setIcon(new ImageIcon(Tienda.class.getResource("/img/consultar.png")));
		mntmConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmConsultar.addActionListener(this);
		mnNewMenu.add(mntmConsultar);
		
		mntmModificar = new JMenuItem("Modificar auto");
		mntmModificar.setIcon(new ImageIcon(Tienda.class.getResource("/img/modificar.png")));
		mntmModificar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmModificar.addActionListener(this);
		mnNewMenu.add(mntmModificar);
		
		mntmListar = new JMenuItem("Listar autos");
		mntmListar.setIcon(new ImageIcon(Tienda.class.getResource("/img/listar.png")));
		mntmListar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmListar.addActionListener(this);
		mnNewMenu.add(mntmListar);
		
		// Menú Ventas
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuProyecto.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.setIcon(new ImageIcon(Tienda.class.getResource("/img/vender.png")));
		mntmVender.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		// Menú Configuración
		mnConfiguracion = new JMenu("Configuracion");
		mnConfiguracion.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuProyecto.add(mnConfiguracion);
		
		mntmDescuentos = new JMenuItem("Configurar descuentos");
		mntmDescuentos.setIcon(new ImageIcon(Tienda.class.getResource("/img/descuentos.png")));
		mntmDescuentos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmDescuentos);
		
		mntmObsequios = new JMenuItem("Configurar obsequios");
		mntmObsequios.setIcon(new ImageIcon(Tienda.class.getResource("/img/obsequios.png")));
		mntmObsequios.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmObsequios.addActionListener(this);
		mnConfiguracion.add(mntmObsequios);
		
		// Menú Ayuda
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuProyecto.add(mnAyuda);
		
		mntmAcerca = new JMenuItem("Acerca de Tienda");
		mntmAcerca.setIcon(new ImageIcon(Tienda.class.getResource("/img/acerca.png")));
		mntmAcerca.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmAcerca.addActionListener(this);
		mnAyuda.add(mntmAcerca);
		getContentPane().setLayout(null);
		
		lblCar = new JLabel("");
		lblCar.setIcon(new ImageIcon(Tienda.class.getResource("/img/car.jpg")));
		lblCar.setBounds(1095, 0, 193, 173);
		getContentPane().add(lblCar);
		
		lblVenta = new JLabel("");
		lblVenta.setIcon(new ImageIcon(Tienda.class.getResource("/img/logo.png")));
		lblVenta.setBounds(10, 11, 346, 214);
		getContentPane().add(lblVenta);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tienda.class.getResource("/img/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 1315, 694);
		getContentPane().add(lblNewLabel);
	}

	/**
	 * Maneja las acciones de los menús según la opción elegida.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAcerca) {
			actionPerformedMntmAcerca(e);
		}
		if (e.getSource() == mntmObsequios) {
			actionPerformedMntmObsequios(e);
		}
		if (e.getSource() == mntmDescuentos) {
			actionPerformedMntmDescuentos(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListar) {
			actionPerformedMntmListar(e);
		}
		if (e.getSource() == mntmModificar) {
			actionPerformedMntmModificar(e);
		}
		if (e.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	// Cierra la aplicación
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
	//VENTANAS DE LOS SUBMENUS
	
	// Abre la ventana para consultar autos
	protected void actionPerformedMntmConsultar(ActionEvent e) {
		MantenimientoConsultar dc = new MantenimientoConsultar(); 
		dc.setLocationRelativeTo(this); 
		dc.setVisible(true); 
	}
	
	// Abre la ventana para modificar autos
	protected void actionPerformedMntmModificar(ActionEvent e) {
		MantenimientoModificar dc = new MantenimientoModificar(); 
		dc.setLocationRelativeTo(this); 
		dc.setVisible(true); 
	}
	
	// Abre la ventana para listar autos
	protected void actionPerformedMntmListar(ActionEvent e) {
		MantenimientoListar dc = new MantenimientoListar(); 
		dc.setLocationRelativeTo(this); 
		dc.setVisible(true); 
	}
	
	// Abre la ventana para realizar ventas
	protected void actionPerformedMntmVender(ActionEvent e) {
		VentasVender dc = new VentasVender(); 
		dc.setLocationRelativeTo(this); 
		dc.setVisible(true); 
	}
	
	// Abre la ventana para configurar descuentos
	protected void actionPerformedMntmDescuentos(ActionEvent e) {
		ConfigurarDescuentos dc = new ConfigurarDescuentos(); 
		dc.setLocationRelativeTo(this); 
		dc.setVisible(true); 
	}
	
	// Abre la ventana para configurar obsequios
	protected void actionPerformedMntmObsequios(ActionEvent e) {
		ConfigurarObsequios dc = new ConfigurarObsequios(); 
		dc.setLocationRelativeTo(this); 
		dc.setVisible(true); 
	}
	
	// Abre la ventana "Acerca de Tienda"
	protected void actionPerformedMntmAcerca(ActionEvent e) {
		AcercaDeTienda dc = new AcercaDeTienda(); 
		dc.setLocationRelativeTo(this); 
		dc.setVisible(true); 
	}
}
