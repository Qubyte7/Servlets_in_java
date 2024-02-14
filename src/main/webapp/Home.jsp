<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        /* Define colors */
        :root {
            --color1: #E1F0DA;
            --color2: #D4E7C5;
            --color3: #BFD8AF;
            --color4: #99BC85;
        }

        body {
            font-family: 'Roboto', sans-serif; /* Use a cool font like Roboto */
            background-color: var(--color1);
            color: #333; /* Text color */
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 50px;
            color: var(--color4); /* Heading color */
            font-size: 32px;
            margin-bottom: 30px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        .student-info {
            background-color: var(--color2);
            border: 2px solid var(--color3);
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
        }

        .student-info p {
            margin-bottom: 10px;
        }

        .action-links {
            margin-top: 10px;
        }

        .action-links a {
            display: inline-block;
            background-color: var(--color4);
            color: #fff;
            padding: 8px 16px;
            border-radius: 5px;
            text-decoration: none;
            margin-right: 10px;
            transition: background-color 0.3s ease;
        }

        .action-links a:hover {
            background-color: #558B2F; /* Hover color */
        }
    </style>
</head>
<body>
<h1>Here the List of Students</h1>

<div class="container">
    <div class="action-links">
        <a href="Register.jsp">Add New Student</a>
        <a href="logout-admin">Logout</a>
    </div>
    <div>
        <jsp:useBean id="students" scope="request" type="java.util.List"/>
        <c:if test="${students != null}">
            <c:forEach var="student" items="${students}">
                <div class="student-info">
                    <p>ID: <c:out value="${student.id}" /></p>
                    <p>Name: <c:out value="${student.name}" /></p>
                    <p>Age: <c:out value="${student.age}" /></p>
                    <p>School: <c:out value="${student.school}" /></p>
                    <div class="action-links">
                        <a href="Delete?id=<c:out value='${student.id}'/>">Delete</a>
                        <a href="Dupdate?id=<c:out value='${student.id}'/>">Update</a>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>

</body>
</html>
