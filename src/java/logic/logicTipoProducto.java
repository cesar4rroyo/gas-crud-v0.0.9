package logic;

import ModeloDAO.daoTipoProducto;
import beans.beanTipoProducto;
import java.util.List;

public class logicTipoProducto {

    public String insertar(beanTipoProducto bTP) {
        daoTipoProducto dTP = new daoTipoProducto();
        if (dTP.add(bTP)) {
            return "Agregado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public String actualizar(beanTipoProducto bTP) {
        daoTipoProducto dTP = new daoTipoProducto();
        if (dTP.edit(bTP)) {
            return "Actualizado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }

    }

    public String eliminar(int id) {
        daoTipoProducto dTP = new daoTipoProducto();
        if (dTP.eliminar(id)) {
            return "Eliminado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public beanTipoProducto listar(int id) {
        daoTipoProducto dTP = new daoTipoProducto();
        return dTP.list(id);
    }
}
