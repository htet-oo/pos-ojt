<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0">Product List</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Product List</li>
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
						<div class="card">
							<div class="card-header">
								<c:url value="/seller/createShop" var="createShop"></c:url>
								<a href="${createShop}" class="btn btn-primary float-right">Add
									New</a>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Product Name</th>
											<th>Product Price</th>
											<th>Product Color</th>
											<th>Product Type</th>
											<th>Product Details</th>
											<th>Add Image</th>
										</tr>
									</thead>
									<tbody>									
										<c:forEach items="${productList}" var="product">
											<tr>
												<td>${product.name}</td>
												<td>${product.price}</td>
												<td>${product.color}</td>
												<td>${product.type}</td>
												<td>
													<c:url value="/product/productDetails" var="productDetails">
														<c:param name="productId" value="${product.id}"></c:param>
														<c:param name="shopId" value="${shopId}"></c:param>
													</c:url>
													<a class="btn btn-primary" href="${productDetails}">Product Details</a>
												</td>
												<td>
													<c:url value="/seller/product/addImage" var="productAddImage">
														<c:param name="productId" value="${product.id}"></c:param>
														<c:param name="shopId" value="${shopId}"></c:param>
													</c:url>
													<a class="btn btn-primary" href="${productAddImage}">Add Image</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
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