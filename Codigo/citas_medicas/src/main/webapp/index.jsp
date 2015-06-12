
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>

    <body>
        <form action="login.jsp" method="post">
            <label>Usuario</label>
            <input type="text" user="username"/>
            <br>
            <label>Contraseña</label>
            <input type="password" password="password"/>
            <br>
            <input type="submit" name="submit" value="Login"/>
        </form>
    </body>
</html>
