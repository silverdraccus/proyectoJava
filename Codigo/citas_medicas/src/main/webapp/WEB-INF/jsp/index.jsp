<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <jsp:include page="/headers.jsp"></jsp:include>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <c:if test="${not empty msj}">
                        <div class="alert alert-danger alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            ${msj}
                        </div>
                    </c:if>
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Sistema de Citas M&eacute;dicas</h3>
                        </div>
                        <div class="panel-body">
                            <c:url var="addAction" value="/login.jsp" ></c:url>
                            <form:form action="${addAction}" modelAttribute="usuarioLogin">
                                <fieldset>
                                    <div class="form-group">
                                        <form:input cssClass="form-control" path="nombre" />
                                    </div>
                                    <div class="form-group">
                                        <form:password cssClass="form-control" path="password" />
                                    </div>
                                    <input type="submit" name="submit" value="Login" class="btn btn-lg btn-success btn-block"/>
                                </fieldset>
                            <!--/form>-->
                            </form:form>
                            <c:out value=""></c:out>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <jsp:include page="/footer.jsp"></jsp:include>
    </body>
</html>
