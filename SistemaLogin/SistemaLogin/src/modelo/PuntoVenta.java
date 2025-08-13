/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author riam_
 */
public class PuntoVenta extends ConexionBD implements CRUDInterface{

    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private double total;
    private CallableStatement cstmt;
    private ResultSet result;
    
    //Constructor

    public PuntoVenta() {
    }

    public PuntoVenta(int idProducto, String nombre, int cantidad, double precio, double total) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }
    
    
    //Metodos set y get

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    //metodo toString

    @Override
    public String toString() {
        return "PuntoVenta{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + '}';
    }
    
  
    
    @Override
    public boolean insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PuntoVenta> buscar() {
    ArrayList<PuntoVenta> listaProductos = new ArrayList<>();
        if (super.openConnectionBD()) {
            try {
             
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_puntoDeVenta(?);");
                this.cstmt.setInt(1, idProducto);
                
                //ejecutar consulta
                this.result = this.cstmt.executeQuery();
                
                while (this.result.next()) {
                    PuntoVenta PuntoVenta = new PuntoVenta();
                    PuntoVenta.idProducto = this.result.getInt(1);
                    PuntoVenta.nombre = this.result.getString(2);
                    PuntoVenta.cantidad = this.result.getInt(3);
                    PuntoVenta.precio = this.result.getByte(4);
                    PuntoVenta.total = this.result.getByte(5);
                    
                   
                    //agregar el objeto usuario a la lista
                    listaProductos.add(PuntoVenta);
                }
                
                
                //cerrar conexion a la BD
                this.cstmt.close();
                super.getConexion().close();
                
               
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, super.getMensajes()); 
        }
        
        return listaProductos;
        
    }

    @Override
    public boolean buscarPorId(int id) {
         this.idProducto = id;
         if (super.openConnectionBD()) {
            try {
             
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_buscar_rol_usuario_id(?);");
                this.cstmt.setInt(1, idProducto);
                
                //ejecutar consulta
                this.result = this.cstmt.executeQuery();
                
                while (this.result.next()) {
                    this.idProducto = this.result.getInt(1);
                    this.nombre = this.result.getString(2);
                    this.cantidad = this.result.getInt(3);
                    this.precio= this.result.getByte(4);
                    this.total = this.result.getByte(5);
                  
                }
                
                
                //cerrar conexion a la BD
                this.cstmt.close();
                super.getConexion().close();
                
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, super.getMensajes()); 
        }
        
        return false;
          
    }

    @Override
    public boolean modificar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
