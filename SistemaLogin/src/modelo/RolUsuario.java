/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author moron
 */
public class RolUsuario {
    //ATRIBUTOS
    private int idRolUsuario;
    private String tipoRolUsuario;
    private String descripcionRolUsuario;
    
    //Constructor

    public RolUsuario() {
    }

    public RolUsuario(int idRolUsuario, String tipoRolUsuario, String descripcionRolUsuario) {
        this.idRolUsuario = idRolUsuario;
        this.tipoRolUsuario = tipoRolUsuario;
        this.descripcionRolUsuario = descripcionRolUsuario;
    }
    //Metodo set y get 

    public int getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(int idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public String getTipoRolUsuario() {
        return tipoRolUsuario;
    }

    public void setTipoRolUsuario(String tipoRolUsuario) {
        this.tipoRolUsuario = tipoRolUsuario;
    }

    public String getDescripcionRolUsuario() {
        return descripcionRolUsuario;
    }

    public void setDescripcionRolUsuario(String descripcionRolUsuario) {
        this.descripcionRolUsuario = descripcionRolUsuario;
    }
    
    //Metodo toString

    @Override
    public String toString() {
        return "RolUsuario{" + "idRolUsuario=" + idRolUsuario + ",\n tipoRolUsuario=" + tipoRolUsuario + ",\n descripcionRolUsuario=" + descripcionRolUsuario + '}';
    }
    
   
    
}
