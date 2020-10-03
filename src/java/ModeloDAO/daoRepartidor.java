
package ModeloDAO;

import Config.Conexion;
import Interfaces.rCRUD;
import beans.beanRepartidor;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class daoRepartidor implements rCRUD{
    
    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanRepartidor bRep = new beanRepartidor();

    @Override
    public List listarRep() {
       ArrayList<beanRepartidor> lstRep = new ArrayList<>();
        String sql = "select * from repartidor";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanRepartidor bRep = new beanRepartidor();
                bRep.setId_Repartidor(rs.getInt("id_Repartidor"));
                bRep.setNombre(rs.getString("nombre"));
                bRep.setApeliido(rs.getString("apellido"));
                bRep.setTelefono(rs.getString("telefono"));
                bRep.setDni(rs.getString("dni"));
                bRep.setId_Transporte(rs.getInt("id_Transporte"));
                lstRep.add(bRep);
            }
        } catch (Exception e) {
        }
        return lstRep;
    }

    @Override
    public beanRepartidor listRep(int idRep) {
       String sql = "select * from repartidor where id_Repartidor="+idRep;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bRep.setId_Repartidor(rs.getInt("id_Repartidor"));
                bRep.setNombre(rs.getString("nombre"));
                bRep.setApeliido(rs.getString("apellido"));
                bRep.setTelefono(rs.getString("telefono"));
                bRep.setDni(rs.getString("dni"));
                bRep.setId_Transporte(rs.getInt("id_Transporte"));
               
            }
        } catch (Exception e) {
        }
        return bRep;
    }

    @Override
    public boolean addRep(beanRepartidor bRep) {
        String sql = "INSERT INTO repartidor (nombre, apellido, telefono, dni, id_Transporte) VALUES ('" + bRep.getNombre() + "', '" + bRep.getApeliido()
                + "', '" + bRep.getTelefono() + "', '" + bRep.getDni() + "', '" + bRep.getId_Transporte() + "')";
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
    public boolean editRep(beanRepartidor bRep) {
       String sql = "UPDATE repartidor set nombre = '" + bRep.getNombre() + "' ,"
                + "apellido = '" + bRep.getApeliido() + "',"
                + "telefono = '" + bRep.getTelefono() + "',"
                + "dni = '" + bRep.getDni() + "',"
                + "id_Transporte = '" + bRep.getId_Transporte() + "'"
                + "where id_Repartidor =" + bRep.getId_Repartidor();
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
    public boolean eliminarRep(int idRep) {
        String sql = "DELETE from repartidor where id_Repartidor="+idRep;
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
