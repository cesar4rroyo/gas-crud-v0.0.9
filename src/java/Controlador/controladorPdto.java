package Controlador;

import beans.beanProducto;
import beans.beanTipoProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logicProducto;
import logic.logicTipoProducto;

public class controladorPdto extends HttpServlet {

    String listar = "vistaProducto/listarPdto.jsp";
    String add = "vistaProducto/addPdto.jsp";
    String edit = "vistaProducto/editPdto.jsp";
    beanProducto bPdto = new beanProducto();
    beanTipoProducto bTPdto = new beanTipoProducto();
    logicProducto lgPdto = new logicProducto();
    logicTipoProducto lgTipoPdto = new logicTipoProducto();
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
            bTPdto = lgTipoPdto.listar(Integer.parseInt(request.getParameter("idTipoPdto")));
            String nombre = request.getParameter("txtNom");
            String descripcion = request.getParameter("txtDescripcion");
            String img = request.getParameter("txtImagen");
            int precio = Integer.parseInt(request.getParameter("txtPrecio"));
            bPdto.setNombre_producto(nombre);
            bPdto.setDescripcion(descripcion);
            bPdto.setImage_ref(img);
            bPdto.setTipoProducto(bTPdto);
            bPdto.setPrecio(precio);
            lgPdto.insertar(bPdto);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idPdto", request.getParameter("idP"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            bTPdto = lgTipoPdto.listar(Integer.parseInt(request.getParameter("idTipoPdto")));
            int id = Integer.parseInt(request.getParameter("txtIdPdto"));
            String nombre = request.getParameter("txtNom");
            String descripcion = request.getParameter("txtDescripcion");
            String img = request.getParameter("txtImagen");
            int precio = Integer.parseInt(request.getParameter("txtPrecio"));
            bPdto.setId_Producto(id);
            bPdto.setNombre_producto(nombre);
            bPdto.setDescripcion(descripcion);
            bPdto.setTipoProducto(bTPdto);
            bPdto.setPrecio(precio);
            bPdto.setImage_ref(img);
            lgPdto.actualizar(bPdto);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idP"));
            bPdto.setId_Producto(id);
            lgPdto.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vistaProducto = request.getRequestDispatcher(acceso);
        vistaProducto.forward(request, response);
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
