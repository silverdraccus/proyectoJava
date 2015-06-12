<%-- 
    Document   : altaBajaMedico
    Created on : 11/06/2015, 02:05:26 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta medico</title>
    </head>
    <body>
        <form action="altaMedico" method="post">
            <label>RFC</label>
            <input type="text" name="rfc">
            <br>
 
            <label>Nombre</label>
            <input type="text" name="nombre">
            <br>
 
            
            <label>Especialidad</label>
            <input type="text" name="especialidad">
            <br>
 
            
            <label>Turno</label>
            <input type="text" name="turno">
            <br>
 
            
            <label>Consultorio</label>
            <input type="text" name="consultorio">
            <br>   
            
            <input type="submit" name="altaMedico" value="dar de alta">
 
 
        </form>
    </body>
</html>
