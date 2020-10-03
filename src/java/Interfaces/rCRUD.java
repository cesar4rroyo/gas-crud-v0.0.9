
package Interfaces;

import beans.beanRepartidor;
import java.util.List;


public interface rCRUD {
    
    public List listarRep();
    public beanRepartidor listRep(int idRep);
    public boolean addRep(beanRepartidor bRep);
    public boolean editRep(beanRepartidor bRep);
    public boolean eliminarRep(int idRep);
}
