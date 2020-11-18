/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.daoPedido;
import beans.beanPedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar4rroyo
 */
public class controladorPedidoCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rutaUrl = request.getServletPath();
        if (rutaUrl.equals("/buscarPedido.html")) {
            listar(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        daoPedido dPed = new daoPedido();
        beanPedido bPed = new beanPedido();
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        try {
            List<beanPedido> lstPedido = dPed.listarPedidoCliente(dni);
            String html = "";

            if (lstPedido.isEmpty()) {
                html = "<p>Aún no haz hecho pedidos</p>";

            } else {
                html = "<table class='table'>"
                        + "<thead>"
                        + "<tr>"
                        + "     <th scope='col'>Nombre</th>"
                        + "     <th scope='col'>Producto</th>"
                        + "     <th scope='col'>Precio</th>"
                        + "     <th scope='col'>Estado del Pedido</th>"
                        + "</tr>"
                        + "</thead>";
                for (int i = 0; i < lstPedido.size(); i++) {
                    html = html + "<tr><td>" + lstPedido.get(i).getCliente().getNombre() + "</td><td>"
                            + lstPedido.get(i).getProducto().getNombre_producto() + "</td><td>"
                            + lstPedido.get(i).getImporte_total() + "</td><td>"
                            + lstPedido.get(i).getEstado_Pedido().getNombre_estado() + "</td><tr>";
                }
                html = html + "</table>";

            }

            out.print(html);
        } catch (Exception e) {
            out.print("Ha ocurrido un error: " + e);
        }

    }

    public void buscar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            daoPedido dPed = new daoPedido();
            beanPedido bPed = new beanPedido();
            bPed = dPed.list(Integer.parseInt(request.getParameter("txtDNI")));
            out.print(bPed.getCliente() + ","
                    + bPed.getProducto().getNombre_producto()
                    + "," + bPed.getFecha_inicio() + ","
                    + bPed.getEstado_Pedido().getNombre_estado());
        } catch (Exception ex) {
            out.print("Error: " + ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
