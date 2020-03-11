<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 08.03.2020
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save request</title>
</head>
<body>
    <div align="center">
        <form action="${pageContext.request.contextPath}/request/save" method="post">
            Begin Time <br><br>
            Year: <select name="beginTimeYear">
            <c:forEach var="i" begin="2020" end="2030">
                <option value="${i}">${i}</option>
            </c:forEach>
            </select>
            Month: <select name="beginTimeMonth">
            <option value="0">January</option>
            <option value="1">February</option>
            <option value="2">March</option>
            <option value="3">April</option>
            <option value="4">May</option>
            <option value="5">June</option>
            <option value="6">July</option>
            <option value="7">August</option>
            <option value="8">September</option>
            <option value="9">October</option>
            <option value="10">November</option>
            <option value="11">December</option>
            </select>
            Day: <select name="beginTimeDay">
            <c:forEach var="i" begin="1" end="31">
                <option value="${i}">${i}</option>
            </c:forEach>
            </select><br><br>
            Number of Days: <input type="number" name="numberOfDays"><br><br>
            If you rent a car for 10+ days, 10% sale <br><br>
            If you rent a car for 30+ days, 15% sale <br><br>
            Car: <select name="car">
                <c:forEach var="car" items="${requestScope.cars}">
                    <option value="${car.getId()}"> <c:out value="${car.getModel()} ${car.getBrand()} (${car.getCarType()})"></c:out></option>
                </c:forEach>
            </select><br><br>
            One day of a normal car is 30$<br><br>
            One day of a sport car is 50$<br><br>
            One day of a business car is 100$<br><br>
        <input type="submit" value="Save">
        </form>
    </div>
</body>
</html>
