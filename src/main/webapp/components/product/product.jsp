<%@ page import="java.util.List" %>
<%@ page import="com.enigma.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products | Enigmat Shop</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        <%@ include file="../../styling/main.css"%>
    </style>
</head>
<body>

<%@include file="../atom/header.jsp" %>

<%--Main--%>
<main class="main-wrapper">
    <div class="main">
        <div class="create-btn">
            <button class="btn-create" onclick="window.location.href='create-product'">Add New Product</button>
        </div>
        <div class="list-products">
            <h3>List of Products</h3>
            <table class="table-products">
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th></th>
                </tr>
                <tbody>
                <% List<Product> products = (List<Product>) request.getAttribute("products"); %>
                <% for (Product product : products) {%>
                <tr>
                    <td><%=product.getName() %>
                    </td>
                    <td><%=product.getPrice() %>
                    </td>
                    <td><%=product.getStock() %>
                    </td>
                    <td class="action-btn">
                        <button class="edit-btn-product"
                                onclick="window.location.href='update-product?productId=<%=product.getId()%>'">Edit
                        </button>
                        <button class="delete-btn-product"
                                onclick="window.location.href='delete-product?productId=<%=product.getId()%>'">Delete
                        </button>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</main>

<%@include file="../atom/footer.jsp" %>

<script type="text/javascript">


</script>
</body>
</html>
