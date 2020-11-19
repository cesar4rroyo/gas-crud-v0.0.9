package ModeloDAO;

import Config.Conexion;
import Interfaces.tCRUD;
import beans.beanTransporte;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class daoTransporte implements tCRUD {

    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanTransporte bTrp = new beanTransporte();

    @Override
    public List listarTrp() {
        ArrayList<beanTransporte> lstTrp = new ArrayList<>();
        String sql = "select * from transporte";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanTransporte bTrp = new beanTransporte();
                bTrp.setId_Transporte(rs.getInt("id_Transporte"));
                bTrp.setDescripcion(rs.getString("descripcion"));
                lstTrp.add(bTrp);
            }
        } catch (Exception e) {
            out.print("ERROR" + e);
        }
        return lstTrp;
    }

    @Override
    public beanTransporte listTrp(int idTrp) {
        String sql = "select * from transporte where id_Transporte=" + idTrp;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bTrp.setId_Transporte(rs.getInt("id_Transporte"));
                bTrp.setDescripcion(rs.getString("descripcion"));

            }
        } catch (Exception e) {
            out.print("ERROR" + e);
        }
        return bTrp;
    }

    @Override
    public boolean addTrp(beanTransporte bTrp) {
        String sql = "INSERT INTO transporte (descripcion)" + "VALUES ('" + bTrp.getDescripcion() + "');";
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
    public boolean editTrp(beanTransporte bTrp) {
        String sql = "UPDATE transporte set descripcion = '" + bTrp.getDescripcion() + "'where id_Transporte =" + bTrp.getId_Transporte();
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
    public boolean eliminarTrp(int idTrp) {
        String sql = "DELETE from transporte where id_Transporte=" + idTrp;
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
