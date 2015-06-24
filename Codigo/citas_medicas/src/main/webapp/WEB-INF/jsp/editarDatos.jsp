<%-- 
    Document   : editarDatos
    Created on : 11/06/2015, 02:15:17 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar datos de paciente</title>
    </head>
    <body>
        <c:url var="addAction" value="/guardarPaciente.jsp" ></c:url>
    <form:form action="${addAction}" method="post" modelAttribute="pacienteForm">
        <table border="1">
            <tr>
                <td>N&uacute;mero de cuenta</td>
                <td>${pacienteForm.noCuenta}</td>
            </tr>
            <tr> 
                <td>nombre</td>             
                <td>${pacienteForm.nombre}</td>
            </tr>
            <tr>          
                <td>carrera</td>
                <td>${pacienteForm.carrera}</td>

            </tr>
            <tr>
                <td>fechaNacimiento</td>
                <td>${pacienteForm.fechaNacimiento}</td>

            </tr>
            <tr>
                <td>semestreVigente</td>
                <td>${pacienteForm.semestreVigente}</td>
            </tr>
            <tr>
                <td>dirCalle</td>
                <td>${pacienteForm.dirCalle}</td>                
            </tr>
            <tr>
                <td>dirNumero</td>
                <td>${pacienteForm.dirNumero}</td>            
            </tr>
            <tr>
                <td>dirColonia</td>            
                <td>${pacienteForm.dirColonia}</td>

            </tr>
            <tr>
                <td>tel&eacute;fono</td>
                <td>${pacienteForm.telefono}</td>
            </tr>
            <tr>
                <td>correo electr&oacute;nico</td>
                <td>${pacienteForm.correoE}</td>                   

            </tr>
            <tr>
                <td>cambiar nombre de usuario</td>

                <td>
                    <a href="/cambiarusuario">
                        Cambiar usuario
                    </a>                                       
                </td>  
            </tr>
            <tr>
                <td>cambiar contraseña</td>                           
                <td> 
                    <a href="/cambiarContrasena">
                        Cambiar contrase&ntilde;a
                    </a>                                           
                </td>  
            </tr>
            <tr>



            </tr>
            </c:forEach>
        </table>
    </form:form>

</body>
</html>
