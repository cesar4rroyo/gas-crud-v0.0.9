/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import ModeloDAO.daoCompra;
import ModeloDAO.daoProducto;
import beans.beanCompra;
import beans.beanProducto;

/**
 *
 * @author cesar4rroyo
 */
public class logicCompra {

    public String insertar(beanCompra bC) {
        
        beanProducto bPdt = new beanProducto();
        daoProducto dPdto = new daoProducto();
        int nro_producto_nuevos = bC.getCantidad();
//        int nuevo_stock = nro_producto_nuevos + bC.getProducto().getCantidad();
        int nuevo_stock = nro_producto_nuevos + bC.getProducto().getStock();
        int idPdto = bC.getProducto().getId_Producto();
        try {
            dPdto.actualizarStock(nuevo_stock, idPdto);
            return "Agregado correctamente";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }
    public String editarCompra(beanCompra bC, int cantidad_defecto){
        beanProducto bPdt = new beanProducto();
        daoProducto dPdto = new daoProducto();
        int cantidad_normal = bC.getProducto().getStock()- cantidad_defecto ;
        int cantidad_corregida = cantidad_normal + bC.getProducto().getCantidad();
        int idPdto = bC.getProducto().getId_Producto();
        try {
            dPdto.actualizarStock(cantidad_corregida, idPdto);
            return "Agregado correctamente";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }
}
