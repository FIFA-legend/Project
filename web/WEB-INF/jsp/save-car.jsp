<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Car</title>
</head>
<body>
    <div align="center">
        <form action="${pageContext.request.contextPath}/car/save" method="post">
            Model <input name="model"><br><br>
            Brand (optional) <input name="brand"><br><br>
            Number <input name="number"><br><br>
            Type of the car <select name="carType">
                <option>NORMAL</option>
                <option>BUSINESS</option>
                <option>SPORT</option>
            </select>
            <input type="submit" value="Add car">
        </form>
    </div>
</body>
</html>
