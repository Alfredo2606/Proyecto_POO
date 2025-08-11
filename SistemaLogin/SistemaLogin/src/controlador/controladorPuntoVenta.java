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
public class controladorPuntoVenta {
    
    //Atributos
    private PuntoVenta modelo;
    private PanelPuntoVenta vista;
    
    //Constructor 

    public controladorPuntoVenta() {
     
    this.vista=new  PanelPuntoVenta();
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
          //Evento para el boton generar venta
       // this.vista.btnGenerarVenta.addActionListener(e -> buscarId());
        //evento para el botón nuevo
        this.vista.btnNuevo.addActionListener(e -> nuevo());
        
               
        
    }
    //metodo para nuevo
    public void nuevo(){
        //lamar el emtodo limpiar cajas de texto
        //limpiarCajasTexto();
        this.vista.txtIDProducto.requestFocus();
        
        
    }
    
    public boolean validarCajasTexto() {
    try {
        if (this.vista.txtIDProducto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this.vista, "Debes ingresar el id del usuario");
            this.vista.txtIDProducto.requestFocus();
            return false;
        }
        return true; // Si pasó la validación
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this.vista, "Error: " + e.getMessage());
        return false;
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
    
     //metodo para limpiar las cajas de texto
    public void limpiarCajasTexto(){
        this.vista.txtIDProducto.setText("");
      
    }

    
}
