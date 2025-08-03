package cibertec;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Toolkit;

public class MantenimientoModificar extends JDialog implements ItemListener, ActionListener {

    private static final long serialVersionUID = 1L;
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
    private JButton btnGuardar;

    public static void main(String[] args) {
        // Iniciar la interfaz gráfica en el hilo de eventos
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MantenimientoModificar dialog = new MantenimientoModificar();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MantenimientoModificar() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoModificar.class.getResource("/img/modificar.png")));
    	getContentPane().setBackground(new Color(255, 255, 128));
        setTitle("Modificar auto");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
        
        // Componentes de la interfaz (etiquetas y cajas de texto)
        lblModelo = new JLabel("Modelo");
        lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblModelo.setBounds(37, 46, 108, 25);
        getContentPane().add(lblModelo);
        
        lblPrecio = new JLabel("Precio ($)");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrecio.setBounds(37, 81, 108, 25);
        getContentPane().add(lblPrecio);
        
        lblPotencia = new JLabel("Potencia (HP)");
        lblPotencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPotencia.setBounds(37, 117, 108, 25);
        getContentPane().add(lblPotencia);
        
        lblTransmision = new JLabel("Transmision");
        lblTransmision.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTransmision.setBounds(37, 153, 108, 25);
        getContentPane().add(lblTransmision);
        
        lblCilindrada = new JLabel("Cilindrada (cc)");
        lblCilindrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCilindrada.setBounds(37, 189, 108, 25);
        getContentPane().add(lblCilindrada);
        
        cboModelo = new JComboBox();
        cboModelo.addItemListener(this);
        cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Toyota Corolla", "Honda Civic", "Ford Mustang", "Mazda 3", "BMW Serie 3"}));
        cboModelo.setBounds(155, 49, 138, 22);
        getContentPane().add(cboModelo);
        
        txtPrecio = new JTextField();
        txtPrecio.setColumns(10);
        txtPrecio.setBounds(155, 85, 138, 20);
        getContentPane().add(txtPrecio);
        
        txtPotencia = new JTextField();
        txtPotencia.setColumns(10);
        txtPotencia.setBounds(155, 121, 138, 20);
        getContentPane().add(txtPotencia);
        
        txtTransmision = new JTextField();
        txtTransmision.setColumns(10);
        txtTransmision.setBounds(155, 157, 138, 20);
        getContentPane().add(txtTransmision);
        
        txtCilindrada = new JTextField();
        txtCilindrada.setColumns(10);
        txtCilindrada.setBounds(155, 193, 138, 20);
        getContentPane().add(txtCilindrada);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(337, 49, 89, 23);
        getContentPane().add(btnCerrar);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(this);
        btnGuardar.setBounds(337, 84, 89, 23);
        getContentPane().add(btnGuardar);
        
        // Mostrar los datos del primer auto al inicio
        int primerItem = 0;
        txtPrecio.setText(String.valueOf(Tienda.precio0));
        txtPotencia.setText(String.valueOf(Tienda.potencia0));
        txtTransmision.setText(String.valueOf(Tienda.transmision0));
        txtCilindrada.setText(String.valueOf(Tienda.cilindrada0));
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

 // 1. SE CREAN 4 METODOS PARA GUARDAR LOS NUEVOS DATOS
    
 void nuevoPrecio(int item) {
     // Modifica el precio según el modelo seleccionado
     switch(item) {
     case 0: Tienda.precio0 = Double.parseDouble(txtPrecio.getText());
     break;
     case 1: Tienda.precio1 = Double.parseDouble(txtPrecio.getText());
     break;
     case 2: Tienda.precio2 = Double.parseDouble(txtPrecio.getText());
     break;
     case 3: Tienda.precio3 = Double.parseDouble(txtPrecio.getText());
     break;
     default: Tienda.precio4 = Double.parseDouble(txtPrecio.getText());
     }
 }

 void nuevaPotencia(int item) {
     // Modifica la potencia según el modelo seleccionado
     switch(item) {
     case 0: Tienda.potencia0 = Integer.parseInt(txtPotencia.getText());
     break;
     case 1: Tienda.potencia1 = Integer.parseInt(txtPotencia.getText());
     break;
     case 2: Tienda.potencia2 = Integer.parseInt(txtPotencia.getText());
     break;
     case 3: Tienda.potencia3 = Integer.parseInt(txtPotencia.getText());
     break;
     default: Tienda.potencia4 = Integer.parseInt(txtPotencia.getText());
     }
 }

 void nuevaTransmision(int item) {
     // Modifica la transmisión según el modelo seleccionado
     switch(item) {
     case 0: Tienda.transmision0 = txtTransmision.getText();
     break;
     case 1: Tienda.transmision1 = txtTransmision.getText();
     break;
     case 2: Tienda.transmision2 = txtTransmision.getText();
     break;
     case 3: Tienda.transmision3 = txtTransmision.getText();
     break;
     case 4: Tienda.transmision4 = txtTransmision.getText();
     }
 }

 void nuevaCilindrada(int item) {
     // Modifica la cilindrada según el modelo seleccionado
     switch(item) {
     case 0: Tienda.cilindrada0 = Integer.parseInt(txtCilindrada.getText());
     break;
     case 1: Tienda.cilindrada1 = Integer.parseInt(txtCilindrada.getText());
     break;
     case 2: Tienda.cilindrada2 = Integer.parseInt(txtCilindrada.getText());
     break;
     case 3: Tienda.cilindrada3 = Integer.parseInt(txtCilindrada.getText());
     break;
     default: Tienda.cilindrada4 = Integer.parseInt(txtCilindrada.getText());
     }
 }

