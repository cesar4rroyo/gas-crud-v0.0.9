

<%@page import="beans.beanProducto"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page import="java.util.List"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title> Reportes </title>
        <link rel="icon" href="assets/img/gas.png" type="image/x-icon" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" >
    </head>
    <body>

        <h1 class="text-center pt-5"> PRODUCTOS </h1> 
        <hr>
        <div class="container first">  
            <div class="row"> 
                <div class="col card mt-5 border border-warning "> 
                    <form action="reportes\repProductos\proPdf.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte PDF </h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Productos</label>
                        </div>
                        <td>
                            <input class="btn btn-warning"type="submit" name="button" id="button" value="Generar Reportes" >
                        </td>    
                    </form>
                </div>
                <div class="col card mt-5 border border-info">
                    <form action="reportes\repProductos\proParaPdf.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte PDF por Id  </h2> 
                            <hr>
                        </div>
                        <div class="help-block">
                            <label  >Base de Datos Productos</label>
                        </div>
                        <%
                            daoProducto dao = new daoProducto();
                            List<beanProducto> list = dao.listar();
                        %>
                        <select class="form-control mb-2" id="control" name="control">
                            <option>Seleccione una opcion</option>
                            <% for (beanProducto i : list) {%>                                                    
                            <option value="<%=i.getId_Producto()%>">
                                <%=i.getNombre_producto()%> 
                            </option>
                            <% }%>
                        </select>
                        <td><input class="btn btn-info" type="submit" name="button" id="button" value="Generar Reportes" ></td>
                    </form>
                </div>
                <div class="col card mt-5 border border-success">
                    <form action="reportes\repProductos\proExcel.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte Excel</h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Productos</label>
                        </div>                    
                        <input class="btn btn-success" type="submit" name="button" id="button" value="Generar Reportes" >
                    </form>
                </div>
                <div class="col card mt-5 border border-primary">
                    <form action="reportes\repProductos\proParaExcel.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte Excel por Id </h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Productos </label>
                        </div>
                        <select class="form-control mb-2" id="control" name="control">
                            <option>Seleccione una opcion</option>
                            <% for (beanProducto i : list) {%>                                                    
                            <option value="<%=i.getId_Producto()%>">
                                <%=i.getNombre_producto()%> 
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
