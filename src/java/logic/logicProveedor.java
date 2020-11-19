
package logic;

import ModeloDAO.daoProveedor;
import beans.beanProveedor;
import java.util.List;


public class logicProveedor {
    public String insertar(beanProveedor bP) {
        daoProveedor dP = new daoProveedor();
        if (dP.buscar(bP.getRuc())) {
            return "Este proveedor ya existe";
        } else {
            if (dP.add(bP)) {
                return "Agregado Correctamente";
            } else {
                return "Ha ocurrido un Error";
            }
        }
    }

    public String actualizar(beanProveedor bP) {
        daoProveedor dP = new daoProveedor();
        if (dP.edit(bP)) {
            return "Actualizado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }

    }

    public String eliminar(int id) {
        daoProveedor dP = new daoProveedor();
        if (dP.eliminar(id)) {
            return "Eliminado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public beanProveedor list(int id) {
        daoProveedor dP = new daoProveedor();
        return dP.list(id);
    }

    public List listar() {
        daoProveedor dP = new daoProveedor();
        return dP.listar();
    }
}
