/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.tipopdtoCRUD;
import beans.beanTipoProducto;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar4rroyo
 */
public class daoTipoProducto implements tipopdtoCRUD {

    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanTipoProducto bTPdct;

    @Override
    public List listar() {
        ArrayList<beanTipoProducto> list = new ArrayList<>();
        String sql = "select * from tipo_producto";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bTPdct = new beanTipoProducto();
                bTPdct.setIdtipo_producto(rs.getInt("idtipo_producto"));
                bTPdct.setTipo(rs.getString("tipo"));
                list.add(bTPdct);
            }
        } catch (Exception e) {
            out.print("ERROR" + e);
        }
        return list;
    }

    @Override
    public beanTipoProducto list(int idTPdto) {
        String sql = "select * from tipo_producto where idtipo_producto=" + idTPdto;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bTPdct = new beanTipoProducto();
                bTPdct.setIdtipo_producto(rs.getInt("idtipo_producto"));
                bTPdct.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
            out.print("ERROR" + e);
        }
        return bTPdct;
    }

    @Override
    public boolean add(beanTipoProducto bTPdto) {
        String sql = "INSERT INTO tipo_producto (idtipo_producto, tipo)" + "VALUES ('" + bTPdto.getIdtipo_producto() + "', '" + bTPdto.getTipo() + "');";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            out.print("ERROR" + e);
            return false;
        }
    }

    @Override
    public boolean edit(beanTipoProducto bTPdto) {
        String sql = "UPDATE tipo_producto set tipo = '" + bTPdto.getTipo() + "'where idtipo_producto =" + bTPdto.getIdtipo_producto();
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            out.print("Error" + e);
            return false;

        }
    }

    @Override
    public boolean eliminar(int idTPdto) {
        String sql = "DELETE from tipo_producto where idtipo_producto=" + idTPdto;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            out.print("Error" + e);
            return false;
        }
    }

}
