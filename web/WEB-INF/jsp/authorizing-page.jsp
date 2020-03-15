<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:if test="${requestScope.passwordMatch == false}">Wrong login or password</c:if>
        <p>Don't have an account?</p>
        <input class="button-main-page" type="submit" value="Create it" onclick="location.href = '/user/save'">
    </div>
</body>
</html>
