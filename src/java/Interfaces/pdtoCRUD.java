
package Interfaces;

import beans.beanProducto;
import java.util.List;


public interface pdtoCRUD 
{
    public List listar();
    public beanProducto list(int idPdto);
    public boolean add(beanProducto bPdto);
    public boolean edit(beanProducto bPdto);
    public boolean eliminar(int idPdto);
    
}
