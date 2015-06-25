<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <jsp:include page="/headers.jsp"></jsp:include>
    <link href="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bower_components/datatables-responsive/css/dataTables.responsive.css" />" rel="stylesheet">
    <body>
         <jsp:include page="/menu.jsp"></jsp:include> 
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Doctores</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Informaci&oacute;n de los doctores
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>id_usuario</th>
                                            <th>RFC</th>
                                            <th>Nombre</th>
                                            <th>Especialidad</th>
                                            <th>Turno</th>
                                            <th>Consultorio</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="doctor" items="${doctores}" varStatus="counter">
                                            <c:choose>
                                                <c:when test="${counter.count % 2 == 0}">
                                                    <c:set var="rowStyle" scope="page" value="odd"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:set var="rowStyle" scope="page" value="even"/>
                                                </c:otherwise>
                                            </c:choose>
                                            <tr class="${rowStyle}">
                                                <td>${doctor.usuario.idUs}</td>
                                                <td>${doctor.rfc}</td>
                                                <td>${doctor.nombre}</td>
                                                <td>${doctor.especialidad.especialidad}</td>
                                                <td>${doctor.turno.turno}</td>
                                                <td>${doctor.consultorio.consultorio}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <jsp:include page="/footer.jsp"></jsp:include>
        <script src="<c:url value="/resources/bower_components/datatables/media/js/jquery.dataTables.js" />"></script>
        <script src="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js" />"></script>
        <script>
        $(document).ready(function() {
            $('#dataTables-example').DataTable({
                    responsive: true
            });
        });
        </script>
    </body>
</html>
