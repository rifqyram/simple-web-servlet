<html>
<head>
    <meta charset="UTF-8">
    <title>Enigma Shop</title>
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        <%@ include file="/styling/main.css"%>
    </style>
</head>
<body>

<header class="header-wrapper">
    <div class="header">
        <div class="logo"><h3>Enigmat Shop</h3></div>
        <nav class="navbar" >
            <ul>
                <li><a href="<%=request.getContextPath()%>/">Home</a></li>
                <li><a href="products">Product</a></li>
                <li><a href="customers">Customer</a></li>
            </ul>
        </nav>
    </div>
</header>

<%--Main--%>
<main class="main-wrapper home">
    <div class="main">
        <div class="left-main-home">
            <h1>Enigmat Shop</h1>
            <p>Code is like humor. When you have to explain it, it's bad.</p>
            <button onclick="window.location.href=window.location.href='<%=request.getContextPath()%>/products'" class="product-menu-btn">Go To Product Menu</button>
        </div>
        <div class="right-main-home">

        </div>
    </div>
</main>

<footer class="footer-wrapper">
    <footer class="footer">
        <span class="copyright">&#169; Enigmat Shop</span>
    </footer>
</footer>

</body>
</html>

