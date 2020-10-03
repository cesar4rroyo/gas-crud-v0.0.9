/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.daoCliente;
import beans.beanCliente;
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
public class controladorCliente extends HttpServlet {

    String listar = "vistaCliente/listar.jsp";
    String add = "vistaCliente/add.jsp";
    String edit = "vistaCliente/edit.jsp";
    beanCliente b = new beanCliente();
    daoCliente dao = new daoCliente();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {

            String nombre = request.getParameter("txtNom");
            String apellido = request.getParameter("txtApe");
            String ubicacion = request.getParameter("txtUbi");
            String dni = request.getParameter("txtDni");
            String telefono = request.getParameter("txtTel");
            String foto = request.getParameter("txtFot");

            b.setNombre(nombre);
            b.setApellido(apellido);
            b.setUbicacion(ubicacion);
            b.setDni(dni);
            b.setTelefono(telefono);
            b.setFoto_casa(foto);
            dao.add(b);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idcli", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));

            String nombre = request.getParameter("txtNom");
            String apellido = request.getParameter("txtApe");
            String ubicacion = request.getParameter("txtUbi");
            String dni = request.getParameter("txtDni");
            String telefono = request.getParameter("txtTel");
            String foto = request.getParameter("txtFot");

            b.setId_Cliente(id);
            b.setNombre(nombre);
            b.setApellido(apellido);
            b.setUbicacion(ubicacion);
            b.setDni(dni);
            b.setTelefono(telefono);
            b.setFoto_casa(foto);

            dao.edit(b);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            b.setId_Cliente(id);
            dao.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

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
