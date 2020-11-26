
<%@page import="beans.beanEstadoPed"%>
<%@page import="ModeloDAO.daoEstadoPed"%>
<%@page import="beans.beanRepartidor"%>
<%@page import="ModeloDAO.daoRepartidor"%>
<%@page import="java.util.Iterator"%>
<%@page import="beans.beanProducto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Pedido</title>
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
                            <h3>Buscar Cliente</h3>
                        </div>
                        <div id="formBuscarCliente">                            
                            <div class="d-flex justify-content-center mt-5 mb-4">            
                                <div class="row">
                                    <div class="col-auto">
                                        <input class="form-control" id="txtDniBuscar" name="txtDniBuscar" placeholder="DNI" autocomplete="off" required>
                                    </div>                   
                                    <div class="col-auto">
                                        <button onclick="buscar()" id="btnBuscarCliente" class="btn btn-outline-info">Buscar <i class="fa fa-search"></i> </button>
                                    </div>                                     
                                </div>
                            </div>
                        </div>
                        <div class="container d-none"  id="formPedido">
                            <form action="agregarPedidoCompleto" method="POST">
                                <input type="hidden" name="txtIdCli" id="txtIdCli">
                                <div class="row">
                                    <div class="form-group col-md">
                                        <label for="txtNombre">Nombre: </label>
                                        <input id="txtNombre" class="form-control" placeholder="Nombre" type="text" name="txtNombre" id="txtNombre" required autoComplete="off" />
                                    </div>
                                    <div class="form-group col-md">
                                        <label for="txtApellido">Apellido </label>
                                        <input class="form-control" type="text" name="txtApellido" placeholder="Apellido" id="txtApellido" required autoComplete="off" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="txtUbicacion">Ubicacion: </label>
                                    <input class="form-control" type="text" placeholder="Ubicación" name="txtUbicacion" id="txtUbicacion" required autoComplete="off" />
                                </div> 
                                <div class="row">
                                    <div class="form-group col-md">
                                        <label for="txtDni">DNI: </label>
                                        <input class="form-control" type="text" placeholder="Nro de DNI" name="txtDni" id="txtDni" required autoComplete="off" />
                                    </div> 
                                    <div class="form-group col-md">
                                        <label for="txtTel">Teléfono:</label>
                                        <input class="form-control" type="text" name="txtTel" placeholder="Nro. de Teléfono" required id="txtTel" autoComplete="off" />                                                    
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="producto">Producto: </label>
                                    <%
                                        daoProducto dao = new daoProducto();
                                        List<beanProducto> lstTrp = dao.listar();

                                    %>
                                    <select id="producto" name="txtIdPdto" class="form-control" required>
                                        <option value="1">Seleccione una opcion</option>
                                        <% for (beanProducto i : lstTrp) {%>                                                    
                                        <option value="<%=i.getId_Producto()%>">
                                            <%=i.getNombre_producto()%>, Precio: s/.<%=i.getPrecio()%>.00, Tipo:<%=i.getTipoProducto().getTipo()%>
                                        </option>
                                        <% }%>
                                    </select>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md">
                                        <label for="repartidor">Repartidor: </label>
                                        <%
                                            daoRepartidor daoR = new daoRepartidor();
                                            List<beanRepartidor> list = daoR.listarRep();

                                        %>
                                        <select id="producto" class="form-control" name="txtIdRep" id="repartidor" required>
                                            <option value="1">Seleccione una opcion</option>
                                            <% for (beanRepartidor i : list) {%>                                                    
                                            <option value="<%=i.getId_Repartidor()%>">
                                                <%=i.getNombre()%>
                                            </option>
                                            <% }%>
                                        </select>
                                    </div> 
                                    <div class="form-group col-md">
                                        <label for="estado">Estado Pedido: </label>
                                        <%
                                            daoEstadoPed daoE = new daoEstadoPed();
                                            List<beanEstadoPed> listE = daoE.listar();

                                        %>
                                        <select id="producto" name="txtIdEP" class="form-control"  id="estado" required>
                                            <option value="1">Seleccione una opcion</option>
                                            <% for (beanEstadoPed i : listE) {%>                                                    
                                            <option value="<%=i.getId_Estado_pedido()%>">
                                                <%=i.getNombre_estado()%>
                                            </option>
                                            <% }%>
                                        </select>
                                    </div>
                                </div>
                                <button id="btnFinalizar" class="btn btn-success btn-block">
                                    Finalizar Pedido
                                </button>
                            </form>
                        </div>
                        <div class="container d-none"  id="formRegistroCliente">
                            <div  id="mensajeRegistro">
                                <p class="text-danger">El cliente no se encuentra registrado, registrelo para poder proceder la compra</p>
                            </div>
                            <form action="agregarCliente.jsp" method="POST">
                                <div class="row">
                                    <div class="form-group col-md">
                                        <label for="txtNombre">Nombre: </label>
                                        <input id="txtNombre" class="form-control" placeholder="Nombre" type="text" name="txtNom" id="txtNombre" required autoComplete="off" />
                                    </div>
                                    <div class="form-group col-md">
                                        <label for="txtApellido">Apellido </label>
                                        <input class="form-control" type="text" name="txtApe" placeholder="Apellido" id="txtApellido" required autoComplete="off" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="txtUbicacion">Ubicacion: </label>
                                    <input class="form-control" type="text" placeholder="Ubicación" name="txtUbi" id="txtUbicacion" required autoComplete="off" />
                                </div> 
                                <div class="row">
                                    <div class="form-group col-md">
                                        <label for="txtDni">DNI: </label>
                                        <input class="form-control" type="text" placeholder="Nro de DNI" name="txtDni" id="txtDni" required autoComplete="off" />
                                    </div> 
                                    <div class="form-group col-md">
                                        <label for="txtTel">Teléfono:</label>
                                        <input class="form-control" type="text" name="txtTel" placeholder="Nro. de Teléfono" required id="txtTel" autoComplete="off" />                                                    
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="hidden" placeholder="Ubicación" name="txtFot" id="txtUbicacion" required autoComplete="off" />
                                </div> 
                                <button type="submit" id="btnRegistrarse" class="btn btn-outline-success btn-block">
                                    Registrarse
                                </button>
                            </form>
                        </div>
                        <!--desde aqui empieza el verdadero codigo :v-->
                        <div class="container mt-5 text-center" >

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
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script> 
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
                                            function buscar() {
                                                param = document.getElementById("txtDniBuscar").value;
                                                resetForm();
                                                axios({
                                                    method: 'POST',
                                                    url: 'buscarCliente.html',
                                                    data: "txtDni=" + param,
                                                }).then((res) => {
                                                    console.log("Correcto!" + res.data);
                                                    data = res.data;
                                                    var dividirCadena = data.split(",");
                                                    if (dividirCadena[0] !== "null") {
                                                        document.getElementById("formPedido").classList.remove("d-none");
                                                        $("#txtNombre").val(dividirCadena[0]);
                                                        $("#txtApellido").val(dividirCadena[1]);
                                                        $("#txtDni").val(dividirCadena[2]);
                                                        $("#txtUbicacion").val(dividirCadena[3]);
                                                        $("#txtTel").val(dividirCadena[4]);
                                                        $("#txtIdCli").val(dividirCadena[5]);

                                                    } else {
                                                        document.getElementById("mensajeRegistro").classList.remove("d-none");
                                                        document.getElementById("formRegistroCliente").classList.remove("d-none");

                                                    }

                                                }).catch((e) => {
                                                    console.log("Error:" + e);
                                                });
                                            }

//                                            function showForm() {
//                                                const form = document.getElementById("formBuscarCliente");
//                                                form.classList.remove("d-none");
//
//                                            }
//                                            function showFormCliente() {
//                                                const formCliente = document.getElementById("formCliente");
//                                                formCliente.classList.remove("d-none");
//                                            }

                                            function resetForm() {
                                                $("#txtNombre").val("");
                                                $("#txtApellido").val("");
                                                $("#txtDni").val("");
                                                $("#txtUbicacion").val("");
                                                $("#txtTel").val("");
                                                $("#txtIdCli").val("");
                                                document.getElementById("mensajeRegistro").classList.add("d-none");
                                                document.getElementById("formRegistroCliente").classList.add("d-none");
                                            }
                                            const btnConfirmar = document.getElementById("btnConfirmar");
                                            var formCliente = document.getElementById("formCliente");
    </script>
</html>
