<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/timeline.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/sb-admin-2.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
        <title>Servicios Medicos</title>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Ingreso</h3>
                        </div>
                        <div class="panel-body">
                            <c:url var="addAction" value="/login.jsp" ></c:url>
                            <form:form action="${addAction}" commandName="usuario">
                            <!--form action="LoginController" method="post" role="form"-->
                                <fieldset>
                                    <div class="form-group">
                                        <form:input cssClass="form-control" path="nombre" />
                                        <!--input class="form-control" placeholder="Usuario" 
                                        name="usuario" type="text" autofocus-->
                                    </div>
                                    <div class="form-group">
                                        <form:input cssClass="form-control" path="password" />
                                        <!--input class="form-control" placeholder="Password" name="password"
                                        type="password" value=""-->
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <input type="submit" name="submit" value="Login" class="btn btn-lg btn-success btn-block"/>
                                </fieldset>
                            <!--/form>-->
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js" />"></script>
        <script src="<c:url value="/resources/js/sb-admin-2.js" />"></script>
    </body>
</html>
