/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Productos;
import vista.PanelProductos;

/**
 *
 * @author taanl
 */
public class controladorPanelProductos {
    //Atributos
    private PanelProductos vista;
    private Productos modelo;
    
     //constructor

    public controladorPanelProductos() {
        //Crear objetos modelo y vista
        this.vista=new PanelProductos();
        this.modelo=new Productos();
        
        //Llamar al metodo manejador eventos
        manejadorEventos();
        //Llamar el metodo LLenar Tabla Productos
        LlenarTablaProductos();
         
    }

    //metodos set y get
    public PanelProductos getVista() {
        return vista;
    }

    public void setVista(PanelProductos vista) {
        this.vista = vista;
    }

    public Productos getModelo() {
        return modelo;
    }

    public void setModelo(Productos modelo) {
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

    private void registrar() {
//JOptionPane.showMessageDialog(this.vista,"Registrar Usuario");
        //Optener los datos de la vista y agregarlos al modelo
        this.modelo.setIdProducto(Integer.parseInt(this.vista.txtIdProducto.getText()));
        this.modelo.setNombreProducto(this.vista.txtNombreProducto.getText());
         this.modelo.setDescripcionProducto(this.vista.txtDescripcionProducto.getText());
         this.modelo.setStockProducto(Integer.parseInt(this.vista.txtStockProducto.getText()));
        this.modelo.setPrecioProducto(Double.parseDouble(this.vista.txtPrecioProducto.getText()));
        
        
        if (this.modelo.insertar()) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario se guardaron correctamente");
            limpiarCajasTexto();
            
            LlenarTablaProductos();
            
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del usuario no se guardaron........");

        }
       
        }

    private void editar() {
 //Validar cajas de texto
        if(validarCajasTexto()){
        
        //Obtener los datos de la vista y agregarlos al modelo
         this.modelo.setNombreProducto(this.vista.txtNombreProducto.getText());
        this.modelo.setIdProducto(Integer.parseInt(this.vista.txtIdProducto.getText()));
        this.modelo.setPrecioProducto(Double.parseDouble(this.vista.txtPrecioProducto.getText()));
        this.modelo.setStockProducto(Integer.parseInt(this.vista.txtStockProducto.getText()));
        this.modelo.setDescripcionProducto(this.vista.txtDescripcionProducto.getText());

        if (this.modelo.modificar(this.modelo.getIdProducto())) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del producto se modificaron correctamente");
            //limpiar cajas de texto
            limpiarCajasTexto();
            
                     
            
            LlenarTablaProductos();
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del producto no se modificaron...");
        }
        }else{
            JOptionPane.showMessageDialog(this.vista, "Se deben capturar todos los datos");
        }    }

    private void eliminar() {
 //Validar cajas de texto
        if(!this.vista.txtIdProducto.getText().trim().isEmpty()){
        
        //Obtener los datos de la vista y agregarlos al modelo
        this.modelo.setIdProducto(Integer.parseInt(this.vista.txtIdProducto.getText()));
       

        if (this.modelo.eliminar(this.modelo.getIdProducto())) {
            JOptionPane.showMessageDialog(this.vista, "Los datos del producto se eliminaron correctamente");
            //limpiar cajas de texto
            limpiarCajasTexto();
                        
            
            LlenarTablaProductos();
        } else {
            JOptionPane.showMessageDialog(this.vista, "Los datos del producto no se eliminaron...");
        }
        }else{
            JOptionPane.showMessageDialog(this.vista, "Se deben capturar todos los datos");
            this.vista.txtIdProducto.requestFocus();
        }    }

    private void buscarId() {
//obtener los datos de la vista y agregarlos al modelo
        this.modelo.setIdProducto(Integer.parseInt(this.vista.txtIdProducto.getText()));
        
        if (this.modelo.buscarPorId(this.modelo.getIdProducto())) {
            
            //Agregar los datos a las cajas de texto
            this.vista.txtNombreProducto.setText(this.modelo.getNombreProducto());
            this.vista.txtPrecioProducto.setText(String.valueOf(this.modelo.getPrecioProducto()));
            this.vista.txtStockProducto.setText(String.valueOf(this.modelo.getStockProducto()));
            this.vista.txtDescripcionProducto.setText(this.modelo.getDescripcionProducto());

                        
            
            LlenarTablaProductos();
                    
        } else {
            
            JOptionPane.showMessageDialog(this.vista, "Los datos del producto no se encontraron");
        }    }

     //metodo para buscar
    public void LlenarTablaProductos(){
        this.vista.tablaProductos.setModel(obtenerDatosProductos());
        
    }
    
    //metodo para obteber los datos de usuario
    public DefaultTableModel obtenerDatosProductos(){
        String encabezadoTabla[] = {"Id Producto","Nombre","Precio","Descripcion", "Stock" };
        DefaultTableModel modeloTabla = new DefaultTableModel(encabezadoTabla, 0);
        
        
        Object[] fila = new Object [modeloTabla.getColumnCount()];
        
        //Agregar los datos del objeto usuario 
        for (Productos producto : this.modelo.buscar()) {
            
            fila[0] = producto.getIdProducto();
            fila[1] = producto.getNombreProducto();
            fila[2] = producto.getPrecioProducto();
            fila[3] = producto.getDescripcionProducto();
            fila[4] = producto.getStockProducto();
           
            
            modeloTabla.addRow(fila);
            
        
        
        
        }
        
        return modeloTabla;
    
    }
    
      //metodo para validar las cajas de texto
    public boolean validarCajasTexto(){
        try {
            if (this.vista.txtIdProducto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el nombre del producto");
                this.vista.txtNombreProducto.requestFocus(); 
                return false;
            }
            if(this.vista.txtNombreProducto.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el precio del producto");
                this.vista.txtNombreProducto.requestFocus();     
                return false;  
            }
            if(this.vista.txtPrecioProducto.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el precio del producto");
                this.vista.txtPrecioProducto.requestFocus();     
                return false;
            }    
            if(this.vista.txtStockProducto.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar el stock del producto");
                this.vista.txtStockProducto.requestFocus(); 
                return false;
            }    
            if(this.vista.txtDescripcionProducto.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this.vista, "Debes ingresar la descripción del producto");
                this.vista.txtDescripcionProducto.requestFocus();
                return false; 
            }
            
        
                    
          return true;          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.vista, "Error:" + e.getMessage());
            return false;
        }
    }
    
   public void limpiarCajasTexto(){
        this.vista.txtIdProducto.setText("");
        this.vista.txtNombreProducto.setText("");
        this.vista.txtPrecioProducto.setText("");
        this.vista.txtStockProducto.setText("");
        this.vista.txtDescripcionProducto.setText("");
     
    }
    


    private void nuevo() {
//llamar metodo para limpiar cajas de texto
        limpiarCajasTexto();
        this.vista.txtIdProducto.requestFocus();
        
  
    }

    private void salir() {
   //ocultar el panel usuario
        this.vista.setVisible(false);
    }
    
}
