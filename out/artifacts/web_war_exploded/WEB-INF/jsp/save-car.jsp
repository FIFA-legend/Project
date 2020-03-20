<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translations" var="bundle"/>
<html>
<head>
    <title><fmt:message key="save.car" bundle="${bundle}"/></title>
</head>
<body>
<%@include file="language.jsp"%>
    <div align="center">
        <form action="${pageContext.request.contextPath}/car/save" method="post">
            <fmt:message key="model" bundle="${bundle}"/>: <input name="model"><br><br>
            <fmt:message key="brand" bundle="${bundle}"/>: <input name="brand"><br><br>
            <fmt:message key="number" bundle="${bundle}"/>: <input name="number"><br><br>
            <fmt:message key="type" bundle="${bundle}"/>: <select name="carType">
                <option value="NORMAL"><fmt:message key="normal" bundle="${bundle}"/></option>
                <option value="BUSINESS"><fmt:message key="business" bundle="${bundle}"/></option>
                <option value="SPORT"><fmt:message key="sport" bundle="${bundle}"/></option>
            </select>
            <input type="submit" value="<fmt:message key="add.car" bundle="${bundle}"/>">
        </form>
    </div>
</body>
</html>
