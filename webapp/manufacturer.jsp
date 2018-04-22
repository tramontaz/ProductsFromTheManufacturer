<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/22/18
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Manufacturers Management</h1>
    <h2>
        <a href="/manufacturer.jsp">Add New Manufacturer</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/manufacturers?action=list">List All Manufacturers</a>

    </h2>
</div>
<div align="center">
    <c:if test="${manufacturer != null}">
    <form action="/manufacturers?action=update" method="post">
        </c:if>
        <c:if test="${manufacturer == null}">
        <form action="/manufacturers?action=insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${manufacturer != null}">
                            Edit Manufacturer
                        </c:if>
                        <c:if test="${manufacturer == null}">
                            Add New Manufacturer
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${manufacturer != null}">
                    <input type="hidden" name="id" value="<c:out value='${manufacturer.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${manufacturer.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
