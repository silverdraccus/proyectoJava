<%-- 
    Document   : altaBajaMedico
    Created on : 11/06/2015, 02:05:26 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta medico</title>
    </head>
    <body>
        <c:url var="addAction" value="/altaMedico.jsp" ></c:url>
        <form:form action="${addAction}" commandName="doctor">
            <fieldset>
            <label>RFC</label>
            <form:input path="rfc"/>
            <br>
 
            <label>Nombre</label>
            <form:input path="nombre"/>
            <br>
 
            
            <label>Especialidad</label>
            <form:input path="especialidad"/>
            <br>
 
            
            <label>Turno</label>
            <form:input path="turno"/>
            <br>
 
            
            <label>Consultorio</label>
            <form:input path="consultorio"/>
            <br>   
            
            <input type="submit" name="altaMedico" value="dar de alta">
            </fieldset>
 
        </form:form>
    </body>
</html>
