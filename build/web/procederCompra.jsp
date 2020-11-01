<%-- 
    Document   : editPedido
    Created on : 24 oct. 2020, 12:02:17
    Author     : cesar4rroyo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="beans.beanProducto"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SoftGas</title>
        <link rel="icon" href="assets/img/gas.png" type="image/x-icon" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css" />
        <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="carrito.css" />
    </head>
    <body>
        <header id="header" >
            <div class="container d-flex align-items-center">
                <h1 class="logo mr-auto"><a href="index.jsp">SoftGas</a></h1>
                <!--                <ul class="list-unstyled">
                                <li>
                                    <span class="step_name">Bolsa de compras</span>
                                    <span class="line_separator">
                                        <i class="fas fa-chevron-right"></i>
                                    </span>
                                </li>
                                <li>
                                    <span class="step_number">1</span>
                                    <span class="step_name">Despacho</span>
                                    <span class="line_separator">
                                        <i class="fas fa-chevron-right"></i>
                                    </span>
                                </li>
                                <li>
                                    <span class="step_name">Verificacion</span>
                                    <span class="line_separator">
                                        <i class="fas fa-chevron-right"></i>
                                    </span>
                                </li>
                                <li>
                                    <span class="step_number_off">3</span>
                                    <span class="step_name">Confirmacion</span>
                                </li>
                                </ul>-->
            </div>
        </header>
        <div class="container">
            <div class="row" >
                <div class="col-sm" >
                    <%
                        HttpSession sesion;
                        sesion = request.getSession(false);
                        int totalProductos = 0;
                        int precioTotal = 0;

                        if (sesion.getAttribute("carroCompras") != null) {
                            daoProducto dPdto1 = new daoProducto();
                            List<beanProducto> lista = (ArrayList<beanProducto>) sesion.getAttribute("carroCompras");
                            Iterator<beanProducto> iter1 = lista.iterator();
                            beanProducto bPdto1 = null;
                            for (beanProducto b : lista) {
                                totalProductos = totalProductos + b.getCantidad();
                                precioTotal = precioTotal + b.getCantidad() * b.getPrecio();
                            }
                    %>
                    <div class="cart cart-header">
                        Tienes <%=totalProductos%> seleccionados
                    </div>
                    <div class="cart">                        
                        <ul class="cart-items">
                            <%
                                int i = 0;
                                while (iter1.hasNext()) {
                                    bPdto1 = iter1.next();
                                    int precio = bPdto1.getPrecio();
                                    int cantidad = bPdto1.getCantidad();
                                    int subtotal = precio * cantidad;
                            %>
                            <li>
                                <div class="cart_item_container">
                                    <img src="<%= bPdto1.getImage_ref()%>">
                                    <div class="item_container_only">
                                        <div class="title_container"> <%= bPdto1.getNombre_producto()%>, <%= bPdto1.getTipoProducto().getTipo()%>  </div>
                                        <div class="price_and_count">
                                            <div class="price_div">s/.<%=subtotal%>.00</div>
                                            <div class="btn-group">
                                                <input id="btnMenos" onclick="disminuir()" class="btn btn-outline-info" type="submit" value="-">
                                                <input id="txtCantidad" class="btn btn-outline-info" type="submit" value="<%= bPdto1.getCantidad()%>">
                                                <input onclick="aumentar()" id="btnMas" class="btn btn-outline-info" type="button" value="+">
                                                <a class="btn btn-outline-danger" href="eliminar.html?codigoEliminar=<%=i%>">
                                                    <i
                                                        class="icofont-trash"
                                                        ></i>  
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>                                                    
                            </li>
                            <%
                                    i++;
                                }%>
                        </ul>
                    </div>                    
                    <div>
                        <div class="total_container mb-2">
                            <div class="total">
                                <div class="value_container">
                                    Total:
                                    <input type="hidden" name="txtImpTot" value="<%=precioTotal%>" >
                                    <span class="total_value"> s/.<%=precioTotal%>.00</span>
                                </div>
                                <div>                                    
                                    <button      
                                        type="submit"
                                        id="btnConfirmar"
                                        onclick="showForm()"
                                        class="btn btn-info btn-block">                                    
                                        Confirmar pedido
                                    </button>
                                    <a href="pedido.jsp" class="btn btn-outline-info btn-block"> 
                                        Seguir comprando
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%> 
                </div>

                <div class="col-sm" >
                    <div class="container mt-4 ml-3">
                        <div id="formBuscarCliente" class="d-none">
                            <p>Registra tu compra con tu DNI</p>
                            <div class="row">
                                <div class="form-group col-sm">                                
                                    <input class="form-control" id="txtDniBuscar" name="txtDniBuscar" placeholder="DNI" autocomplete="off" required>
                                </div>
                                <div class="col-sm" >
                                    <button onclick="buscarCliente()" id="btnBuscarCliente" class="btn btn-outline-info">Buscar</button>
                                </div>

                            </div>
                        </div> 
                        <div class="d-none" id="formCliente">
                            <div class="d-none" id="mensajeRegistro">
                                <p class="text-danger">No te encuentras registrado, registrate para poder proceder la compra</p>
                            </div>
                            <form action="addPedido" method="POST" id="formPedido" class="d-none">
                                <div class="row">
                                    <input type="hidden" name="txtIdCli" id="txtIdCli">
                                    <input type="hidden" name="txtImpTot" value="<%=precioTotal%>">

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
                                <button id="btnFinalizar" class="btn btn-success btn-block">
                                    Finalizar Pedido
                                </button>
                            </form>
                            <form action="agregarCliente.jsp" method="POST" id="formRegistroCliente" class="d-none">
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
                    </div>
                </div>
            </div>
        </div>
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
                                        function buscarCliente() {
                                            param = document.getElementById("txtDniBuscar").value;
                                            resetForm();
                                            axios({
                                                method: 'POST',
                                                url: 'buscarCliente.html',
                                                data: "txtDni=" + param,
                                            }).then((res) => {
                                                console.log("Correcto!" + res.data);
                                                data = res.data;
                                                showFormCliente();
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

                                        function showForm() {
                                            const form = document.getElementById("formBuscarCliente");
                                            form.classList.remove("d-none");

                                        }
                                        function showFormCliente() {
                                            const formCliente = document.getElementById("formCliente");
                                            formCliente.classList.remove("d-none");
                                        }

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
    </body>

</html>
