package logic;

import ModeloDAO.daoTransporte;
import beans.beanTransporte;
import java.util.List;


public class logicTransporte {
    public String insertar(beanTransporte bT) {
        daoTransporte dT = new daoTransporte();
        if (dT.addTrp(bT)) {
            return "Agregado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public String actualizar(beanTransporte bT) {
        daoTransporte dT = new daoTransporte();
        if (dT.editTrp(bT)) {
            return "Actualizado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }

    }

    public String eliminar(int id) {
        daoTransporte dT = new daoTransporte();
        if (dT.eliminarTrp(id)) {
            return "Eliminado Correctamente";
        } else {
            return "Ha ocurrido un Error";
        }
    }
    
    public beanTransporte list(int id){
        daoTransporte dT = new daoTransporte();
        return dT.listTrp(id);
    }

    public List listar() {
        daoTransporte dT = new daoTransporte();
        return dT.listarTrp();
    }
}
