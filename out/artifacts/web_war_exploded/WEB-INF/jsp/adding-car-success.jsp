<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translations" var="bundle"/>
<html>
<head>
    <title><fmt:message key="car.added" bundle="${bundle}"/></title>
</head>
<body>
    <div align="center">
        <p><fmt:message key="car.added" bundle="${bundle}"/> <fmt:message key="successfully" bundle="${bundle}"/></p>
        <input class="button-main-page" type="button" value="<fmt:message key="add.new" bundle="${bundle}"/>" onclick="location.href = '/car/save'">
    </div>
</body>
</html>
