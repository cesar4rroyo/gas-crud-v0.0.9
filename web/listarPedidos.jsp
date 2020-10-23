<%-- 
    Document   : listarPedidos.jsp
    Created on : 22 oct. 2020, 18:30:21
    Author     : cesar4rroyo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="beans.beanPedido"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.daoPedido"%>
<%@page import="ModeloDAO.daoPedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
    </head>
    <body>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Producto</th>
                    <th scope="col">Fecha-Inicio</th>
                    <th scope="col">Fecha-Entrega</th>
                    <th scope="col">Repartidor</th>
                    <th scope="col">Estado Pedido</th>
                    <th scope="col">Acciones</th>


                </tr>
            </thead>
            <%
                daoPedido dao = new daoPedido();
                List<beanPedido> list = dao.listarPedido();
                Iterator<beanPedido> iter = list.iterator();
                beanPedido bp = null;
                while (iter.hasNext()) {
                    bp = iter.next();

            %>
            <tbody>
                <tr>                                                                                       
                    <td><%=bp.getId_Pedido()%></td>
                    <td><%=bp.getId_Cliente().getNombre()%></td>
                    <td><%=bp.getId_Producto().getNombre_producto()%></td>
                    <td><%=bp.getFecha_inicio()%></td>
                    <td><%=bp.getFecha_entrega()%></td>
                    <td><%=bp.getId_Repartidor().getNombre()%></td>
                    <td><%=bp.getId_Estado_pedido().getNombre_estado()%></td>
                    <td>
                        <div class="btn-group" >
                            <a class="btn btn-primary" href="delete.jsp?&txtIdEsc=<%=bp.getId_Pedido()%>">
                                <i class="fa fa-pencil-square-o"></i>Eliminar
                            </a>
                            <a class="btn btn-danger" href="editEscuela?&id=<%=bp.getId_Pedido()%>">
                                <i class="fa fa-trash"></i> Editar
                            </a>
                        </div>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
