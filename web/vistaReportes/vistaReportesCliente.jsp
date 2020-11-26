

<%@page import="java.util.Iterator"%>
<%@page import="beans.beanCliente"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.daoCliente"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title> Reportes </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" >
        <link rel="icon" href="assets/img/gas.png" type="image/x-icon" />
    </head>
    <body>

        <h1 class="text-center pt-5"> CLIENTES  </h1> 
        <hr>
        <div class="container first">  
            <div class="row"> 
                <div class="col card mt-5 border border-warning "> 
                    <form action="reportes/repClientes/clientesPdf.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte PDF </h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Clientes</label>
                        </div>
                        <td>
                            <input class="btn btn-warning"type="submit" name="button" id="button" value="Generar Reportes" >
                        </td>    
                    </form> 
                </div>
                <div class="col card mt-5 border border-info">
                    <form action="reportes\repClientes\clientesParaPdf.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte PDF por Id  </h2> 
                            <hr>
                        </div>
                        <div class="help-block">
                            <label  >Base de Datos Clientes</label>
                        </div>
                        <%
                            daoCliente dao = new daoCliente();
                            List<beanCliente> list = dao.listar();
                        %>
                        <select class="form-control mb-2" id="control" name="control">
                            <option>Seleccione una opcion</option>
                            <% for (beanCliente i : list) {%>                                                    
                            <option value="<%=i.getId_Cliente()%>">
                                <%=i.getNombre()%> <%=i.getApellido()%>
                            </option>
                            <% }%>
                        </select>
                        <td><input class="btn btn-info" type="submit" name="button" id="button" value="Generar Reportes" ></td>
                    </form>
                </div>
                <div class="col card mt-5 border border-success">
                    <form action="reportes\repClientes\clientesExcel.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte Excel</h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Clientes</label>
                        </div>
                        <input class="btn btn-success" type="submit" name="button" id="button" value="Generar Reportes" >
                    </form>
                </div>
                <div class="col card mt-5 border border-primary">
                    <form action="reportes\repClientes\clientesParaExcel.jsp" method="post" >
                        <div class="text-center pt-3">
                            <h2 class="font-weight-bold">Generar Reporte Excel por Id </h2> 
                            <hr>
                        </div>
                        <div class="form-group" >
                            <label  >Base de Datos Clientes </label>
                        </div>
                        <select class="form-control mb-2" id="control" name="control">
                            <option>Seleccione una opcion</option>
                            <% for (beanCliente i : list) {%>                                                    
                            <option value="<%=i.getId_Cliente()%>">
                                <%=i.getNombre()%> <%=i.getApellido()%>
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
