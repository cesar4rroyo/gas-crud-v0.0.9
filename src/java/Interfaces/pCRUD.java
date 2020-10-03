/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.beanProveedor;
import java.util.List;


public interface pCRUD {
    
    public List listar();
    public beanProveedor list(int idProv);
    public boolean add(beanProveedor bProv);
    public boolean edit(beanProveedor bProv);
    public boolean eliminar(int idProv);
 
    
}
