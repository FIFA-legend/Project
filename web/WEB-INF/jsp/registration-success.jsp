<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translations" var="bundle"/>
<html>
<head>
    <title><fmt:message key="account.created" bundle="${bundle}"/></title>
</head>
<body>
    <div align="center">
        <p><fmt:message key="message1" bundle="${bundle}"/></p>
        <p><fmt:message key="congratulations" bundle="${bundle}"/>!!!</p>
        <p><fmt:message key="message2" bundle="${bundle}"/>=${requestScope.id} <fmt:message key="message3" bundle="${bundle}"/>.</p>
        <input class="button-main-page" type="button" value="<fmt:message key="go.back" bundle="${bundle}"/>" onclick="location.href = '/login'">
    </div>
</body>
</html>
