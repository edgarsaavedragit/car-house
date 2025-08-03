package cibertec;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;

public class VentasVender extends JDialog implements ActionListener, ItemListener {

    private static final long serialVersionUID = 1L;
    private JLabel lblModelo;
    private JLabel lblPrecio;
    private JLabel lblCantidad;
    private JComboBox cboModelo;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnCerrar;
    private JButton btnVender;
    private JTextArea textArea;

    // VARIABLES GLOBALES
    double precioVenta, impCompra, impDescuento, impPagar;
    int cantidadVenta;
    String obsequio;

    // Método main que ejecuta la ventana
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentasVender dialog = new VentasVender();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor para crear el diálogo
    public VentasVender() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VentasVender.class.getResource("/img/vender.png")));
    	getContentPane().setBackground(new Color(255, 255, 128));
        setTitle("Vender");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        // Creación y configuración de las etiquetas (labels)
        lblModelo = new JLabel("Modelo");
        lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblModelo.setBounds(35, 5, 82, 25);
        getContentPane().add(lblModelo);

        lblPrecio = new JLabel("Precio ($)");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrecio.setBounds(35, 30, 82, 25);
        getContentPane().add(lblPrecio);

        lblCantidad = new JLabel("Cantidad");
        lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCantidad.setBounds(35, 55, 82, 25);
        getContentPane().add(lblCantidad);

        // Configuración del JComboBox para seleccionar el modelo
        cboModelo = new JComboBox();
        cboModelo.setModel(new DefaultComboBoxModel(
                new String[] { "Toyota Corolla", "Honda Civic", "Ford Mustang", "Mazda 3", "BMW Serie 3" }));
        cboModelo.setBounds(127, 8, 138, 22);
        cboModelo.addItemListener(this); // Asignación del listener
        getContentPane().add(cboModelo);

        // Configuración de los JTextFields para mostrar el precio y cantidad
        txtPrecio = new JTextField();
        txtPrecio.setEditable(false);
        txtPrecio.setColumns(10);
        txtPrecio.setBounds(127, 34, 138, 20);
        getContentPane().add(txtPrecio);

        txtCantidad = new JTextField();
        txtCantidad.setColumns(10);
        txtCantidad.setBounds(127, 59, 138, 20);
        getContentPane().add(txtCantidad);

        // Botón de "Cerrar" para cerrar la ventana
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(323, 8, 89, 23);
        getContentPane().add(btnCerrar);

        // Botón de "Vender" para realizar la venta
        btnVender = new JButton("Vender");
        btnVender.addActionListener(this);
        btnVender.setBounds(323, 33, 89, 23);
        getContentPane().add(btnVender);

        // Área de texto para mostrar los resultados de la venta
        textArea = new JTextArea();
        textArea.setBounds(10, 83, 416, 169);
        getContentPane().add(textArea);

        // Mostrar datos iniciales del primer auto al abrir
        cboModelo.setSelectedIndex(0); // Selecciona automáticamente el primer modelo
        txtPrecio.setText(String.valueOf(Tienda.precio0)); // Muestra su precio
        txtCantidad.setText(""); // Establece cantidad inicial por defecto
    }
    
    //DECLARAR LAS VARIABLES COMO GLOBALES)
    
    // Crea el método precio para devolver el precio según modelo seleccionado
    //El método precio es independiente para que pueda ser usado en cualquier parte del código
    double precio(int item) {
        switch (item) {
            case 0: return Tienda.precio0;
            case 1: return Tienda.precio1;
            case 2: return Tienda.precio2;
            case 3: return Tienda.precio3;
            default: return Tienda.precio4;
        }
    }
       
 // CREA EL MÉTODO VENDER PARA LLAMAR A LOS MÉTODOS QUE SE CREARAN DESPUES
    protected void actionPerformedBtnVender(ActionEvent e) {
    	//Se llaman a los siguientes metodos:
        obtenerDatos();
        if (cantidadVenta <= 0) return; // Si la cantidad a vender es 0 o negativa, detiene la operación
        importeCompra();
        importeDescuento();
        importePagar();
        obtenerObsequio();
        mostrarResultados();
        contAcum();
        contAcumTotal();
        mostrarMensajePantalla();
    }
    
 // SE DEFINE CADA UNO DE LOS METODOS ANTERIORES
    
    // El método obtenerDatos para leer y validar la cantidad ingresada por el usuario, contiene las siguientes validaciones:
    void obtenerDatos() {
        precioVenta = Double.parseDouble(txtPrecio.getText());
        String cantidadStr = txtCantidad.getText().trim();
        if (cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La cantidad no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            cantidadVenta = -1;
            return;
        }
        try {
            cantidadVenta = Integer.parseInt(cantidadStr);
            if (cantidadVenta <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                cantidadVenta = -1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            cantidadVenta = -1;// Valida si la cantidad es cero o negativa y muestra un mensaje de error si es inválida.
        }
    }

    // El método importeCompra
    void importeCompra() {
        impCompra = precioVenta * cantidadVenta;
    }

	 // El método importeDescuento que designa el monto del descuento según la cantidad de productos vendidos
	 void importeDescuento() {
	     if (cantidadVenta >= 16)
	         impDescuento = impCompra * Tienda.porcentaje4 / 100;
	     else if (cantidadVenta >= 11)
	         impDescuento = impCompra * Tienda.porcentaje3 / 100;
	     else if (cantidadVenta >= 6)
	         impDescuento = impCompra * Tienda.porcentaje2 / 100;
	     else
	         impDescuento = impCompra * Tienda.porcentaje1 / 100;
	 }


    // El método importePagar 
    void importePagar() {
        impPagar = impCompra - impDescuento;
    }

	 // El método obtenerObsequio que asigna un obsequio según la cantidad de productos vendidos
	 void obtenerObsequio() {
	     if (cantidadVenta >= 6)
	         obsequio = Tienda.obsequio3;
	     else if (cantidadVenta >= 2)
	         obsequio = Tienda.obsequio2;
	     else
	         obsequio = Tienda.obsequio1;
	 }


    // El método mostrarResultados para mostrar la boleta en el área de texto
    void mostrarResultados() {
        textArea.setText("BOLETA DE VENTA\n\n");
        textArea.append("Modelo: " + cboModelo.getSelectedItem() + "\n");
        textArea.append("Precio unitario: $ " + String.format("%,.2f", precioVenta) + "\n");
        textArea.append("Cantidad: " + cantidadVenta + "\n");
        textArea.append("Importe compra: $. " + String.format("%,.2f", impCompra) + "\n");
        textArea.append("Descuento: $. " + String.format("%,.2f", impDescuento) + "\n");
        textArea.append("Total a pagar: $. " + String.format("%,.2f", impPagar) + "\n");
        textArea.append("Obsequio: " + obsequio);
    }

	 // El método contAcum que actualiza los contadores y acumulados de ventas por modelo seleccionado,
	 // incrementando la cantidad de ventas, el importe acumulado, el porcentaje de la cuota semanal
	 // y la cantidad de unidades vendidas.
	 void contAcum() {
	     int item = cboModelo.getSelectedIndex();
	     switch (item) {
	         case 0:
	             Tienda.contadorVenta0++;
	             Tienda.importeAcumulado0 += impPagar;
	             Tienda.porcentajeCuota0 = (Tienda.importeAcumulado0 / Tienda.cuotaSemanal) * 100;
	             Tienda.cantUniVendidas0 += cantidadVenta;
	             break;
	         case 1:
	             Tienda.contadorVenta1++;
	             Tienda.importeAcumulado1 += impPagar;
	             Tienda.porcentajeCuota1 = (Tienda.importeAcumulado1 / Tienda.cuotaSemanal) * 100;
	             Tienda.cantUniVendidas1 += cantidadVenta;
	             break;
	         case 2:
	             Tienda.contadorVenta2++;
	             Tienda.importeAcumulado2 += impPagar;
	             Tienda.porcentajeCuota2 = (Tienda.importeAcumulado2 / Tienda.cuotaSemanal) * 100;
	             Tienda.cantUniVendidas2 += cantidadVenta;
	             break;
	         case 3:
	             Tienda.contadorVenta3++;
	             Tienda.importeAcumulado3 += impPagar;
	             Tienda.porcentajeCuota3 = (Tienda.importeAcumulado3 / Tienda.cuotaSemanal) * 100;
	             Tienda.cantUniVendidas3 += cantidadVenta;
	             break;
	         default:
	             Tienda.contadorVenta4++;
	             Tienda.importeAcumulado4 += impPagar;
	             Tienda.porcentajeCuota4 = (Tienda.importeAcumulado4 / Tienda.cuotaSemanal) * 100;
	             Tienda.cantUniVendidas4 += cantidadVenta;
	     }
	 }


	// El método contAcumTotal que actualiza los datos totales de la tienda,
	// incrementando el número total de ventas, el importe total acumulado
	// y el porcentaje total de la cuota semanal.
	void contAcumTotal() {
	    Tienda.contadorVentaTotal++;
	    Tienda.importeAcumuladoTotal += impPagar;
	    Tienda.porcentajeCuotaTotal += (impPagar / Tienda.cuotaSemanal) * 100;
	}


	// El método mostrarMensajePantalla que muestra la ventana avance de ventas cada 5 ventas realizadas,
	// mostrando el número de venta, el importe total acumulado y el porcentaje total de la cuota semanal.
	void mostrarMensajePantalla() {
	    if (Tienda.contadorVentaTotal % 5 == 0) {
	        JOptionPane.showInternalMessageDialog(null,
	            "Número de venta. " + Tienda.contadorVentaTotal + "\n" +
	            "Importe total acumulado: $." + Math.round(Tienda.importeAcumuladoTotal * 100.0) / 100.0 + "\n" +
	            "Porcentaje de cuota semanal: " + Math.round(Tienda.porcentajeCuotaTotal * 100.0) / 100.0 + "%",
	            
	            "Avance de Ventas", JOptionPane.INFORMATION_MESSAGE);
	    }
	}


	// Actualiza el precio cuando se cambia el modelo seleccionado.
	protected void itemStateChangedCboModelo(ItemEvent e) {
	    int item = cboModelo.getSelectedIndex();
	    txtPrecio.setText("" + precio(item));
	}

	// Maneja el cambio de selección en el JComboBox.
	public void itemStateChanged(ItemEvent e) {
	    if (e.getSource() == cboModelo) {
	        itemStateChangedCboModelo(e);
	    }
	}

    // Crea el método cerrar
    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }
    
    //SE LLAMA A LOS METODOS VENDER Y CERRAR
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVender) {
            actionPerformedBtnVender(e);
        } else if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }

}
