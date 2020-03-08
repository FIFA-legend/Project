<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 17:46
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
        <p>Want to add a car?<input class="button-main-page" type="button" value="Go" onclick="location.href = '/car/save'"></p>
    </div>
</body>
</html>
