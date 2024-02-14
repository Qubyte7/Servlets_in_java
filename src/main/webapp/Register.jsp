<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            background-color: #FBFADA; /* Pale Yellow */
            color: #12372A; /* Dark Green */
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #436850; /* Olive Green */
        }

        form {
            background-color: #ADBC9F; /* Light Khaki */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="number"],
        input[type="text"] {
            margin: 10px;
            padding: 10px;
            border: 2px solid #12372A; /* Dark Green */
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #12372A; /* Dark Green */
            color: #FBFADA; /* Pale Yellow */
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #436850; /* Olive Green */
        }
    </style>
</head>
<body>
<h1>Home</h1>
<form action="form" method="post">
    <input type="hidden" name="id" /><br>
    name:   <input type="text" name="name" /><br>
    age:    <input type="number" name="age" /><br>
    school: <input type="text" name="school" /><br>
           <input type="submit" />
</form>
</body>
</html>
