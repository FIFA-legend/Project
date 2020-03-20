<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 08.03.2020
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translations" var="bundle"/>
<html>
<head>
    <title><fmt:message key="hello" bundle="${bundle}"/></title>
</head>
<body>
    <div align="center">
        <fmt:message key="hello" bundle="${bundle}"/>, ${sessionScope.user.getName()} ${sessionScope.user.getLastName()}
        <p><input class="button-main-page" type="button" value="<fmt:message key="order.taxi" bundle="${bundle}"/>" onclick="location.href = '/request/save'"></p>
    </div>
</body>
</html>
