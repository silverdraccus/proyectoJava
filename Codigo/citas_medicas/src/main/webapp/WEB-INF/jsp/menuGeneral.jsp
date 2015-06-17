<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <jsp:include page="/headers.jsp"></jsp:include>
    <body>
        <div class="container" style="min-height: 203px;">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Sistema de Citas Médicas</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <h2>Bienvenid@</h2>
                    <c:if test="${not empty isDoctor}">
                        doctor!
                    </c:if>
                    <c:if test="${not empty isAdmin}">
                        admin!
                    </c:if>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4"></div>
            </div>
            <!-- /.row -->
          
        </div>
       
        <jsp:include page="/footer.jsp"></jsp:include>
    </body>
    
</html>
