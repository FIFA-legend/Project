<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translations" var="bundle"/>
<html>
<head>
    <title><fmt:message key="authorizing" bundle="${bundle}"/></title>
</head>
<body>
<%@include file="language.jsp"%>
<div align="center">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <fmt:message key="login" bundle="${bundle}"/>: <input name="login"/>
            <br><br>
            <fmt:message key="password" bundle="${bundle}"/>: <input type="password" name="password"/>
            <br><br>
            <input type="submit" value="<fmt:message key="continue" bundle="${bundle}"/>"/>
            <br><br>
        </form>
        <c:if test="${requestScope.passwordMatch == false}"><fmt:message key="wrong" bundle="${bundle}"/></c:if>
        <p><fmt:message key="account" bundle="${bundle}"/></p>
        <input class="button-main-page" type="submit" value="<fmt:message key="create" bundle="${bundle}"/>" onclick="location.href = '/user/save'">
    </div>
</body>
</html>
