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
						<h1 class="m-0">Edit Shop</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Create Shop</li>
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
							<c:url value="/seller/shopEdit/save" var="shopEdit"></c:url>
							<form:form method="POST" action="${shopEdit}"
								modelAttribute="shopEdit" enctype="multipart/form-data">
								<form:hidden path="id"/>
								<div>
									<div class="d-flex justify-content-center">
										<div class="form-group mb-3 col-5">
											<form:label path="name">Name</form:label>
											<form:input path="name" class="form-control"
												placeholder="Enter Shop Name" />
											<form:errors path="name" cssClass="text-danger"></form:errors>
										</div>
										<div class="form-group mb-3 col-5">
											<form:label path="Phone">Phone</form:label>
											<form:input path="phone" class="form-control"
												placeholder="Enter Phone" />
											<form:errors path="phone" cssClass="text-danger"></form:errors>
										</div>
									</div>
									
									<div class="d-flex justify-content-center">
									  <div class="col-5 mb-3">
									    <form:label path="logo" cssClass="form-label">Logo</form:label>
									    <form:input path="logo" class="form-control-file border" type="file" id="logo" accept="image/*" />
									    <small class="form-text text-muted">Select your logo image</small>
									    <form:errors path="logo" cssClass="text-danger"></form:errors>
									  </div>
									
									  <div class="col-5 mb-3">
									    <form:label path="coverPhoto" cssClass="form-label">Cover Photo</form:label>
									    <form:input path="coverPhoto" class="form-control-file border" type="file" id="coverPhoto" accept="image/*" />
									    <small class="form-text text-muted">Select your cover photo</small>
									    <form:errors path="coverPhoto" cssClass="text-danger"></form:errors>
									  </div>
									</div>
									
									<div class="d-flex justify-content-center">
										<div class="col-10 mb-3">
											<form:label path="address">Address</form:label>
											<form:input path="address" class="form-control"
												placeholder="Enter Shop Address" />
											<form:errors path="address" cssClass="text-danger"></form:errors>
										</div>
									</div>
									<div class="d-flex justify-content-center">
										<div class="col-10 mb-3">
											<form:label path="summary">Summary</form:label>
											<form:input path="summary" class="form-control"
												placeholder="Enter Shop summary" />
											<form:errors path="summary" cssClass="text-danger"></form:errors>
										</div>
									</div>
									
								    <div class="d-flex justify-content-center">
								      <div class="col-10 mb-3">
								        <div class="row">
								          <div class="col-6 text-left">
								            <button type="submit" class="btn btn-primary">Submit</button>
								          </div>
								          <div class="col-6 text-right">
								          	<c:url value="/seller/shopList" var="sellerShopList"></c:url>
								            <button type="submit" class="btn btn-light">Cancel</button>
								          </div>
								        </div>
								      </div>
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