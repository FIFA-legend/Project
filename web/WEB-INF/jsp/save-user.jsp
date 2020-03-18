<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translations" var="bundle"/>
<html>
<head>
    <title><fmt:message key="save.user" bundle="${bundle}"/></title>
</head>
<body>
<%@include file="language.jsp"%>
    <div align="center">
        <form action="${pageContext.request.contextPath}/user/save" method="post">
            <fmt:message key="name" bundle="${bundle}"/>: <input name="name"/> <br><br>
            <fmt:message key="surname" bundle="${bundle}"/>: <input name="surname"/> <br><br>
            <fmt:message key="password" bundle="${bundle}"/>: <input type="password" name="password"/> <br><br>
            <fmt:message key="rep.pas" bundle="${bundle}"/>: <input type="password" name="repPassword"/> <br><br>
            <fmt:message key="role" bundle="${bundle}"/>: <select name="role">
                <option value="CLIENT"><fmt:message key="client" bundle="${bundle}"/></option>
                <option value="DISPATCHER"><fmt:message key="dispatcher" bundle="${bundle}"/></option>
                <option value="DRIVER"><fmt:message key="driver" bundle="${bundle}"/></option>
            </select><br><br>
            <input type="submit" value="<fmt:message key="save" bundle="${bundle}"/>" /> <br><br>
        </form>
    </div>
</body>
</html>
