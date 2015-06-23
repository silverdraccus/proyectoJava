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
        <form:form action="${addAction}" modelAttribute="doctorForm" method="post">
        <fieldset>
                <form:label path="rfc">RFC</form:label>
                <form:input path="rfc" />
            <br>
 
            <form:label path="nombre">Nombre</form:label>
            <form:input path="nombre"/>
            <br>
 
            
            <form:label path="especialidad">Especialidad</form:label>          
            <form:select path="especialidad">    
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${especialidades}" />
            </form:select>
            <br>
 
            
            <form:label path="turno">Turno</form:label>  
            <form:select path="turno">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${turnos}" />
            </form:select>
            <br>
            
            <form:label path="consultorio">Consultorio</form:label>           
            <form:select path="consultorio">
                 <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${consultorios}" />
            </form:select>  
            
            <br>   
            
            <input type="submit" name="altaMedico" value="dar de alta">
        </fieldset>
 
        </form:form>
    </body>
</html>
