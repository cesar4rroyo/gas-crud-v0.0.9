package ModeloDAO;

import Config.Conexion;
import Interfaces.userCRUD;
import beans.beanUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class daoUsuario implements userCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    beanUsuario bUser = new beanUsuario();

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public beanUsuario list(String uName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(beanUsuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(beanUsuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String uName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public beanUsuario validar(String user, String password) {
        beanUsuario bUser = new beanUsuario();
        String sql = "Select * from user where  username=? and password=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
             rs=ps.executeQuery();
            while(rs.next()){
                bUser.setEmail(rs.getString("email"));
                bUser.setUsername(rs.getString("username"));
                bUser.setTipo(rs.getString("tipo"));
                bUser.setCreate_time(rs.getTimestamp("create_time"));
            }
         
        } catch (Exception e) {
            return null;
        }
        return bUser;
    }

}
