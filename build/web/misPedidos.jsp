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
        <!-- ======= Header ======= -->
        <header id="header" >
            <div class="container d-flex align-items-center">
                <h1 class="logo mr-auto"><a href="index.jsp">SoftGas</a></h1>
                <!-- Uncomment below if you prefer to use an image logo -->
                <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

                <nav class="nav-menu d-none d-lg-block">
                    <ul>
                        <li class="active"><a href="index.jsp">Inicio</a></li>                        
                        <li><a href="#">Productos</a></li>
                    </ul>
                </nav><!-- .nav-menu -->
                <a href="pedidos.jsp"  class="appointment-btn" id="shop-cart" >
                    Hacer Pedido
                </a>                
            </div>
        </header><!-- End Header -->
        <!--========= Pedidos Sectio ============-->
        <section id="inicio">
            <div class="container">
                <div class="section-title">
                    <h2>Consultar Pedidos</h2>
                    <div class="container">
                        <p class="mb-4">Ingresa tu DNI para consultar tus pedidos o ver el estado de tus pedidos</p>
                        <div class="row d-flex justify-content-center" >
                            <div class="form-group col-sm-6">
                                <input id="txtDNI" name="txtDNI" type="number" class="form-control">                                    
                            </div>
                            <div clas="col-sm">
                                <button onclick="buscarPedidos()" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="container" >
                                <p id="mensajeError" class="text-danger d-none">Ingresa tu DNI correctamente</p>
                            </div>
                        </div>
                    </div>
                    <div class="container" id="lstPedidos"></div>
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
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<script>
                                    const divLista = document.getElementById("lstPedidos");
                                    const error = document.getElementById("mensajeError");
                                    const validarDni = (dni) => {
                                        if (!error.classList.contains("d-none")) {
                                            error.classList.add("d-none");
                                        }
                                        var filtroRx = /^\d{8}(?:[-\s]\d{4})?$/;
                                        if (filtroRx.test(dni) === true) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    }
                                    function buscarPedidos() {


                                        param = document.getElementById("txtDNI").value;

                                        if (validarDni(param)) {
                                            axios({
                                                method: 'POST',
                                                url: 'buscarPedido.html',
                                                data: 'txtDNI=' + param,
                                            }).then((res) => {
                                                console.log("Correcto!" + res.data);
                                                data = res.data;
                                                divLista.innerHTML = res.data;
                                            }).catch((e) => {
                                                console.log("Ha ocurrido un error: ", e);
                                            });
                                        } else {
                                            error.classList.remove("d-none");
                                        }


                                    }

</script>
</html>
