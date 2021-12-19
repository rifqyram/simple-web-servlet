<%--
  Created by IntelliJ IDEA.
  User: rifqi
  Date: 11/07/21
  Time: 20.01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header class="header-wrapper">
    <div class="header">
        <div class="logo"><h3>Enigmat Shop</h3></div>
        <nav class="navbar">
            <ul>
                <li><a href="<%=request.getContextPath()%>/">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/products">Product</a></li>
                <li><a href="<%=request.getContextPath()%>/customers">Customer</a></li>
            </ul>
        </nav>
    </div>
</header>
</body>
</html>
