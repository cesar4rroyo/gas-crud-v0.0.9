/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import beans.beanProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cesar4rroyo
 */
public class controladorCarrito extends HttpServlet {
    
    PrintWriter out;
    ArrayList<beanProducto> lstProducto;
    String url;
    HttpSession session;
    beanProducto bP;
    
    protected void metGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        if (url.equals("/eliminar.html")) {
            eliminar(request, response);
            
        }
    }
    
    protected void metPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        if (url.equals("/agregarProducto.html")) {
            añadir(request, response);
        }
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session = request.getSession(false);
        lstProducto = (ArrayList<beanProducto>) session.getAttribute("carroCompras");
        lstProducto.remove(Integer.parseInt(request.getParameter("codigoEliminar")));
        response.sendRedirect("pedido.jsp");
        
    }
    
    private void añadir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session = request.getSession(false);
        lstProducto = (ArrayList<beanProducto>) session.getAttribute("carroCompras");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        if (lstProducto == null) {
            lstProducto = new ArrayList<beanProducto>();
            //      Guarda en variable de session un valor 
            session.setAttribute("carroCompras", lstProducto);
        }
        bP = new beanProducto();
        bP.setId_Producto(Integer.parseInt(request.getParameter("id")));
        bP.setNombre_producto(request.getParameter("nombre"));
        bP.setDescripcion(request.getParameter("descripcion"));
        bP.setTipo_producto(request.getParameter("tipo"));
        bP.setImage_ref(request.getParameter("foto"));
        bP.setCantidad(cantidad);
        //      Para ver si se repite un dato 
        int indice = -1;
        for (int i = 0; i < lstProducto.size(); i++) {
            beanProducto proB = lstProducto.get(i);
            if (proB.getId_Producto() == bP.getId_Producto()) {
                bP.setCantidad(bP.getCantidad()+cantidad);
                indice = i;
                break;
            }
        }
        //      Si el indice = -1 entonces voa registrar de lo contrario actualizar       
        if (indice == -1) {
            lstProducto.add(bP);
            
        } else {
            
            lstProducto.set(indice, bP);
        }
        session.setAttribute("carroCompras", lstProducto);
//        out = response.getWriter();
//        out.print("Registrado Correctamente");
        response.sendRedirect("pedido.jsp");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        metGet(request, response);
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
        metPost(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
