/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author taanl
 */
public class Login {

    //Atributos
    private int idLogin;
    private String nombreLogin;
    private String passwordLogin;
    private Date fechaCreacionLogin;
    private boolean estatusLogin;
    //Declarar objetos usuario y rolUsuario
    private Usuario usuario;
    private RolUsuario rolUsuario;

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

    //Metodo para validar el inicio de sesión 
    public boolean validarLogin() {
        //Variables para el usuario, password y tipo de usuario
        String nameUser = "Moroni";
        String passwordUser = "12345";
        String typeUser = "admin";
        
        if ((nameUser.equals(this.usuario.getNombreUsuario()))
                && (passwordUser.equals(this.passwordLogin)
                && (typeUser.equals(this.rolUsuario.getTipoRolUsuario())))) {
            return true;
            
        } else {
            return false;
        }
        
    }
    
}
