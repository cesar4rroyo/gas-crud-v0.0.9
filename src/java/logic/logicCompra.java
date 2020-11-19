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

public class logicCompra {

    public String insertar(beanCompra bC) {
        daoCompra dCompra = new daoCompra();
        if (dCompra.add(bC).equalsIgnoreCase("Añadido correctamente")) {
            actualizarStock(bC);
            return "Compra Correcta";
        } else {
            return "Ha ocurrido un Error";
        }
    }

    public String eliminar(int id) {
        daoCompra dCompra = new daoCompra();
        return dCompra.eliminar(id);
    }

    public String actualizarStock(beanCompra bC) {
        beanProducto bPdt = new beanProducto();
        daoProducto dPdto = new daoProducto();
        int nro_producto_nuevos = bC.getCantidad();
        int nuevo_stock = nro_producto_nuevos + bC.getProducto().getStock();
        int idPdto = bC.getProducto().getId_Producto();
        try {
            dPdto.actualizarStock(nuevo_stock, idPdto);
            return "Agregado correctamente";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }

    public String editarCompra(beanCompra bC, int cantidad_defecto) {
        daoCompra dCompra = new daoCompra();
        if(dCompra.edit(bC).equalsIgnoreCase("Actualizado correctamente")){
            return actualizarStockCompra(bC, cantidad_defecto);            
        }else{
            return "Ha ocurrido un Error";
        }
        
    }
    public String actualizarStockCompra(beanCompra bC, int cantidad_defecto){
        beanProducto bPdt = new beanProducto();
        daoProducto dPdto = new daoProducto();
        int cantidad_normal = bC.getProducto().getStock() - cantidad_defecto;
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
