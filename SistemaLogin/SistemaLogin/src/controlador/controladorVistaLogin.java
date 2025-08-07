/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Login;
import vista.VistaDashBoardAdmin;
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
        String typeUser="admin";
        
        this.modelo.getUsuario().setNombreUsuario(user);
        this.modelo.setPasswordLogin(password);
        this.modelo.getRolUsuario().setTipoRolUsuario(typeUser);
        //Validar login
        if (this.modelo.validarLogin()) {
            //JOptionPane.showMessageDialog(this.vista, "Usuario y/o Password Correctos");
            //Crear objeto de la vista DashBoaardAdmin
            controladorDashBoardAdmin vistaDashBoardAdmin=new controladorDashBoardAdmin();
            vistaDashBoardAdmin.getVista().setVisible(true);
            vistaDashBoardAdmin.getVista().setLocationRelativeTo(null);
            
            
            //Ocultar la vista de Login
            this.vista.dispose();
            
       
            
        } else {
            JOptionPane.showMessageDialog(this.vista, "Usuario y/o Password Incorrectos");
        }
                
    }
    
    //Metodo principal main
    public static void main(String[] args) {
        controladorVistaLogin controlador=new controladorVistaLogin();
        controlador.vista.setVisible(true);
    }
    
    
}
