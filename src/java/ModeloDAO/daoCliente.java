package ModeloDAO;

import Config.Conexion;
import beans.beanCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.cCRUD;

public class daoCliente implements cCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanCliente b = new beanCliente();

    @Override
    public List listar() {
        ArrayList<beanCliente> list = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanCliente cli = new beanCliente();
                cli.setId_Cliente(rs.getInt("id_Cliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setUbicacion(rs.getString("ubicacion"));
                cli.setDni(rs.getString("dni"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setFoto_casa(rs.getString("foto_casa"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public beanCliente buscarDni(int dni) {
        String sql = "select * from cliente where dni=" + dni;
        beanCliente b1 = new beanCliente();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                b1.setId_Cliente(rs.getInt("id_Cliente"));
                b1.setNombre(rs.getString("nombre"));
                b1.setApellido(rs.getString("apellido"));
                b1.setUbicacion(rs.getString("ubicacion"));
                b1.setDni(rs.getString("dni"));
                b1.setTelefono(rs.getString("telefono"));
                b1.setFoto_casa(rs.getString("foto_casa"));
            }
        } catch (Exception e) {
        }
        return b1;
    }

    @Override
    public beanCliente list(int id) {
        String sql = "select * from cliente where id_Cliente =" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                b.setId_Cliente(rs.getInt("id_Cliente"));
                b.setNombre(rs.getString("nombre"));
                b.setApellido(rs.getString("apellido"));
                b.setUbicacion(rs.getString("ubicacion"));
                b.setDni(rs.getString("dni"));
                b.setTelefono(rs.getString("telefono"));
                b.setFoto_casa(rs.getString("foto_casa"));
            }
        } catch (Exception e) {
        }
        return b;

    }

    @Override
    public boolean add(beanCliente cli) {
        String sql = "INSERT INTO cliente(nombre,apellido,ubicacion,dni,telefono,foto_casa)VALUES ('" + cli.getNombre() + "' , '" + cli.getApellido()
                + "', '" + cli.getUbicacion() + "' , '" + cli.getDni() + "', '" + cli.getTelefono() + "' , '" + cli.getFoto_casa() + "');";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;

    }

    @Override
    public boolean edit(beanCliente cli) {
        String sql = "UPDATE cliente set nombre = '" + cli.getNombre() + "',"
                + "apellido =  '" + cli.getApellido() + "',"
                + "ubicacion = '" + cli.getUbicacion() + "',"
                + "dni = '" + cli.getDni() + "',"
                + "telefono = '" + cli.getTelefono() + "',"
                + "foto_casa = '" + cli.getFoto_casa() + "'"
                + "where id_Cliente =" + cli.getId_Cliente();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;

    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE from cliente where id_Cliente =" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
