
package Controlador;

import ModeloDAO.daoCompra;
import ModeloDAO.daoProducto;
import ModeloDAO.daoProveedor;
import beans.beanCompra;
import beans.beanProducto;
import beans.beanProveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logicCompra;


public class controladorCompra extends HttpServlet {

    beanCompra bCompra;
    daoCompra dCompra;
    beanProducto bPdt;
    daoProducto dPdt;
    beanProveedor bProv;
    daoProveedor dProv;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String rutaUrl = request.getServletPath();
        if (rutaUrl.equals("/listCompra")) {
           RequestDispatcher vista = request.getRequestDispatcher("vistaCompra/list.jsp");
           vista.forward(request, response);
        }else if (rutaUrl.equals("/editCompra.html")) {
            request.setAttribute("id", request.getParameter("id"));
            RequestDispatcher vista = request.getRequestDispatcher("vistaCompra/editCompra.jsp");
            vista.forward(request, response);
        } else if (rutaUrl.equals("/editCompra")) {
            editarCompra(request, response);
        } else if (rutaUrl.equals("/addCompra")) {
            agregarCompra(request, response);
        } else if (rutaUrl.equals("/deleteCompra")) {
            eliminar(request, response);
        } 
    }

    public void editarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        bCompra = new beanCompra();
        dCompra = new daoCompra();

        bPdt = new beanProducto();
        dPdt = new daoProducto();

        bProv = new beanProveedor();
        dProv = new daoProveedor();
        
        bPdt = dPdt.list(Integer.parseInt(request.getParameter("txtProducto")));
        bProv = dProv.list(Integer.parseInt(request.getParameter("txtProvedor")));
        int cantidad_actualizada=Integer.parseInt(request.getParameter("txtCantidad"));
        int cantidad_defecto = Integer.parseInt(request.getParameter("txtCantidadDefecto"));
        bCompra.setCantidad(cantidad_actualizada);
        bCompra.setTotal(Integer.parseInt(request.getParameter("txtTotal")));
        bCompra.setProducto(bPdt);
        bCompra.setProvedor(bProv);
        bCompra.setId_Compra(Integer.parseInt(request.getParameter("txtIdCompra")));
                
        try {
            logicCompra lgCompra = new logicCompra();
            lgCompra.editarCompra(bCompra, cantidad_defecto);
            dCompra.edit(bCompra);
            String acceso = "listCompra";
            response.sendRedirect(acceso);
        } catch (IOException e) {
            out.print(e);
        }
    }

    public void agregarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        bCompra = new beanCompra();
        dCompra = new daoCompra();

        bPdt = new beanProducto();
        dPdt = new daoProducto();

        bProv = new beanProveedor();
        dProv = new daoProveedor();

        bPdt = dPdt.list(Integer.parseInt(request.getParameter("txtProducto")));
        bProv = dProv.list(Integer.parseInt(request.getParameter("txtProvedor")));
        
        bCompra.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
        bCompra.setTotal(Integer.parseInt(request.getParameter("txtTotal")));
        bCompra.setProducto(bPdt);
        bCompra.setProvedor(bProv);

        try {
            logicCompra lgCompra = new logicCompra();
            lgCompra.insertar(bCompra);
            dCompra.add(bCompra);
            String acceso = "listCompra";
            response.sendRedirect(acceso);
        } catch (IOException e) {
            out.print(e);
        }

    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        bCompra = new beanCompra();
        dCompra = new daoCompra();
        int id_compra = Integer.parseInt(request.getParameter("id"));
        try {
            dCompra.eliminar(id_compra);
            String acceso = "listCompra";
            response.sendRedirect(acceso);
        } catch (IOException e) {
            out.print(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
