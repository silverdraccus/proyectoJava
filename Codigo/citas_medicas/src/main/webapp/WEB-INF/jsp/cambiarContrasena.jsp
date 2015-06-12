<%-- 
    Document   : cambiarContrasena
    Created on : 11/06/2015, 10:21:00 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar Contrase&ntilde;a</title>
    </head>
    <body>
        <form action="cambiarContrasena" method="post">
            <label>Escribe tu antigua contrase&ntilde;a</label>
            <input type="password" name="contrasenaAntigua">
            <br>
            <label>Escribe tu nueva contrase&ntilde;a</label>
            <input type="password" name="contrasenaNueva">
            <br>
            <label>Confirma tu nueva contrase&ntilde;a</label>
            <input type="password" name="contrasenaNuevaConfirmacion">
            <br>
                
            <input type="submit" name="guardarContrasena" value="cambiar contraseña">
            <br>
            
        </form>
    </body>
</html>
