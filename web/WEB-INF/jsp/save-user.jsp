<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 07.03.2020
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save user</title>
</head>
<body>
    <div align="center">
        <form action="${pageContext.request.contextPath}/user/save" method="post">
            Name: <input name="name"/> <br><br>
            Surname: <input name="surname"/> <br><br>
            Password: <input type="password" name="password"/> <br><br>
            Repeat Password: <input type="password" name="repPassword"/> <br><br>
            Role: <select name="role">
                <option>CLIENT</option>
                <option>DISPATCHER</option>
                <option>DRIVER</option>
            </select><br><br>
            <input type="submit" value="Save" /> <br><br>
        </form>
    </div>
</body>
</html>
