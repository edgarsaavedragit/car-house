package cibertec;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;

public class ConfigurarDescuentos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblUnidades1;
	private JLabel lblAUnidades2;
	private JLabel lblUnidades3;
	private JLabel lblUnidades4;
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JLabel lblUnidades1_1;
	private JLabel lblUnidades1_2;
	private JLabel lblUnidades1_3;
	private JLabel lblUnidades1_4;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 * Este bloque ejecuta la ventana de configuración al iniciar el programa.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarDescuentos dialog = new ConfigurarDescuentos();
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
	 * Create the dialog.
	 * Este bloque configura la interfaz gráfica de la ventana de configuración.
	 */
	public ConfigurarDescuentos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarDescuentos.class.getResource("/img/descuentos.png")));
		getContentPane().setBackground(new Color(255, 255, 128));
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		// Etiquetas que muestran el rango de unidades
		lblUnidades1 = new JLabel("1 a 5 unidades");
		lblUnidades1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidades1.setBounds(32, 53, 147, 25);
		getContentPane().add(lblUnidades1);
		
		lblAUnidades2 = new JLabel("6 a 10 unidades");
		lblAUnidades2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAUnidades2.setBounds(32, 89, 147, 25);
		getContentPane().add(lblAUnidades2);
		
		lblUnidades3 = new JLabel("11 a 15 unidades");
		lblUnidades3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidades3.setBounds(32, 125, 147, 25);
		getContentPane().add(lblUnidades3);
		
		lblUnidades4 = new JLabel("Mas de 15 unidades");
		lblUnidades4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidades4.setBounds(32, 161, 147, 25);
		getContentPane().add(lblUnidades4);

		// Campos de texto donde el usuario introduce los porcentajes
		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setColumns(10);
		txtPorcentaje1.setBounds(209, 57, 59, 20);
		getContentPane().add(txtPorcentaje1);
		
		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setColumns(10);
		txtPorcentaje2.setBounds(209, 93, 59, 20);
		getContentPane().add(txtPorcentaje2);
		
		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setColumns(10);
		txtPorcentaje3.setBounds(209, 129, 59, 20);
		getContentPane().add(txtPorcentaje3);
		
		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setColumns(10);
		txtPorcentaje4.setBounds(209, 165, 59, 20);
		getContentPane().add(txtPorcentaje4);

		// Etiquetas para indicar que los valores son porcentajes
		lblUnidades1_1 = new JLabel("%");
		lblUnidades1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidades1_1.setBounds(278, 53, 26, 25);
		getContentPane().add(lblUnidades1_1);
		
		lblUnidades1_2 = new JLabel("%");
		lblUnidades1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidades1_2.setBounds(278, 89, 26, 25);
		getContentPane().add(lblUnidades1_2);
		
		lblUnidades1_3 = new JLabel("%");
		lblUnidades1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidades1_3.setBounds(278, 125, 26, 25);
		getContentPane().add(lblUnidades1_3);
		
		lblUnidades1_4 = new JLabel("%");
		lblUnidades1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidades1_4.setBounds(278, 161, 26, 25);
		getContentPane().add(lblUnidades1_4);

		// Botones de Aceptar y Cancelar
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(337, 56, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(337, 92, 89, 23);
		getContentPane().add(btnCancelar);

	// MOSTRAR LOS VALORES ACTUALES DE LOS DESCUENTOS EN LOS CAMPOS DE TEXTO
		txtPorcentaje1.setText(String.valueOf(Tienda.porcentaje1));
	    txtPorcentaje2.setText(String.valueOf(Tienda.porcentaje2));
	    txtPorcentaje3.setText(String.valueOf(Tienda.porcentaje3));
	    txtPorcentaje4.setText(String.valueOf(Tienda.porcentaje4));
	}

	// CREA MÉTODO ACEPTAR PARA LAS VALIDACIONES LO QUE HACE LO SIGUIENTE
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		// Elimina espacios en blanco para evitar errores en cálculos y validaciones.
		String porcentaje1Str = txtPorcentaje1.getText().trim();
		String porcentaje2Str = txtPorcentaje2.getText().trim();
		String porcentaje3Str = txtPorcentaje3.getText().trim();
		String porcentaje4Str = txtPorcentaje4.getText().trim();

	    // Se valida cada uno de los porcentajes mostrando una alerta en caso no se ingrese ningun valor
	    if (porcentaje1Str.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 1 no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (porcentaje2Str.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 2 no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (porcentaje3Str.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 3 no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (porcentaje4Str.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 4 no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Se valida cada uno de los porcentajes en caso el valor no sea entero o decimal
	    double porcentaje1, porcentaje2, porcentaje3, porcentaje4;
	    try {
	        porcentaje1 = Double.parseDouble(porcentaje1Str);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 1 debe ser un número entero o decimal.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    try {
	        porcentaje2 = Double.parseDouble(porcentaje2Str);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 2 debe ser un número entero o decimal.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    try {
	        porcentaje3 = Double.parseDouble(porcentaje3Str);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 3 debe ser un número entero o decimal.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    try {
	        porcentaje4 = Double.parseDouble(porcentaje4Str);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 4 debe ser un número entero o decimal.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    // Se valida cada uno de los porcentajes en caso el valor sea negativo
	    if (porcentaje1 < 0) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 1 no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (porcentaje2 < 0) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 2 no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (porcentaje3 < 0) {
	        JOptionPane.showMessageDialog(this, "El orcentaje 3 no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (porcentaje4 < 0) {
	        JOptionPane.showMessageDialog(this, "El Porcentaje 4 no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }


	    // Si todo está correctamente, se guardan los cambios y se muestra en pantalla Modificación Exitosa
	    Tienda.porcentaje1 = porcentaje1;
	    Tienda.porcentaje2 = porcentaje2;
	    Tienda.porcentaje3 = porcentaje3;
	    Tienda.porcentaje4 = porcentaje4;

	    JOptionPane.showMessageDialog(this, "¡Modificación exitosa!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	// Crea el metodo cancelar
	protected void actionPerformedBtnCancelar(ActionEvent e) {
	    dispose();
	}

    //SE LLAMA A LOS METODOS ACEPTAR Y CANCELAR
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
	        actionPerformedBtnAceptar(e);
	    }
		if (e.getSource() == btnCancelar) {
	        actionPerformedBtnCancelar(e); 
	    }
	}


}