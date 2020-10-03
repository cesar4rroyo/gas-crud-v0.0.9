package ModeloDAO;

import Config.Conexion;
import Interfaces.epCRUD;
import beans.beanEstadoPed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar4rroyo
 */
public class daoEstadoPed implements epCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanEstadoPed b = new beanEstadoPed();

    @Override
    public List listar() {
        ArrayList<beanEstadoPed> list = new ArrayList<>();
        String sql = "select * from estado_pedido";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanEstadoPed est = new beanEstadoPed();
                est.setId_Estado_pedido(rs.getInt("id_Estado_pedido"));
                est.setTipo_estado(rs.getInt("tipo_estado"));
                est.setNombre_estado(rs.getString("nombre_estado"));
                list.add(est);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return list;
    }

    @Override
    public beanEstadoPed list(int idEst) {
        String sql = "select * from estado_pedido where id_Estado_pedido ="+idEst;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                b.setId_Estado_pedido(rs.getInt("id_Estado_pedido"));
                b.setTipo_estado(rs.getInt("tipo_estado"));
                b.setNombre_estado(rs.getString("nombre_estado"));
                
            }
            }catch(Exception e){
            }
        return b;
    }

    @Override
    public boolean add(beanEstadoPed bEst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(beanEstadoPed bEst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean elimina(int idEst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
