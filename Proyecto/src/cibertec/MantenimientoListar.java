package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;

public class MantenimientoListar extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextArea txtListado;
    private JButton btnCerrar;
    private JButton btnListar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MantenimientoListar dialog = new MantenimientoListar();
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
    public MantenimientoListar() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoListar.class.getResource("/img/listar.png")));
        setTitle("Listado de autos"); // Establece el título del cuadro de diálogo
        setBounds(100, 100, 450, 300); // Define las dimensiones de la ventana
        getContentPane().setLayout(null);
        
        // Inicialización y configuración del área de texto para mostrar el listado
        txtListado = new JTextArea();
        txtListado.setBackground(new Color(255, 255, 128));
        txtListado.setEditable(false); // Hace que el área de texto no sea editable
        JScrollPane scroll = new JScrollPane(txtListado); // Agrega desplazamiento al área de texto
        scroll.setBounds(10, 11, 416, 209); // Establece las dimensiones del JScrollPane
        getContentPane().add(scroll);
        
        // Configuración del botón "Cerrar"
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this); // Asocia la acción del botón a su manejador de eventos
        btnCerrar.setBounds(108, 231, 89, 23); // Define la ubicación y el tamaño del botón
        getContentPane().add(btnCerrar);
        
        // Configuración del botón "Listar"
        btnListar = new JButton("Listar");
        btnListar.addActionListener(this); // Asocia la acción del botón a su manejador de eventos
        btnListar.setBounds(225, 231, 89, 23); // Define la ubicación y el tamaño del botón
        getContentPane().add(btnListar);
    } 

 // CREA LOS MÉTODOS PARA LISTAR LAS CARACTERÍSTICAS DE CADA MODELO DE AUTO

 // Listado de características del modelo 1
 void listadoModelo0() {
     txtListado.append("Modelo : "+ Tienda.modelo0 + "\n");
     txtListado.append("Precio : "+"$. "+Tienda.precio0 + "\n");
     txtListado.append("Potencia : "+ Tienda.potencia0 + " HP"+ "\n");
     txtListado.append("Transmision : "+ Tienda.transmision0 + "\n");
     txtListado.append("Cilindrada : "+ Tienda.cilindrada0 + " cc"+ "\n\n");
 }

 // Listado de características del modelo 2
 void listadoModelo1() {
     txtListado.append("Modelo : "+ Tienda.modelo1 + "\n");
     txtListado.append("Precio : "+"$. "+Tienda.precio1 + "\n");
     txtListado.append("Potencia : "+ Tienda.potencia1 + " HP"+ "\n");
     txtListado.append("Transmision : "+ Tienda.transmision1 + "\n");
     txtListado.append("Cilindrada : "+ Tienda.cilindrada1 + " cc"+ "\n\n");
 }

 // Listado de características del modelo 3
 void listadoModelo2() {
     txtListado.append("Modelo : "+ Tienda.modelo2 + "\n");
     txtListado.append("Precio : "+"$. "+Tienda.precio2 + "\n");
     txtListado.append("Potencia : "+ Tienda.potencia2 + " HP"+ "\n");
     txtListado.append("Transmision : "+ Tienda.transmision2 + "\n");
     txtListado.append("Cilindrada : "+ Tienda.cilindrada2 + " cc"+ "\n\n");
 }

 // Listado de características del modelo 4
 void listadoModelo3() {
     txtListado.append("Modelo : "+ Tienda.modelo3 + "\n");
     txtListado.append("Precio : "+"$. "+Tienda.precio3 + "\n");
     txtListado.append("Potencia : "+ Tienda.potencia3 + " HP"+ "\n");
     txtListado.append("Transmision : "+ Tienda.transmision3 + "\n");
     txtListado.append("Cilindrada : "+ Tienda.cilindrada3 + " cc"+ "\n\n");
 }

 // Listado de características del modelo 5
 void listadoModelo4() {
     txtListado.append("Modelo : "+ Tienda.modelo4 + "\n");
     txtListado.append("Precio : "+"$. "+Tienda.precio4 + "\n");
     txtListado.append("Potencia : "+ Tienda.potencia4 + " HP"+ "\n");
     txtListado.append("Transmision : "+ Tienda.transmision4 + "\n");
     txtListado.append("Cilindrada : "+ Tienda.cilindrada4 + " cc"+ "\n\n");
 }
 
 // Crea el metodo listar llamando a los metodos de las listas creadas
 protected void actionPerformedBtnListar(ActionEvent e) {
	// Muestra el titulo principal al inicio
     txtListado.setText("LISTADO DE AUTOS\n\n");// Muestra el titulo principal

     // LLAMA A LOS METODOS QUE LISTAN LOS MODELOS
     listadoModelo0();
     listadoModelo1();
     listadoModelo2();
     listadoModelo3();
     listadoModelo4();

     // Coloca el cursor al inicio del área de texto.
     txtListado.setCaretPosition(0);
 }
 
//Crea metodo cerrar
protected void actionPerformedBtnCerrar(ActionEvent e) {
   dispose();
	}
 
 public void actionPerformed(ActionEvent e) {
	//Llama al metodo listar
     if (e.getSource() == btnListar) {
         actionPerformedBtnListar(e); 
     }
   //Llama al metodo cerrar
     if (e.getSource() == btnCerrar) {
         actionPerformedBtnCerrar(e);
     }
 }
}