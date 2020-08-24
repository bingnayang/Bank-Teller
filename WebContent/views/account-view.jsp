<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Account View Page</title>
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
		<h5>Name: ${accountInfo.lastName}, ${accountInfo.firstName}</h5>
		<h5>Account Number: ${accountInfo.accountNumber}</h5>
		<h5>Account Type: ${accountInfo.accountType}</h5>
		<h5>Account Balance:$ ${accountInfo.accountBalance}</h5>
	</div>
	
	<div class="container">
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Date</th>
      <th scope="col">Time</th>
      <th scope="col">Transaction</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${accountTransactionList}" var="transaction">
    <tr>
      <td>${transaction.transaction_Date}</td>
      <td>${transaction.transaction_Time}</td>
      <td>${transaction.transaction_Type}</td>
      <td>${transaction.amount}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>
	
	<div class="container">
		<button type="button" class="btn btn-primary">Deposit</button>
		<button type="button" class="btn btn-primary">Withdraw</button>
	</div>
</body>
</html>