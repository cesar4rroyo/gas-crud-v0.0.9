/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.pedCRUD;
import beans.beanCliente;
import beans.beanEstadoPed;
import beans.beanPedido;
import beans.beanProducto;
import beans.beanRepartidor;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author cesar4rroyo
 */
public class daoPedido implements pedCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listarPedido() {
        ArrayList<beanPedido> lstPedido = new ArrayList<>();
            String sql = "SELECT id_Pedidos, fecha_inicio, fecha_entrega, precio, pedido.id_Estado_pedido, nombre_estado, pedido.id_Producto, pedido.id_Repartidor, pedido.id_Cliente, "
                + "cliente.nombre as nombreC, producto.nombre_producto as nombrePdto, repartidor.nombre as nombreRep from pedido INNER JOIN estado_pedido ON pedido.id_Estado_pedido = estado_pedido.id_Estado_pedido "
                + "INNER JOIN producto ON  pedido.id_Producto = producto.id_Producto INNER JOIN repartidor ON pedido.id_Repartidor = repartidor.id_Repartidor INNER JOIN cliente ON pedido.id_Cliente = cliente.id_Cliente";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beanPedido bPed = new beanPedido();
                beanEstadoPed bEP = new beanEstadoPed();
                beanProducto bPdto = new beanProducto();
                beanRepartidor bRep = new beanRepartidor();
                beanCliente bCli = new beanCliente();
                
                bEP.setId_Estado_pedido(rs.getInt("id_Estado_pedido"));
                bEP.setNombre_estado(rs.getString("nombre_estado"));

                bPdto.setId_Producto(rs.getInt("id_Producto"));
                bPdto.setNombre_producto(rs.getString("nombrePdto"));

                bRep.setId_Repartidor(rs.getInt("id_Repartidor"));
                bRep.setNombre(rs.getString("nombreRep"));

                bCli.setId_Cliente(rs.getInt("id_Cliente"));
                bCli.setNombre(rs.getString("nombreC"));

                bPed.setId_Pedido(rs.getInt("id_Pedidos"));
                bPed.setFecha_inicio(rs.getTimestamp("fecha_inicio"));
                bPed.setFecha_entrega(rs.getTimestamp("fecha_entrega"));
                bPed.setPrecio(rs.getInt("precio"));
                bPed.setId_Estado_pedido(bEP);
                bPed.setId_Producto(bPdto);
                bPed.setId_Repartidor(bRep);
                bPed.setId_Cliente(bCli);

                lstPedido.add(bPed);
            }
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return lstPedido;

    }

    @Override
    public beanPedido list(int idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(beanPedido bPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(beanPedido bPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
