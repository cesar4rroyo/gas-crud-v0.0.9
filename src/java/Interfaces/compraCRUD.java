
package Interfaces;

import beans.beanCompra;
import java.util.List;


public interface compraCRUD {
    public List listarCompras();
    public beanCompra list(int id_Compra);
    public String add(beanCompra bCompra);
    public String edit(beanCompra bCompra);
    public String eliminar(int id_Compra);
}
