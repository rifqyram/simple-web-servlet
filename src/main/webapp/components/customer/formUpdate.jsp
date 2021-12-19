<%@ page import="com.enigma.entity.Customer" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: rifqi
  Date: 09/07/21
  Time: 21.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer | Enigmat Shop</title>
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
        <%Format format = new SimpleDateFormat("yyyy-MM-dd");%>
        <%Customer customer = (Customer) request.getAttribute("customer");%>
        <% if (customer != null) {%>
        <div class="back-to-menu">
                  <span onclick="window.location.href='<%=request.getContextPath()%>/customers'">

                <svg class="svg-back" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px"
                     fill="#fff">
                    <path d="M0 0h24v24H0V0z" fill="none"></path>
                    <path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12l4.58-4.59z"></path>
                </svg>
                  </span>
        </div>
        <form class="form-create-product" method="post" onsubmit="return validate()">
            <h3 class="form-create-product-title">Update Customer</h3>
            <div style="display: none" class="input-container">
                <label for="customerId">Customer Id</label>
                <input readonly type="text" id="customerId" name="customerId" value="<%=customer.getId()%>"/>
            </div>
            <div class="input-container">
                <label for="name">Customer Name</label>
                <input type="text" id="name" name="customerName" value="<%=customer.getName()%>"/>
            </div>
            <div class="input-container">
                <label for="phone">Phone Number</label>
                <input type="text" id="phone" name="customerPhone" value="<%=customer.getPhone()%>"/>
            </div>
            <div class="input-container">
                <label for="birthdate">Birth Date</label>
                <input type="date" id="birthdate" name="customerBirthDate"
                       value="<%=format.format(customer.getBirthDate())%>"/>
            </div>
            <div class="input-container address">
                <label for="address">Address</label>
                <textarea name="customerAddress" id="address"><%=customer.getAddress()%></textarea>
            </div>
            <div class="input-container checkbox">
                <label for="status">Status</label>
                <%if (customer.getStatus()) {%>
                <input name="customerStatus" type="checkbox" id="status" checked/>
                <%} else {%>
                <input name="customerStatus" type="checkbox" id="status"/>
                <%}%>
            </div>
            <button class="save-customer" type="submit">Save Customer</button>
        </form>
        <% } else {%>
        <div class="id-notfound">
            <h1>Id Not Found</h1>
            <h3 class="back-notfound" onclick="window.location.href='<%=request.getContextPath()%>/'">Back To Home</h3>
            <%@ include file="../atom/error.jsp"%>
        </div>
        <% }%>
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
        let phone = document.getElementById("phone").value;
        let birthdate = document.getElementById("birthdate").value;
        let address = document.getElementById("address").value;

        if (name === "" || phone === "" || birthdate === "" || address === "") {
            alert("Field can't be blank");
            return false;
        }

        return true;
    }

</script>

</body>
</html>
