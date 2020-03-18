<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 18.03.2020
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translations" var="bundle"/>
<html>
<head>
    <title>Language</title>
</head>
<body>
<div align="right">
    <form action="${pageContext.request.contextPath}/language" method="get">
        <fmt:message key="language" bundle="${bundle}"/> <select name="language">
        <option value="en_EN"><fmt:message key="english" bundle="${bundle}"/></option>
        <option value="ru_RU"><fmt:message key="russian" bundle="${bundle}"/></option>
    </select>
        <input type="submit" value="<fmt:message key="choose" bundle="${bundle}"/>"/>
    </form>
</div>
</body>
</html>
