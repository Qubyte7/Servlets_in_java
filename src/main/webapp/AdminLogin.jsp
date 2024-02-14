<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login Page</title>
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

        form {
            background-color: var(--color2);
            border: 2px solid var(--color3);
            border-radius: 10px;
            padding: 20px;
            margin: 20px auto;
            width: 50%;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
        }

        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid var(--color3);
            border-radius: 5px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: var(--color4); /* Highlight input on focus */
        }

        input[type="submit"] {
            background-color: var(--color4);
            color: #fff; /* Text color */
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #558B2F; /* Hover color */
        }

        /* Style links */
        a {
            color: var(--color4); /* Link color */
            text-decoration: none;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #558B2F; /* Hover color */
        }

        /* Additional styling */
        .form-links {
            text-align: center;
            margin-top: 20px;
        }

        .form-links p {
            margin: 10px 0;
            font-size: 16px;
        }

        .message {
            color: #ec2d2d;
            text-align: center;
            margin-top: 10px;
        }

        .retry {
            text-align: center;
            margin-top: 10px;
        }

        .retry p {
            color: #c20b0b;
            font-size: 16px;
            margin: 5px 0;
        }
    </style>
</head>
<body>
<h1>Admin Login Page</h1>

<div>
    <form action="A_login" method="post">
        Email: <input type="text" name="email" required/>
        Password: <input type="password" name="password" required/>
        <input name="submit" value="Login" type="submit"/>
        <c:if test="${message != null}">
            <p class="message">${message}</p>
        </c:if>
        <c:if test="${issue != null}">
            <p class="message">${issue}</p>
        </c:if>
        <c:if test="${retry != null}">
            <div class="retry">
                <p>${retry}</p>
            </div>
        </c:if>
    </form>
    <div class="form-links">
        <p>Don't have an account? <a href="AdminSignup.jsp">Register</a></p>
        <p><a href="Welcome.jsp">Back to Welcome Page</a></p>
    </div>
</div>

</body>
</html>
