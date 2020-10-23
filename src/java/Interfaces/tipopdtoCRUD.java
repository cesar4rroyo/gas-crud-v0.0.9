/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import beans.beanTipoProducto;
import java.util.List;

/**
 *
 * @author cesar4rroyo
 */
public interface tipopdtoCRUD {
     public List listar();
    public beanTipoProducto list(int idTPdto);
    public boolean add(beanTipoProducto bTPdto);
    public boolean edit(beanTipoProducto bTPdto);
    public boolean eliminar(int idTPdto);
}
