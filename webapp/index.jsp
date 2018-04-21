<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/16/18
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Login page</title>
</head>
<body>
        <form action="${pageContext.request.contextPath}login" method="POST">
            <input type="text" placeholder="name" name = "name"/>
            <input type="password" placeholder="password" name="password"/>
            <button>login</button>
            <p class="message">Not registered? <a href="registration.jsp">Create an account</a></p>
        </form>
</body>
</html>
