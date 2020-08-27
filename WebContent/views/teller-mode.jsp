<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>The Bank</title>
</head>
<body>

	<nav class="navbar navbar-light bg-light mb-2">
		<a class="navbar-brand" href="#"> <i class="fas fa-piggy-bank"></i>
			Piggy Bank
		</a>
	</nav>
	<!-- 	Form to get account information -->
	<div class="container mb-2">
		<div class="card">
			<h5 class="text-center">Get Account Information</h5>
			<div class="card-body">
				<form
					action="${pageContext.request.contextPath}/TransactionController"
					method="GET">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="First Name"
							name="firstName">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Last Name"
							name="lastName">
					</div>
					<div class="form-group">
						<input type="number" class="form-control"
							placeholder="Account Number" name="accountNumber">
					</div>
					<button type="submit" class="btn btn-primary btn-block">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<!-- 	Form to search account number -->
	<div class="container">
		<div class="card">
			<h5 class="text-center">Search For Account Number</h5>
	  		<div class="card-body">
	    		<form
					action="${pageContext.request.contextPath}/SearchController"
					method="GET">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="First Name" name="firstName">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Last Name" name="lastName">
					</div>
					<button type="submit" class="btn btn-primary btn-block">Search</button>
				</form>
	  		</div>
		</div>
	</div>
</body>
</html>