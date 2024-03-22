<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
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

        .book-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        .book-card {
            position: relative;
            width: 300px;
            height: 400px;
            margin: 20px;
            overflow: hidden;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out;
            display: flex; /* Додаємо flex-контейнер */
            flex-direction: column; /* Налаштовуємо вертикальне вирівнювання */
        }

        .book-card:hover {
            transform: scale(1.05);
        }

        .book-image {
            width: 100%;
            height: 60%;
            object-fit: cover;
        }

        .book-details {
            padding: 20px;
            text-align: center;
            flex-grow: 1; /* Розтягуємо блок, щоб зайняв весь доступний простір */
            position: relative; /* Додаємо relative позиціонування */
        }

        h3 {
            margin-top: 0;
            color: #333;
        }

        p {
            color: #666;
            margin: 8px 0;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        input[type="number"] {
            width: 60px;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        .close-button {
            position: absolute;
            top: 10px;
            right: 10px;
            width: 30px;
            height: 30px;
            background-color: #fff;
            color: #0c0c0c;
            border: none;
            border-radius: 50%;
            cursor: pointer;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 18px;
            transition: background-color 0.3s ease-in-out;

        }

        .close-button:hover {
            background-color: #f8efef;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            margin-top: 5px;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<h2>Shopping Cart</h2>
<form action="/book/addOrder" method="post">

    <div class="book-container">
        <#if booksInCart??>
            <#list booksInCart as book>
                <div class="book-card">

                    <div class="book-details">
                        <div class="close-button" onclick="window.location.href='/book/removeBookFromShoppingCart?bookId=${book.id}'">x</div>
                        <h3>${book.title}</h3>
                        <img class="book-image" src="${book.photo}" alt="Book Cover">
                        <p>Author: ${book.author.name}</p>
                        <p>Price: ${book.price}</p>
                        <p>Quantity in Stock: ${book.quantityInStock}</p>

                        <input type="hidden" name="bookId" value="${book.id}">
                        Quantity:<input type="number" id="quantity" name="quantity" value="1" min="1" max="${book.quantityInStock}" required>
                    </div>
                </div>
            </#list>
        <#else>
            <p>No books in the cart</p>
        </#if>
    </div>
    <input type="submit" value="Buy" >

</form>
</body>
</html>
