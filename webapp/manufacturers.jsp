<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/21/18
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manufacturers</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Manufacturers</h1>
    <h2>
        <a href="/manufacturer.jsp">Add New Manufacturer</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/manufacturers?action=list">List All Manufacturers</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="4">
        <caption><h2>List of Manufacturers</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Products</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="manufacturer" items="${manufacturers}">
            <tr>
                <td><c:out value="${manufacturer.id}" /></td>
                <td><c:out value="${manufacturer.name}" /></td>
                <td><a href="/products?action=list&id=<c:out value='${manufacturer.id}'/>">Products</a></td>
                <td>
                    <a href="/manufacturers?action=edit&id=<c:out value='${manufacturer.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/manufacturers?action=delete&id=<c:out value='${manufacturer.id}' />">Delete</a>
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
        <%--<td style="width: 80px;">Products</td>--%>
        <%--<td style="width: 80px;"></td>--%>
        <%--<td style="width: 80px;"></td>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<c:forEach var="manufacturer" items="${manufacturers}">--%>
        <%--<tr>--%>
            <%--<td>${manufacturer.id}</td>--%>
            <%--<td><c:out value="${manufacturer.name}" /></td>--%>
            <%--<td><a href="/products?id=${manufacturer.id}">Products</a></td>--%>
            <%--<td><a href="/manufacturers?edit?id=${manufacturer.id}">Products</a></td>--%>
            <%--<td><a href="/manufacturers?delete?id=${manufacturer.id}">Products</a></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
</body>
</html>
