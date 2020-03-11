<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization completed</title>
</head>
<body>
    <div align="center">
        <p>You've created an account</p>
        <p>Congratulation!!!</p>
        <p>Use your id=${requestScope.id} as login for the next time. </p>
        <input class="button-main-page" type="button" value="Go back" onclick="location.href = '/login'">
    </div>
</body>
</html>
