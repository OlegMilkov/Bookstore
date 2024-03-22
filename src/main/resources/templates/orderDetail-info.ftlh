<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Info</title>
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
            max-width: 800px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            box-sizing: border-box;
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: space-between;
        }

        div {
            flex: 1;
            min-width: 48%;
        }

        .spacer {
            flex-basis: 100%;
            height: 0;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            padding: 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            width: 100%;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        /* Стилі для виводу інформації */
        p {
            margin: 8px 0;
            line-height: 1.6;
        }

        strong {
            display: block;
            font-size: 1.2em;
            color: #333;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>

<h2>Employee Info</h2>

<form action="/book/mainPage">
    <input type="hidden" name="id" value="${orderDetailItem[0].orderDetailId}"/>

    <!-- Перша група інформації (зліва) -->
    <div>
        <p><strong>Name:</strong> ${orderDetailItem[0].order.name}</p>
        <p><strong>Surname:</strong> ${orderDetailItem[0].order.surname}</p>
        <p><strong>Phone:</strong> ${orderDetailItem[0].order.phone}</p>
        <p><strong>Email:</strong> ${orderDetailItem[0].order.email}</p>
        <p><strong>Post Office:</strong> ${orderDetailItem[0].order.post_office}</p>
        <p><strong>Order Date:</strong> ${orderDetailItem[0].order.orderDate}</p>
    </div>

    <!-- Простір між групами інформації -->
    <div class="spacer"></div>


    <!-- Друга група інформації (справа) -->
    <#list orderDetailItem as orderDetail>

    <div>
        <p><strong>Book:</strong> ${orderDetail.book.title}</p>
        <img src="${orderDetail.book.photo}" alt="Book Photo" style="max-width: 100%; height: auto; margin-bottom: 10px;">
        <p><strong>Quantity:</strong> ${orderDetail.quantity}</p>
        <p><strong>Total price:</strong> ${orderDetail.totalPrice}</p>
    </div>
    </#list>
    <input type="submit" value="OK">
</form>

</body>
</html>
