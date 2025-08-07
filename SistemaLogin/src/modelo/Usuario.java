/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author moron
 */
public class Usuario {
    //ATRIBUTOS
    private int idUsuario;
    private String nombreUsuario;
    private String apPaternoUsuario;
    private String apMaternoUsuario;
    private String email;
    private String telefonoCelular;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String apPaternoUsuario, String apMaternoUsuario, String email, String telefonoCelular) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apPaternoUsuario = apPaternoUsuario;
        this.apMaternoUsuario = apMaternoUsuario;
        this.email = email;
        this.telefonoCelular = telefonoCelular;
    }
    
    //Metodo set y get

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApPaternoUsuario() {
        return apPaternoUsuario;
    }

    public void setApPaternoUsuario(String apPaternoUsuario) {
        this.apPaternoUsuario = apPaternoUsuario;
    }

    public String getApMaternoUsuario() {
        return apMaternoUsuario;
    }

    public void setApMaternoUsuario(String apMaternoUsuario) {
        this.apMaternoUsuario = apMaternoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    
    //Metodo String

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ",\n nombreUsuario=" + nombreUsuario + ",\n apPaternoUsuario=" + apPaternoUsuario + ",\n apMaternoUsuario=" + apMaternoUsuario + ",\n email=" + email + ",\n telefonoCelular=" + telefonoCelular + '}';
    }

    public void getIdUsuario(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
