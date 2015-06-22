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
            <label>N&uacute;mero de Cuenta</label>
            <form:input path="noCuenta"/>
            <br>

            <label>Nombre</label>
            <form:input path="nombre"/>
            <br>


            <label>Carrera</label>
            <form:input path="carrera"/>
            <br>


            <label>Fecha de Nacimiento</label>
            <form:input path="fechaNacimiento"/>
            <br>


            <label>Semestre Vigente</label>
            <form:input path="semestreVigente"/>
            <br>   

            <label>Calle</label>
            <form:input path="dirCalle"/>
            <br>   


            <label>N&uacute;mero</label>
            <form:input path="dirNumero"/>
            <br>   


            <label>C.P.</label>
            <form:input path="dirColonia"/>
            <br>   


            <label>Tel&eacute;fono</label>
            <form:input type="text" path="telefono"/>
            <br>   

            <label>Correo Electr&oacute;nico</label>
            <form:input path="correoE"/>
            <br>   

            <input type="submit" name="altaPaciente" value="dar de alta">
        </fieldset>

    </form:form>
</body>
</html>
