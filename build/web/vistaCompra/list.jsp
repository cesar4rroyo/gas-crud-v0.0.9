
<%@page import="java.util.Iterator"%>
<%@page import="beans.beanCompra"%>
<%@page import="ModeloDAO.daoCompra"%>
<%@page import="beans.beanProducto"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page import="beans.beanProveedor"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.daoProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%

    HttpSession sc = request.getSession();
    String username = "";
    String tipo = "";
    if (sc.getAttribute("username") != null && sc != null) {
        username = sc.getAttribute("username").toString();
        tipo = sc.getAttribute("tipo").toString();
        sc.setAttribute("username", username);
        sc.setAttribute("tipo", tipo);

        if (tipo.equalsIgnoreCase("repartidor")) {
            response.sendRedirect("login.jsp");
        }
    } else {
        response.sendRedirect("login.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Compras</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" >
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css" />
        <link rel="stylesheet" href="estilos.css" />
        <link rel="icon" href="assets/img/gas.png" type="image/x-icon" /> 
    </head>
    <body>
        <div id="wrapper">
            <nav
                class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion color-nav p-0"
                >
                <div class="container-fluid d-flex flex-column p-0">
                    <a
                        class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
                        href="#"
                        >
                        <div class="sidebar-brand-icon">
                            <img src="https://cesar4rroyo.github.io/tarea-menu/assets/img/logo2.png" alt="logo" height="60" />
                        </div>
                        <div class="sidebar-brand-text mx-3 text-capitalize">
                            <span>SoftGas</span>
                        </div>
                    </a>
                    <hr class="sidebar-divider my-0" />
                    <ul class="nav navbar-nav text-light" id="accordionSidebar">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link active" href="index.jsp"
                               ><i class="fas fa-tachometer-alt"></i><span>INICIO</span>
                            </a>
                            <a class="nav-link active" href="controladorCliente?accion=listar"
                               ><i class="fas fa-user-alt"></i><span>CLIENTES</span>
                            </a>
                            <a class="nav-link active" href="controladorPdto?accion=listar"
                               ><i class="fas fa-money-bill-alt"></i><span>PRODUCTOS</span>
                            </a>
                            <a class="nav-link active" href="Controlador?accion=listar"
                               ><i class="fas fa-truck-moving"></i><span>PROVEEDORES</span>
                            </a>
                            <a class="nav-link active" href="controladorRep?accion=listar"
                               ><i class="fas fa-user-alt"></i><span>REPARTIDORES</span>
                            </a>
                            <a class="nav-link active" href="controladorEstadoP?accion=listar"
                               ><i class="fas fa-list-alt"></i><span>ESTADOS PEDIDO</span>
                            </a>
                            <a class="nav-link active" href="controladorTrp?accion=listarTrp"
                               ><i class="fas fa-car"></i><span>TRANSPORTE</span>
                            </a>
                            <a class="nav-link active" href="listPedido"
                               ><i class="fas fa-list"></i><span>PEDIDOS</span>
                            </a>
                            <a class="nav-link active" href="listCompra"
                               ><i class="fas fa-shopping-basket"></i><span>COMPRAS</span>
                            </a>
                        </li>
                        <li class="nav-item" role="presentation"></li>
                    </ul>
                    <div class="text-center d-none d-md-inline">
                        <button
                            class="btn rounded-circle border-0"
                            id="sidebarToggle"
                            type="button"
                            ></button>
                    </div>
                </div>
            </nav>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <nav
                        class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top"
                        >
                        <div class="container-fluid">
                            <button
                                class="btn btn-link d-md-none rounded-circle mr-3"
                                id="sidebarToggleTop"
                                type="button"
                                >
                                <i class="fas fa-bars"></i>
                            </button>
                            <form
                                class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                                >
                                <div class="input-group">
                                    <input
                                        class="bg-light form-control border-0 small"
                                        type="text"
                                        placeholder="Buscar ..."
                                        />
                                    <div class="input-group-append">
                                        <button class="btn btn-dark py-0" type="button">
                                            <i class="fas fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                            <ul class="nav navbar-nav flex-nowrap ml-auto">
                                <li class="nav-item dropdown d-sm-none no-arrow">
                                    <a
                                        class="dropdown-toggle nav-link"
                                        data-toggle="dropdown"
                                        aria-expanded="false"
                                        href="#"
                                        ><i class="fas fa-search"></i
                                        ></a>
                                    <div
                                        class="dropdown-menu dropdown-menu-right p-3 animated--grow-in"
                                        role="menu"
                                        aria-labelledby="searchDropdown"
                                        >
                                        <form class="form-inline mr-auto navbar-search w-100">
                                            <div class="input-group">
                                                <input
                                                    class="bg-light form-control border-0 small"
                                                    type="text"
                                                    placeholder="Buscar..."
                                                    />
                                                <div class="input-group-append">
                                                    <button class="btn btn-dark py-0" type="button">
                                                        <i class="fas fa-search"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </li>
                                <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                                    <div class="nav-item dropdown no-arrow">
                                        <a
                                            class="dropdown-toggle nav-link"
                                            data-toggle="dropdown"
                                            aria-expanded="false"
                                            href="#"
                                            ><span class="badge badge-danger badge-counter">3+</span
                                            ><i class="fas fa-bell fa-fw"></i
                                            ></a>
                                        <div
                                            class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                            role="menu"
                                            >
                                            <h6 class="dropdown-header bg-gradient-dark">
                                                Notificaciones
                                            </h6>
                                            <a
                                                class="d-flex align-items-center dropdown-item"
                                                href="#"
                                                >
                                                <div class="mr-3">
                                                    <div class="bg-primary icon-circle">
                                                        <i class="fas fa-file-alt text-white"></i>
                                                    </div>
                                                </div>
                                                <div>
                                                    <span class="small text-gray-500"
                                                          >20 de agosto, 2020</span
                                                    >
                                                    <p>Tienes un nuevo pedido</p>
                                                </div>
                                            </a>
                                            <a
                                                class="d-flex align-items-center dropdown-item"
                                                href="#"
                                                >
                                                <div class="mr-3">
                                                    <div class="bg-success icon-circle">
                                                        <i class="fas fa-donate text-white"></i>
                                                    </div>
                                                </div>
                                                <div>
                                                    <span class="small text-gray-500"
                                                          >18 de agosto, 2020</span
                                                    >
                                                    <p>Tu reporte de la semana ya está listo</p>
                                                </div>
                                            </a>
                                            <a
                                                class="text-center dropdown-item small text-gray-500"
                                                href="#"
                                                >Ver más</a
                                            >
                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                                    <div class="nav-item dropdown no-arrow">
                                        <a
                                            class="dropdown-toggle nav-link"
                                            data-toggle="dropdown"
                                            aria-expanded="false"
                                            href="#"
                                            ><i class="fas fa-envelope fa-fw"></i
                                            ><span class="badge badge-danger badge-counter"
                                                   >1</span
                                            ></a
                                        >
                                        <div
                                            class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                            role="menu"
                                            >
                                            <h6 class="dropdown-header bg-gradient-dark">Mensajes</h6>

                                            <a
                                                class="text-center dropdown-item small text-gray-500"
                                                href="#"
                                                >Ver más</a
                                            >
                                        </div>
                                    </div>
                                    <div
                                        class="shadow dropdown-list dropdown-menu dropdown-menu-right"
                                        aria-labelledby="alertsDropdown"
                                        ></div>
                                </li>
                                <div class="d-none d-sm-block topbar-divider"></div>
                                <li class="nav-item dropdown no-arrow" role="presentation">
                                    <div class="nav-item dropdown no-arrow">
                                        <a
                                            class="dropdown-toggle nav-link"
                                            data-toggle="dropdown"
                                            aria-expanded="false"
                                            href="#"
                                            ><span class="d-none d-lg-inline mr-2 text-gray-600 small"
                                               ><%=username%></span
                                            ><img
                                                class="border rounded-circle img-profile"
                                                src="assets/img/logo2.png"
                                                /></a>
                                        <div
                                            class="dropdown-menu shadow dropdown-menu-right animated--grow-in"
                                            role="menu"
                                            >
                                            <a class="dropdown-item" role="presentation" href="#"
                                               ><i
                                                    class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"
                                                    ></i
                                                >&nbsp;Perfil</a
                                            ><a class="dropdown-item" role="presentation" href="#"
                                                ><i
                                                    class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"
                                                    ></i
                                                >&nbsp;Configuración</a
                                            >
                                            <a class="dropdown-item" role="presentation" href="reportes.html"
                                               ><i
                                                    class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"
                                                    ></i
                                                >&nbsp;Reportes</a
                                            >
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" role="presentation" href="login.jsp?cerrar=true"
                                               ><i
                                                    class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"
                                                    ></i
                                                >&nbsp;Logout</a
                                            >
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <div class="container" >
                        <div class="text-center pt-5" >
                            <h1>Compras</h1>
                        </div>
                        <form action="buscar.jsp">
                            <div class="d-flex justify-content-center mt-5 mb-4">            
                                <div class="row">
                                    <div class="col-auto">
                                        <input class="form-control" autocomplete="off" name="buscar" id="search" type="text">                         
                                    </div>                   
                                    <div class="col-auto">
                                        <button type="button" class="btn btn-info">Buscar <i class="fa fa-search"></i>
                                        </button>                                    
                                    </div>                                     
                                </div>
                            </div>
                        </form>
                        <div class="container">
                            <button type="button" class="btn btn-dark"  data-toggle="modal" data-target="#modal_insertar"><i class="fa fa-plus"> </i>  Añadir nuevo </button>
                            <a class="btn btn-warning float-right" href="vistaReportesCompra.jsp">Generar Reportes</a>
                        </div>            
                        <div class="modal fade" id="modal_insertar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="addCompra" >
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Nueva Compra</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row" >                                                                    
                                            </div>
                                            <div class="form-group">
                                                <label for="txtProvedor">Proveedor: </label>
                                                <%
                                                    daoProveedor daoProv = new daoProveedor();
                                                    List<beanProveedor> lstProv = daoProv.listar();
                                                %>
                                                <select id="txtProvedor" name="txtProvedor" class="form-control" required>
                                                    <option>Seleccione una opcion</option>
                                                    <% for (beanProveedor i : lstProv) {%>                                                    
                                                    <option value="<%=i.getId_Provedor()%>">
                                                        <%=i.getNombre()%>
                                                    </option>
                                                    <% } %>
                                                </select>
                                            </div>   
                                            <div class="form-group">
                                                <label for="txtProducto">Producto: </label>
                                                <%
                                                    daoProducto dPdt = new daoProducto();
                                                    List<beanProducto> lstPdto = dPdt.listar();
                                                %>
                                                <select id="txtProducto" name="txtProducto" class="form-control" required>
                                                    <option>Seleccione una opcion</option>
                                                    <% for (beanProducto i : lstPdto) {%>                                                    
                                                    <option value="<%=i.getId_Producto()%>">
                                                        <%=i.getNombre_producto()%>
                                                    </option>
                                                    <% } %>
                                                </select>
                                            </div>    
                                            <div class="row" >
                                                <div class="form-group col-md">
                                                    <label for="txtCantidad">Cantidad: </label>
                                                    <input class="form-control" type="number" placeholder="Cantidad"  name="txtCantidad" id="txtCantidad" required="" autocomplete="off" >
                                                </div> 
                                                <div class="form-group col-md">
                                                    <label for="txtTotal">Total:  </label>
                                                    <input class="form-control" type="number" name="txtTotal" placeholder="Total"  required="" id="txtTotal" autocomplete="off">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                            <input type="submit" name="accion" class="btn btn-primary" value="Agregar" >
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--desde aqui empieza el verdadero codigo :v-->
                        <div class="container mt-5 text-center" >
                            <div class="table-responsive">
                                <table class="table table-hover" >
                                    <thead>
                                        <tr>
                                            <th scope="col">Provedor</th>
                                            <th scope="col">Producto</th>
                                            <th scope="col">Fecha</th>
                                            <th scope="col">Cantidad</th>
                                            <th scope="col">Total</th>
                                            <th scope="col">Acciones</th>
                                        </tr>
                                    </thead>
                                    <%
                                        daoCompra dCompra = new daoCompra();
                                        List<beanCompra> lstCompra = dCompra.listarCompras();
                                        Iterator<beanCompra> iter = lstCompra.iterator();
                                        beanCompra bCompra = null;
                                        while (iter.hasNext()) {
                                            bCompra = iter.next();
                                    %>
                                    <tbody>
                                        <tr>                                            
                                            <td><%= bCompra.getProvedor().getNombre()%></td>
                                            <td><%= bCompra.getProducto().getNombre_producto()%></td>
                                            <td class="fecha"><%= bCompra.getFecha()%></td>
                                            <td><%= bCompra.getCantidad()%></td>
                                            <td><%= bCompra.getTotal()%></td>
                                            <td>
                                                <div class="btn-group" >
                                                    <a  class="btn btn-primary" href="editCompra.html?&id=<%= bCompra.getId_Compra()%>">
                                                        <i class="fa fa-pencil-square-o"></i>Editar
                                                    </a>
                                                    <a class="btn btn-danger disabled" href="deleteCompra?&id=<%= bCompra.getId_Compra()%>">
                                                        <i class="fa fa-trash"></i> Eliminar
                                                    </a>
                                                    <a class="btn btn-success" href="reportes\repCompras\comprasParaPdf.jsp?control=<%= bCompra.getId_Compra()%>">
                                                        <i class="fa fa-eye"></i>Ver
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- aqui acaba el codigo :v-->
                    </div>
                    <footer class="bg-white sticky-footer">
                        <div class="container my-auto">
                            <div class="text-center my-auto copyright">
                                <span
                                    >Copyright ©
                                    <a href="https://cesar4rroyo.github.io/softeam/"> SoftTeam </a>
                                    - 2020</span
                                >
                            </div>
                        </div>
                    </footer>
                </div>
                <a class="border rounded d-inline scroll-to-top" href="#page-top"
                   ><i class="fas fa-angle-up"></i
                    ></a>
            </div>
        </div>        
    </body>
    <script src="assets/js/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
    <script src="assets/js/theme.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <script>
        $('#modal_insertar').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus')
        });

    </script>
    <script>
        document.addEventListener("DOMContentLoaded", function (event) {
            cargarFechas();

        });
        const fecha = document.getElementsByClassName("fecha");
        const cargarFechas = () => {
            for (i = 0; i < fecha.length; i++) {
                var date = new Date(fecha[i].innerHTML);
                moment.locale('es');
                var newdate = moment(date).format('MMMM Do YYYY, h:mm:ss a');
                fecha[i].innerHTML = newdate;
            }
        };
    </script>

</html>

