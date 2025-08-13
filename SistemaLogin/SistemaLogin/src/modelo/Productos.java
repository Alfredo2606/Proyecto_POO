/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import  java.sql.ResultSet;

/**
 *
 * @author taanl
 */


public class Productos extends ConexionBD implements CRUDInterface {

    //Atributos
    private int idProducto;
    private String nombreProducto;
    private double precioProducto;
    private int stockProducto;
    private String descripcionProducto;
    private CallableStatement cstmt;
    private ResultSet resultado;

    //Constructor
    public Productos() {
    }

    public Productos(int idProducto, String nombreProducto, int cantidadProducto, double precioProducto, int totalProducto, int stockProducto, String descripcionProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.descripcionProducto = descripcionProducto;
    }

    //Métodos set y get

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
  

    
    //Metodo toString
    @Override
    public String toString() {
        return "Productos{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", stockProducto=" + stockProducto + ", descripcionProducto=" + descripcionProducto + '}';
    }

    //CRUD
    @Override
    public boolean insertar() {
        if (super.openConnectionBD()) {
            try {
                JOptionPane.showMessageDialog(null,super.getMensajes());
                //llamar el procedimiento
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_insertar_producto(?, ?, ?, ?, ?);");
                this.cstmt.setInt(1, this.idProducto);
                this.cstmt.setString(2,this.nombreProducto);
                this.cstmt.setString(3, this.descripcionProducto);
                this.cstmt.setInt(4,this.stockProducto);
                this.cstmt.setDouble(5, this.precioProducto);
                
                
                
                //ejecutar el procedimiento almacenado
                this.cstmt.execute();
                //cerrar conexion a la BD
                this.cstmt.close();
                this.getConexion().clearWarnings();
                return true;
            } catch (SQLException ex) {
                
                super.setMensajes("Error sql: " + ex.getMessage());
                   
            }
            
        } else {
            JOptionPane.showMessageDialog(null,super.getMensajes());

        }
        
        return false;
    }

    @Override
    public ArrayList<Productos> buscar() {
        ArrayList<Productos> listaProductos = new ArrayList<Productos>();
     if (super.openConnectionBD()) {
        try {
             //llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_buscar_productos();");
              
                //ejecutar consulta
                this.resultado=this.cstmt.executeQuery();
                
                while (this.resultado.next()) {
                    
                   Productos producto = new Productos();
                   
                   producto.idProducto = this.resultado.getInt(1);
                   producto.nombreProducto=this.resultado.getString(2);
                   producto.descripcionProducto=this.resultado.getString(3);
                   producto.stockProducto=this.resultado.getInt(4);
                   producto.precioProducto=this.resultado.getDouble(5);
                 
                   
                   //Agregar el objeto usuario a la lista
                   listaProductos.add(producto);
                    
                }
                //cerrar conexion a la BD
                this.cstmt.close();
                this.getConexion().close();
                
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
                   
            }
            
        } else {
            JOptionPane.showMessageDialog(null,super.getMensajes());

        }
        
        return listaProductos;
    }

    @Override
    public boolean buscarPorId(int id) {
        this.idProducto = id; 
       if (super.openConnectionBD()) {
            try {
                //llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.`sp_buscar _productos_id`(?);");
                this.cstmt.setInt(1,this.idProducto);
              
                //ejecutar consulta
                this.resultado=this.cstmt.executeQuery();
                
                while (this.resultado.next()) {
                   this.idProducto = this.resultado.getInt(1);
                   this.nombreProducto=this.resultado.getString(2);
                   this.descripcionProducto=this.resultado.getString(3);
                   this.stockProducto=this.resultado.getInt(4);
                   this.precioProducto=this.resultado.getDouble(5);
                   
                    
                }
                //cerrar conexion a la BD
                this.cstmt.close();
                this.getConexion().close();
                
                return true;
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
                   
            }
            
        } else {
            JOptionPane.showMessageDialog(null,super.getMensajes());

        }
        
        return false;
    }

    @Override
    public boolean modificar(int id) {
         this.idProducto=id;
         if (super.openConnectionBD()) {
            try {
                //JOptionPane.showMessageDialog(null, super.getMensajes());
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_actualizar_Productos(?, ?, ?, ?, ?);");
                this.cstmt.setInt(1, this.idProducto);
                this.cstmt.setString(2, this.nombreProducto);
                this.cstmt.setString(3, this.descripcionProducto);
                this.cstmt.setInt(4, this.stockProducto);
                this.cstmt.setDouble(5, this.precioProducto);
              
                
                //ejecutar el procedimiento almacenado
                this.cstmt.execute();
                //cerrar conexion a la BD
                this.cstmt.close();
                super.getConexion().close();
                
                return true;
            } catch (SQLException ex) {
                super.setMensajes("Error sql:" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, super.getMensajes()); 
        }
        
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        this.idProducto=id;
        
        if (super.openConnectionBD()) {
            try {
                //JOptionPane.showMessageDialog(null, super.getMensajes());
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_Eliminar_Productos(?);");
                this.cstmt.setInt(1, this.idProducto);
                
                
                //ejecutar el procedimiento almacenado
                this.cstmt.execute();
                //cerrar conexion a la BD
                this.cstmt.close();
                super.getConexion().close();
                
                return true;
            } catch (SQLException ex) {
                super.setMensajes("Error sql:" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, super.getMensajes()); 
        }
        
        return false;
       
        
    }
}
