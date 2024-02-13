<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/13/2024
  Time: 5:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin sign up page</title>
</head>
<body>
<form action="RegisterAdmin" method="post">
    Name     :  <input type="text" name="name"/>
    Email    :  <input type="email" name="email"/>
    Password :  <input type="password" name="password"/>
    <input name="submit" type="submit" value="Register"/>
</form>

</body>
</html>
