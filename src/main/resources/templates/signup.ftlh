<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
        /* Загальні стилі для тіла документа */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            flex-direction: column;
        }

        /* Стилі для форми */
        form {
            text-align: center;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            margin: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #6b6b6b; /* Змінено колір тексту */
            font-weight: bold; /* Змінено товщину шрифту */
            text-align: left; /* Додано вирівнювання тексту зліва */
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        /* Додаткові стилі для заголовку */
        h2 {
            font-size: 36px;
            color: #777;
            margin-bottom: 20px;
        }
    </style>
</head>

<body>

<h2>Sign Up</h2>

<form action="/user/saveUser" method="post">
    <label for="username">Name:</label>
    <input type="text" id="username" name="username" value="${user.username!}" required>
    <br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${user.email!}" required>
    <br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${user.password!}" required>
    <br><br>

    <input type="submit" value="OK">
</form>

</body>

</html>
