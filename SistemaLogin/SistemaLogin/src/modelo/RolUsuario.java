/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author MORONI
 */
public class RolUsuario extends ConexionBD implements CRUDInterface {
    //Atributos
    private int idRolUsuario;
    private String tipoRolUsuario;
    private String descripcionRolUsuario;
    private CallableStatement cstmt;
    private ResultSet result;
    
    //Constructor

    public RolUsuario() {
    }

    public RolUsuario(int idRolUsuario, String tipoRolUsuario, String descripcionRolUsuario) {
        this.idRolUsuario = idRolUsuario;
        this.tipoRolUsuario = tipoRolUsuario;
        this.descripcionRolUsuario = descripcionRolUsuario;
    }
    
    //Metodos set y get

    public int getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(int idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public String getTipoRolUsuario() {
        return tipoRolUsuario;
    }

    public void setTipoRolUsuario(String tipoRolUsuario) {
        this.tipoRolUsuario = tipoRolUsuario;
    }

    public String getDescripcionRolUsuario() {
        return descripcionRolUsuario;
    }

    public void setDescripcionRolUsuario(String descripcionRolUsuario) {
        this.descripcionRolUsuario = descripcionRolUsuario;
    }
    
    //Metodo toString

    @Override
    public String toString() {
        return "RolUsuario{" + "idRolUsuario=" + idRolUsuario + ",\n tipoRolUsuario=" + tipoRolUsuario + ",\n descripcionRolUsuario=" + descripcionRolUsuario + '}';
    }

    @Override
    public boolean insertar() {
if (super.openConnectionBD()) {
            try {
                JOptionPane.showMessageDialog(null, super.getMensajes());
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_insertar_rol_usuario(?, ?, ?);");
                this.cstmt.setInt(1, this.idRolUsuario);
                this.cstmt.setString(2, this.tipoRolUsuario);
                this.cstmt.setString(3, this.descripcionRolUsuario);
           
                
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
    }//fin del metodo insertar    }

    @Override
   public ArrayList<RolUsuario> buscar() {
        ArrayList<RolUsuario> listaUsuarios = new ArrayList<RolUsuario>();
        if (super.openConnectionBD()) {
            try {
             
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_buscar_rol_usuario();");
                
                //ejecutar consulta
                this.result = this.cstmt.executeQuery();
                
                while (this.result.next()) {
                    RolUsuario Rolusuario = new RolUsuario();
                    Rolusuario.idRolUsuario = this.result.getInt(1);
                    Rolusuario.tipoRolUsuario = this.result.getString(2);
                    Rolusuario.descripcionRolUsuario = this.result.getString(3);
                   
                    //agregar el objeto usuario a la lista
                    listaUsuarios.add(Rolusuario);
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
        
        return listaUsuarios;
        
        
    }

    @Override
    public boolean buscarPorId(int id) {
        this.idRolUsuario = id;
         if (super.openConnectionBD()) {
            try {
             
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_buscar_rol_usuario_id(?);");
                this.cstmt.setInt(1, idRolUsuario);
                
                //ejecutar consulta
                this.result = this.cstmt.executeQuery();
                
                while (this.result.next()) {
                    this.idRolUsuario = this.result.getInt(1);
                    this.tipoRolUsuario = this.result.getString(2);
                    this.descripcionRolUsuario = this.result.getString(3);
                  
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
    }//fin del metodo buscar por id    

    @Override
    public boolean modificar(int id) {
    this.idRolUsuario=id;
         if (super.openConnectionBD()) {
            try {
                //JOptionPane.showMessageDialog(null, super.getMensajes());
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_actualizar_rol_usuario(?, ?, ?);");
                this.cstmt.setInt(1, this.idRolUsuario);
                this.cstmt.setString(2, this.tipoRolUsuario);
                this.cstmt.setString(3, this.descripcionRolUsuario);
            
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
        this.idRolUsuario=id;
        if (super.openConnectionBD()) {
            try {
                //JOptionPane.showMessageDialog(null, super.getMensajes());
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_eliminar_rol_usuario(?);");
                this.cstmt.setInt(1, this.idRolUsuario);
                
                
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