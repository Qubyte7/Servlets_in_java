<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head><title>Home page</title></head>
<body>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){
        String message  = "You have been logged out please login again";
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
        dispatcher.forward(request, response);
        return;
    }

%>
<h1> HERE THE LIST OF STUDENTS</h1>
<jsp:useBean id="students" scope="request" type="java.util.List"/>
<c:if test="${students != null}">
    <c:forEach var="student" items="${students}">
        <p>ID: <c:out value="${student.id}" /></p>
        <p>Name: <c:out value="${student.name}" /></p>
        <p>Age: <c:out value="${student.age}" /></p>
        <p>School: <c:out value="${student.school}" /></p>
        <hr>
    </c:forEach>
</c:if>


<p> The End</p>
    <a href="logout-admin">Logout</a>
</body>
</html>