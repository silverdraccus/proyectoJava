<%-- 
    Document   : cambiarUsuario
    Created on : 11/06/2015, 10:20:41 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        

    <c:url var="addAction" value="/cambiarUsuario.jsp" ></c:url>
    <form:form action="${addAction}" modelAttribute="usuarioForm" method="post">      
        <form:label path="nombre">Escribe tu nuevo usuario</form:label>
        <form:input path="nombre"/>

        <br>

        <input type="submit" name="guardarUsuarioNuevo" value="guardar nuevo usuario"/>
    </form:form>
</body>
</html>
