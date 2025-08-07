/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author moron
 */
public interface CRUDInterface {
    public boolean insertar();//create
    public ArrayList buscar();//Read
    public boolean buscarPorId (int id);//Read
    public boolean modificar(int id);//upDate
    public boolean eliminar (int id);//delate
}
