package Controlador;


import beans.beanCliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logicCliente;


public class controladorCliente extends HttpServlet {

    String listar = "vistaCliente/listar.jsp";
    String add = "vistaCliente/add.jsp";
    String edit = "vistaCliente/edit.jsp";
    beanCliente b = new beanCliente();
    logicCliente lgC=new logicCliente();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String rutaUrl = request.getServletPath();
        if (rutaUrl.equals("/agregarCliente.jsp")) {
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
            lgC.insertar(b);
            
            response.sendRedirect("procederCompra.jsp");
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
            

            b.setNombre(nombre);
            b.setApellido(apellido);
            b.setUbicacion(ubicacion);
            b.setDni(dni);
            b.setTelefono(telefono);
            
            lgC.insertar(b);
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
            

            b.setId_Cliente(id);
            b.setNombre(nombre);
            b.setApellido(apellido);
            b.setUbicacion(ubicacion);
            b.setDni(dni);
            b.setTelefono(telefono);            

            lgC.actualizar(b);
            acceso = listar;
//            response.sendRedirect(listar);
            
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            b.setId_Cliente(id);
            lgC.eliminar(id);
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
