/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ModeloDAO.daoPedido;
import ModeloDAO.daoProducto;
import beans.beanPedido;
import beans.beanProducto;

/**
 *
 * @author cesar4rroyo
 */
public class logicPedido {


    public String agregarPedidoTemporal(beanPedido bPed){
        daoPedido dPed = new daoPedido();
        if(dPed.addPedidoTemporal(bPed)){
            return "Agregado Correctamente";
        }else{
            return "Ha ocurrido un Error";
        }
    }
    

    public String agregarPedidoCompleto(beanPedido bPed) {
        daoPedido dPed = new daoPedido();
        if (dPed.add(bPed)) {
            return "Agregado Correctamente";
        }else{
            return "Ha ocurrido un error :v";
        }

    }

    public String eliminar(int id) {
        daoPedido dPed = new daoPedido();
        return dPed.eliminar(id);
    }

    public String actualizar(beanPedido bP, beanProducto bPdt) {
        daoPedido dPed = new daoPedido();
        if (dPed.edit(bP).equalsIgnoreCase("Actualizado correctamente")) {
            if (bP.getEstado_Pedido().getId_Estado_pedido() == 5) {
                actualizarStock(bPdt.getStock() - 1, bPdt.getId_Producto());
            }
        }
        return "Actualizado Correctamente";
    }

    public void actualizarStock(int stock, int id) {
        daoProducto dPdt = new daoProducto();
        dPdt.actualizarStock(stock, id);
    }
}
