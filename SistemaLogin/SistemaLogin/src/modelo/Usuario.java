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
public class Usuario extends ConexionBD implements CRUDInterface {
    //Atributos
    private int idUsuario;
    private String nombreUsuario;
    private String apPaternoUsuario;
    private String apMaternoUsuario;
    private String emailUsuario;
    private String telefonoCelular;
    private CallableStatement cstmt;
    private ResultSet resultado;
    
    //Constructores
     public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String apPaternoUsuario, String apMaternoUsuario, String emailUsuario, String telefonoCelular) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apPaternoUsuario = apPaternoUsuario;
        this.apMaternoUsuario = apMaternoUsuario;
        this.emailUsuario = emailUsuario;
        this.telefonoCelular = telefonoCelular;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApPaternoUsuario() {
        return apPaternoUsuario;
    }

    public void setApPaternoUsuario(String apPaternoUsuario) {
        this.apPaternoUsuario = apPaternoUsuario;
    }

    public String getApMaternoUsuario() {
        return apMaternoUsuario;
    }

    public void setApMaternoUsuario(String apMaternoUsuario) {
        this.apMaternoUsuario = apMaternoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

   //Metodo toString

    @Override
    public String toString() {
        return "Usuario{ " + "idUsuario=" + idUsuario + ",\n nombreUsuario=" + nombreUsuario + ",\n apPaternoUsuario=" + apPaternoUsuario + ",\n apMaternoUsuario=" + apMaternoUsuario + ",\n emailUsuario=" + emailUsuario + ",\n telefonoCelular=" + telefonoCelular + '}';
    }

    @Override
    public boolean insertar() {
        if (super.openConnectionBD()) {
            try {
                JOptionPane.showMessageDialog(null,super.getMensajes());
                //llamar el procedimiento
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_insertar_usuario(?,?, ?, ?, ?);");
                this.cstmt.setString(1,this.nombreUsuario);
                this.cstmt.setString(2,this.apPaternoUsuario);
                this.cstmt.setString(3, this.apMaternoUsuario);
                this.cstmt.setString(4,this.emailUsuario);
                this.cstmt.setString(5, this.telefonoCelular);
                
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
    }//fin metodo insertar
    

    @Override
    public ArrayList <Usuario> buscar() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        if (super.openConnectionBD()) {
            try {
                //llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_buscar_usuario();");
              
                //ejecutar consulta
                this.resultado=this.cstmt.executeQuery();
                
                while (this.resultado.next()) {
                    
                   Usuario usuario = new Usuario();
                   
                   usuario.idUsuario = this.resultado.getInt(1);
                   usuario.nombreUsuario=this.resultado.getString(2);
                   usuario.apPaternoUsuario=this.resultado.getString(3);
                   usuario.apMaternoUsuario=this.resultado.getString(4);
                   usuario.emailUsuario=this.resultado.getString(5);
                   usuario.telefonoCelular=this.resultado.getString(6);
                   
                   //Agregar el objeto usuario a la lista
                   listaUsuarios.add(usuario);
                    
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
        
        return listaUsuarios;
        
    }
    
    
    
    //Metodo buscar por Id INICIO
    @Override
    public boolean buscarPorId(int id) {
        
       this.idUsuario = id; 
       if (super.openConnectionBD()) {
            try {
                //llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_buscar_usuario_id(?);");
                this.cstmt.setInt(1,this.idUsuario);
              
                //ejecutar consulta
                this.resultado=this.cstmt.executeQuery();
                
                while (this.resultado.next()) {
                   this.idUsuario = this.resultado.getInt(1);
                   this.nombreUsuario=this.resultado.getString(2);
                   this.apPaternoUsuario=this.resultado.getString(3);
                   this.apMaternoUsuario=this.resultado.getString(4);
                   this.emailUsuario=this.resultado.getString(5);
                   this.telefonoCelular=this.resultado.getString(6);
                    
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
    }//fin del metodo buscar por Id
    
    
       @Override
    public boolean modificar(int id) {
        this.idUsuario=id;
         if (super.openConnectionBD()) {
            try {
                //JOptionPane.showMessageDialog(null, super.getMensajes());
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_actualizar_usuario(?, ?, ?, ?, ?, ?);");
                this.cstmt.setInt(1, this.idUsuario);
                this.cstmt.setString(2, this.nombreUsuario);
                this.cstmt.setString(3, this.apPaternoUsuario);
                this.cstmt.setString(4, this.apMaternoUsuario);
                this.cstmt.setString(5, this.emailUsuario);
                this.cstmt.setString(6, this.telefonoCelular);
                
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
        this.idUsuario=id;
        
        if (super.openConnectionBD()) {
            try {
                //JOptionPane.showMessageDialog(null, super.getMensajes());
                //Llamar el procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.Eliminar_un_usuario(?);");
                this.cstmt.setInt(1, this.idUsuario);
                
                
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
