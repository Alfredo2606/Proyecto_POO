/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Login;
import vista.VistaLogin;

/**
 *
 * @author moron
 */
public class controladorVistaLogin {
    //Atriutos
    private VistaLogin vista;
    private Login modelo;
    
    //constructor

    public controladorVistaLogin() {
        //Crear objeto vista y modelo
        this.vista=new VistaLogin();
        this.modelo=new Login();
        
        manejadorEventos();
    }
    //Metodo para el manejador de eventos
    public void manejadorEventos(){
        this.vista.btnIniciar.addActionListener(e->iniciarSesion());
    
    }
    
     //Metodo para iniciar
    public void iniciarSesion(){
        //Entrada de datos
        String user=this.vista.txtUsuario.getText();
        String password=String.valueOf(this.vista.txtPassword.getPassword());
        //String typeUser="admin";
        
        this.modelo.getUsuario().setNombreUsuario(user);
        this.modelo.setPasswordLogin(password);
        //this.modelo.getRolUsuario().setTipoRolUsuario(typeUser);
        
        //Validar login
        if (this.modelo.validarLogin()&& this.modelo.getRolUsuario().getTipoRolUsuario().equals("admin")) {
            //JOptionPane.showMessageDialog(this.vista, "Usuario y/o Password Correctos");
            //Crear objeto de la vista DashBoaardAdmin
            controladorDashBoardAdmin vistaDashBoardAdmin=new controladorDashBoardAdmin();
            vistaDashBoardAdmin.getVista().setVisible(true);
            vistaDashBoardAdmin.getVista().setLocationRelativeTo(null);
            
            
            //Ocultar la vista de Login
            this.vista.dispose();
            
        } else if (this.modelo.validarLogin()&& this.modelo.getRolUsuario().getTipoRolUsuario().equals("cajero")){
            //Crear objeto de DashBoardAdmin
            controladorDashBoardCajero dashBoardPuntoVenta = new controladorDashBoardCajero();
            dashBoardPuntoVenta.getVista().setVisible(true);
            dashBoardPuntoVenta.getVista().setLocationRelativeTo(null);
            
            this.vista.dispose();
        }                
    }
    
    //Metodo principal main
    public static void main(String[] args) {
        controladorVistaLogin controlador=new controladorVistaLogin();
        controlador.vista.setVisible(true);
    }   
}