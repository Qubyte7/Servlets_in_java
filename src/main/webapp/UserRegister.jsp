<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Register Page</title>
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
        input[type="email"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            box-sizing: border-box;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="password"]:focus {
            background-color: #f3f3f3;
        }

        input[type="submit"] {
            background-color: var(--color4);
            color: #fff; /* Text color */
            cursor: pointer;
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
        }

        .form-links a {
            margin: 10px;
            display: block;
        }
    </style>
</head>
<body>
<h1>User Register Page</h1>

<div>
    <form action="RegisterUser" method="post">
        Name:     <input type="text" name="name" required/>
        Email:    <input type="email" name="email" required/>
        Password: <input type="password" name="password" required/>
        <input name="submit" type="submit" value="Register"/>
        <div class="form-links">
            <a href="Userlogin.jsp">Already Registered? Login</a>
            <a href="Welcome.jsp">Back to Welcome Page</a>
        </div>
    </form>
</div>

</body>
</html>
