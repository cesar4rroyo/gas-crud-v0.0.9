
package ModeloDAO;

import Config.Conexion;
import Interfaces.pdtoCRUD;
import beans.beanProducto;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class daoProducto implements pdtoCRUD
{
    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanProducto bPdto = new beanProducto();

    @Override
    public List listar() 
    {
        ArrayList<beanProducto> lstPdto = new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanProducto bPdto = new beanProducto();
                bPdto.setId_Producto(rs.getInt("id_Producto"));
                bPdto.setNombre_producto(rs.getString("nombre_producto"));
                bPdto.setDescripcion(rs.getString("descripcion"));
                bPdto.setTipo_producto(rs.getString("tipo_producto"));
                bPdto.setImage_ref(rs.getString("image_ref"));
                lstPdto.add(bPdto);
            }
        } catch (Exception e) {
        }
        return lstPdto;
    }

    @Override
    public beanProducto list(int idPdto) 
    {
        String sql = "select * from producto where id_Producto="+idPdto;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bPdto.setId_Producto(rs.getInt("id_Producto"));
                bPdto.setNombre_producto(rs.getString("nombre_producto"));
                bPdto.setDescripcion(rs.getString("descripcion"));
                bPdto.setTipo_producto(rs.getString("tipo_producto"));
                bPdto.setImage_ref(rs.getString("image_ref"));
               
            }
        } catch (Exception e) {
        }
        return bPdto;
    }

    @Override
    public boolean add(beanProducto bPdto) {
        String sql = "INSERT INTO producto (nombre_producto, descripcion, tipo_producto, image_ref) VALUES ('" + bPdto.getNombre_producto() + "', '" + bPdto.getDescripcion()
                + "', '" + bPdto.getTipo_producto() + "', '" + bPdto.getImage_ref() + "')";
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
                + "tipo_producto = '" + bPdto.getTipo_producto() + "',"
                + "image_ref = '" + bPdto.getImage_ref() + "'"
                + "where id_Producto =" + bPdto.getId_Producto();
      try{
          con = cnx.getConnection();
          ps = con.prepareStatement(sql);
          ps.executeUpdate();
      }catch (Exception e){
          out.print("Error"+e);
      }
        return false;
    }

    @Override
    public boolean eliminar(int idPdto) {
        
        String sql = "DELETE from producto where id_Producto="+idPdto;
        try {
            con=cnx.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
          out.print("Error"+e);
        }
        return false;
    }
    
}
