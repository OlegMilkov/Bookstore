<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Books</title>
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
        }

        h3 {
            margin-top: 0;
            color: #333;
        }

        p {
            color: #666;
            margin: 8px 0;
        }

        form {
            margin-top: 10px;
            text-align: center;
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

        input[type="submit"], input[type="button"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            margin-top: 5px;
        }

        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: #2980b9;
        }

        /* Додали стилі для назви "All Books" */
        h2 {
            font-size: 36px;
            color: #777;
        }
    </style>
</head>
<body>

<h2>All Books</h2>
<input type="button" value="ShoppingCart" onclick="window.location.href='/book/shoppingCart'"/>
<div class="book-container">
    <#list allBooks as book>

        <form action="/book/addOrder" method="post">
            <div class="book-card">
                <div class="book-details">
                    <h3>${book.title}</h3>
                    <img class="book-image" src="${book.photo}" alt="Book Cover">
                    <p>Author: ${book.author.name}</p>
                    <p>Price: ${book.price}</p>
                    <p>Quantity in Stock: ${book.quantityInStock}</p>

                    <input type="hidden" name="bookId" value="${book.id}">

                    <input type="number" id="quantity" name="quantity" value="1" min="1" max="${book.quantityInStock}" required>
                    <input type="submit" value="Buy">
                    <br>
                    <input type="button" value="To Cart" onclick="window.location.href='/book/addBookToShoppingCart?bookId=${book.id}'"/>
                </div>
            </div>
        </form>
    </#list>

</div>

</body>
</html>
