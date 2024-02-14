<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
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
        }

        /* Style form */
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
            margin-right: 10px; /* Add margin for spacing */
        }

        a:hover {
            color: #558B2F; /* Hover color */
        }

        /* Additional styling */
        .message {
            color: #c20b0b;
            text-align: center;
        }

        .form-links {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h1>User Login</h1>

<div>
    <form action="login" method="post">
        Email:     <input type="text" name="email" required/>
        Password:  <input type="password" name="password" required/>
        <input name="submit" value="Login" type="submit" required/>
    </form>
    <c:if test="${issue != null}">
        <p class="message">${issue}</p>
    </c:if>
    <div class="form-links">
        <a href="UserRegister.jsp">Register</a>
        <a href="Welcome.jsp">Back to welcome page</a>
    </div>
</div>

</body>
</html>
