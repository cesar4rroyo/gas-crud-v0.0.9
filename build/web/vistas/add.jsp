<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AGREGAR PROVEEDORES</h1>
        <form action="Controlador">
            ID:<br>
            <input class="form-control" readonly type="text" name="txtId"><br>
            Nombres: <br>
            <input class="form-control" type="text" name="txtNom"><br>
            Ruc <br>
            <input class="form-control" type="text" name="txtRuc"><br>
            Telefono <br>
            <input class="form-control" type="text" name="txtTel"><br>
            Direccion <br>
            <input class="form-control" type="text" name="txtDir"><br>
            <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
            <a class="btn btn-primary" href="Controlador?accion=listar">Regresar</a>
        </form>
    </body>
</html>
