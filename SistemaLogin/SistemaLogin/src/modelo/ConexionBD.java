/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author moron
 */
public class ConexionBD {
    //ATRIBUTOS
    private String driverBD;
    private String userBD;
    private String passwordBD;
    private String urlBD;
    
    private Connection conexion;
    private String mensajes;
    
    //Constructor

    public ConexionBD() {
        
        this.driverBD="com.mysql.cj.jdbc.Driver";
        this.userBD="root";
        this.passwordBD="123456";
        this.urlBD="jdbc:mysql://localhost:3306/bd_sistema_login";
                
                
    }

    public ConexionBD(String driverBD, String userBD, String passwordBD, String urlBD) {
        this.driverBD = driverBD;
        this.userBD = userBD;
        this.passwordBD = passwordBD;
        this.urlBD = urlBD;
    }
    
    //Metodos Set y get

    public String getDriverBD() {
        return driverBD;
    }

    public void setDriverBD(String driverBD) {
        this.driverBD = driverBD;
    }

    public String getUserBD() {
        return userBD;
    }

    public void setUserBD(String userBD) {
        this.userBD = userBD;
    }

    public String getPasswordBD() {
        return passwordBD;
    }

    public void setPasswordBD(String passwordBD) {
        this.passwordBD = passwordBD;
    }

    public String getUrlBD() {
        return urlBD;
    }

    public void setUrlBD(String urlBD) {
        this.urlBD = urlBD;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }
    
    //Metodo para establecer la conexion al servidor de BD
    
    public boolean openConnectionBD(){
        try {
            //1.-Registrar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2.-Establecer la conexion
            this.conexion=DriverManager.getConnection(urlBD, userBD, passwordBD);
            this.mensajes="SE ESTABLECIO LA CONEXION A LA BD CON EXITO";
            return true;
                 
            
        } catch (Exception e) {
            this.mensajes="Error de conexion: " + e.getMessage();
        }
        return false;
        
    }
    
    //Metodo para cerrar la conexion al servidor
    public boolean closeConectionBD(){
        try {
            if(this.conexion!=null){
                this.conexion.close();
                this.mensajes="SE CERRO LA CONEXION";
                return true;
            
            }
        } catch (Exception e) {
            this.mensajes="Error: " + e.getMessage();
        }
        return false;
    
    }
    
   
    
}
