<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorizing</title>
</head>
<body>
    <div align="center" >
        <form action="${pageContext.request.contextPath}/login" method="post">
            Login <input name="login"/> <br><br>
            Password <input type="password" name="password"/> <br><br>
            <input type="submit" value="Continue" /> <br><br>
        </form>
        <p>Don't have an account?</p>
        <input class="button-main-page" type="submit" value="Create it" onclick="location.href = '/user/save'">
    </div>
</body>
</html>
