/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Usuario;

/**
 *
 * @author taanl
 */
public class TestUsuario {
    public static void main(String[] args) {
        //Crear el objeto usuario
        Usuario usuario=new Usuario(1, "Tania", "Nuñez", "Laguna", "24300569@uttt.edu.mx", "7731518673");
        System.out.println(usuario);
        
        Usuario usuario2=new Usuario();
        
        usuario2.setIdUsuario(2);
        usuario2.setNombreUsuario("Alfredo");
        usuario2.setApPaternoUsuario("Juan");
        usuario2.setApMaternoUsuario("Moroni");
        usuario2.setEmailUsuario("24300632@uttt.edu.mx");
        usuario2.setTelefonoCelular("7731783475");
        
        
        System.out.println(usuario2);
        
        System.out.println("");
        
        Usuario usuario3=new Usuario();
        usuario3.setIdUsuario(3);
        usuario3.setNombreUsuario("Stefany");
        usuario3.setApPaternoUsuario("Ausencio");
        usuario3.setApMaternoUsuario("Lopez");
        usuario3.setEmailUsuario("24300619@uttt.edu.mx");
        usuario3.setTelefonoCelular("7727634259");
        
        System.out.println("Id \t Nombre \t Apellido Paterno \t Apellino Materno \t Email \t Telefono \n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println(usuario3.getIdUsuario() + "\t" + usuario3.getNombreUsuario()+ "\t" + usuario3.getApPaternoUsuario()+ "\t" + usuario3.getApMaternoUsuario()+ "\t" + usuario3.getEmailUsuario()+ "\t" + usuario3.getTelefonoCelular() + "\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }
    
}
