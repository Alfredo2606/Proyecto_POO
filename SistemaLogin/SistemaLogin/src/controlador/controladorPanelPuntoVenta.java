/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PuntoVenta;
import modelo.RolUsuario;
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
       //this.vista.btnGenerarVenta.addActionListener(e -> nuevo());
           
        
    }
    
    private DefaultTableModel modeloTabla;

// Método para inicializar la tabla
private void inicializarTabla() {
    modeloTabla = new DefaultTableModel(
        new Object[]{"Nombre", "Cantidad", "Precio", "Total"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Solo permitir edición en la columna de Cantidad (índice 1)
            return column == 1;
        }
    };

    
    // Asignar el modelo a la JTable
    this.vista.tblDatos.setModel(modeloTabla);

    // Listener para recalcular total cuando cambie cantidad
    modeloTabla.addTableModelListener(e -> {
        int fila = e.getFirstRow();
        int columna = e.getColumn();

        if (columna == 1) { // si se modificó la cantidad
            try {
                int cantidad = Integer.parseInt(modeloTabla.getValueAt(fila, 1).toString());
                double precio = Double.parseDouble(modeloTabla.getValueAt(fila, 2).toString());
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vista, "Cantidad inválida");
                modeloTabla.setValueAt(1, fila, 1); // reset a cantidad 1
            }
        }
    });
}

// Método para buscar producto y agregarlo a la tabla
private void buscarId() {
    try {
        // Obtener el ID del producto escrito en la vista
        int idProducto = Integer.parseInt(this.vista.txtIDProducto.getText());
        this.modelo.setIdProducto(idProducto);

        // Buscar el producto
        if (this.modelo.buscarPorId(idProducto)) {
            // Agregar a la tabla
            modeloTabla.addRow(new Object[]{
                this.modelo.getNombre(),
                1, // cantidad por defecto
                this.modelo.getPrecio(),
                this.modelo.getPrecio() // total inicial
            });

            // Limpiar el campo de texto del ID
            this.vista.txtIDProducto.setText("");
            
            

        } else {
            JOptionPane.showMessageDialog(this.vista, "El producto no se encontró...");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this.vista, "Ingrese un ID válido");
    }
}
    
//metodo para llenar tabla usuarios
      public void LlenarTablaRolUsuarios(){
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

     //metodo para limpiar las cajas de texto
    public void limpiarCajasTexto(){
        this.vista.txtIDProducto.setText("");
      
    }

   
}
