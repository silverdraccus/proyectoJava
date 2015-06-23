<%-- 
    Document   : mostrarAltaMedico
    Created on : 23/06/2015, 10:58:53 AM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos médico</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${isDoctor}">
                <h1>El médico se dió de alta de manera exitosa</h1>
                <table>
                    <tr>
                        <th>rfc</th>
                        <th>nombre<th>
                        <th>especialidad</th>          
                        <th>turno</th>
                        <th>consultorio</th>
                        <th>nombre</th>
                        <th>contraseña</th> 
                    </tr>
                    <tr>
                        <td>${doctorForm.rfc}</td>
                        <td>${doctorForm.nombre}<td>
                        <td>${doctorForm.especialidad}</td>          
                        <td>${doctorForm.turno}</td>
                        <td>${doctorForm.consultorio}</td>
                        <td>${usuario.nombre}</td>
                        <td>${usuario.password}</td>           
                    </tr>

                </table>
            </c:when>
            <c:otherwise>
                <h1>El paciente se dió de alta de manera exitosa</h1>
                <table>
                    <tr>

                        <th>N&uacute;mero de Cuenta</th>           
                        <th>Nombre</th>
                        <th>Carrera</th>
                        <th>Fecha de Nacimiento(YYYY-MM-DD)</th>
                        <th>Semestre Vigente</th>
                        <th>Calle</th>
                        <th>N&uacute;mero</th>
                        <th>C.P.</th>
                        <th>Tel&eacute;fono</th>
                        <th>Correo Electr&oacute;nico</th>
                        <th>nombre1</th>
                        <th>contraseña1</th> 
                    </tr>
                    <tr>
                        <td> ${pacienteForm.noCuenta}</td>
                        <td> ${pacienteForm.nombre}</td>
                        <td> ${pacienteForm.carrera}</td>
                        <td> ${pacienteForm.fechaNacimiento}</td>
                        <td> ${pacienteForm.semestreVigente}</td>
                        <td> ${pacienteForm.dirCalle}</td>
                        <td> ${pacienteForm.dirNumero}</td>
                        <td> ${pacienteForm.dirColonia}</td>
                        <td> ${pacienteForm.telefono}</td>
                        <td> ${pacienteForm.correoE}</td>
                        <td>${usuario.nombre}</td>
                        <td>${usuario.password}</td>           
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>


    </body>
</html>
