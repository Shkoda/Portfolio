<%@ page import="com.pelican.persistence.domain.auth.LoginInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Nightingale
  Date: 22.08.2014
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test jpa</title>
</head>
<body>
<div>
    <% List<LoginInfo> list = (List<LoginInfo>) request.getAttribute("info");
        for (int i = 0; i < list.size(); ++i) {
    %>
    <li>
        <%= list.get(i) %>

    </li>
    <%
        }
    %>
</div>

</body>
</html>
