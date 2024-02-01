<!DOCTYPE html>
<html lang="en">

<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .book-card {
            display: inline-block;
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
            margin-right: 20px;
            margin-bottom: 20px;
            background-color: #fff;
            transition: transform 0.3s ease-in-out;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 10px; /* Відступи з ліва і справа */
            width: 200px; /* Фіксований розмір */
            height: 300px; /* Фіксований розмір */
        }

        .book-card:hover {
            transform: scale(1.05);
        }


        .book-details {
            padding: 20px;
            overflow-wrap: break-word; /* Дозволяє рядкам переходити на наступний рядок */
        }


        .book-title {
            font-size: 1.2em;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
            border-bottom: 1px solid #ddd;
            padding-bottom: 8px;
        }

        .book-info {
            color: #666;
            margin-bottom: 8px;
        }

        .center {
            text-align: center;
        }
    </style>
    <title>Bookstore</title>
</head>

<body>
<h2>All Books</h2>

<#list allBooks as book>
    <div class="book-card">
        <h3 class="book-title center">${book.title}</h3>
        <div class="book-details">
            <p class="book-info"><strong>Photo:</strong> ${book.photo}</p>
            <p class="book-info"><strong>Price:</strong> ${book.price}</p>
            <p class="book-info"><strong>Author:</strong> ${book.author.name}</p>
        </div>
    </div>
</#list>
</body>

</html>




