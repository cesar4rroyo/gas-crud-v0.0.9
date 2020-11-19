package Controlador;

import beans.beanRepartidor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logicRepartidor;


public class controladorRep extends HttpServlet {

    String listarRep = "vistaRepartidor/lstRep.jsp";
    String addRep = "vistaRepartidor/addRep.jsp";
    String editRep = "vistaRepartidor/editRep.jsp";
    beanRepartidor bR = new beanRepartidor();
    logicRepartidor lgR = new logicRepartidor();
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
            lgR.insertar(bR);
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
            lgR.actualizar(bR);
            acceso = listarRep;
        } else if (action.equalsIgnoreCase("eliminarR")) {
            id = Integer.parseInt(request.getParameter("idR"));
            bR.setId_Repartidor(id);
            lgR.eliminar(id);
            acceso = listarRep;
        }
        RequestDispatcher vistaT = request.getRequestDispatcher(acceso);
        vistaT.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
