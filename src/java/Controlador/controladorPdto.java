/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.daoProducto;
import ModeloDAO.daoTipoProducto;
import beans.beanProducto;
import beans.beanTipoProducto;
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
public class controladorPdto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listar = "vistaProducto/listarPdto.jsp";
    String add = "vistaProducto/addPdto.jsp";
    String edit = "vistaProducto/editPdto.jsp";
    beanProducto bPdto = new beanProducto();
    daoProducto dPdto = new daoProducto();
    beanTipoProducto bTPdto = new beanTipoProducto();
    daoTipoProducto dTPdto = new daoTipoProducto();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorPdto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorPdto at " + request.getContextPath() + "</h1>");
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
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            //id = Integer.parseInt(request.getParameter("txtIdPdto"));
            bTPdto = dTPdto.list(Integer.parseInt(request.getParameter("idTipoPdto")));
            String nombre = request.getParameter("txtNom");
            String descripcion = request.getParameter("txtDescripcion");
            String img = request.getParameter("txtImagen");
            int precio = Integer.parseInt(request.getParameter("txtPrecio"));
            //bPdto.setId_Producto(id);
            bPdto.setNombre_producto(nombre);
            bPdto.setDescripcion(descripcion);
            bPdto.setImage_ref(img);
            bPdto.setTipoProducto(bTPdto);
            bPdto.setPrecio(precio);
            dPdto.add(bPdto);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idPdto", request.getParameter("idP"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            bTPdto = dTPdto.list(Integer.parseInt(request.getParameter("idTipoPdto")));
            int id = Integer.parseInt(request.getParameter("txtIdPdto"));
            String nombre = request.getParameter("txtNom");
            String descripcion = request.getParameter("txtDescripcion");
            String tipo = request.getParameter("txtTipo");
            String img = request.getParameter("txtImagen");
            int precio = Integer.parseInt(request.getParameter("txtPrecio"));
            bPdto.setId_Producto(id);
            bPdto.setNombre_producto(nombre);
            bPdto.setDescripcion(descripcion);
            bPdto.setTipoProducto(bTPdto);
            bPdto.setPrecio(precio);
            bPdto.setImage_ref(img);
            dPdto.edit(bPdto);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idP"));
            bPdto.setId_Producto(id);
            dPdto.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vistaProducto = request.getRequestDispatcher(acceso);
        vistaProducto.forward(request, response);
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
