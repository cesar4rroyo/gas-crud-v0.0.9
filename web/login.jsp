<%@page session="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <link rel="icon" href="assets/img/gas.png" type="image/x-icon" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="assets/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form action="controladorLogin?accion=Ingresar" method="POST" class="login100-form validate-form">
                        <span class="login100-form-title p-b-1">
                            Bienvenido
                        </span>
                        <span class="login100-form-title p-b-1">
                            <img src="assets/img/gas.png" height="150">
                        </span>
                        <div class="wrap-input100 validate-input" data-validate = "El email es incorrecto">
                            <input class="input100" type="text" autocomplete="off" name="txtUser">
                            <span class="focus-input100" data-placeholder="Usuario"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Ingresar contraseña">
                            <span class="btn-show-pass">
                                <i class="zmdi zmdi-eye"></i>
                            </span>
                            <input class="input100" type="password" name="txtPass">
                            <span class="focus-input100" data-placeholder="Password"></span>
                        </div>
                        <%
                            if (request.getAttribute("error") != null) {

                        %>
                        <p class="text-center text-danger mb-2">Usuario o contraseña incorrectos</p>

                        <%}%>                        
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button type="submit" class="login100-form-btn">
                                    Ingresar
                                    <!--                                    <input class="bg-transparent" type="submit" name="accion"  value="Ingresar" >-->
                                </button>
                            </div>
                        </div>                       
                        <div class="text-center p-t-105">
                            <a class="txt2" href="#">
                                ¿Haz olvidado tu contraseña?
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%
            HttpSession sesion = request.getSession();
            String vista = "controladorPdto?accion=listar";
            if (request.getAttribute("username") != null && request.getAttribute("tipo") != null) {
                String username=request.getAttribute("username").toString();
                String tipo=request.getAttribute("tipo").toString();
                sesion.setAttribute("username", username);
                sesion.setAttribute("tipo", tipo);
                response.sendRedirect(vista);
            }
            if(request.getParameter("cerrar")!=null){
                    sesion.invalidate();
                    response.sendRedirect("login.jsp");
            }

        %>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/bootstrap/js/popper.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/daterangepicker/moment.min.js"></script>
        <script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="assets/js/main2.js"></script>

    </body>
</html>