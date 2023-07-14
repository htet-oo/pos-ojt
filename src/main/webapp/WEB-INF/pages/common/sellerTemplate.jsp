<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:getAsString name="title" /></title>

<c:url value="/resources/css/adminlte.min.css" var="adminlteCss"></c:url>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">

<!-- Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

<!-- IonIcons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<!-- Theme style -->
<link rel="stylesheet" href="${adminlteCss}">

</head>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<!-- Navbar -->
		<tiles:insertAttribute name="navbar"></tiles:insertAttribute>
		
		<!-- Main Sidebar Container -->
		<tiles:insertAttribute name="mainSideBar"></tiles:insertAttribute>	
		
		<!-- Content Wrapper. Contains page content -->
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		
		<!-- Main Footer -->
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
	
	<!-- REQUIRED SCRIPTS -->
	<c:url value="/resources/js/jquery.min.js" var="jQuery"></c:url>
	<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrap"></c:url>
	<c:url value="/resources/js/adminlte.js" var="adminlteJs"></c:url>
	<c:url value="/resources/js/Chart.min.js" var="chart"></c:url>
	<c:url value="/resources/js/demo.js" var="demo"></c:url>
	<c:url value="/resources/js/dashboard3.js" var="dashboard"></c:url>
	
	<!-- jQuery -->
	<script src="${jQuery}"></script>
	
	<!-- Bootstrap -->
	<script src="${bootstrap}"></script>
	
	<!-- AdminLTE -->
	<script src="${adminlteJs}"></script>
	
	<!-- OPTIONAL SCRIPTS -->
	<script src="${chart}"></script>
	
	<!-- AdminLTE for demo purposes -->
	<script src="${demo}"></script>
	
	<!-- AdminLTE dashboard demo-->
	<script src="${dashboard}"></script>
</body>
</html>