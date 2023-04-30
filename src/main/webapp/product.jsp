<%--
  Created by IntelliJ IDEA.
  User: sn09p
  Date: 29/04/2023
  Time: 4:46 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productos</title>
</head>
<body>
<h1>Verificar productos</h1>
<form action="/home/verification" method="post">
    <label for="id">Id</label>
    <div>
        <input type="text" name="id" id="id">
    </div>
    <div>
        <input type="submit" value="send">
    </div>
</form>
</body>
</html>
