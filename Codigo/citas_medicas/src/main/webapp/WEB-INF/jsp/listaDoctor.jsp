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
                            <c:if test="${not empty msj}">
                                <div class="alert alert-danger alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    ${msj}
                                </div>
                            </c:if>
                            <div class="dataTable_wrapper">
                                <c:url var="addAction" value="/actualizaDoctor.jsp" ></c:url>
                                <form:form action="${addAction}" modelAttribute="doc">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>RFC</th>
                                            <th>Nombre</th>
                                            <th>Especialidad</th>
                                            <th>Turno</th>
                                            <th>Consultorio</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="d" items="${doctores}" varStatus="counter">
                                            <c:choose>
                                                <c:when test="${counter.count % 2 == 0}">
                                                    <c:set var="rowStyle" scope="page" value="odd"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:set var="rowStyle" scope="page" value="even"/>
                                                </c:otherwise>
                                            </c:choose>
                                            <tr class="${rowStyle}">
                                                <td><form:radiobutton path="rfc" value="${d.rfc}"/>${d.rfc}</td>
                                                <td>${d.nombre}</td>
                                                <td>${d.especialidad.especialidad}</td>
                                                <td>${d.turno.turno}</td>
                                                <td class="center">${d.consultorio.consultorio}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="row">
                                    <div class="col-sm-4"></div>
                                    <div class="col-sm-2">
                                        <input type="submit" name="action" value="Editar" class="btn btn-lg btn-info btn-block"/>
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="submit" name="action" value="Borrar" class="btn btn-lg btn-danger btn-block"/>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                </form:form>
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
