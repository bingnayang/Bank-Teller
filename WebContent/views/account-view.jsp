<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Account View Page</title>
</head>
<body>
	<!-- 	Navbar Section -->
	<nav class="navbar navbar-dark bg-primary mb-2">
		<a class="navbar-brand" href="#"> <i class="fas fa-piggy-bank"></i>
			Piggy Bank
		</a>
		<form class="form-inline my-2 my-lg-0">
      		<a class="btn btn-outline-light my-2 my-sm-0" href="${pageContext.request.contextPath}/TellerController">Back To Main Page</a>
    	</form>
	</nav>
	
	<div class="container">
		<h5>Name: ${accountInfo.lastName}, ${accountInfo.firstName}</h5>
		<h5>Account Number: ${accountInfo.accountNumber}</h5>
		<h5>Account Type: ${accountInfo.accountType}</h5>
		<h5>Account Balance:$ ${accountInfo.accountBalance}</h5>
	</div>
	<div class="container">
		<a href="AccountInfo.pdf" type="application/pdf" target="_blank">Account PDF</a>
	</div>
	<div class="container mb-2">
		<div class="card">
			<div class="card-body">
				<h4 class="text-center">Deposit / Withdraw</h4>
				<form action="${pageContext.request.contextPath}/TransactionController" method="POST">
					<div class="form-group">
						<label for="formControlSelect">Select Deposit/Withdraw</label> 
						<select class="form-control" name="transactionType">
							<option value="deposit">Deposit</option>
							<option value="withdraw">Withdraw</option>
						</select>
					</div>
					<div class="form-group">
						<label for="controlInput">Enter Amount</label> 						
						<input type="number" class="form-control" name="amount" step="0.01">
						<input type="hidden" class="form-control" name="accountNumber" value="${accountInfo.accountNumber}">
						<input type="hidden" class="form-control" name="accountFirstName" value="${accountInfo.firstName}">
						<input type="hidden" class="form-control" name="accountLastName" value="${accountInfo.lastName}">
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-2">Submit</button>
				</form>
			</div>
		</div>
	</div>

	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Time</th>
					<th scope="col">Transaction</th>
					<th scope="col">Amount</th>
					<th scope="col">View Detail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accountTransactionList}" var="transaction">
					<tr>
						<td>${transaction.transaction_Date}</td>
						<td>${transaction.transaction_Time}</td>
						<td>${transaction.transaction_Type}</td>
						<fmt:setLocale value = "en_US"/>
						<td><fmt:formatNumber value = "${transaction.amount}" type = "currency"/></td>					
 						<td><button type="button" class="btn btn-info" onclick="window.location.href='${pageContext.request.contextPath}/TransactionDetailController?id=${transaction.transaction_ID}'">View</button></td>
 					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>