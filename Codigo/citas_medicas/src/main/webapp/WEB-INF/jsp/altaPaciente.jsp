<%-- 
    Document   : altaPaciente
    Created on : 11/06/2015, 02:05:49 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="altaPaciente" method="post">
            <label>N&uacute;mero de Cuenta</label>
            <input type="text" name="noCuenta">
            <br>
 
            <label>Nombre</label>
            <input type="text" name="nombre">
            <br>
 
            
            <label>Carrera</label>
            <input type="text" name="carrera">
            <br>
 
            
            <label>Fecha de Naciemiento</label>
            <input type="date" name="fechaNacimiento">
            <br>
 
            
            <label>Semestre Vigente</label>
            <input type="text" name="semestreVigente">
            <br>   
            
            <label>Calle</label>
            <input type="text" name="dirCalle">
            <br>   


            <label>N&uacute;mero</label>
            <input type="text" name="dirNumero">
            <br>   


            <label>C.P.</label>
            <input type="text" name="dirColonia">
            <br>   


            <label>Tel&eacute;fono</label>
            <input type="text" name="telefono">
            <br>   

            <label>Correo Electr&oacute;nico</label>
            <input type="text" name="correoE">
            <br>   
            
            <input type="submit" name="altaPaciente" value="dar de alta">
 
 
        </form>
    </body>
</html>
