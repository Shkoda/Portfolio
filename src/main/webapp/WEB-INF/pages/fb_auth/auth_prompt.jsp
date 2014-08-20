<%--
  Created by IntelliJ IDEA.
  User: Nightingale
  Date: 15.08.2014
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Facebook Analytics</title>

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
    <title>Facebook login request</title>
</head>
<body>

<div class="row" style="width: 1000px; margin:0 auto;">
    <div class="col-lg-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Login
            </div>
            <div class="panel-body">

                <a class="btn btn-block btn-social btn-facebook" href=${auth_uri}>
                    <i class="fa fa-facebook"></i> Sign in with Facebook
                </a>


            </div>
        </div>
    </div>
</div>

<%--<!-- jQuery Version 1.11.0 -->--%>
<%--<script src="../../../js/jquery-1.11.0.js"></script>--%>

<%--<!-- Bootstrap Core JavaScript -->--%>
<%--<script src="../../../js/bootstrap.min.js"></script>--%>

<%--<!-- Metis Menu Plugin JavaScript -->--%>
<%--<script src="../../../js/plugins/metisMenu/metisMenu.min.js"></script>--%>

<%--<!-- Custom Theme JavaScript -->--%>
<%--<script src="../../../js/sb-admin-2.js"></script>--%>

</body>
</html>
