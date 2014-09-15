<%@ page import="java.util.List" %>
<%@ page import="com.pelican.persistence.Task" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html lang="en">

<head>
    <title>Task List</title>
    <%@ include file="include_css.html" %>
</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <%@ include file="navigation.html" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Task List</h2>
            </div>
            <!-- /.col-lg-12 -->
        </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

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
                            <tr class="odd gradeX" ondblclick=redirectToTaskPage(<%=task.getId()%>)>
                                <td><%=task.getDescription()%>
                                </td>
                                <td><%=task.getCreatedAt()%>
                                </td>
                                <td><%=task.getStartAt()%>
                                </td>
                                <td><%=task.getFinishAt()%>
                                </td>

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
        </div>
</div>
</body>
<script>
    function redirectToTaskPage(taskId) {
        window.location = "/user/task?task_id=" + taskId
    }
</script>
<%@ include file="include_default_scripts.html" %>

<!-- DataTables JavaScript -->
<script src="../../../js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="../../../js/plugins/dataTables/dataTables.bootstrap.js"></script>


<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>

</html>
