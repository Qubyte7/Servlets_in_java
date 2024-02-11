<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head><title>Home page</title></head>
<body>
<h1> HERE THE LIST OF STUDENTS</h1>
<jsp:useBean id="students" scope="request" type="java.util.List"/>
<c:forEach var="student" items="${students}">
    <p>ID: <c:out value="${student.id}" /></p>
    <p>Name: <c:out value="${student.name}" /></p>
    <p>Age: <c:out value="${student.age}" /></p>
    <p>School: <c:out value="${student.school}" /></p>
    <hr>
</c:forEach>
<p> The End</p>
</body>
</html>