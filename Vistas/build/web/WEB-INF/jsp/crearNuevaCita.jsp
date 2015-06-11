<%-- 
    Document   : citasPaciente
    Created on : 11/06/2015, 12:59:25 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>crearNuevaCita</title>
    </head>
    <body>
        <form action="crearNuevaCita" method="post">
            
            <input type="date" name="fecha"/>
            <input type="text" name="hora"/>
            <%-- dado que se está agregando suponemos está activa--%>
            <input type="hidden" name="estatus" value="1"/>            
            <input type="text" name="noCuenta"/>
            <input type="submit" name="guardarCita" value="guardar cita"/>
        </form>
    </body>
</html>
