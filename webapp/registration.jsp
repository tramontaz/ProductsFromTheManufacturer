<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/16/18
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action= "${pageContext.request.contextPath}/registration">
    <c:if test="${message != null}">
        <p class="message">${message}</p>
    </c:if>
    <br>
    <input type="text" name="name" placeholder="name"/>
    <input type="password" name="password" placeholder="password"/>
    <input type="text" name="email" placeholder="email address"/>
    <button>create</button>
    <p class="message">Already registered? <a href="index.jsp">Sign In</a></p>
</form>
</body>
</html>
