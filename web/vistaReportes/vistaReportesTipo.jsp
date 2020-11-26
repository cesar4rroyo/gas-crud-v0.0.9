<%@page import="beans.beanTipoProducto"%>
<%@page import="ModeloDAO.daoTipoProducto"%>
<%@page import="beans.beanTransporte"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.daoTransporte"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title> Reportes </title>
        <link rel="icon" href="assets/img/gas.png" type="image/x-icon" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" >
    </head>
    <body>
        <h1 class="text-center pt-5"> TIPO DE PRODUCTOS </h1> 
        <hr>
        <div class="container first">  
            <div class="row"> 
                <div class="col card mt-5 border border-warning "> 
                    <form action="reportes\repTipoProd\tipoPdf.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte PDF </h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Tipo Producto</label>
                        </div>
                        <td>
                            <input class="btn btn-warning"type="submit" name="button" id="button" value="Generar Reportes" >
                        </td>    
                    </form> 
                </div>
                <div class="col card mt-5 border border-info"> 
                    <form action="reportes\repTipoProd\tipoParaPdf.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte PDF por Id  </h2> 
                            <hr>
                        </div>
                        <div class="help-block">
                            <label  >Base de Datos Tipo Producto</label>
                        </div>
                        <%
                            daoTipoProducto dao = new daoTipoProducto();
                            List<beanTipoProducto> list = dao.listar();
                        %>
                        <select class="form-control mb-2" id="control" name="control">
                            <option>Seleccione una opcion</option>
                            <% for (beanTipoProducto i : list) {%>                                                    
                            <option value="<%=i.getIdtipo_producto()%>">
                                <%=i.getTipo()%>
                            </option>
                            <% }%>
                        </select>
                        <td><input class="btn btn-info" type="submit" name="button" id="button" value="Generar Reportes" ></td>
                    </form>
                </div>
                <div class="col card mt-5 border border-success">
                    <form action="reportes\repTipoProd\tipoExcel.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte Excel</h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Tipo Producto</label>
                        </div>
                        <input class="btn btn-success" type="submit" name="button" id="button" value="Generar Reportes" >
                    </form>
                </div>
                <div class="col card mt-5 border border-primary">
                    <form action="reportes\repTipoProd\tipoParaExcel.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte Excel por Id </h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Tipo Producto </label>
                        </div>
                        <select class="form-control mb-2" id="control" name="control">
                            <option>Seleccione una opcion</option>
                            <% for (beanTipoProducto i : list) {%>                                                    
                            <option value="<%=i.getIdtipo_producto()%>">
                                <%=i.getTipo()%>
                            </option>
                            <% }%>
                        </select>
                        <input class="  btn btn-primary" type="submit" name="button" id="button" value="Generar Reportes" >
                    </form>
                </div>
            </div>
        </div>      

    </body>
</html>
