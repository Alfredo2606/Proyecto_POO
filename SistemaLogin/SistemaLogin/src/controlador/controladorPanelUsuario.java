/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.PanelUsuarios;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moron
 */
public class controladorPanelUsuario {
    
    //Atributos
    private PanelUsuarios vista;
    private Usuario modelo;
    
    //constructor

    public controladorPanelUsuario() {
        //Crear objetos modelo y vista
        this.vista=new PanelUsuarios();
        this.modelo=new Usuario();
        
        //Llamar al metodo manejador eventos
        manejadorEventos();
        //Llamar el metodo LLenar Tabla Usuario
        LlenarTablaUsuario();
         
    }
    //metodos set y get

    public PanelUsuarios getVista() {
        return vista;
    }

    public void setVista(PanelUsuarios vista) {
        this.vista = vista;
    }

    public Usuario getModelo() {
        return modelo;
    }

    public void setModelo(Usuario modelo) {
        this.modelo = modelo;
    }
    
    
    //metodo para manejar los eventos
    public void manejadorEventos(){
        //evento para el voton registrar
        this.vista.btnRegistrar.addActionListener(e -> registrar());
        //evento para el boton editar
        this.vista.btnEditar.addActionListener(e -> editar());
        //event para el boton eliminar 
        this.vista.btnEliminar.addActionListener(e -> eliminar());
        //evento para el boton buscar
        this.vista.btnBuscar.addActionListener(e -> buscarId());
        
        
        //evento para nuevo
        this.vista.btnNuevo.addActionListener(e-> nuevo());
        this.vista.btnSalir.addActionListener(e-> salir());
       
    }
    //metodo para registrar
    public void registrar(){
        //JOptionPane.showMessageDialog(this.vista,"Registrar Usuario");
        //Optener los datos de la vista y agregarlos al modelo
        this.modelo.setNombreUsuario(this.vista.txtNombreUsuario.getText());
        this.modelo.setApPaternoUsuario(this.vista.txtApParterno.getText());
        this.modelo.setApMaternoUsuario(this.vista.txtApMaterno.getText());
        this.modelo.setEmailUsuario(this.vista.txtEmail.getText());
        this.modelo.setTelefonoCelular(this.vista.txtTelefono.getText());
        
        if (this.modelo.insertar()) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario se guardaron correctamente");
            limpiarCajasTexto();
            
            LlenarTablaUsuario();
            
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se guardaron........");

        }
       
    
    }
    
      //Metodo para editar usuario
    public void editar(){
        //Validar cajas de texto
        if(validarCajasTexto()){
        
        //Obtener los datos de la vista y agregarlos al modelo
        this.modelo.setIdUsuario(Integer.parseInt(this.vista.txtIdUsuario.getText()));
        this.modelo.setNombreUsuario(this.vista.txtNombreUsuario.getText());
        this.modelo.setApPaternoUsuario(this.vista.txtApParterno.getText());
        this.modelo.setApMaternoUsuario(this.vista.txtApMaterno.getText());
        this.modelo.setEmailUsuario(this.vista.txtEmail.getText());
        this.modelo.setTelefonoCelular(this.vista.txtTelefono.getText());

        if (this.modelo.modificar(this.modelo.getIdUsuario())) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario se modificaron correctamente");
            //limpiar cajas de texto
            limpiarCajasTexto();
            
                     
            
            LlenarTablaUsuario();
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
        this.modelo.setIdUsuario(Integer.parseInt(this.vista.txtIdUsuario.getText()));
       

        if (this.modelo.eliminar(this.modelo.getIdUsuario())) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario se eliminaron correctamente");
            //limpiar cajas de texto
            limpiarCajasTexto();
                        
            
            LlenarTablaUsuario();
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se eliminaron...");
        }
        }else{
            JOptionPane.showMessageDialog(this.vista, "Se deben capturar todos los datos");
            this.vista.txtIdUsuario.requestFocus();
        }
        
    }//fin del metodo eliminar
     
    public void buscarId(){
        //obtener los datos de la vista y agregarlos al modelo
        this.modelo.setIdUsuario(Integer.parseInt(this.vista.txtIdUsuario.getText()));
        
        if (this.modelo.buscarPorId(this.modelo.getIdUsuario())) {
            
            //Agregar los datos a las cajas de texto
            this.vista.txtNombreUsuario.setText(this.modelo.getNombreUsuario());
            this.vista.txtApParterno.setText(this.modelo.getApPaternoUsuario());
            this.vista.txtApMaterno.setText(this.modelo.getApMaternoUsuario());
            this.vista.txtEmail.setText(this.modelo.getEmailUsuario());
            this.vista.txtTelefono.setText(this.modelo.getTelefonoCelular());

                        
            
            LlenarTablaUsuario();
                    
        } else {
            
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se encontraron");
        }
    
    } //fin 
    
    
    //metodo para buscar
    public void LlenarTablaUsuario(){
        this.vista.TablaUsuarios.setModel(obtenerDatosUsuarios());
        
    }
    
    //metodo para obteber los datos de usuario
    public DefaultTableModel obtenerDatosUsuarios(){
        String encabezadoTabla[] = {"Id","Nombre","Apellido Paterno","Apellido Materno", "Email", "Telefono" };
        DefaultTableModel modeloTabla = new DefaultTableModel(encabezadoTabla, 0);
        
        
        Object[] fila = new Object [modeloTabla.getColumnCount()];
        
        //Agregar los datos del objeto usuario 
        for (Usuario usuario : this.modelo.buscar()) {
            
            fila[0] = usuario.getIdUsuario();
            fila[1] = usuario.getNombreUsuario();
            fila[2] = usuario.getApPaternoUsuario();
            fila[3] = usuario.getApMaternoUsuario();
            fila[4] = usuario.getEmailUsuario();
            fila[5] = usuario.getTelefonoCelular();
            
            modeloTabla.addRow(fila);
            
        
        
        
        }
        
        return modeloTabla;
    
    }
       //metodo para validar las cajas de texto
    public boolean validarCajasTexto(){
        try {
            if (this.vista.txtNombreUsuario.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el nombre del usuario");
                this.vista.txtApParterno.requestFocus(); 
                return false;
                
                
            }if(this.vista.txtApParterno.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el apellido paterno del usuario");
                this.vista.txtApParterno.requestFocus();     
                return false;
                
            }if(this.vista.txtApMaterno.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el apellido materno del usuario");
                this.vista.txtApMaterno.requestFocus(); 
                return false;
                
            }if(this.vista.txtEmail.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el correo del usuario");
                this.vista.txtEmail.requestFocus();
                return false;
                
                
            }if(this.vista.txtTelefono.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes inglesar el telefono celular del usuario");
                this.vista.txtTelefono.requestFocus();
                return false;
            
        }
                    
          return true;          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.vista, "Error:" + e.getMessage());
            return false;
        }
        
    }//fin del metodo validar cajas de texto
       //metodo para limpiar las cajas de texto
    public void limpiarCajasTexto(){
        this.vista.txtIdUsuario.setText("");
        this.vista.txtNombreUsuario.setText("");
        this.vista.txtApMaterno.setText("");
        this.vista.txtApMaterno.setText("");
        this.vista.txtEmail.setText("");
        this.vista.txtTelefono.setText("");
    }
    
    //Metodo para nuevo
    public void nuevo(){
        //llamar metodo para limpiar cajas de texto
        limpiarCajasTexto();
        this.vista.txtIdUsuario.requestFocus();
        
  
    }
    //metodo salir
    public void salir(){
        //ocultar el panel usuario
        this.vista.setVisible(false);
    
    }
}
