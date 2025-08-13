/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PuntoVenta;
import vista.PanelPuntoVenta;

/**
 *
 * @author riam_
 */
public class controladorPanelPuntoVenta {
    
    //Atributos
    private PuntoVenta modelo;
    private PanelPuntoVenta vista;
    
    //Constructor

    public controladorPanelPuntoVenta() {
        
        //Crear los objetos
        this.vista = new PanelPuntoVenta();
        this.modelo = new PuntoVenta();
         inicializarTabla();
         manejadorEventos();
        
    }
    
    //Metodo set y get

    public PuntoVenta getModelo() {
        return modelo;
    }

    public void setModelo(PuntoVenta modelo) {
        this.modelo = modelo;
    }

    public PanelPuntoVenta getVista() {
        return vista;
    }

    public void setVista(PanelPuntoVenta vista) {
        this.vista = vista;
    }
    
    //Metodo para manejar los eventos
    public void manejadorEventos(){
         //evento para el boton buscar
      this.vista.btnNuevo.addActionListener(e -> buscarId());
        //evento para el botón nuevo
       this.vista.btnGenerarVenta.addActionListener(e -> generarVenta());

           
        
    }
    
    
    
    private DefaultTableModel modeloTabla;

// Método para inicializar la tabla
private void inicializarTabla() {
    modeloTabla = new DefaultTableModel(
        new Object[]{"Nombre", "Cantidad", "Precio", "Total"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 1; // Solo permitir edición en la columna Cantidad
        }
    };

    // Asignar el modelo a la JTable
    this.vista.tblDatos.setModel(modeloTabla);

    // Listener para recalcular total cuando cambie cantidad
    modeloTabla.addTableModelListener(e -> {
        int fila = e.getFirstRow();
        int columna = e.getColumn();

        if (columna == 1) { 
            try {
                int cantidad = Integer.parseInt(modeloTabla.getValueAt(fila, 1).toString());
                double precio = Double.parseDouble(modeloTabla.getValueAt(fila, 2).toString());
                modeloTabla.setValueAt(cantidad * precio, fila, 3);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vista, "Cantidad inválida");
                modeloTabla.setValueAt(1, fila, 1); 
            }
        }
    });
}



private void buscarId() {
    try {
        int idProducto = Integer.parseInt(this.vista.txtIDProducto.getText());
        this.modelo.setIdProducto(idProducto);

        if (this.modelo.buscarPorId(idProducto)) {
            modeloTabla.addRow(new Object[]{
                this.modelo.getNombre(),
                1, 
                this.modelo.getPrecio(),
                this.modelo.getPrecio()
            });
            this.vista.txtIDProducto.setText("");
        } else {
            JOptionPane.showMessageDialog(this.vista, "El producto no se encontró...");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this.vista, "Ingrese un ID válido");
    }
   
}

    
//metodo para llenar tabla usuarios
      public void LlenarTablaPuntoVenta(){
          this.vista.tblDatos.setModel(obtenerDatosRolUsuarios());
      }
     //metodo para obtener los datos de usuario
      public DefaultTableModel obtenerDatosRolUsuarios(){
          String encabezadoTabla[] = {"Nombre", "Cantidad", "Precio", "Total"};
          DefaultTableModel modeloTabla = new DefaultTableModel(encabezadoTabla, 0);
          Object[] fila = new Object[modeloTabla.getColumnCount()];
          
          for (PuntoVenta PuntoVenta : this.modelo.buscar()) {
              fila[0] = PuntoVenta.getNombre();
              fila[1] = PuntoVenta.getCantidad();
              fila[2] = PuntoVenta.getPrecio();
              fila[3] = PuntoVenta.getTotal();
              
          
              modeloTabla.addRow(fila);
              
             
          }
           return modeloTabla;
          
       }
      //metodo para validar las cajas de texto
    public boolean validarCajasTexto() {
    try {
        if (this.vista.txtIDProducto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this.vista, "Debes ingresar el ID del producto");
            this.vista.txtIDProducto.requestFocus();
            return false;
        }
        return true; // si pasó la validación
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this.vista, "Error: " + e.getMessage());
        return false;
    }
}

    private void generarVenta() {
    double subtotal = 0.0;
    double iva = 0.0;
    double totalFinal = 0.0;
    double tasaIVA = 0.16; // 16% IVA

    // Sumar todos los totales de la tabla
    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
        double totalFila = Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());
        subtotal += totalFila;
    }

    // Calcular IVA y Total
    iva = subtotal * tasaIVA;
    totalFinal = subtotal + iva;

    this.vista.txtSubtotal.setText(String.format("%.2f", subtotal));
    this.vista.txtIVA.setText(String.format("%.2f", iva));
    this.vista.txtTotal.setText(String.format("%.2f", totalFinal));

    
}

     //metodo para limpiar las cajas de texto
    public void limpiarCajasTexto(){
        this.vista.txtIDProducto.setText("");
      
    }

    public static void main(String[] args) {
    // Código que se ejecuta al iniciar el programa
}

   
}
