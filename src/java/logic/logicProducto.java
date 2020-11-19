package logic;

import ModeloDAO.daoProducto;
import beans.beanProducto;
import java.util.List;

public class logicProducto {

    public String insertar(beanProducto bP) {
        daoProducto dP = new daoProducto();
        if (dP.add(bP)) {
            return "Agregado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public String actualizar(beanProducto bP) {
        daoProducto dP = new daoProducto();
        if (dP.edit(bP)) {
            return "Actualizado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }

    }

    public String eliminar(int id) {
        daoProducto dP = new daoProducto();
        if (dP.eliminar(id)) {
            return "Eliminado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public List listar() {
        daoProducto dP = new daoProducto();
        return dP.listar();
    }
}
