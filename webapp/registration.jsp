<%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 4/16/18
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action= "${pageContext.request.contextPath}/registration">
    <input type="text" placeholder="name"/>
    <input type="password" placeholder="password"/>
    <input type="text" placeholder="email address"/>
    <button>create</button>
    <p class="message">Already registered? <a href="index.jsp">Sign In</a></p>
</form>
</body>
</html>
