<%@ page import="java.util.List" %>
<%@ page import="com.enigma.entity.Customer" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer | Enigmat Shop</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        <%@ include file="../../styling/main.css"%>
    </style>
</head>
<body>

<%Format format = new SimpleDateFormat("yyyy-MM-dd");%>

<%@include file="../atom/header.jsp"%>

<%--Main--%>
<main class="main-wrapper">
    <div class="main">
        <div class="create-btn">
            <button class="btn-create" onclick="window.location.href='create-customer'">Add New Customer</button>
        </div>
        <div class="list-customer">
            <h3>List Customer</h3>
            <table class="table-customer">
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Birth Date</th>
                    <th></th>
                </tr>
                <tbody>
                <% List<Customer> customers = (List<Customer>) request.getAttribute("customers"); %>
                <% for (Customer customer : customers) {%>
                <tr>
                    <td><%=customer.getName() %>
                    </td>
                    <td><%=customer.getAddress()%>
                    </td>
                    <td><%=customer.getPhone() %>
                    </td>
                    <td><%=format.format(customer.getBirthDate())%>
                    </td>
                    <td class="action-btn">
                        <button class="edit-btn-product"
                                onclick="window.location.href='update-customer?customerId=<%=customer.getId()%>'">Edit
                        </button>
                        <button class="delete-btn-product"
                                onclick="window.location.href='delete-customer?customerId=<%=customer.getId()%>'">Delete
                        </button>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</main>

<%@include file="../atom/footer.jsp"%>

<script type="text/javascript">


</script>
</body>
</html>
