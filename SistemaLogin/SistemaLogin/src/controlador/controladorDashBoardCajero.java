/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.VistaDashBoardCajero;

/**
 *
 * @author riam_
 */
public class controladorDashBoardCajero {
    
    //Atributos
    private VistaDashBoardCajero vista;
    
    //constructor

    public controladorDashBoardCajero() {
        this.vista = new VistaDashBoardCajero();
        
        //Llamar al manejador de eventos
        ManejadorEventos();
        
    }
     
    //Metodo set y get 

    public VistaDashBoardCajero getVista() {
        return vista;
    }
    
    public void setVista(VistaDashBoardCajero vista) {
        this.vista = vista;
    }
    
    public void ManejadorEventos(){
        //evento para el boton usuario
       this.vista.btnGenerarVenta.addActionListener(e->mostrarPanelPuntoVenta());
    
}
    //metodo para mostrar el PuntoVenta
    public void mostrarPanelPuntoVenta(){
        //crear el objeto del controlador del panel punto de venta
        controladorPanelPuntoVenta controladorpanelPuntoVenta = new controladorPanelPuntoVenta();
        controladorpanelPuntoVenta.getVista().setSize(800,560);
        controladorpanelPuntoVenta.getVista().setLocation(0, 0);
        
        //agregar el panel usuarios al panel contenedor
        this.vista.panelContenedor.removeAll();
        this.vista.panelContenedor.add(controladorpanelPuntoVenta.getVista());
        this.vista.panelContenedor.revalidate();
        this.vista.panelContenedor.repaint();
    }
    
    
    //metodo main
    public static void main(String[] args) {
        //crear controlador
        controladorDashBoardCajero controlador =new controladorDashBoardCajero();
        controlador.vista.setVisible(true);
        controlador.vista.setLocationRelativeTo(null);
        
    }
    
    
}