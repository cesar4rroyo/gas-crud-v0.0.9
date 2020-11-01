/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.compraCRUD;
import beans.beanCompra;
import beans.beanProducto;
import beans.beanProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar4rroyo
 */
public class daoCompra implements compraCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listarCompras() {
        ArrayList<beanCompra> lstCompra = new ArrayList<>();
        String sql = "SELECT id_Compra, producto.id_Producto, provedor.id_Provedor, "
                + "cantidad, fecha, ruc, provedor.nombre as nPv, nombre_producto, "
                + "total from compra INNER JOIN producto on compra.id_Producto=producto.id_Producto"
                + " INNER JOIN provedor on compra.id_Provedor=provedor.id_Provedor";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanCompra bCompra = new beanCompra();
                beanProducto bPdto = new beanProducto();
                beanProveedor bPrv = new beanProveedor();
                bPdto.setNombre_producto(rs.getString("nombre_producto"));
                bPdto.setId_Producto(rs.getInt("id_Producto"));

                bPrv.setNombre(rs.getString("nPv"));
                bPrv.setRuc(rs.getString("ruc"));
                bPrv.setId_Provedor(rs.getInt("id_Provedor"));

                bCompra.setId_Compra(rs.getInt("id_Compra"));
                bCompra.setFecha(rs.getTimestamp("fecha"));
                bCompra.setCantidad(rs.getInt("cantidad"));
                bCompra.setTotal(rs.getInt("total"));
                bCompra.setProducto(bPdto);
                bCompra.setProvedor(bPrv);

                lstCompra.add(bCompra);
            }
        } catch (Exception e) {
            return null;
        }
        return lstCompra;
    }

    @Override
    public beanCompra list(int id_Compra) {
        ArrayList<beanCompra> lstCompra = new ArrayList<>();
        String sql = "SELECT id_Compra, producto.id_Producto, provedor.id_Provedor, "
                + "cantidad, fecha, ruc, provedor.nombre as nPv, nombre_producto, "
                + "total from compra INNER JOIN producto on compra.id_Producto=producto.id_Producto"
                + " INNER JOIN provedor on compra.id_Provedor=provedor.id_Provedor where id_Compra=" + id_Compra;
        beanCompra bCompra = new beanCompra();
        beanProducto bPdto = new beanProducto();
        beanProveedor bPrv = new beanProveedor();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bPdto.setNombre_producto(rs.getString("nombre_producto"));
                bPdto.setId_Producto(rs.getInt("id_Producto"));

                bPrv.setNombre(rs.getString("nPv"));
                bPrv.setRuc(rs.getString("ruc"));
                bPrv.setId_Provedor(rs.getInt("id_Provedor"));

                bCompra.setId_Compra(rs.getInt("id_Compra"));
                bCompra.setFecha(rs.getTimestamp("fecha"));
                bCompra.setCantidad(rs.getInt("cantidad"));
                bCompra.setTotal(rs.getInt("total"));
                bCompra.setProducto(bPdto);
                bCompra.setProvedor(bPrv);
            }
        } catch (Exception e) {
            return null;
        }
        return bCompra;

    }

    @Override
    public String add(beanCompra bCompra) {
        String out = "";
        String sql = "INSERT INTO compra (id_Compra, cantidad,"
                + "id_Provedor, total, id_Producto) VALUES ('" + bCompra.getId_Compra() + "', '"
                + bCompra.getCantidad() + "', '"
                + bCompra.getProvedor().getId_Provedor() + "', '"
                + bCompra.getTotal() + "', '"
                + bCompra.getProducto().getId_Producto() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            out = "Añadido correctamente";
        } catch (Exception e) {
            out = "Ha ocurrido un Error" + e.getMessage();
        }
        return out;
    }

    @Override
    public String edit(beanCompra bCompra) {
        String out = "";
        String sql = 
                "UPDATE compra set cantidad='"+bCompra.getCantidad()+"',"
                + "id_Provedor='"+ bCompra.getProvedor().getId_Provedor()+"', "
                + "id_Producto='"+ bCompra.getProducto().getId_Producto()+"', "
                + "total='"+ bCompra.getTotal()+"' WHERE id_Compra="+ bCompra.getId_Compra();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            out = "Actualizado correctamente";
        } catch (Exception e) {
            out = "Ha ocurrido un Error" + e.getMessage();
        }
        return out;
    }

    @Override
    public String eliminar(int id_Compra) {
        String out = "";
        String sql = "DELETE FROM compra where id_Compra=" + id_Compra;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            out = "Eliminado correctamente";
        } catch (Exception e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

}
