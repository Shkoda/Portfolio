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

    <!-- DataTables CSS -->
    <link href="../../../css/plugins/dataTables.bootstrap.css" rel="stylesheet">


    <!-- Custom CSS -->
    <link href="../../../css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../../../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">


</head>

<body>

<div class="row">
<div class="col-lg-12">
<div class="panel panel-default">
<div class="panel-heading">
    Task List
</div>
<!-- /.panel-heading -->
<div class="panel-body">
<div class="table-responsive">

<table class="table table-striped table-bordered table-hover" id="dataTables-example">
<thead>
<tr>
    <th>Description</th>
    <th>Created at</th>
    <th>Start time</th>
    <th>Expiration time</th>

</tr>
</thead>
<tbody>
<%
    List<Task> list = (List<Task>) request.getAttribute("tasks");

    for (int i = 0; i < list.size(); ++i) {
        Task task = list.get(i);
%>
<tr class="odd gradeX">
    <td><%=task.getDescription()%></td>
    <td><%=task.getCreatedAt()%></td>
    <td><%=task.getStartAt()%></td>
    <td><%=task.getFinishAt()%></td>

</tr>

<%
    }
%>

</tbody>
</table>

</div>

</div>
<!-- /.panel-body -->
</div>
<!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>

</body>

<!-- jQuery Version 1.11.0 -->
<script src="../../../js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../../js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../../../js/plugins/metisMenu/metisMenu.min.js"></script>


<!-- Custom Theme JavaScript -->
<script src="../../../js/sb-admin-2.js"></script>
<!-- DataTables JavaScript -->
<script src="../../../js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="../../../js/plugins/dataTables/dataTables.bootstrap.js"></script>



<!-- Custom Theme JavaScript -->
<script src="../../../js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
</script>

</html>
