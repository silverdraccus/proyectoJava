<%-- 
    Document   : cambiarContrasena
    Created on : 11/06/2015, 10:21:00 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar Contrase&ntilde;a</title>
    </head>
    <body>

        <c:url var="addAction" value="/cambiarContrasena.jsp" ></c:url>
        <form:form action="${addAction}" method="post" modelAttribute="contrasena">
            <form:label path="contrasenaAntigua">Escribe tu antigua contrase&ntilde;a</form:label>
            <form:input path="contrasenaAntigua"/>
            <br>
            <form:label path="contrasenaNueva">Escribe tu nueva contrase&ntilde;a</form:label>
            <form:input path="contrasenaNueva"/>
            <br>
            <form:label path="contrasenaNuevaConfirmacion">Confirma tu nueva contrase&ntilde;a</form:label>
            <form:input path="contrasenaNuevaConfirmacion"/>
            <br>

            <input type="submit" name="guardarContrasena" value="cambiar contraseña">
            <br>

        </form:form>
    </body>
</html>
