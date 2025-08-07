/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Usuario;

/**
 *
 * @author moron
 */
public class TestUsuario {
    public static void main(String[] args) {
        //Crear el objeto usuario
        Usuario usuario =new Usuario(1, "Alfredo", "Juan", "Moroni", "24300632@uttt.edu.mx", "7731783475");
        System.out.println(usuario);
        
        System.out.println("");
        
        Usuario usuario2 =new Usuario();
        usuario2.setIdUsuario(2);
        usuario2.setNombreUsuario("Tania");
        usuario2.setApMaternoUsuario("Nuñez");
        usuario2.setApMaternoUsuario("Laguna");
        usuario2.setEmail("2430056@uttt.edu.mx");
        usuario2.setTelefonoCelular("7731518673");
        
        System.out.println(usuario2);
        
        System.out.println("");
        
        Usuario usuario3=new Usuario();
        
        usuario3.setIdUsuario(3);
        usuario3.setNombreUsuario("Pablo");
        usuario3.setApPaternoUsuario("Gil");
        usuario3.setApMaternoUsuario("Lopez");
        usuario3.setEmail("24300686@uttt.edu.mx");
        usuario3.setTelefonoCelular("7731237720");
        
        System.out.println("Id \t Nombre \t Apellido Paterno \t Apellido Materno \t Email \t Telefono \n");
        System.out.println("------------------------------------------------------------------------------------------------\n");
        System.out.println(usuario3.getIdUsuario() + "\t" + usuario3.getNombreUsuario()+ "\t" + usuario3.getApPaternoUsuario() + "\t" + usuario3.getApMaternoUsuario()+ "\t" + usuario3.getEmail()+ "\t" + usuario3.getTelefonoCelular() + "\n");
        System.out.println("---------------------------------------------------------------------------------------------\n");
        
    }
}
