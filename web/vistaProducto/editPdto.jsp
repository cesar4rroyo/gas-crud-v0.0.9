<%-- 
    Document   : editPdto
    Created on : 01/10/2020, 11:31:57 AM
    Author     : USER
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="beans.beanTipoProducto"%>
<%@page import="ModeloDAO.daoTipoProducto"%>
<%@page import="beans.beanProducto"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto</title>
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
                            <img src="assets/img/logo2.png" alt="logo" height="60" />
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
                    <!--desde aqui empieza el verdadero codigo :v-->
                    <div class="container col-md-6 mt-5" >
                        <div class="text-center">
                            <%
                                daoProducto dPdto = new daoProducto();
                                int idPdto = Integer.parseInt((String) request.getAttribute("idPdto"));
                                beanProducto bPdto = (beanProducto) dPdto.list(idPdto);
                            %>
                            <h1>Editar Producto</h1>
                            <hr>
                        </div>
                        <form action="controladorPdto">
                            Nombre: <br>
                            <input class="form-control" type="text" name="txtNom" value="<%=bPdto.getNombre_producto()%>"><br>
                            Descripcion: <br>
                            <input class="form-control" type="text" name="txtDescripcion" value="<%=bPdto.getDescripcion()%>"><br>
                            Tipo: <br>
                            <%
                                daoTipoProducto dao = new daoTipoProducto();
                                List<beanTipoProducto> lstTrp = dao.listar();
                            %>
                            <select id="tipo_producto" name="idTipoPdto" class="form-control" required>
                                <option value="1">Seleccione uno</option>
                                <% for (beanTipoProducto i : lstTrp) {%>                                                    
                                <option value="<%=i.getIdtipo_producto()%>">
                                    <%=i.getTipo()%>
                                </option>
                                <% }%>
                            </select>
                            <br>
                            Precio: <br>
                            <input class="form-control" value="<%=bPdto.getPrecio()%>" type="text" name="txtPrecio" placeholder="Precio" id="precio" required autocomplete="off">
                            <br>
                            Imagen: <br>
                            <input type="hidden" value="<%=bPdto.getImage_ref()%>" name="txtImagen" id="img-preview">
                            <input class="form-control-file" name="file" type="file" id="file-upload" value="Seleccionar imagen">   
                            <br>
                            <input type="hidden" name="txtIdPdto" value="<%=bPdto.getId_Producto()%>">
                            <input class="btn btn-success" type="submit"  id="btnAgregar" name="accion" value="Actualizar">
                            <a class="btn btn-secondary" href="controladorPdto?accion=listar">Regresar</a>                            
                        </form>
                    </div>
                    <!--aqui termina el codigo lo demas son wbds-->

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

    </body>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
    <script src="assets/js/theme.js"></script>
    <script src="assets/js/upload.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
</html>
