<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 09.03.2020
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="request" var="bundle1"/>
<html>
<head>
    <title><fmt:message key="request.accepted" bundle="${bundle1}"/></title>
</head>
<body>
    <div align="center">
        <fmt:message key="accepted" bundle="${bundle1}"/>!!!<br><br>
        <fmt:message key="cost" bundle="${bundle1}"/> ${requestScope.cost} <fmt:message key="dollars" bundle="${bundle1}"/>. <br><br>
        <fmt:message key="driver" bundle="${bundle1}"/> ${requestScope.driver.getName()} ${requestScope.driver.getLastName()}<br><br>
    </div>
</body>
</html>
