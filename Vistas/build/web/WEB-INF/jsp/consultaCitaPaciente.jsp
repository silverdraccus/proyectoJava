<%-- 
    Document   : consultaCitaPaciente
    Created on : 11/06/2015, 02:10:48 PM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de citas</title>
    </head>
    <body>
         <br>

        <a href="${pageContext.request.contextPath}/crearNuevaCita?rfc=${cita.rfc}">
			Agregar nueva cita
        </a>	
        <br>        
        <a href="${pageContext.request.contextPath}/editarDatos=${cita.noCuenta}">
							editarDatos						       
        </a>                        

                        <br>
        <table border="1">
            <tr> 
                <th>id_cit</th> 
                <th>fecha</th>
                <th>hora</th>
                <th>estatus</th>
                <th>eliminar cita</th>
                <th>cancelar cita</th>
            </tr>
            <c:forEach var="cita" items="{citas}">
                <tr>
                    <td>${cita.id_cit} </td>
                    <td>${cita.fecha}</td>
                    <td>${cita.estatus}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/eliminaCitasPaciente?id_cit=${cita.id_cit}">
							eliminar cita
                        </a>                       
                    </td>                                       
                    <td>
                        <a href="${pageContext.request.contextPath}/cancelarCitasPaciente?id_cit=${cita.id_cit}">
							cancelar cita						
                        </a>            
                    </td>

                </tr>
            </c:forEach>
        </table>
    </body>
</html>
