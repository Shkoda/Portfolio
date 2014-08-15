<%--
  Created by IntelliJ IDEA.
  User: Nightingale
  Date: 13.08.2014
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>
<header>
    <h1>Title : ${title}</h1>
</header>
<section>
    <h1>Message : ${message}</h1>
</section>
<div>Get <a href="protected">protected</a> resource for admin.</div>
<div>Get <a href="confidential">confidential</a> resource for superadmin.</div>

<div>Use <a href="https://graph.facebook.com/oauth/authorize?redirect_uri=http%3A%2F%2F213.169.67.21%3A8180%2F&client_id=726032407427404">facebook login</a> </div>
<%--<footer>--%>
    <%--<div>Updated by Alex Art from <a href="https://in2circle.com" target="_blank">in2circle.com</a></div>--%>
<%--</footer>--%>
</body>
</html>
