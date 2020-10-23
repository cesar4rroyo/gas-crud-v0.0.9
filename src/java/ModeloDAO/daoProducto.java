package ModeloDAO;

import Config.Conexion;
import Interfaces.pdtoCRUD;
import beans.beanProducto;
import beans.beanTipoProducto;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class daoProducto implements pdtoCRUD {

    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanProducto bPdto;
    beanTipoProducto bTPdto;

    @Override
    public List listar() {
        ArrayList<beanProducto> lstPdto = new ArrayList<>();
        String sql = "select id_Producto, precio, nombre_producto, descripcion, image_ref, "
                + "idtipo_producto, tipo  FROM producto "
                + "INNER JOIN tipo_producto ON producto.id_tipo_producto=tipo_producto.idtipo_producto";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bPdto = new beanProducto();
                bTPdto = new beanTipoProducto();

                bTPdto.setIdtipo_producto(rs.getInt("idtipo_producto"));
                bTPdto.setTipo(rs.getString("tipo"));

                bPdto.setId_Producto(rs.getInt("id_Producto"));
                bPdto.setNombre_producto(rs.getString("nombre_producto"));
                bPdto.setDescripcion(rs.getString("descripcion"));
                bPdto.setImage_ref(rs.getString("image_ref"));
                bPdto.setPrecio(rs.getInt("precio"));
                bPdto.setTipoProducto(bTPdto);

                lstPdto.add(bPdto);
            }
        } catch (Exception e) {
        }
        return lstPdto;
    }

    @Override
    public beanProducto list(int idPdto) {
        String sql = "select id_Producto, nombre_producto, descripcion, image_ref, "
                + "idtipo_producto, tipo  FROM producto "
                + "INNER JOIN tipo_producto ON producto.id_tipo_producto=tipo_producto.idtipo_producto where id_Producto=" + idPdto;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bPdto = new beanProducto();
                bTPdto = new beanTipoProducto();
                bTPdto.setIdtipo_producto(rs.getInt("idtipo_producto"));
                bTPdto.setTipo(rs.getString("tipo"));

                bPdto.setId_Producto(rs.getInt("id_Producto"));
                bPdto.setNombre_producto(rs.getString("nombre_producto"));
                bPdto.setDescripcion(rs.getString("descripcion"));
                bPdto.setImage_ref(rs.getString("image_ref"));
                bPdto.setPrecio(rs.getInt("precio"));
                bPdto.setTipoProducto(bTPdto);

            }
        } catch (Exception e) {
        }
        return bPdto;
    }

    @Override
    public boolean add(beanProducto bPdto) {
        String sql = "INSERT INTO producto (nombre_producto, descripcion, image_ref,precio,  id_tipo_producto) VALUES ('" + bPdto.getNombre_producto() + "', '" + bPdto.getDescripcion()
                + "', '" + bPdto.getImage_ref()+ "', '" + bPdto.getPrecio() + "', '"+bPdto.getTipoProducto().getIdtipo_producto()+"')";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return false;
    }

    @Override
    public boolean edit(beanProducto bPdto) {

        String sql = "UPDATE producto set nombre_producto = '" + bPdto.getNombre_producto() + "' ,"
                + "descripcion = '" + bPdto.getDescripcion() + "',"
                + "precio = '" + bPdto.getPrecio() + "',"
                + "image_ref = '" + bPdto.getImage_ref() + "', id_tipo_producto = '"+bPdto.getTipoProducto().getIdtipo_producto()+"'"
                + "where id_Producto =" + bPdto.getId_Producto();
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int idPdto) {

        String sql = "DELETE from producto where id_Producto=" + idPdto;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return false;
    }

}
