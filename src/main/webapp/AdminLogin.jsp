<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/13/2024
  Time: 5:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login Page </title>
</head>
<body>
<form action="Adminlogin" method="post">
    Name  :  <input type="text" name="name"/>
    Email :  <input type="text" name="email"/>
    Password :  <input type="password" name="password"/>
    <input name="submit" value="login" type="submit"/>
    <c:if test="${message != null}">
        <p style="color: #ec2d2d">${message}</p>
    </c:if>
    <c:if test="${issue != null}">
        <p style="color: #c20b0b">${issue}</p>
    </c:if>
   <c:if test="${retry != null}">
       <p>${retry}</p>
   </c:if>

</form>
<p>Don't have account <a href="AdminSignup.jsp">Register</a> </p>

</body>
</html>
