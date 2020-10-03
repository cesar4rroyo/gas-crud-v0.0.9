/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.daoRepartidor;
import beans.beanRepartidor;
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
public class controladorRep extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listarRep = "vistaRepartidor/lstRep.jsp";
    String addRep = "vistaRepartidor/addRep.jsp";
    String editRep = "vistaRepartidor/editRep.jsp";
    beanRepartidor bR = new beanRepartidor();
    daoRepartidor dR = new daoRepartidor();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorRep</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorRep at " + request.getContextPath() + "</h1>");
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
        if (action.equalsIgnoreCase("listar")) {
            acceso = listarRep;
        } else if (action.equalsIgnoreCase("addR")) {
            acceso = addRep;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String nombre = request.getParameter("txtNomRep");
            String apellido = request.getParameter("txtApeRep");
            String telefono = request.getParameter("txtTelRep");
            String dni = request.getParameter("txtDniRep");
            int id_Transporte = Integer.parseInt(request.getParameter("txtIdTrp"));
            bR.setNombre(nombre);
            bR.setApeliido(apellido);
            bR.setTelefono(telefono);
            bR.setDni(dni);
            bR.setId_Transporte(id_Transporte);
            dR.addRep(bR);
            acceso = listarRep;
        } else if (action.equalsIgnoreCase("editarR")) {
            request.setAttribute("idRep", request.getParameter("idR"));
            acceso = editRep;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int id = Integer.parseInt(request.getParameter("txtIdRep"));
            String nombre = request.getParameter("txtNomRep");
            String apellido = request.getParameter("txtApeRep");
            String telefono = request.getParameter("txtTelRep");
            String dni = request.getParameter("txtDniRep");
            int id_Transporte = Integer.parseInt(request.getParameter("txtIdTrp"));
            bR.setId_Repartidor(id);
            bR.setNombre(nombre);
            bR.setApeliido(apellido);
            bR.setTelefono(telefono);
            bR.setDni(dni);
            bR.setId_Transporte(id_Transporte);
            dR.editRep(bR);
            acceso = listarRep;
        } else if (action.equalsIgnoreCase("eliminarR")) {
            id = Integer.parseInt(request.getParameter("idR"));
            bR.setId_Repartidor(id);
            dR.eliminarRep(id);
            acceso = listarRep;
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
