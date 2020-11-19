
package Controlador;


import beans.beanProveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logicProveedor;


public class Controlador extends HttpServlet {

    String listar = "vistaProveedor/listar.jsp";
    String add = "vistaProveedor/add.jsp";
    String edit = "vistaProveedor/edit.jsp";
    beanProveedor bP = new beanProveedor();
    logicProveedor lgP=new logicProveedor();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
            String ruc = request.getParameter("txtRuc");
            String telefono = request.getParameter("txtTel");
            String direccion = request.getParameter("txtDir");
            bP.setNombre(nombre);
            bP.setRuc(ruc);
            bP.setTelefono(telefono);
            bP.setDireccion_provedor(direccion);
            lgP.insertar(bP);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idProv", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtNom");
            String ruc = request.getParameter("txtRuc");
            String telefono = request.getParameter("txtTel");
            String direccion = request.getParameter("txtDir");
            bP.setId_Provedor(id);
            bP.setNombre(nombre);
            bP.setRuc(ruc);
            bP.setTelefono(telefono);
            bP.setDireccion_provedor(direccion);
            lgP.actualizar(bP);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            bP.setId_Provedor(id);
            lgP.eliminar(id);
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
