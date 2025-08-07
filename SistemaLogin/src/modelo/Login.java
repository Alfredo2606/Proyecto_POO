/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package modelo;

import java.util.Date;

/**
 *
 * @author moron
 */
public class Login {
    //Atributos
    private int idLogin;
    private String nomLogin;
    private String passwordLogin;
    private Date fechaCreacionLogin;
    private boolean estatusLogin;
    
    private Usuario usuario;
    private RolUsuario rolUsuario;
    
    
    //constructor
    

    public Login() {
        //Crear
        this.usuario=new Usuario();
        this.rolUsuario=new RolUsuario();
                
    }

    public Login(int idLogin, String nomLogin, String passwordLogin) {
        this.idLogin = idLogin;
        this.nomLogin = nomLogin;
        this.passwordLogin = passwordLogin;
        
         //Crear
        this.usuario=new Usuario();
        this.rolUsuario=new RolUsuario();
    }
     //metodo set y get

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getNomLogin() {
        return nomLogin;
    }

    public void setNomLogin(String nomLogin) {
        this.nomLogin = nomLogin;
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
     //metodo to String 

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", nomLogin=" + nomLogin + ", passwordLogin=" + passwordLogin + ", fechaCreacionLogin=" + fechaCreacionLogin + ", estatusLogin=" + estatusLogin + ", usuario=" + usuario.getNombreUsuario() + ", rolUsuario=" + rolUsuario.getTipoRolUsuario() + '}';
    }
    //Metodo para validar el inicio de secion
    public boolean validarLogin(){
        //Variables para que el usuario 
        String nameUser="Alfredo";
        String passwordUser="12345";
        String typeUser="admin";
        if ((nameUser.equals(this.usuario.getNombreUsuario()))&&
                (passwordUser.equals(this.passwordLogin)&&
                (typeUser.equals(this.rolUsuario.ge())))
                ) {
            return true;
            
        } else {
            return false;
            
        }
        
        
        
    }

    private static class RolUsuario {

        public RolUsuario() {
        }
    }
    
    
    
      
}
