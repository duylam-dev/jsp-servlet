<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><dec:title default="Home"/> </title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>

<body>
<!-- Header -->
<%@include file="/common/web/header.jsp"%>
<!-- Page Content -->
<div class="container">
    <dec:body/>
</div>
<!-- /.container -->

<!-- Footer -->
<%@include file="/common/web/footer.jsp"%>

<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>


</body>

</html>
