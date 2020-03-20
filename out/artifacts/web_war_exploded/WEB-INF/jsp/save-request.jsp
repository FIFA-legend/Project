<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 08.03.2020
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="request" var="bundle1"/>
<html>
<head>
    <title><fmt:message key="save.request" bundle="${bundle1}"/></title>
</head>
<body>
<%@include file="language.jsp"%>
    <div align="center">
        <form action="${pageContext.request.contextPath}/request/save" method="post">
            <fmt:message key="begin.time" bundle="${bundle1}"/> <br><br>
            <fmt:message key="year" bundle="${bundle1}"/>: <select name="beginTimeYear">
            <c:forEach var="i" begin="2020" end="2030">
                <option value="${i}">${i}</option>
            </c:forEach>
            </select>
            <fmt:message key="month" bundle="${bundle1}"/>: <select name="beginTimeMonth">
            <option value="0"><fmt:message key="january" bundle="${bundle1}"/></option>
            <option value="1"><fmt:message key="february" bundle="${bundle1}"/></option>
            <option value="2"><fmt:message key="march" bundle="${bundle1}"/></option>
            <option value="3"><fmt:message key="april" bundle="${bundle1}"/></option>
            <option value="4"><fmt:message key="may" bundle="${bundle1}"/></option>
            <option value="5"><fmt:message key="june" bundle="${bundle1}"/></option>
            <option value="6"><fmt:message key="july" bundle="${bundle1}"/></option>
            <option value="7"><fmt:message key="august" bundle="${bundle1}"/></option>
            <option value="8"><fmt:message key="september" bundle="${bundle1}"/></option>
            <option value="9"><fmt:message key="october" bundle="${bundle1}"/></option>
            <option value="10"><fmt:message key="november" bundle="${bundle1}"/></option>
            <option value="11"><fmt:message key="december" bundle="${bundle1}"/></option>
            </select>
            <fmt:message key="day" bundle="${bundle1}"/>: <select name="beginTimeDay">
            <c:forEach var="i" begin="1" end="31">
                <option value="${i}">${i}</option>
            </c:forEach>
            </select><br><br>
            <fmt:message key="day.number" bundle="${bundle1}"/>: <input type="number" name="numberOfDays"><br><br>
            <fmt:message key="rent.10" bundle="${bundle1}"/> <br><br>
            <fmt:message key="rent.30" bundle="${bundle1}"/> <br><br>
            <fmt:message key="car" bundle="${bundle1}"/>: <select name="car">
                <c:forEach var="car" items="${requestScope.cars}">
                    <option value="${car.getId()}"> <c:out value="${car.getModel()} ${car.getBrand()} (${car.getCarType()})"></c:out></option>
                </c:forEach>
            </select><br><br>
            <fmt:message key="day.normal" bundle="${bundle1}"/><br><br>
            <fmt:message key="day.sport" bundle="${bundle1}"/><br><br>
            <fmt:message key="day.business" bundle="${bundle1}"/><br><br>
            <c:if test="${requestScope.driversAvailable == false}">
                <p><fmt:message key="no.drivers" bundle="${bundle1}"/></p>
                <p><fmt:message key="later" bundle="${bundle1}"/></p>
            </c:if>
        <input type="submit" value="<fmt:message key="save" bundle="${bundle1}"/>">
        </form>
    </div>
</body>
</html>
