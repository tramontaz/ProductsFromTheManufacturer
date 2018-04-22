<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/22/18
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Product Management</h1>
    <h2>
        <a href="/product.jsp">Add New Product</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/manufacturers?action=list">Cancel</a>
    </h2>
</div>
<div align="center">
    <c:if test="${product != null}">
    <form action="/products?action=update" method="post">
        </c:if>
        <c:if test="${product == null}">
        <form action="/products?action=insert" method="post">
            </c:if>
            <table border="1" cellpadding="3">
                <caption>
                    <h2>
                        <c:if test="${product != null}">
                            Edit Product
                        </c:if>
                        <c:if test="${product == null}">
                            Add New Product
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
                </c:if>
                <c:if test="${manufacturer_id != null}">
                    <input type="hidden" name="manufacturer_id" value="<c:out value='${manufacturer_id}' />" />
                </c:if>

                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${product.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price: </th>
                    <td>
                        <input type="text" name="price" size="45"
                               value="<c:out value='${product.price}' />"
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
    </form>
</div>


</body>
</html>
