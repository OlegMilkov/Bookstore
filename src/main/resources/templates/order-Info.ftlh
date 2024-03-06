<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Information</title>
    <style>
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

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            max-width: 400px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            box-sizing: border-box;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        h2 {
            font-size: 30px;
            color: #777;
        }
    </style>
</head>
<body>

<h2>Order Information</h2>

<form action="saveOrder" method="post">
    <input type="hidden" name="id" value="${order.id}"/>

<#--    <input type="hidden" name="orderDetail" value="${orderDetail.orderDetailId!}" placeholder="Order Detail"/>-->
    <input type="hidden" name="bookId" value="${book.id}"/>
    <input type="hidden" name="quantity" value="${orderDetail.quantity}"/>


    Name<input type="text" name="name" value="${order.name!}" placeholder="Name"/>
    <br><br>
    Surname<input type="text" name="surname" value="${order.surname!}" placeholder="Surname"/>
    <br><br>
    Phone<input type="text" name="phone" value="${order.phone!}" placeholder="Phone"/>
    <br><br>
    Email<input type="text" name="email" value="${order.email!}" placeholder="Email"/>
    <br><br>
    Post office<input type="text" name="post_office" value="${order.post_office!}" placeholder="Post Office"/>
    <br><br>

    <input type="submit" value="OK">
</form>

</body>
</html>

