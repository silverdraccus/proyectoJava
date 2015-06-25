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
            <form:label path="fecha">Fecha</form:label>
            <form:input path="fecha"/>
            <br>
            
            <form:label path="hora">Hora</form:label>
            <form:input path="hora"/>
            <br>
            
            <%-- dado que se está agregando suponemos está activa--%>
            <form:input type="hidden" path="estatus"/>
            <br>
            
            <form:label path="doctor.rfc">RFC</form:label>
            <form:input path="doctor.rfc"/>
            <br>
            
            <form:label path="paciente.noCuenta">N&uacute;mero de cuenta</form:label>
            <form:input path="paciente.noCuenta"/>
            <br>
            <input type="submit" name="guardarCita" value="guardar cita"/>
        </form:form>
    </body>
</html>
