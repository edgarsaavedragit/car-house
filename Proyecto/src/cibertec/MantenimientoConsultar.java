package cibertec;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class MantenimientoConsultar extends JDialog implements ActionListener,  ItemListener {

	private static final long serialVersionUID = 1L;
	// Declaración de los componentes gráficos de la interfaz
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblPotencia;
	private JLabel lblTransmision;
	private JLabel lblCilindrada;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtPotencia;
	private JTextField txtTransmision;
	private JTextField txtCilindrada;
	private JButton btnCerrar;

	/**
	 * Método principal para lanzar la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Crea y muestra el diálogo
					MantenimientoConsultar dialog = new MantenimientoConsultar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor que crea y configura la ventana del diálogo.
	 */
	public MantenimientoConsultar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoConsultar.class.getResource("/img/consultar.png")));
		getContentPane().setBackground(new Color(255, 255, 128));
		setBackground(new Color(240, 240, 240));
		// Configuración básica de la ventana
		setTitle("Consultar auto");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		// Creación y configuración de la etiqueta "Modelo"
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(34, 38, 82, 25);
		getContentPane().add(lblModelo);
		
		// Creación y configuración de la etiqueta "Precio"
		lblPrecio = new JLabel("Precio ($)");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(34, 79, 109, 25);
		getContentPane().add(lblPrecio);
		
		// Creación y configuración de la etiqueta "Potencia"
		lblPotencia = new JLabel("Potencia (HP)");
		lblPotencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPotencia.setBounds(34, 115, 109, 25);
		getContentPane().add(lblPotencia);
		
		// Creación y configuración de la etiqueta "Transmision"
		lblTransmision = new JLabel("Transmision");
		lblTransmision.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTransmision.setBounds(34, 151, 109, 25);
		getContentPane().add(lblTransmision);
		
		// Creación y configuración de la etiqueta "Cilindrada"
		lblCilindrada = new JLabel("Cilindrada (cc)");
		lblCilindrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCilindrada.setBounds(34, 187, 109, 25);
		getContentPane().add(lblCilindrada);
		
		// Creación y configuración del comboBox para seleccionar el modelo del auto
		cboModelo = new JComboBox();
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Toyota Corolla", "Honda Civic", "Ford Mustang", "Mazda 3", "BMW Serie 3"}));
		cboModelo.addActionListener(this);
		cboModelo.addItemListener(this);
		cboModelo.setBounds(153, 41, 138, 22);
		getContentPane().add(cboModelo);
		
		// Creación y configuración del campo de texto para mostrar el precio
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(153, 83, 138, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		// Creación y configuración del campo de texto para mostrar la potencia
		txtPotencia = new JTextField();
		txtPotencia.setEditable(false);
		txtPotencia.setColumns(10);
		txtPotencia.setBounds(153, 119, 138, 20);
		getContentPane().add(txtPotencia);
		
		// Creación y configuración del campo de texto para mostrar la transmisión
		txtTransmision = new JTextField();
		txtTransmision.setEditable(false);
		txtTransmision.setColumns(10);
		txtTransmision.setBounds(153, 155, 138, 20);
		getContentPane().add(txtTransmision);
		
		// Creación y configuración del campo de texto para mostrar la cilindrada
		txtCilindrada = new JTextField();
		txtCilindrada.setEditable(false);
		txtCilindrada.setColumns(10);
		txtCilindrada.setBounds(153, 191, 138, 20);
		getContentPane().add(txtCilindrada);
		
		// Creación y configuración del botón "Cerrar"
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(337, 41, 89, 23);
		getContentPane().add(btnCerrar);
		
		// Cargar los valores del primer auto al iniciar la ventana
		txtPrecio.setText(""+Tienda.precio0); 
		txtPotencia.setText(""+Tienda.potencia0); 
		txtTransmision.setText(""+Tienda.transmision0); 
		txtCilindrada.setText(""+Tienda.cilindrada0); 
	}

//1. SE CREAN 4 METODOS SEGUN EL ITEM SELECCIONADO PARA RETORNAR EL PRECIO, POTENCIA, TRANSMISION Y CILINDRADA:

    // Crea el metodo precio para devolver el precio según el modelo seleccionado
    double precio(int item) {
        switch (item) {
        case 0: return Tienda.precio0;
        case 1: return Tienda.precio1;
        case 2: return Tienda.precio2;
        case 3: return Tienda.precio3;
        default: return Tienda.precio4;
        }
    }

    // Crea el metodo potencia para devolver el precio según el modelo seleccionado
    int potencia(int item) {
        switch(item) {
        case 0: return Tienda.potencia0;
        case 1: return Tienda.potencia1;
        case 2: return Tienda.potencia2;
        case 3: return Tienda.potencia3;
        default: return Tienda.potencia4;
        }
    }

    // Crea el metodo transmision para devolver el precio según el modelo seleccionado
    String transmision(int item) {
        switch(item) {
        case 0: return Tienda.transmision0;
        case 1: return Tienda.transmision1;
        case 2: return Tienda.transmision2;
        case 3: return Tienda.transmision3;
        default: return Tienda.transmision4;
        }
    }

    // Crea el metodo cilindrada para devolver el precio según el modelo seleccionado
    int cilindrada(int item) {
        switch(item) {
        case 0: return Tienda.cilindrada0;
        case 1: return Tienda.cilindrada1;
        case 2: return Tienda.cilindrada2;
        case 3: return Tienda.cilindrada3;
        default: return Tienda.cilindrada4;
        }
    }

    // Crea el metodo modelo
    protected void itemStateChangedCboModelo(ItemEvent e) {
        // 3. DECLARACION DE VARIABLES
        double precio;
        int item, potencia, cilindrada;
        String transmision;
        
        // 2. LOS METODOS CREADOS ANTERIORMENTE SE ALMACENAN EN VARIABLES
        item = cboModelo.getSelectedIndex();//La variable item almacena el índice seleccionado en el combobox
        precio = precio(item);
        potencia = potencia(item);
        transmision = transmision(item);
        cilindrada = cilindrada(item);
        
     // 5. LLAMA AL METODO MOSTRARRESULTADO PARA MOSTRAR LOS DATOS EN LOS CAMPOS CORRESPONDIENTES.
        mostrarResultado(precio, potencia, transmision, cilindrada); 
    }

    // 4. CREA EL METODO MOSTRARRESULTADO PARA MOSTRAR LOS RESULTADOS EN LOS CAMPOS DE TEXTO.
    void mostrarResultado(double precio, int potencia, String transmision, int cilindrada) {
        txtPrecio.setText(""+precio);
        txtTransmision.setText(""+transmision);
        txtPotencia.setText(""+potencia);
        txtCilindrada.setText(""+cilindrada);
    }
        
    // Llama al metodo Modelo
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cboModelo) {
            itemStateChangedCboModelo(e);
        }
    }
    
    // Crea el metodo cerrar
    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }
    
    // Llama al metodo cerrar
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }
}