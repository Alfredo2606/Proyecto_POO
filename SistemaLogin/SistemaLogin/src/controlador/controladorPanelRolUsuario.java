/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.RolUsuario;
import vista.PanelRolUsuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author taanl
 */
public class controladorPanelRolUsuario {
    //Atributos
    private PanelRolUsuario vista;
    private RolUsuario modelo;
    
    //Constructor

    public controladorPanelRolUsuario() {
        
        //Crear objetos modelo y vista
        this.vista=new PanelRolUsuario();
        this.modelo=new RolUsuario();
        
        //Llamar al manejador de eventos
        manejadorEventos();
           //llamar al metodo llenar tabla
        LlenarTablaRolUsuarios();
    }
    
    //Metodos set y get

    public PanelRolUsuario getVista() {
        return vista;
    }

    public void setVista(PanelRolUsuario vista) {
        this.vista = vista;
    }

    public RolUsuario getModelo() {
        return modelo;
    }

    public void setModelo(RolUsuario modelo) {
        this.modelo = modelo;
    }

       //Metodo para manejar los eventos
    public void manejadorEventos(){
          //Evento para el boton registrar
        this.vista.btnRegistrar.addActionListener(e->registrar());
        //evento para el boton editar
        this.vista.btnEditar.addActionListener(e -> editar());
        //evento para el boton eliminar
        this.vista.btnEliminar.addActionListener(e -> eliminar());
        //evento para el boton buscar
        this.vista.btnBuscar.addActionListener(e -> buscarId());
        //evento para el botón nuevo
        this.vista.btnNuevo.addActionListener(e -> nuevo());
        //evento parfa el botón salir
        this.vista.btnSalir.addActionListener(e -> salir());
               
        
    }
    
    //Metodo para registrar
    public void registrar(){
        //JOptionPane.showMessageDialog(this.vista, "Registrar usuario");
        //Validar cajas de texto
        if(validarCajasTexto()){
        
        //Obtener los datos de la vista y agregarlos al modelo
        this.modelo.setIdRolUsuario(Integer.parseInt(this.vista.txtIdUsuario.getText()));
        this.modelo.setTipoRolUsuario(this.vista.txtTipoUsuario.getText());
        this.modelo.setDescripcionRolUsuario(this.vista.txtDescripcion.getText());
     

        if (this.modelo.insertar()) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario se guardaron correctamente");
            //limpiar cajas de texto
            limpiarCajasTexto();
             //llamar al metodo llenar tabla
        LlenarTablaRolUsuarios();
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se guardaron...");
        }
        }else{
            JOptionPane.showMessageDialog(this.vista, "Se deben capturar todos los datos");
        }
    }//fin de metodo registrar
    //Metodo para editar usuario
    public void editar(){
        //Validar cajas de texto
        if(validarCajasTexto()){
        
        //Obtener los datos de la vista y agregarlos al modelo
        this.modelo.setIdRolUsuario(Integer.parseInt(this.vista.txtIdUsuario.getText()));
        this.modelo.setTipoRolUsuario(this.vista.txtTipoUsuario.getText());
        this.modelo.setDescripcionRolUsuario(this.vista.txtDescripcion.getText());
     
      
        if (this.modelo.modificar(this.modelo.getIdRolUsuario())) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario se modificaron correctamente");
            //limpiar cajas de texto
            limpiarCajasTexto();
             //llamar al metodo llenar tabla
            LlenarTablaRolUsuarios();
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se modificaron...");
        }
        }else{
            JOptionPane.showMessageDialog(this.vista, "Se deben capturar todos los datos");
        }
        
    }//fin del metodo editar
    //Metodo para eliminar usuario
     public void eliminar(){
        //Validar cajas de texto
        if(!this.vista.txtIdUsuario.getText().trim().isEmpty()){
        
            
        //Obtener los datos de la vista y agregarlos al modelo
        this.modelo.setIdRolUsuario(Integer.parseInt(this.vista.txtIdUsuario.getText()));
       

        if (this.modelo.eliminar(this.modelo.getIdRolUsuario())) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario se eliminaron correctamente");
            //limpiar cajas de texto
            limpiarCajasTexto();
             //llamar al metodo llenar tabla
        LlenarTablaRolUsuarios();
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se eliminaron...");
        }
        }else{
            JOptionPane.showMessageDialog(this.vista, "Se debe capturar el id");
            this.vista.txtIdUsuario.requestFocus();
        }
        
    }//fin del metodo eliminar
    //metodo para buscar usuario por id
      private void buscarId(){
          //obtener los datos de la vista y agregarlos al modelo
          this.modelo.setIdRolUsuario(Integer.parseInt(this.vista.txtIdUsuario.getText()));
          
          if (this.modelo.buscarPorId(this.modelo.getIdRolUsuario())) {
              //agregar los datos a las cajas de texto
              this.vista.txtTipoUsuario.setText(this.modelo.getTipoRolUsuario());
              this.vista.txtDescripcion.setText(this.modelo.getDescripcionRolUsuario());
  
               //llamar al metodo llenar tabla
        LlenarTablaRolUsuarios();
          } else {
              JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se encontraron...");
          }
          
      }//fin del metodo buscar por id
    
      //metodo para llenar tabla usuarios
      public void LlenarTablaRolUsuarios(){
          this.vista.tablaRolUsuario.setModel(obtenerDatosRolUsuarios());
      }
     //metodo para obtener los datos de usuario
      public DefaultTableModel obtenerDatosRolUsuarios(){
          String encabezadoTabla[] = {"Id", "Tipo Rol Usuario", "Descripcion"};
          DefaultTableModel modeloTabla = new DefaultTableModel(encabezadoTabla, 0);
          Object[] fila = new Object[modeloTabla.getColumnCount()];
          
          for (RolUsuario Rolusuario : this.modelo.buscar()) {
              fila[0] = Rolusuario.getIdRolUsuario();
              fila[1] = Rolusuario.getTipoRolUsuario();
              fila[2] = Rolusuario.getDescripcionRolUsuario();
          
              modeloTabla.addRow(fila);
              
             
          }
           return modeloTabla;
          
       }
      //metodo para validar las cajas de texto
    public boolean validarCajasTexto(){
        try {
            if (this.vista.txtIdUsuario.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el id del usuario");
                this.vista.txtIdUsuario.requestFocus();
                return false;
            }if(this.vista.txtTipoUsuario.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el tipo de rol del usuario");
                this.vista.txtTipoUsuario.requestFocus();
                return false;               
            }if(this.vista.txtDescripcion.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar la descripcion de el rol del usuario");
                this.vista.txtDescripcion.requestFocus();
                return false;
        }
         //si todos los campos están llenos           
          return true;          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.vista, "Error:" + e.getMessage());
            return false;
        }
    }//fin del metodo validar cajas de texto
     //metodo para limpiar las cajas de texto
    public void limpiarCajasTexto(){
        this.vista.txtIdUsuario.setText("");
        this.vista.txtTipoUsuario.setText("");
        this.vista.txtDescripcion.setText("");
      
    }

    //metodo para nuevo
    public void nuevo(){
        //lamar el emtodo limpiar cajas de texto
        limpiarCajasTexto();
        this.vista.txtIdUsuario.requestFocus();
        
        
    }
    
    //metodo para salir
    public void salir(){
        //ocultar el panel usuario
        this.vista.setVisible(false);
        
    }
  
        
    
    }