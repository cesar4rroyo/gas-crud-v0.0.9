<%-- 
    Document   : pedido
    Created on : 11 oct. 2020, 17:44:24
    Author     : cesar4rroyo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="beans.beanProducto"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.daoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- ======= Top Bar ======= -->
        <div id="topbar" class="d-none d-lg-flex align-items-center fixed-top">
            <div class="container d-flex">
                <div class="contact-info mr-auto">
                    <i class="icofont-envelope"></i> <a href="mailto:contact@example.com">contact@softgas.com</a>
                    <i class="icofont-phone"></i> +51 923 543 210
                    <i class="icofont-google-map"></i> Chiclayo, Lambayeque
                </div>
                <div class="social-links">
                    <a href="#" class="twitter"><i class="icofont-twitter"></i></a>
                    <a href="#" class="facebook"><i class="icofont-facebook"></i></a>
                    <a href="#" class="instagram"><i class="icofont-instagram"></i></a>
                    <a href="#" class="skype"><i class="icofont-skype"></i></a>
                    <a href="#" class="linkedin"><i class="icofont-linkedin"></i></a>
                </div>
            </div>
        </div>
        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top">
            <div class="container d-flex align-items-center">

                <h1 class="logo mr-auto"><a href="index.html">SoftGas</a></h1>
                <!-- Uncomment below if you prefer to use an image logo -->
                <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

                <nav class="nav-menu d-none d-lg-block">
                    <ul>
                        <li class="active"><a href="#inicio">Inicio</a></li>                        
                        <li><a href="#services">Productos</a></li>
                        <li><a href="#contact">Contacto</a></li>

                    </ul>
                </nav><!-- .nav-menu -->
                <a href="login.jsp" class="appointment-btn scrollto">Login</a>
            </div>
        </header><!-- End Header -->
        <!--========= Pedidos Sectio ============-->
        <section id="inicio">
            <div class="container mt-5 pt-4">
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
                            <div class="icon-box mt-4 mt-xl-0">
                                <img class="img-balon" src="<%= bPdto.getImage_ref()%>" alt="Img ref">
                                <hr>
                                <h4><%= bPdto.getNombre_producto()%></h4>
                                <p><%= bPdto.getDescripcion()%></p>
                                <a href="#" class="btn btn-outline-primary mt-2">Agregar</a>                                    
                            </div>
                        </div>
                        <%}%>
                    </div>


                </div>
            </div>
        </section>
        <!--============End Pedidos ==============-->
        <!-- ======= Contact Section ======= -->
        <section id="contact" class="contact">
            <div class="container">
                <div class="section-title">
                    <h2>Contacto</h2>
                    <p> Nuestro local principal se encuentra ubicado aqui: </p>
                </div>
            </div>

            <div>
                <iframe style="border:0; width: 100%; height: 350px;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3961.839898901976!2d-79.84915648563353!3d-6.789327995092671!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x904cef3ed10535b1%3A0x78d437cc8576c717!2sGrifo%20Pecsa!5e0!3m2!1ses-419!2spe!4v1601333878125!5m2!1ses-419!2spe" frameborder="0" allowfullscreen></iframe>
            </div>

            <div class="container">
                <div class="row mt-5">

                    <div class="col-lg-4">
                        <div class="info">
                            <div class="address">
                                <i class="icofont-google-map"></i>
                                <h4>Ubicación:</h4>
                                <p>Av. Grau 2032, Chiclayo - Lambayeque</p>
                            </div>

                            <div class="email">
                                <i class="icofont-envelope"></i>
                                <h4>Email:</h4>
                                <p>contact@softgas.com</p>
                            </div>

                            <div class="phone">
                                <i class="icofont-phone"></i>
                                <h4>Teléfono:</h4>
                                <p>+51 923 543 210</p>
                            </div>

                        </div>

                    </div>

                    <div class="col-lg-8 mt-5 mt-lg-0">

                        <form role="form" class="php-email-form">
                            <div class="form-row">
                                <div class="col-md-6 form-group">
                                    <input type="text" name="name" class="form-control" id="name" placeholder="Nombre" data-rule="minlen:4" data-msg="Por favor escriba al menos 4 caracteres " />
                                    <div class="validate"></div>
                                </div>
                                <div class="col-md-6 form-group">
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Email" data-rule="email" data-msg="Este email no es válido" />
                                    <div class="validate"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="subject" id="subject" placeholder="Asunto" data-rule="minlen:4" data-msg="Por favor escriba al menos 8 caracteres" />
                                <div class="validate"></div>
                            </div>
                            <div class="form-group">
                                <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Por favor escriba algo para nosotros" placeholder="Mensaje"></textarea>
                                <div class="validate"></div>
                            </div>
                            <div class="mb-3">
                                <div class="loading">Loading</div>
                                <div class="error-message"></div>
                                <div class="sent-message">Your message has been sent. Thank you!</div>
                            </div>
                            <div class="text-center"><button type="submit">Enviar Mensaje</button></div>
                        </form>

                    </div>

                </div>

            </div>
        </section><!-- End Contact Section -->

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
</html>
