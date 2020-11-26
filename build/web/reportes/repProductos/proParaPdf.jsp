<%-- 
    Document   : clientesPdf
    Created on : 22/11/2020, 04:01:53 AM
    Author     : JOSE ZAFRA
--%>

<%@page import="Config.Conexion"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            int n = Integer.parseInt(request.getParameter("control"));
//            Connection conexion;
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "jose66");
            Conexion cn = new Conexion();
            Connection conexion;
            conexion = cn.getConnection();
            File reportFile = new File(application.getRealPath("/reportes/repProductos/reporteProductoPara.jasper"));
            Map parametros = new HashMap();

            parametros.put("id", n);

            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametros, conexion);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);

            ServletOutputStream output = response.getOutputStream();
            response.getOutputStream();
            output.write(bytes, 0, bytes.length);
            output.flush();
            output.close();

        %>
    </body>
</html>
