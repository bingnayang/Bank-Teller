<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Transaction Detail</title>
</head>
<body>
	<!-- 	Navbar Section -->
	<nav class="navbar navbar-dark bg-primary">
		<a class="navbar-brand" href="#"> <i class="fas fa-piggy-bank"></i>
			Piggy Bank
		</a>
		<form class="form-inline my-2 my-lg-0">
			<a class="btn btn-outline-light my-2 my-sm-0"
				href="${pageContext.request.contextPath}/TellerController">Back
				To Main Page</a>
		</form>
	</nav>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h3>Account Info</h3>
			<h5>Account Number:</h5>#${transactionDetail.account_Number}
		</div>
	</div>

	<div class="container">
		<h3>Transaction Detail</h3>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">
				<h5>Transaction Date / Time:</h5> ${transactionDetail.transaction_Date} / ${transactionDetail.transaction_Time}
			</li>
			<li class="list-group-item">
				<h5>Branch Name:</h5> ${transactionDetail.branch_Name}
			</li>
			<li class="list-group-item">
				<h5>Employee Name:</h5> ${transactionDetail.employeeName}
			</li>
			<li class="list-group-item">
				<h5>Transaction Type: </h5> ${transactionDetail.transaction_Type}
			</li>
			<li class="list-group-item">
				<h5>Transaction Amount: </h5>  $ ${transactionDetail.amount}
			</li>
		</ul>
	</div>
</body>
</html>