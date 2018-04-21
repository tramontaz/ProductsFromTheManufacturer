<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/21/18
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturers</title>
</head>
<body>
<table style=" border-style: solid; border-width:1px; width: 600px; border-collapse: collapse;">
    <thead>
    <tr style="background-color: gray;">
        <td style="width: 30px;">ID</td>
        <td style="width: 80px;">Name</td>
        <td style="width: 80px;">Products</td>
        <td></td>
        <td style="width: 80px;">action</td>
        <td style="width: 80px;">action</td>
    </tr>
    </thead>
    <c:forEach var="manufacturer" items="${manufacturers}">
        <tr>
            <td>${manufacturer.id}</td>
            <td><c:out value="${manufacturer.name}" /></td>
            <td></td>
            <td><c:out value="${manufacturer.projects}" /></td>
            <td><a href="./kill-user.html?id=${theUser.id}">delete</a></td>
            <td><a href="./edit-user.html?id=${theUser.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
