<%@ page import="com.enigma.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: rifqi
  Date: 09/07/21
  Time: 21.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product | Enigmat Shop</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        <%@ include file="../../styling/main.css"%>
    </style>
</head>
<body>

<main class="main-wrapper">
    <div class="main">
        <div class="back-to-menu">
      <span onclick="window.location.href='<%=request.getContextPath()%>/products'">
                <svg class="svg-back" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px"
                     fill="#fff">
                    <path d="M0 0h24v24H0V0z" fill="none"></path>
                    <path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12l4.58-4.59z"></path>
                </svg>
      </span>
        </div>
        <form class="form-create-product" method="post" onsubmit="return validate()">
            <h3 class="form-create-product-title">Create New Product</h3>
            <div class="input-container">
                <label for="name">Product Name</label>
                <input type="text" id="name" name="productName"/>
            </div>
            <div class="input-container">
                <label for="price">Price</label>
                <input type="number" min="1" id="price" name="productPrice"/>
            </div>
            <div class="input-container">
                <label for="stock">Stock</label>
                <input type="number" min="0" id="stock" name="stock"/>
            </div>
            <button class="save-product" type="submit">Save Product</button>
        </form>
    </div>
</main>

<footer class="footer-wrapper">
    <footer class="footer">
        <span class="copyright">&#169; Enigmat Shop</span>
    </footer>
</footer>

<script type="text/javascript">
    function validate() {
        let name = document.getElementById("name").value;
        let price = document.getElementById("price").value;
        let stock = document.getElementById("stock").value;

        console.log(stock === null)
        if (name === null || price <= 0 || stock <= 0) {
            alert("Field can't be blank");
            return false;
        }

        return true;
    }

</script>

</body>
</html>
