<%-- 
    Document   : citasPaciente
    Created on : 11/06/2015, 12:59:25 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>crearNuevaCita</title>
    </head>
    <body>

        <c:url var="addAction" value="/crearNuevaCita.jsp" ></c:url>
        <form:form action="${addAction}" method="post" modelAttribute="cita">           
            <form:input path="fecha"/>
            <form:input path="hora"/>
            <%-- dado que se está agregando suponemos está activa--%>
            <form:input type="hidden" path="estatus"/>            
            <form:input path="noCuenta"/>
            <input type="submit" name="guardarCita" value="guardar cita"/>
        </form:form>
    </body>
</html>
