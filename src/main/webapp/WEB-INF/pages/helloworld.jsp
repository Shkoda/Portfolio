<%@ page import="java.io.Console" %>
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
    <title>Pelican Pet Project</title>
</head>
<body>
<header>
    <h1>${title}</h1>
</header>
<section>
    <h1>Message : ${message}</h1>
</section>
<div>Get <a href="protected">protected</a> resource for admin.</div>
<div>Get <a href="confidential">confidential</a> resource for superadmin.</div>

<%
    String authUri = (String) request.getAttribute("auth_uri");
    if (authUri == null)
        authUri = "facebook_init_error";
%>
<div>Use <a href=<%=authUri%>> facebook login</a></div>

</body>
</html>
