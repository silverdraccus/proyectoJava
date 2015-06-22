<%-- 
    Document   : editarDatos
    Created on : 11/06/2015, 02:15:17 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar datos de paciente</title>
    </head>
    <body>
        <table border="1">
            <tr> 
nombre varchar(255),
carrera varchar(255),
fechaNacimiento date,
semestreVigente integer(10),
dirCalle varchar(255),
dirNumero integer(10),
dirColonia integer(10),
telefono varchar(255),
correoE varchar(255),
id_us integer(10),

                <th>nombre</th> 
                <th>carrera</th>
                <th>fechaNacimiento</th>
                <th>semestreVigente</th>
                <th>dirCalle</th>
                <th>dirNumero</th>
                <th>dirColonia</th>
                <th>tel&eacute;fono</th>
                <th>correo electr&oacute;nico</th>
                <th>telefono</th>
                <th>cambiar nombre de usuario</th>
                <th>cambiar contraseña</th>
            </tr>
            <c:forEach var="paciente" items="{paciente}">
                <tr>
                    <td>${paciente.nombre} </td>
                    <td>${paciente.carrera}</td>
                    <td>${paciente.fechaNacimiento}</td>
                    <td>${paciente.semestreVigente}</td>
                    <td>${paciente.dirCalle}</td>
                    <td>${paciente.dirNumero}</td>
                    <td>${paciente.dirColonia}</td>
                    <td>${paciente.telefono}</td>
                    <td>${paciente.correoE}</td>                   
                    <td>
                        <a href="${pageContext.request.contextPath}/cambiarusuario?noCuenta=${paciente.noCuenta}">
							Cambiar usuario
                        </a>                       
                    </td>                                       
                    <td>
                        <a href="${pageContext.request.contextPath}/cambiarContrasena?noCuenta=${paciente.noCuenta}">
							Cambiar usuario
                        </a>                       
                    </td>  

                </tr>
            </c:forEach>
        </table>

    </body>
</html>
