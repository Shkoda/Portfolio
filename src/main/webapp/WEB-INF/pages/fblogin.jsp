<%--
  Created by IntelliJ IDEA.
  User: Nightingale
  Date: 13.08.2014
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fb login</title>
</head>
<body>
<%@page import="java.net.URLEncoder" %>
<%
    String fbURL = "http://www.facebook.com/dialog/oauth?client_id=myfacebookappid&redirect_uri=" + URLEncoder.encode("http://myappengineappid.appspot.com/signin_fb.do") + "&scope=email";
%>

<a href="<%= fbURL %>"><img src="/img/facebook.png" border="0" /></a>
</body>
</html>



