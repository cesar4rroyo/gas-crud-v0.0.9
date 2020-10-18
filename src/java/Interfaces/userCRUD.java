/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.beanUsuario;
import java.util.List;

/**
 *
 * @author cesar4rroyo
 */
public interface userCRUD {
    public List listar();
    public beanUsuario list(String uName);
    public boolean add(beanUsuario user);
    public boolean edit(beanUsuario user);
    public boolean eliminar(String uName);
}
