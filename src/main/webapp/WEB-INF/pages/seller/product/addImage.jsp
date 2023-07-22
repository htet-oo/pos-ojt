<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0">Add Product Image</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Add Product Image</li>
						</ol>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /.content-header -->

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card pt-5">
							<c:url value="/seller/product/addImage/save" var="productAddImage"></c:url>
							<form:form method="POST" action="${productAddImage}"
								modelAttribute="productImage" enctype="multipart/form-data">
									<form:hidden path="product_id"/>
									<form:hidden path="shopId"/>
									<div class="d-flex justify-content-center">
									  <div class="col-10 mb-3">
									    <form:label path="photo" cssClass="form-label">Add Product Photo</form:label>
									    <form:input path="photo" class="form-control-file border" type="file" id="photo" accept="image/*" />
									    <small class="form-text text-muted">Select your product image</small>
									    <form:errors path="photo" cssClass="text-danger"></form:errors>
									  </div>
									</div>
									<div class="d-flex justify-content-center mb-5">
									  <div class="col-10">
									  	<button type="submit" class="btn btn-primary">Add Image</button>
									  </div>
									</div>
							</form:form>
							<!-- /.card-body -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
