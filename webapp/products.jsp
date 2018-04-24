<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/22/18
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Products of ${manufacturer_name}</h1>
    <h2>
        <a href="/products?action=new&manufacturer_id=${manufacturer_id}">Add New Product</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/manufacturers?action=list">Manufacturers</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="4">
        <caption><h2>List of Products</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.price}" /></td>
                <td>
                    <a href="/products?action=edit&manufacturer_id=${manufacturer_id}&id=<c:out value='${product.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/products?action=delete&manufacturer_id=${manufacturer_id}&id=<c:out value='${product.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<%--<body>--%>
<%--<table style=" border-style: solid; border-width:1px; width: 600px; border-collapse: collapse;">--%>
    <%--<thead>--%>
    <%--<tr style="background-color: gray;">--%>
        <%--<td style="width: 30px;">ID</td>--%>
        <%--<td style="width: 80px;">Name</td>--%>
        <%--<td style="width: 80px;">Price</td>--%>
        <%--<td></td>--%>
        <%--<td style="width: 80px;">action</td>--%>
        <%--<td style="width: 80px;">action</td>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<c:forEach var="product" items="${products}">--%>
        <%--<tr>--%>
            <%--<td>${product.id}</td>--%>
            <%--<td><c:out value="${product.name}"/></td>--%>
            <%--<td><c:out value="${product.price}"/></td>--%>
            <%--<td></td>--%>
            <%--<td><a href="./manufacturers?id=${theManufacturer.id}">delete</a></td>--%>
            <%--<td><a href="./manufacturers?id=${theManufacturer.id}">edit</a></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<%--<a href="/manufacturers">Manufacturers</a></p>--%>
<%--</body>--%>
</html>
