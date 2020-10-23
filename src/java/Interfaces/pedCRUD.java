/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import beans.beanPedido;
import java.util.List;


public interface pedCRUD {
    
    public List listarPedido();
    public beanPedido list(int idPedido);
    public boolean add(beanPedido bPedido);
    public boolean edit(beanPedido bPedido);
    public boolean eliminar(int idPedido);
}
