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
						<h1 class="m-0">Shop List</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Shop List</li>
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
											<th>Shop Name</th>
											<th>Phone Number</th>
											<th>Details</th>
											<th>Product</th>
											<th>Close</th>
										</tr>
									</thead>
									<tbody>										
										<c:forEach items="${shopList}" var="shop">
											<tr>
												<td>${shop.name}</td>
												<td>${shop.phone_number}</td>
												<td>
													<c:url value="/seller/shopDetails" var="shopDetails">
														<c:param name="shopId" value="${shop.id}"></c:param>
													</c:url>
													<a class="btn btn-primary" href="${shopDetails}">Details</a>
												</td>
												<td>
													<c:url value="/seller/productCreate" var="sellerProductCreate"></c:url>
													<a class="btn btn-primary" href="${sellerProductCreate}">Products</a>
												</td>
												<td>
													<c:url value="/seller/shopList" var="sellerShopList"></c:url>
													<button class="btn btn-primary">Close</button>
												</td>
											</tr>
										</c:forEach>
									</tfoot>
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