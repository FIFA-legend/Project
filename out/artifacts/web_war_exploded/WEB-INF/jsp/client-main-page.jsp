<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 08.03.2020
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <div align="center">
        Hello, ${sessionScope.user.getName()} ${sessionScope.user.getLastName()}
        <p><input class="button-main-page" type="button" value="Order a taxi" onclick="location.href = '/request/save'"></p>
    </div>
</body>
</html>