//2. SE CREA EL MÉTODO GUARDAR PARA REALIZAR LAS VALIDACIONES.
protected void actionPerformedBtnGuardar(ActionEvent e) {
   int item = cboModelo.getSelectedIndex();

   // Obtiene y limpia los textos de los campos
   String precioStr = txtPrecio.getText().trim();
   String potenciaStr = txtPotencia.getText().trim();
   String transmision = txtTransmision.getText().trim();
   String cilindradaStr = txtCilindrada.getText().trim();

   // Validar que no estén vacíos
   if (precioStr.isEmpty()) {
       JOptionPane.showMessageDialog(this, "El Precio no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
   }
   if (potenciaStr.isEmpty()) {
       JOptionPane.showMessageDialog(this, "La Potencia no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
   }
   if (transmision.isEmpty()) {
       JOptionPane.showMessageDialog(this, "La Transmisión no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
   }
   if (cilindradaStr.isEmpty()) {
       JOptionPane.showMessageDialog(this, "La Cilindrada no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
   }

   // Validar que Precio sea número o decimal
   double precio;
   try {
       precio = Double.parseDouble(precioStr);
   } catch (NumberFormatException ex) {
       JOptionPane.showMessageDialog(this, "El Precio debe ser de tipo número o decimal.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
   }

   // Validar que Potencia sea número entero
   int potencia;
   try {
       potencia = Integer.parseInt(potenciaStr);
   } catch (NumberFormatException ex) {
       JOptionPane.showMessageDialog(this, "La Potencia debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
   }

   // Validar que Transmisión solo contenga texto
   if (!transmision.matches("[a-zA-Z]+")) {
       JOptionPane.showMessageDialog(this, "La Transmisión debe ser texto.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
   }

   // Validar que Cilindrada sea número entero
   int cilindrada;
   try {
       cilindrada = Integer.parseInt(cilindradaStr);
   } catch (NumberFormatException ex) {
       JOptionPane.showMessageDialog(this, "La Cilindrada debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
}
   
	// Validar que no sean negativos
	if (precio < 0) {
	    JOptionPane.showMessageDialog(this, "El Precio no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
	    return;
	}
	if (potencia < 0) {
	    JOptionPane.showMessageDialog(this, "La Potencia no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
	    return;
	}
	if (cilindrada < 0) {
	    JOptionPane.showMessageDialog(this, "La Cilindrada no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
	    return;
	}

   
     // Si todo está bien, procede con la actualización de los datos
     nuevoPrecio(item);
     nuevaPotencia(item);
     nuevaTransmision(item);
     nuevaCilindrada(item);
     
     // Confirma que la modificación se realizó exitosamente
     JOptionPane.showMessageDialog(this, "¡Modificación exitosa!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
     dispose();
 }

 // Llama al metodo itemStateChangedCboModelo
 public void itemStateChanged(ItemEvent e) {
     if (e.getSource() == cboModelo) {
         itemStateChangedCboModelo(e);
     }
 }
 
 // Crea el metodo cerrar
 protected void actionPerformedBtnCerrar(ActionEvent e) {
     dispose(); 
 }
 
 public void actionPerformed(ActionEvent e) {
	 	//Llama al metodo Guardar
     if (e.getSource() == btnGuardar) {
         actionPerformedBtnGuardar(e);
     }
     //Llama al metodo cerrar
     if (e.getSource() == btnCerrar) {
         actionPerformedBtnCerrar(e);
     }
 }
}