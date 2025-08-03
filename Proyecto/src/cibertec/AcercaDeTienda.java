package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class AcercaDeTienda extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTienda;
	private JLabel lblAutor1;
	private JButton btnCerrar;
	private JLabel lblAutor2;
	private JLabel lblAutor3;
	private JLabel lblAutor4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDeTienda dialog = new AcercaDeTienda();
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
	 */
	public AcercaDeTienda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDeTienda.class.getResource("/img/acerca.png")));
		getContentPane().setBackground(new Color(255, 255, 128));
		setTitle("Acerca de CAR HOUSE");
		setBounds(100, 100, 450, 300); 
		getContentPane().setLayout(null); 
		
		// Etiqueta que muestra el nombre del proyecto
		lblTienda = new JLabel("CAR HOUSE");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTienda.setBounds(147, 22, 150, 31);
		getContentPane().add(lblTienda);
		
		// Etiqueta que muestra el título "Autores"
		JLabel lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAutores.setBounds(178, 64, 88, 31);
		getContentPane().add(lblAutores);
		
		// Botón para cerrar el diálogo
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this); 
		btnCerrar.setBounds(177, 229, 89, 23); 
		getContentPane().add(btnCerrar);
		
		// Etiqueta que muestra el primer autor
		lblAutor1 = new JLabel("1. Saavedra Suarez Deyner Edgardo");
		lblAutor1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15)); 
		lblAutor1.setBounds(85, 105, 307, 31); 
		getContentPane().add(lblAutor1);
		
		// Etiqueta que muestra el segundo autor
		lblAutor2 = new JLabel("2. Jimenez Ormeño Alexis Manuel");
		lblAutor2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15)); 
		lblAutor2.setBounds(85, 130, 307, 31); 
		getContentPane().add(lblAutor2);
		
		// Etiqueta que muestra el tercer autor
		lblAutor3 = new JLabel("3. Gutierrez Velasquez Diego Enrique");
		lblAutor3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblAutor3.setBounds(85, 155, 307, 31);
		getContentPane().add(lblAutor3);
		
		// Etiqueta que muestra el cuarto autor
		lblAutor4 = new JLabel("4. Coral Galindo Carlos Cirilo");
		lblAutor4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblAutor4.setBounds(85, 182, 307, 31);
		getContentPane().add(lblAutor4);
	}
	
	// Crea el metodo cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose(); // Cierra el cuadro de diálogo
	}
	
	// Llama al metodo cerrar
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
}
