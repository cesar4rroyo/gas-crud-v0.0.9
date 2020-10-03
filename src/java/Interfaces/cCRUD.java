
package Interfaces;

import beans.beanCliente;
import java.util.List;


public interface cCRUD {
    public List listar();
    public beanCliente list(int id);
    public boolean add(beanCliente cli);
    public boolean edit(beanCliente cli);
    public boolean eliminar(int id);
}
