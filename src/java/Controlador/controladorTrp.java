/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.daoTransporte;
import beans.beanTransporte;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar4rroyo
 */
public class controladorTrp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listarT = "vistaTransporte/lstTrp.jsp";
    String addT = "vistaTransporte/addTrp.jsp";
    String editT = "vistaTransporte/editTrp.jsp";
    beanTransporte bT = new beanTransporte();
    daoTransporte dT = new daoTransporte();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorTrp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorTrp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listarTrp")) {
            acceso = listarT;
        } else if (action.equalsIgnoreCase("addT")) {
            acceso = addT;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String descripcion = request.getParameter("txtDesc");
            bT.setDescripcion(descripcion);
            dT.addTrp(bT);
            acceso = listarT;
        } else if (action.equalsIgnoreCase("editarTrp")) {
            request.setAttribute("idTrp", request.getParameter("idT"));
            acceso = editT;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtIdT"));
            String descripcion = request.getParameter("txtDesc");
            bT.setId_Transporte(id);
            bT.setDescripcion(descripcion);
            dT.editTrp(bT);
            acceso = listarT;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idT"));
            bT.setId_Transporte(id);
            dT.eliminarTrp(id);
            acceso = listarT;
        }

        RequestDispatcher vistaT = request.getRequestDispatcher(acceso);
        vistaT.forward(request, response);
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
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listarTrp")) {
            acceso = listarT;
        } else if (action.equalsIgnoreCase("addT")) {
            acceso = addT;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String descripcion = request.getParameter("txtDesc");
            bT.setDescripcion(descripcion);
            dT.addTrp(bT);
            acceso = listarT;
        } else if (action.equalsIgnoreCase("editarTrp")) {
            request.setAttribute("idTrp", request.getParameter("idT"));
            acceso = editT;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtIdT"));
            String descripcion = request.getParameter("txtDesc");
            bT.setId_Transporte(id);
            bT.setDescripcion(descripcion);
            dT.editTrp(bT);
            acceso = listarT;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idT"));
            bT.setId_Transporte(id);
            dT.eliminarTrp(id);
            acceso = listarT;
        }

        RequestDispatcher vistaT = request.getRequestDispatcher(acceso);
        vistaT.forward(request, response);
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
