<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/12/2024
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Userlogin</title>
</head>
<body>
<form action="login" method="post">
   Name  :  <input type="text" name="name"/>
   Email :  <input type="text" name="email"/>
   Password :  <input type="password" name="password"/>
    <input name="submit" value="login" type="submit"/>
</form>
<p>Don't have account <a href="UserRegister.jsp">Register</a> </p>

</body>
</html>
