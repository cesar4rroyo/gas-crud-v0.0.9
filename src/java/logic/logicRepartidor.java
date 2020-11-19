package logic;

import ModeloDAO.daoRepartidor;
import beans.beanRepartidor;
import java.util.List;

public class logicRepartidor {

    public String insertar(beanRepartidor bR) {
        daoRepartidor dR = new daoRepartidor();
        if (dR.buscar(bR.getDni())) {
            return "Este usuario ya existe";
        } else {
            if (dR.addRep(bR)) {
                return "Agregado Correctamente";
            } else {
                return "Ha ocurrido un Error";
            }
        }
    }

    public String actualizar(beanRepartidor bR) {
        daoRepartidor dR = new daoRepartidor();
        if (dR.editRep(bR)) {
            return "Actualizado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }

    }

    public String eliminar(int id) {
        daoRepartidor dR = new daoRepartidor();
        if (dR.eliminarRep(id)) {
            return "Eliminado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public beanRepartidor list(int id) {
        daoRepartidor dR = new daoRepartidor();
        return dR.listRep(id);
    }

    public List listar() {
        daoRepartidor dR = new daoRepartidor();
        return dR.listarRep();
    }
}
