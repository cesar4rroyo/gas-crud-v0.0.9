/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.beanTransporte;
import java.util.List;

/**
 *
 * @author ROG STRIX
 */
public interface tCRUD {
    public List listarTrp();
    public beanTransporte listTrp(int idTrp);
    public boolean addTrp(beanTransporte bTrp);
    public boolean editTrp(beanTransporte bTrp);
    public boolean eliminarTrp(int idTrp);
 
}
