<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
    <style>
        /* Define colors */
        :root {
            --color1: #E1F0DA;
            --color2: #D4E7C5;
            --color3: #BFD8AF;
            --color4: #99BC85;
        }

        body {
            font-family: 'Arial', sans-serif; /* Use a cool font like Arial */
            background-color: var(--color1);
            color: #333; /* Text color */
            margin: 0;
            padding: 0;
        }

        h2 {
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
        input[type="number"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid var(--color3);
            border-radius: 5px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="number"]:focus {
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
    </style>
</head>
<body>
<h2>You can now change</h2>

<c:if test="${student != null}">
    <form action="updateStudent" method="post">
        <input type="hidden" name="id" value="${student.id}" />
        name:   <input type="text" name="name" value="${student.name}" /><br>
        age:    <input type="number" name="age" value="${student.age}" /><br>
        school: <input type="text" name="school" value="${student.school}" /><br>
        <input type="submit" value="Update" />
    </form>
</c:if>

</body>
</html>
