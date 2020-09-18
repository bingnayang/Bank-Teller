<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Transaction Detail</title>
</head>
<body>
	<div class="container">
		<h3>Account Info</h3>
		<h5>${transactionDetail.account_Number}</h5>
	</div>
	<hr>
	<div class="container">
		<h3>Transaction Detail</h3>
		<h5>Branch Name: ${transactionDetail.branch_Name}</h5>
		<h5>Transaction Date: ${transactionDetail.transaction_Date}</h5>
		<h5>Transaction Time: ${transactionDetail.transaction_Time}</h5>
		<h5>Employee Name: ${transactionDetail.employeeName}</h5>
		<h5>Amount $ ${transactionDetail.amount}</h5>
		<h5>Type: ${transactionDetail.transaction_Type}</h5>
	</div>
</body>
</html>