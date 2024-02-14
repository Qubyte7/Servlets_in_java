<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
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

        h1 {
            text-align: center;
            margin-top: 50px;
            color: var(--color4); /* Heading color */
        }

        /* Style links */
        a {
            text-decoration: none;
            color: #fff; /* Link text color */
            background-color: var(--color4); /* Link background color */
            padding: 10px 20px;
            border-radius: 5px;
            margin: 10px;
            display: inline-block;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #558B2F; /* Hover color */
        }

        /* Style divs */
        div {
            background-color: var(--color2);
            border: 2px solid var(--color3);
            border-radius: 10px;
            padding: 20px;
            margin: 20px auto;
            width: 50%;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
        }
    </style>
</head>
<body>
<h1>LOGIN AS</h1>

<div>
    <a href="Userlogin.jsp">Guest</a>
    <a href="AdminLogin.jsp">Admin</a>
</div>

</body>
</html>
