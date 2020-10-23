<%-- 
    Document   : pedido
    Created on : 11 oct. 2020, 17:44:24
    Author     : cesar4rroyo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="beans.beanProducto"%>
<%@page import="java.util.List"%>
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
        <div class="overlay_container d-none" id="cart">
            <div class="slide_container">
                <div class="cart_general">

                    <%
                        HttpSession sesion;
                        sesion = request.getSession(false);
                        //ArrayList<beanProducto> lista = (ArrayList<beanProducto>) sesion.getAttribute("carroCompras");
                        int totalProductos = 0;
                        int precioTotal=0;

                        if (sesion.getAttribute("carroCompras") != null) {
                            daoProducto dPdto1 = new daoProducto();
                            List<beanProducto> lista = (ArrayList<beanProducto>) sesion.getAttribute("carroCompras");
                            Iterator<beanProducto> iter1 = lista.iterator();
                            beanProducto bPdto1 = null;
                            for (beanProducto b : lista) {
                                totalProductos = totalProductos + b.getCantidad();
                                precioTotal = precioTotal + b.getCantidad()*b.getPrecio() ;
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
                                    int precio =bPdto1.getPrecio();
                                    int cantidad=bPdto1.getCantidad();
                                    int subtotal = precio*cantidad;
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
                                    <span class="total_value"> s/.<%=precioTotal%>.00</span>
                                </div>
                                <div class="total_btn_actions">
                                    <button class="close_btn" id="btnCerrar" onclick="cerrar()"> 
                                        Cerrar
                                    </button>
                                    <button                                   
                                        class="proceed_btn">                                    
                                        Proceder compra
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%} else {%>
                    <div class="cart cart-header mt-1">
                        No tienes ningun producto
                        <div class="close_btn_no_products">
                            <button id="btnCerrar" onclick="cerrar()" class="close_btn width_total">Cerrar</button>
                        </div>
                    </div>                    
                    <%}%>

                </div>
            </div>
        </div>
        <!-- ======= Header ======= -->
        <header id="header" >
            <div class="container d-flex align-items-center">
                <h1 class="logo mr-auto"><a href="index.jsp">SoftGas</a></h1>
                <!-- Uncomment below if you prefer to use an image logo -->
                <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

                <nav class="nav-menu d-none d-lg-block">
                    <ul>
                        <li class="active"><a href="#inicio">Inicio</a></li>                        
                        <li><a href="#services">Productos</a></li>
                        <li><a href="#contact">Contacto</a></li>

                    </ul>
                </nav><!-- .nav-menu -->
                <a onclick="toggle()" class="appointment-btn" id="shop-cart" >
                    <i style="color:white; font-size:18px" class="icofont-shopping-cart"></i>
                </a>
                <span class="cart-count">
                    <%=totalProductos%>
                </span>
            </div>
        </header><!-- End Header -->
        <!--========= Pedidos Sectio ============-->
        <section id="inicio">
            <div class="container">
                <div class="section-title">
                    <h2>Seleccionar producto</h2>
                    <div class="row">
                        <%
                            daoProducto dPdto = new daoProducto();
                            List<beanProducto> lstPdto = dPdto.listar();
                            Iterator<beanProducto> iter = lstPdto.iterator();
                            beanProducto bPdto = null;
                            while (iter.hasNext()) {
                                bPdto = iter.next();
                        %>
                        <div class="col-lg d-flex align-items-stretch justify-content-center">
                            <form method="post" action="agregarProducto.html">
                                <div class="icon-box mt-4 mt-xl-0">
                                    <img class="img-balon" src="<%= bPdto.getImage_ref()%>" alt="Img ref">
                                    <hr>
                                    <h4><%= bPdto.getNombre_producto()%></h4>
                                    <h5>S/. <%=bPdto.getPrecio()%>.00</h5>
                                    <p><%= bPdto.getDescripcion()%></p>
                                    <input type="hidden" name="id" value="<%=bPdto.getId_Producto()%>" >
                                    <input type="hidden" name="foto" value="<%=bPdto.getImage_ref()%>" >
                                    <input type="hidden" name="descripcion" value="<%=bPdto.getDescripcion()%>" >
                                    <input type="hidden" name="txtPrecio" value="<%=bPdto.getPrecio()%>" >
                                    <input type="hidden" name="nombre" value="<%=bPdto.getNombre_producto()%>" >
                                    <input type="hidden" name="idTipoPdto" value="<%=bPdto.getTipoProducto().getIdtipo_producto()%>">
                                    <input type="hidden" name="cantidad" value="1" >
                                    <button class="btn btn-outline-primary mt-2">Agregar</button>
                                </div>
                            </form>    

                        </div>
                        <%}%>
                    </div>
                </div>
            </div>
        </section>
        <!--============End Pedidos ==============-->


    </main><!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer">

        <div class="footer-top">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 col-md-6 footer-contact">
                        <h3>SoftGas</h3>
                        <p>
                            Av. Grau 2032 <br>
                            Chiclayo, Lambayeque<br>
                            Perú <br><br>
                            <strong>Phone:</strong> +51 923 543 210<br>
                            <strong>Email:</strong> contact@softgas.com  <br>
                        </p>
                    </div>

                    <div class="col-lg-2 col-md-6 footer-links">
                        <h4>Links</h4>
                        <ul>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Inicio</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Sobre Nosotros</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Productos</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Términos y Condiciones</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Políticas de privacidad</a></li>
                        </ul>
                    </div>

                    <div class="col-lg-3 col-md-6 footer-links">
                        <h4>Nuestros Productos</h4>
                        <ul>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Balón de 5Kg</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Balón de 10Kg</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Balón de 45Kg </a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Balón Premium</a></li>
                            <li><i class="bx bx-chevron-right"></i> <a href="#">Tanque Doméstico</a></li>
                        </ul>
                    </div>

                    <div class="col-lg-4 col-md-6 footer-newsletter">
                        <h4>Suscripción</h4>
                        <p>Suscribite para recibir ofertas y promociones</p>
                        <form action="" method="post">
                            <input type="email" name="email"><input type="submit" value="Suscribirse">
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <div class="container d-md-flex py-4">

            <div class="mr-md-auto text-center text-md-left">
                <div class="copyright">
                    &copy; Copyright <strong><span>SoftTeam</span></strong>. All Rights Reserved
                </div>

            </div>
            <div class="social-links text-center text-md-right pt-3 pt-md-0">
                <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
            </div>
        </div>
    </footer><!-- End Footer -->

    <div id="preloader"></div>
    <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

</body>
<!-- Vendor JS Files -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<script src="assets/vendor/venobox/venobox.min.js"></script>
<script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
<script src="assets/vendor/counterup/counterup.min.js"></script>
<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>
<script>
                    var carrito = document.getElementById("shop-cart")
                    var listaProductos = document.getElementById("cart");
                    var cerrarBtn = document.getElementById("btnCerrar");
                    const toggle = () => {
                        if (listaProductos.classList.contains("d-none")) {
                            listaProductos.classList.remove("d-none");
                        } else {
                            listaProductos.classList.add("d-none");
                        }
                    }
                    const cerrar = () => {
                        listaProductos.classList.add("d-none");
                    }

                    var txtCantidad = document.getElementById("txtCantidad");
                    var btnMas = document.getElementById("btnMas");
                    var btnMenos = document.getElementById("btnMenos");

                    const aumentar = () => {
                        txtCantidad.value = parseInt(txtCantidad.value) + 1;
                    }
                    const disminuir = () => {
                        txtCantidad.value = parseInt(txtCantidad.value) - 1;
                    }

</script>
</html>
