package ModeloDAO;

import Config.Conexion;
import Interfaces.pCRUD;
import beans.beanProveedor;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoProveedor implements pCRUD {

    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanProveedor bProv = new beanProveedor();

    @Override
    public List listar() {
        ArrayList<beanProveedor> lstProv = new ArrayList<>();
        String sql = "select * from provedor";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanProveedor bProv = new beanProveedor();
                bProv.setId_Provedor(rs.getInt("id_Provedor"));
                bProv.setNombre(rs.getString("nombre"));
                bProv.setRuc(rs.getString("ruc"));
                bProv.setTelefono(rs.getString("telefono"));
                bProv.setDireccion_provedor(rs.getString("direccion_provedor"));
                lstProv.add(bProv);
            }
        } catch (Exception e) {
        }
        return lstProv;
    }

    @Override
    public beanProveedor list(int idProv) {
        String sql = "select * from provedor where id_Provedor=" + idProv;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bProv.setId_Provedor(rs.getInt("id_Provedor"));
                bProv.setNombre(rs.getString("nombre"));
                bProv.setRuc(rs.getString("ruc"));
                bProv.setTelefono(rs.getString("telefono"));
                bProv.setDireccion_provedor(rs.getString("direccion_provedor"));

            }
        } catch (Exception e) {
        }
        return bProv;
    }

    @Override
    public boolean add(beanProveedor bProv) {
        String sql = "INSERT INTO provedor (nombre, ruc, telefono, direccion_provedor) VALUES ('" + bProv.getNombre() + "', '" + bProv.getRuc()
                + "', '" + bProv.getTelefono() + "', '" + bProv.getDireccion_provedor() + "')";
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
    public boolean edit(beanProveedor bProv) {
        String sql = "UPDATE provedor set nombre = '" + bProv.getNombre() + "' ,"
                + "ruc = '" + bProv.getRuc() + "',"
                + "telefono = '" + bProv.getTelefono() + "',"
                + "direccion_provedor = '" + bProv.getDireccion_provedor() + "'"
                + "where id_Provedor =" + bProv.getId_Provedor();
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
    public boolean eliminar(int idProv) {
        String sql = "DELETE from provedor where id_Provedor=" + idProv;
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

    public boolean buscar(String ruc) {
        String sql = "select * from provedor where ruc=" + ruc;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }

    }

}
