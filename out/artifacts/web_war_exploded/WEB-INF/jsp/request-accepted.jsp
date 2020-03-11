<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 09.03.2020
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request accepted</title>
</head>
<body>
    <div align="center">
        Your request is accepted!!!<br><br>
        It will cost you ${requestScope.cost} dollars. <br><br>
        Your driver is ${requestScope.driver.getName()} ${requestScope.driver.getLastName()}<br><br>
    </div>
</body>
</html>
