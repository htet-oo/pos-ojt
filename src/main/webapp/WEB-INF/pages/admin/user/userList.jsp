<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0">User List</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">User List</li>
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
								<a href="form.html" class="btn btn-primary float-right">Add
									New</a>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>User Name</th>
											<th>Email</th>
											<th>Restrict</th>
											<th>Release</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach  items="${userList}" var="user">
											<tr>
												<td>${user.name}</td>
												<td>${user.email}</td>
												<td>
													<button class="btn btn-danger">Restrict</button>
												</td>
												<td>
													<button class="btn btn-success">Release</button>
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