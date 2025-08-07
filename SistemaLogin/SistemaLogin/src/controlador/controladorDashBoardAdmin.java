/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.VistaDashBoardAdmin;

/**
 *
 * @author moron
 */
public class controladorDashBoardAdmin {
    
    //Atributos
    private VistaDashBoardAdmin vista;
    
    //Constructor

    public controladorDashBoardAdmin() {
        //crear Objeto
        this.vista=new VistaDashBoardAdmin();
        //llama el manejador de eventos
        manejadoEventos();
        
      
    }
    // SET Y GET

    public VistaDashBoardAdmin getVista() {
        return vista;
    }

    public void setVista(VistaDashBoardAdmin vista) {
        this.vista = vista;
    }
    
    //metodo para el manejador de evventos
    public void manejadoEventos(){
        //evento para el boton usuario
        this.vista.btnUsuarios.addActionListener(e->mostrarPanelUsuarios());
        //EVENTO PARA EL BOTON DEL ROL USUARIO
        this.vista.btnRolUsuario.addActionListener(e->mostrarPanelRolUsuario());
    }
    //metodo para mostrar el panel usuarios
    public void mostrarPanelRolUsuario(){
        //crear el objeto del controlador del panel usuario
        controladorPanelRolUsuario ControladorpanelrolUsuario = new controladorPanelRolUsuario();
        ControladorpanelrolUsuario.getVista().setSize(800,560);
        ControladorpanelrolUsuario.getVista().setLocation(0, 0);
        
        //agregar el panel usuarios al panel contenedor
        this.vista.panelContenedor.removeAll();
        this.vista.panelContenedor.add(ControladorpanelrolUsuario.getVista());
        this.vista.panelContenedor.revalidate();
        this.vista.panelContenedor.repaint();
        
    
    }
    
    //metodo para mostrar el panel usuarios
    public void mostrarPanelUsuarios(){
        //crear el objeto del controlador del panel usuario
        controladorPanelUsuario controladorpanelUsuario = new controladorPanelUsuario();
        controladorpanelUsuario.getVista().setSize(800,560);
        controladorpanelUsuario.getVista().setLocation(0, 0);
        
        //agregar el panel usuarios al panel contenedor
        this.vista.panelContenedor.removeAll();
        this.vista.panelContenedor.add(controladorpanelUsuario.getVista());
        this.vista.panelContenedor.revalidate();
        this.vista.panelContenedor.repaint();
        
    
    }
    
    //metodo main
    public static void main(String[] args) {
        //crear controlador
        controladorDashBoardAdmin controlador =new controladorDashBoardAdmin();
        controlador.vista.setVisible(true);
        controlador.vista.setLocationRelativeTo(null);
        
    }
    
}
