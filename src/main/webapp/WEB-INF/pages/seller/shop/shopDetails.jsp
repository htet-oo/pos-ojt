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
						<h1 class="m-0">Shop Details</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Shop Details</li>
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
							<div class="d-flex m-3">
								<div class="col-5">
									<div>
										<img alt="shop_logo" src="${pageContext.request.contextPath}/resources/img/shopCoverPhoto/${shop.cover_photo}" class="img-fluid">
									</div>
								</div>
								
								<div class="col-7 align-items-stretch">
									<div>
										<form class="border rounded p-3 mb-2">
											<div class="d-flex justify-content-center mb-3">
												<div class="rounded-circle overflow-hidden" style="width: 150px; height: 150px;">
            										<img alt="shop_logo" src="${pageContext.request.contextPath}/resources/img/shopLogo/${shop.logo}" class="img-fluid">
        										</div>
											</div>
											<div class="d-flex  mb-2">
											  <div class="form-group col-6">
											    <label for="name">Shop Name</label>
											    <input type="text" class="form-control" id="name" value="${shop.name}">
											  </div>
											  <div class="form-group col-6">
											    <label for="phonenumber">Phone Number</label>
											    <input type="text" class="form-control" id="phonenumber"  value="${shop.phone_number}">
											  </div>
											</div>
											
											<div class="d-flex mb-2">
											  <div class="form-group col-12">
											    <label for="address">Address</label>
											    <input type="text" class="form-control" id="address" value="${shop.address}">
											  </div>
											</div>
											
											<div class="d-flex mb-2">
											  <div class="form-group col-12">
											    <label for="summary">Summary</label>
											    <textarea class="form-control" id="summary" rows="3">${shop.summary}</textarea>
											  </div>
											</div>
											
											<div class="d-flex mb-2">
											    <div class="form-group col-md-6">
											    	<c:url value="/seller/shopEdit" var="shopEdit">
														<c:param name="shopId" value="${shop.id}"></c:param>
													</c:url>
											        <a class="btn btn-primary btn-block px-3" href="${shopEdit}">Change</a>
											    </div>
											    <div class="form-group col-md-6"> 
											    	<c:url value="/seller/shopList" var="sellerShopList"></c:url>
											        <a class="btn btn-primary btn-block px-3" href="${sellerShopList}">Home</a> 
											    </div>
											</div>
										</form>
									</div>
								</div>
							</div>
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