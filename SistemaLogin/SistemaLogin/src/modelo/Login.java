/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.CallableStatement;
import  java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author taanl
 */
public class Login extends ConexionBD{

    //Atributos
    private int idLogin;
    private String nombreLogin;
    private String passwordLogin;
    private Date fechaCreacionLogin;
    private boolean estatusLogin;
    
    //Declarar objetos usuario y rolUsuario
    private Usuario usuario;
    private RolUsuario rolUsuario;
    
    CallableStatement cstmt;
    ResultSet result;

    //Constructor
    public Login() {
        //Crear objetos usuario y rolUsuario
        this.usuario = new Usuario();
        this.rolUsuario = new RolUsuario();
        
    }
    
    public Login(int idLogin, String nombreLogin, String passwordLogin) {
        this.idLogin = idLogin;
        this.nombreLogin = nombreLogin;
        this.passwordLogin = passwordLogin;

        //Crear objetos usuario y rolUsuario
        this.usuario = new Usuario();
        this.rolUsuario = new RolUsuario();
    }

    //Metodo set y get 
    public int getIdLogin() {
        return idLogin;
    }
    
    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
    
    public String getNombreLogin() {
        return nombreLogin;
    }
    
    public void setNombreLogin(String nombreLogin) {
        this.nombreLogin = nombreLogin;
    }
    
    public String getPasswordLogin() {
        return passwordLogin;
    }
    
    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }
    
    public Date getFechaCreacionLogin() {
        return fechaCreacionLogin;
    }
    
    public void setFechaCreacionLogin(Date fechaCreacionLogin) {
        this.fechaCreacionLogin = fechaCreacionLogin;
    }
    
    public boolean isEstatusLogin() {
        return estatusLogin;
    }
    
    public void setEstatusLogin(boolean estatusLogin) {
        this.estatusLogin = estatusLogin;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }
    
    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", nombreLogin=" + nombreLogin + ", passwordLogin=" + passwordLogin + ", fechaCreacionLogin=" + fechaCreacionLogin + ", estatusLogin=" + estatusLogin + ", usuario=" + usuario.getNombreUsuario() + ", rolUsuario=" + rolUsuario.getTipoRolUsuario() + '}';
    }
    
    public boolean validarLogin() {  
        if(super.openConnectionBD()){
            try{
                //Llamar al procedimiento almacenado
                this.cstmt=super.getConexion().prepareCall("call bd_sistema_login.sp_validar_login(?,?);");
                this.cstmt.setString(1, this.getUsuario().getNombreUsuario());
                this.cstmt.setString(2, this.getPasswordLogin());
                //Ejecuta el procedimiento almacenado y agrega los datos del resultado
                this.result=this.cstmt.executeQuery();
                
                boolean existeUsuario=false;
                
                //Recorrer la consulta
                while(this.result.next()){
                    existeUsuario=true;
                    //Agregar los datos de la consulta a los atributos del Rol Usuario
                    this.getRolUsuario().setTipoRolUsuario(this.result.getString("tipoRolUsuario"));                 
                }
                //Cerrar la conexión
                this.cstmt.close();
                super.getConexion().close();
                if (existeUsuario) {
                    super.setMensajes("Si existe el usuario");
                    return true;
                } else{
                    super.setMensajes("NO existe el usuario");
                    return false;
                }
            } catch (SQLException e){
                super.setMensajes("Error de SQL" + e.getMessage());                
            }//{
             //       JOptionPane.showMessageDialog(null, super.getMensajes());
             //       }
        }
        return false;

    
    }
}
