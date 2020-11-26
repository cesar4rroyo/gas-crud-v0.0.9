<%-- 
    Document   : clientesParaExcel
    Created on : 22/11/2020, 04:29:20 AM
    Author     : JOSE ZAFRA
--%>

<%@page import="Config.Conexion"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporter"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.DriverManager"%>
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
            Conexion cn = new Conexion();
            Connection conexion;
            conexion = cn.getConnection();
//        Connection conexion;
//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "jose66");

            int bit;
            Map parameters = new HashMap();
//A nuestro informe de prueba le vamos a enviar parametros
            parameters.put("id", n);

            File f;
            InputStream in;

            JasperPrint jasperPrint;
            jasperPrint = JasperFillManager.fillReport("C:\\Users\\JOSE ZAFRA\\Downloads\\FINAL_TALLER\\gas-final\\web\\reportes\\repClientes\\reporteClientesPara.jasper", parameters, conexion);
            String xlsFileName = "reporteCliente.xls";

//Creacion del XLS
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, xlsFileName);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            exporter.exportReport();

// En este punto ya esta Creado el XLS
// Ahora leemos el fichero y forzamos al navegador a que nos descargue el fichero.
            f = new File(xlsFileName);

            response.setContentType("application/XLSX"); //Tipo de fichero.
            response.setHeader("Content-Disposition", "attachment;filename=" + xlsFileName + ""); //Configurar cabecera http

            in = new FileInputStream(f);
            ServletOutputStream output = response.getOutputStream();

            bit = 256;
            while ((bit) >= 0) {
                bit = in.read();
                output.write(bit);
            }

            output.flush();
            output.close();
            in.close();


        %>
    </body>
</html>
