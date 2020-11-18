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

public class daoPedido implements pedCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listarPedido() {
        ArrayList<beanPedido> lstPedido = new ArrayList<>();
        String sql = "SELECT id_Pedidos, fecha_inicio, fecha_entrega, importe_total, pedido.id_Estado_pedido, nombre_estado, pedido.id_Producto, pedido.id_Repartidor, pedido.id_Cliente, "
                + "cliente.nombre as nombreC, producto.nombre_producto as nombrePdto, repartidor.nombre as nombreRep from pedido INNER JOIN estado_pedido ON pedido.id_Estado_pedido = estado_pedido.id_Estado_pedido "
                + "INNER JOIN producto ON  pedido.id_Producto = producto.id_Producto INNER JOIN repartidor ON pedido.id_Repartidor = repartidor.id_Repartidor "
                + "INNER JOIN cliente ON pedido.id_Cliente = cliente.id_Cliente ORDER BY id_Pedidos DESC";

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
                bPed.setImporte_total(rs.getInt("importe_total"));
                bPed.setEstado_Pedido(bEP);
                bPed.setProducto(bPdto);
                bPed.setRepartidor(bRep);
                bPed.setCliente(bCli);

                lstPedido.add(bPed);
            }
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return lstPedido;

    }

    public List listarPedidoRepartidor(String nombre) {
        ArrayList<beanPedido> lstPedido = new ArrayList<>();
        String sql = "SELECT id_Pedidos, fecha_inicio, fecha_entrega, importe_total, "
                + "pedido.id_Estado_pedido, ubicacion, cliente.telefono,"
                + " nombre_estado, pedido.id_Producto, pedido.id_Repartidor, "
                + "pedido.id_Cliente, cliente.nombre as nombreC, producto.nombre_producto as nombrePdto, "
                + "repartidor.nombre as nombreRep from pedido INNER JOIN estado_pedido ON "
                + "pedido.id_Estado_pedido = estado_pedido.id_Estado_pedido INNER JOIN producto ON  "
                + "pedido.id_Producto = producto.id_Producto INNER JOIN repartidor ON "
                + "pedido.id_Repartidor = repartidor.id_Repartidor INNER JOIN cliente ON "
                + "pedido.id_Cliente = cliente.id_Cliente where (repartidor.nombre='" + nombre + "' and pedido.id_Estado_pedido!=5) ORDER BY fecha_inicio ASC";
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
                bCli.setUbicacion(rs.getString("ubicacion"));
                bCli.setTelefono(rs.getString("telefono"));

                bPed.setId_Pedido(rs.getInt("id_Pedidos"));
                bPed.setFecha_inicio(rs.getTimestamp("fecha_inicio"));
                bPed.setFecha_entrega(rs.getTimestamp("fecha_entrega"));
                bPed.setImporte_total(rs.getInt("importe_total"));
                bPed.setEstado_Pedido(bEP);
                bPed.setProducto(bPdto);
                bPed.setRepartidor(bRep);
                bPed.setCliente(bCli);

                lstPedido.add(bPed);
            }
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return lstPedido;
    }

    public List listarPedidoRealizados(String nombre) {
        ArrayList<beanPedido> lstPedido = new ArrayList<>();
        String sql = "SELECT id_Pedidos, fecha_inicio, fecha_entrega, importe_total, "
                + "pedido.id_Estado_pedido, ubicacion, cliente.telefono,"
                + " nombre_estado, pedido.id_Producto, pedido.id_Repartidor, "
                + "pedido.id_Cliente, cliente.nombre as nombreC, producto.nombre_producto as nombrePdto, "
                + "repartidor.nombre as nombreRep from pedido INNER JOIN estado_pedido ON "
                + "pedido.id_Estado_pedido = estado_pedido.id_Estado_pedido INNER JOIN producto ON  "
                + "pedido.id_Producto = producto.id_Producto INNER JOIN repartidor ON "
                + "pedido.id_Repartidor = repartidor.id_Repartidor INNER JOIN cliente ON "
                + "pedido.id_Cliente = cliente.id_Cliente where (repartidor.nombre='" + nombre + "' and pedido.id_Estado_pedido=5) ORDER BY fecha_entrega DESC";
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
                bCli.setUbicacion(rs.getString("ubicacion"));
                bCli.setTelefono(rs.getString("telefono"));

                bPed.setId_Pedido(rs.getInt("id_Pedidos"));
                bPed.setFecha_inicio(rs.getTimestamp("fecha_inicio"));
                bPed.setFecha_entrega(rs.getTimestamp("fecha_entrega"));
                bPed.setImporte_total(rs.getInt("importe_total"));
                bPed.setEstado_Pedido(bEP);
                bPed.setProducto(bPdto);
                bPed.setRepartidor(bRep);
                bPed.setCliente(bCli);

                lstPedido.add(bPed);
            }
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return lstPedido;
    }

    public List listarPedidoCliente(int dni) {
        ArrayList<beanPedido> lstPedido = new ArrayList<>();
        String sql = "SELECT id_Pedidos, fecha_inicio, fecha_entrega, importe_total, "
                + "pedido.id_Estado_pedido, nombre_estado, pedido.id_Producto, pedido.id_Repartidor, "
                + "pedido.id_Cliente, cliente.nombre as nombreC, producto.nombre_producto as nombrePdto, "
                + "repartidor.nombre as nombreRep from pedido INNER JOIN estado_pedido ON "
                + "pedido.id_Estado_pedido = estado_pedido.id_Estado_pedido INNER JOIN producto ON  "
                + "pedido.id_Producto = producto.id_Producto INNER JOIN repartidor ON "
                + "pedido.id_Repartidor = repartidor.id_Repartidor INNER JOIN cliente ON "
                + "pedido.id_Cliente = cliente.id_Cliente where cliente.dni=" + dni;

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
                bPed.setImporte_total(rs.getInt("importe_total"));
                bPed.setEstado_Pedido(bEP);
                bPed.setProducto(bPdto);
                bPed.setRepartidor(bRep);
                bPed.setCliente(bCli);

                lstPedido.add(bPed);
            }
        } catch (Exception e) {
            out.print("Error" + e);
        }
        return lstPedido;

    }

    @Override
    public beanPedido list(int idPedido) {
        String sql = "SELECT id_Pedidos, fecha_inicio, fecha_entrega, importe_total, pedido.id_Estado_pedido, nombre_estado, pedido.id_Producto, pedido.id_Repartidor, pedido.id_Cliente, "
                + "cliente.nombre as nombreC, producto.nombre_producto as nombrePdto, repartidor.nombre as nombreRep from pedido INNER JOIN estado_pedido ON pedido.id_Estado_pedido = estado_pedido.id_Estado_pedido "
                + "INNER JOIN producto ON  pedido.id_Producto = producto.id_Producto INNER JOIN repartidor "
                + "ON pedido.id_Repartidor = repartidor.id_Repartidor "
                + "INNER JOIN cliente ON pedido.id_Cliente = cliente.id_Cliente where id_Pedidos=" + idPedido;

        beanPedido bPed = new beanPedido();
        beanEstadoPed bEP = new beanEstadoPed();
        beanProducto bPdto = new beanProducto();
        beanRepartidor bRep = new beanRepartidor();
        beanCliente bCli = new beanCliente();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

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
                bPed.setImporte_total(rs.getInt("importe_total"));
                bPed.setEstado_Pedido(bEP);
                bPed.setProducto(bPdto);
                bPed.setRepartidor(bRep);
                bPed.setCliente(bCli);
            }
        } catch (Exception e) {
        }
        return bPed;
    }

    @Override
    public boolean add(beanPedido bPedido) {
        String sql = "INSERT INTO pedido (importe_total, id_Estado_pedido, id_Producto, "
                + "id_Repartidor, id_Cliente, id_Pedidos) VALUES ('" + bPedido.getImporte_total() + "', '"
                + bPedido.getEstado_Pedido().getId_Estado_pedido() + "', '"
                + bPedido.getProducto().getId_Producto() + "', '" + bPedido.getRepartidor().getId_Repartidor() + "', '" + bPedido.getCliente().getId_Cliente() + "', '" + bPedido.getId_Pedido() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addPedidoTemporal(beanPedido bPedido) {
        String sql = "INSERT INTO pedido (importe_total, id_Estado_pedido, id_Producto, "
                + "id_Repartidor, id_Cliente, id_Pedidos) VALUES ('" + bPedido.getImporte_total() + "', '1', '"
                + bPedido.getProducto().getId_Producto() + "', '1', '" + bPedido.getCliente().getId_Cliente() + "', '" + bPedido.getId_Pedido() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String edit(beanPedido bPedido) {
        String sql = "UPDATE pedido set importe_total= '" + bPedido.getImporte_total() + "',"
                + " id_Estado_pedido= '" + bPedido.getEstado_Pedido().getId_Estado_pedido() + "',"
                + " id_Producto= '" + bPedido.getProducto().getId_Producto() + "',"
                + "fecha_entrega='" + bPedido.getFecha_entrega() + "',"
                + " id_Repartidor= '" + bPedido.getRepartidor().getId_Repartidor() + "',"
                + " id_Cliente= '" + bPedido.getCliente().getId_Cliente() + "' WHERE id_Pedidos=" + bPedido.getId_Pedido();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            return "Actualizado correctamente";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String eliminar(int idPedido) {
        String out;
        String sql = "DELETE FROM pedido where id_Pedidos=" + idPedido;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            out = "Eliminado Correctamente";
            return out;
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
