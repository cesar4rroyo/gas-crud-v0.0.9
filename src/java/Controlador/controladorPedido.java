/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.daoCliente;
import ModeloDAO.daoEstadoPed;
import ModeloDAO.daoProducto;
import ModeloDAO.daoRepartidor;
import beans.beanCliente;
import beans.beanEstadoPed;
import beans.beanPedido;
import beans.beanProducto;
import beans.beanRepartidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.logicPedido;
import java.util.Calendar;

public class controladorPedido extends HttpServlet {

    beanPedido bPed;

    beanCliente bC;
    daoCliente dC;

    beanProducto bPdt;
    daoProducto dPdt;

    beanRepartidor bRep;
    daoRepartidor dRep;

    beanEstadoPed bEP;
    daoEstadoPed dEP;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String rutaUrl = request.getServletPath();
        if (rutaUrl.equals("/addPedido")) {
            agregarPedidoTemporal(request, response);
        } else if (rutaUrl.equals("/add")) {
            RequestDispatcher vista = request.getRequestDispatcher("vistaPedido/addPedido.jsp");
            vista.forward(request, response);
        } else if (rutaUrl.equals("/edit")) {
            request.setAttribute("id", request.getParameter("id"));
            RequestDispatcher vista = request.getRequestDispatcher("vistaPedido/editPedido.jsp");
            vista.forward(request, response);
        } else if (rutaUrl.equals("/delete.jsp")) {
            eliminar(request, response);
        } else if (rutaUrl.equals("/listPedido")) {
            RequestDispatcher vista = request.getRequestDispatcher("vistaPedido/listarPedido.jsp");
            vista.forward(request, response);
        } else if (rutaUrl.equals("/agregarPedidoCompleto")) {
            agregarPedidoCompleto(request, response);
        } else if (rutaUrl.equals("/actualizarPedido")) {
            actualizar(request, response);
        } else if (rutaUrl.equals("/actualizarPedidoRepartidor")) {
            request.setAttribute("id", request.getParameter("id"));
            RequestDispatcher vista = request.getRequestDispatcher("seccionRepartidor/editarPedido.jsp");
            vista.forward(request, response);
        } else if (rutaUrl.equals("/editPedidoRepartidor")) {
            actualizarRepartidor(request, response);
        } else if (rutaUrl.equals("/listarPedidosRepartidor")) {
            RequestDispatcher vista = request.getRequestDispatcher("seccionRepartidor/listarPedido.jsp");
            vista.forward(request, response);
        } else if (rutaUrl.equals("/listarPedidosRealizados")) {
            RequestDispatcher vista = request.getRequestDispatcher("seccionRepartidor/pedidosRealizados.jsp");
            vista.forward(request, response);
        }
    }

    public void actualizarRepartidor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        esta es la seccion donde el repartidor actualizara el estado del pedido
        PrintWriter out = response.getWriter();
        bPed = new beanPedido();
        bC = new beanCliente();
        dC = new daoCliente();
        bPdt = new beanProducto();
        dPdt = new daoProducto();
        bRep = new beanRepartidor();
        dRep = new daoRepartidor();
        bEP = new beanEstadoPed();
        dEP = new daoEstadoPed();
        logicPedido lgPedido = new logicPedido();
        Calendar calendar = Calendar.getInstance();
        Timestamp fecha_entrega = new Timestamp(calendar.getTime().getTime());
        bC = dC.list(Integer.parseInt(request.getParameter("txtIdCli")));
        bPdt = dPdt.list(Integer.parseInt(request.getParameter("txtIdPdto")));
        bRep = dRep.listRep(Integer.parseInt(request.getParameter("txtIdRep")));
        bEP = dEP.list(Integer.parseInt(request.getParameter("txtIdEP")));
        bPed.setId_Pedido(Integer.parseInt(request.getParameter("txtIdPed")));
        bPed.setImporte_total(bPdt.getPrecio());
        bPed.setCliente(bC);
        bPed.setProducto(bPdt);
        bPed.setEstado_Pedido(bEP);
        bPed.setRepartidor(bRep);
        bPed.setFecha_entrega(fecha_entrega);

        try {
            String mensajeLogic = lgPedido.actualizar(bPed, bPdt);
            out.print(mensajeLogic);
            String acceso = "listarPedidosRealizados";
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        } catch (IOException e) {
            out.print(e);
        }
    }

    public void agregarPedidoTemporal(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//Aca se va a agregar el pedido temporal este pedido
//no va tener repartidor aun asignado, y el estado pedido sera por defecto el primero, "en espera"
        ArrayList<beanProducto> lstProducto;
        HttpSession sesion;
        sesion = request.getSession(false);
        lstProducto = (ArrayList<beanProducto>) sesion.getAttribute("carroCompras");
        Iterator<beanProducto> iter1 = lstProducto.iterator();
        beanProducto bPdto1 = null;
        int idProducto = 1;
        for (beanProducto b : lstProducto) {
            idProducto = b.getId_Producto();
        }

        PrintWriter out = response.getWriter();
        bPed = new beanPedido();
        bC = new beanCliente();
        dC = new daoCliente();
        bPdt = new beanProducto();
        dPdt = new daoProducto();
        logicPedido lgPedido = new logicPedido();

        bC = dC.list(Integer.parseInt(request.getParameter("txtIdCli")));
        bPdt = dPdt.list(idProducto);

        bPed.setImporte_total(Integer.parseInt(request.getParameter("txtImpTot")));
        bPed.setCliente(bC);
        bPed.setProducto(bPdt);

        try {
            out.print(lgPedido.agregarPedidoTemporal(bPed));
            String acceso = "pedido.jsp";
            sesion.invalidate();
            request.setAttribute("compra", "success");
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        } catch (IOException e) {
            out.print(e);
        }

    }

    public void agregarPedidoCompleto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        bPed = new beanPedido();
        bC = new beanCliente();
        dC = new daoCliente();
        bPdt = new beanProducto();
        dPdt = new daoProducto();
        bRep = new beanRepartidor();
        dRep = new daoRepartidor();
        bEP = new beanEstadoPed();
        dEP = new daoEstadoPed();
        logicPedido lgPedido = new logicPedido();

        bC = dC.list(Integer.parseInt(request.getParameter("txtIdCli")));
        bPdt = dPdt.list(Integer.parseInt(request.getParameter("txtIdPdto")));
        bRep = dRep.listRep(Integer.parseInt(request.getParameter("txtIdRep")));
        bEP = dEP.list(Integer.parseInt(request.getParameter("txtIdEP")));

        bPed.setImporte_total(bPdt.getPrecio());
        bPed.setCliente(bC);
        bPed.setProducto(bPdt);
        bPed.setEstado_Pedido(bEP);
        bPed.setRepartidor(bRep);

        try {
            lgPedido.agregarPedidoCompleto(bPed);
            String acceso = "listPedido";
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        } catch (IOException e) {
            out.print(e);
        }

    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        logicPedido lgPedido = new logicPedido();
        bPed = new beanPedido();
        bC = new beanCliente();
        dC = new daoCliente();
        bPdt = new beanProducto();
        dPdt = new daoProducto();
        bRep = new beanRepartidor();
        dRep = new daoRepartidor();
        bEP = new beanEstadoPed();
        dEP = new daoEstadoPed();
        Calendar calendar = Calendar.getInstance();
        Timestamp fecha_entrega = new Timestamp(calendar.getTime().getTime());

        bC = dC.list(Integer.parseInt(request.getParameter("txtIdCli")));
        bPdt = dPdt.list(Integer.parseInt(request.getParameter("txtIdPdto")));
        bRep = dRep.listRep(Integer.parseInt(request.getParameter("txtIdRep")));
        bEP = dEP.list(Integer.parseInt(request.getParameter("txtIdEP")));
        bPed.setId_Pedido(Integer.parseInt(request.getParameter("txtIdPed")));
        bPed.setImporte_total(bPdt.getPrecio());
        bPed.setCliente(bC);
        bPed.setProducto(bPdt);
        bPed.setEstado_Pedido(bEP);
        bPed.setRepartidor(bRep);
        bPed.setFecha_entrega(fecha_entrega);

        try {
            String mensajeLogic = lgPedido.actualizar(bPed, bPdt);
            out.print(mensajeLogic);
            String acceso = "listPedido";
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        } catch (IOException e) {
            out.print(e);
        }
    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logicPedido lgPedido = new logicPedido();
        PrintWriter out = response.getWriter();
        int id_pedido = Integer.parseInt(request.getParameter("txtIdPedido"));
        try {
            out.print(lgPedido.eliminar(id_pedido));
            String acceso = "listPedido";
            response.sendRedirect(acceso);
        } catch (IOException e) {
            out.print(e);
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
