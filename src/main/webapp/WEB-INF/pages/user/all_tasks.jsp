<%@ page import="java.util.List" %>
<%@ page import="com.pelican.persistence.Task" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> ${pageContext.request.userPrincipal.name} - All Tasks</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../../../css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../../../css/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../../css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../../../css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../../../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="http://d3js.org/d3.v3.min.js"></script>
</head>

<body>


Tasks:

<br>
<% List<Task> list = (List<Task>) request.getAttribute("tasks");
%>

<%
    for (int i = 0; i < list.size(); ++i) {
%>
<li>
    <%= list.get(i) %>

</li>
<%
    }
%>


<%--<button id="generate-btn" type="button" class="btn btn-primary" onclick="request_tasks()"--%>
        <%--data-dismiss="modal">Request tasks--%>
<%--</button>--%>


</body>

<script>
//    function request_tasks() {
//        d3.text("/user/request_tasks")
//                .header("Content-type", "application/json")
//                .get(function (error, text) {
//                    var tasks = JSON.parse(text);
//                    console.log(tasks);
//
//                    for (i = 0; i < tasks.length; ++i) {
//                        console.log(tasks.get(i));
//                        $("#task-description").html("<strong>Task: </strong>" + tasks.get(i));
//                    }
//                    $("#task-description-block").slideDown(400);
//                });
//    }

</script>
<!-- jQuery Version 1.11.0 -->
<script src="../../../js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../../js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../../../js/plugins/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="../../../js/plugins/morris/raphael.min.js"></script>
<script src="../../../js/plugins/morris/morris.min.js"></script>
<script src="../../../js/plugins/morris/morris-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../../../js/sb-admin-2.js"></script>

</html>
