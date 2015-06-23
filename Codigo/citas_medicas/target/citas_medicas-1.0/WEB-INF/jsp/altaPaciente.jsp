<%-- 
    Document   : altaPaciente
    Created on : 11/06/2015, 02:05:49 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:url var="addAction" value="/altaPaciente.jsp" ></c:url>
        <form:form action="${addAction}" commandName="paciente" method="post">
        <fieldset>
            <form:label path="noCuenta">N&uacute;mero de Cuenta</form:label>
            <form:input path="noCuenta"/>
            <br>

            <form:label path="nombre">Nombre</form:label>
            <form:input path="nombre"/>
            <br>


            <form:label path="carrera">Carrera</form:label>
            <form:input path="carrera"/>
            <br>


            <form:label path="fechaNacimiento">Fecha de Nacimiento(YYYY-MM-DD)</form:label>
            <form:input path="fechaNacimiento"/>
            <br>


            <form:label path="semestreVigente">Semestre Vigente</form:label>
            <form:input path="semestreVigente"/>
            <br>   

            <form:label path="dirCalle">Calle</form:label>
            <form:input path="dirCalle"/>
            <br>   


            <form:label path="dirNumero">N&uacute;mero</form:label>
            <form:input path="dirNumero"/>
            <br>   


            <form:label path="dirColonia">C.P.</form:label>
            <form:input path="dirColonia"/>
            <br>   


            <form:label path="telefono">Tel&eacute;fono</form:label>
            <form:input path="telefono"/>
            <br>   

            <form:label path="correoE">Correo Electr&oacute;nico</form:label>
            <form:input path="correoE"/>
            <br>   

            <input type="submit" name="altaPaciente" value="dar de alta">
        </fieldset>

    </form:form>
</body>
</html>
