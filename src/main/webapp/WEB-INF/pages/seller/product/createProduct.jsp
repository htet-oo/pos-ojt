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
						<h1 class="m-0">Create Shop</h1>
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
							<c:url value="/seller/productCreate/save" var="createProduct"></c:url>
							<form:form method="POST" action="${createProduct}"
								modelAttribute="productCreate" enctype="multipart/form-data">
								<form:hidden path="shopId"/>
								<div class="d-flex justify-content-center">
									<div class="form-group mb-3 col-5">
										<form:label path="name">Product Name</form:label>
										<form:input path="name" class="form-control"
											placeholder="Enter Product Name" />
										<form:errors path="name" cssClass="text-danger"></form:errors>
									</div>
									<div class="form-group mb-3 col-5">
										<form:label path="price">Price</form:label>
										<form:input path="price" class="form-control"
											placeholder="Enter Product Price" />
										<form:errors path="name" cssClass="text-danger"></form:errors>
									</div>
								</div>
								
								<div class="d-flex justify-content-center">
									<div class="form-group mb-3 col-5">
										<label>Category</label>
										<select class="form-select form-control">
											<c:forEach items="${categories}" var="category">
												<option value="${category.id}">${category.name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group mb-3 col-5">
										<label>Subcategory</label>
										<form:select path="subCategory_id" class="form-select form-control">
											<c:forEach items="${subcategories}" var="subcategory">
												<form:option value="${subcategory.id}">${subcategory.name}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								
								<div class="d-flex justify-content-center">
									<div class="form-group mb-3 col-5">
										<form:label path="count">Product Count</form:label>
										<form:input path="count" class="form-control"
											placeholder="Enter Number of Products" />
										<form:errors path="count" cssClass="text-danger"></form:errors>
									</div>
									<div class="form-group mb-3 col-5">
										<form:label path="size">Product Size</form:label>
										<form:input path="size" class="form-control"
											placeholder="Enter Size of the product" />
										<form:errors path="size" cssClass="text-danger"></form:errors>
									</div>
								</div>
								
								<div class="d-flex justify-content-center">
									<div class="form-group mb-3 col-5">
										<form:label path="color">Product Color</form:label>
										<form:input path="color" class="form-control"
											placeholder="Enter color of Product" />
										<form:errors path="count" cssClass="text-danger"></form:errors>
									</div>
									
									<div class="form-group mb-3 col-5">
									    <form:label path="type">Product Type</form:label>
									    <form:select path="type" class="form-control">
									        <form:option value="instock">In Stock</form:option>
									        <form:option value="preorder">Pre-order</form:option>
									    </form:select>
									</div>
								</div>
								
								<div class="d-flex justify-content-center">
								    <div class="form-group mb-3 col-10">
								        <form:label path="description">Product Description</form:label>
								        <form:textarea path="description" class="form-control"
								            placeholder="Enter description of the Product" rows="3" />
								        <form:errors path="description" cssClass="text-danger"></form:errors>
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
