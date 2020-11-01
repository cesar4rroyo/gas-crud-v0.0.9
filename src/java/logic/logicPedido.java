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

    public void pedidoCompletado(beanPedido bP, beanProducto bPdto) {
//        beanPedido bPed = new beanPedido();
//        beanProducto bPdt = new beanProducto();
        daoProducto dPdt = new daoProducto();
//        daoPedido dPed = new daoPedido();
        int stock = bPdto.getStock();
        if (bP.getEstado_Pedido().getTipo_estado() == 5) {
            int nuevo_stock = stock - 1;
            dPdt.actualizarStock(bPdto.getId_Producto(), nuevo_stock);
        }
    }
}
