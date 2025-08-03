package cibertec;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class ConfigurarObsequios extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarObsequios dialog = new ConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarObsequios.class.getResource("/img/obsequios.png")));
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// Etiqueta para 1 Unidad
		{
			JLabel lblUnidad1 = new JLabel("1 Unidad");
			lblUnidad1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUnidad1.setBounds(26, 55, 147, 25);
			contentPanel.add(lblUnidad1);
		}
		
		// Etiqueta para 2 a 5 Unidades
		{
			JLabel lblUnidad2 = new JLabel("2 a 5 unidades");
			lblUnidad2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUnidad2.setBounds(26, 91, 147, 25);
			contentPanel.add(lblUnidad2);
		}
		
		// Etiqueta para 6 o más unidades
		{
			JLabel lblUnidad3 = new JLabel("6 a mas unidades");
			lblUnidad3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUnidad3.setBounds(26, 127, 147, 25);
			contentPanel.add(lblUnidad3);
		}
		
		// Campo de texto para el obsequio 1
		{
			txtObsequio1 = new JTextField();
			txtObsequio1.setColumns(10);
			txtObsequio1.setBounds(155, 59, 161, 20);
			contentPanel.add(txtObsequio1);
		}
		
		// Campo de texto para el obsequio 2
		{
			txtObsequio2 = new JTextField();
			txtObsequio2.setColumns(10);
			txtObsequio2.setBounds(155, 95, 161, 20);
			contentPanel.add(txtObsequio2);
		}
		
		// Campo de texto para el obsequio 3
		{
			txtObsequio3 = new JTextField();
			txtObsequio3.setColumns(10);
			txtObsequio3.setBounds(155, 131, 161, 20);
			contentPanel.add(txtObsequio3);
		}
		
		// Botón para aceptar la configuración
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(337, 58, 89, 23);
			contentPanel.add(btnAceptar);
		}
		
		// Botón para cancelar la configuración
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(337, 91, 89, 23);
			contentPanel.add(btnCancelar);
			
			// MOSTRAR LOS VALORES ACTUALES DE LOS OBSEQUIOS EN LOS CAMPOS DE TEXTO
			txtObsequio1.setText(""+Tienda.obsequio1);
			txtObsequio2.setText(""+Tienda.obsequio2);
			txtObsequio3.setText(""+Tienda.obsequio3);
		}
	}
	
	 //CREA METODO ACEPTAR PARA LAS VALIDACIONES LO QUE HACE LO SIGUIENTE
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		// Elimina espacios en blanco para evitar errores.
	    String ob1 = txtObsequio1.getText().trim();
	    String ob2 = txtObsequio2.getText().trim();
	    String ob3 = txtObsequio3.getText().trim();

	    // Verificar que no estén vacíos
	    if (ob1.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El obsequio para 1 unidad no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (ob2.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El obsequio para 2 a 5 unidades no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (ob3.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El obsequio para 6 o más unidades no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar que solo contengan texto
	    if (ob1.matches(".*\\d.*")) {
	        JOptionPane.showMessageDialog(this, "El obsequio para 1 unidad debe ser texto.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (ob2.matches(".*\\d.*")) {
	        JOptionPane.showMessageDialog(this, "El obsequio para 2 a 5 unidades debe ser texto.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (ob3.matches(".*\\d.*")) {
	        JOptionPane.showMessageDialog(this, "El obsequio para 6 o más unidades debe ser texto.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    // Si todo está correctamente, se guardan los cambios y se muestra en pantalla Modificación Exitosa
	    Tienda.obsequio1 = ob1;
	    Tienda.obsequio2 = ob2;
	    Tienda.obsequio3 = ob3;
	    
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
