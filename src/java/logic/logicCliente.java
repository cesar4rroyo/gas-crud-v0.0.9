
package logic;

import ModeloDAO.daoCliente;
import beans.beanCliente;
import java.util.List;

public class logicCliente {
    public String insertar(beanCliente bC) {
        daoCliente dC = new daoCliente();
        if (dC.buscar(bC.getDni())) {
            return "Este cliente ya existe";
        } else {
            if (dC.add(bC)) {
                return "Agregado Correctamente";
            } else {
                return "Ha ocurrido un Error";
            }
        }
    }

    public String actualizar(beanCliente bC) {
        daoCliente dC = new daoCliente();
        if (dC.edit(bC)) {
            return "Actualizado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }

    }

    public String eliminar(int id) {
        daoCliente dC = new daoCliente();
        if (dC.eliminar(id)) {
            return "Eliminado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public beanCliente list(int id) {
        daoCliente dC = new daoCliente();
        return dC.list(id);
    }

    public List listar() {
        daoCliente dC = new daoCliente();
        return dC.listar();
    }
    
}
