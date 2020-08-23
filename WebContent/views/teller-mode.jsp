<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>The Bank</title>
</head>
<body>
	<!-- Image and text -->
	<nav class="navbar navbar-light bg-light mb-2">
	  <a class="navbar-brand" href="#">
	    <img src="/docs/4.0/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
	    Bootstrap
	  </a>
	</nav>

	<div class="container">
		<form action="${pageContext.request.contextPath}/TransactionController" method="POST">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="First Name" name="firstName"> 
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Last Name" name="lastName"> 
			</div>
			<div class="form-group">
				<input type="number" class="form-control" placeholder="Account Number" name="accountNumber">
			</div>
			<button type="submit" class="btn btn-primary btn-block">Submit</button>
		</form>
	</div>
	
</body>
</html>