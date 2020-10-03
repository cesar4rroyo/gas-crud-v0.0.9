/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.beanEstadoPed;
import java.util.List;

/**
 *
 * @author cesar4rroyo
 */
public interface epCRUD {

    public List listar();

    public beanEstadoPed list(int idEst);

    public boolean add(beanEstadoPed bEst);

    public boolean edit(beanEstadoPed bEst);

    public boolean elimina(int idEst);

}
