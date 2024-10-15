<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Receipt" method="post">

Payment Id: <input name="paymentId" type="text" required><br>
User Id: <input name="userId" type="text" required><br>
Donor Name: <input name="name" type="text" required><br>
Donation Amount: <input name="donationAmount" type="text" required><br>
Donation Date: <input name="donationDate" type="date" required><br>
Payment Mode: <input name="paymentMode" type="text" required><br>
<input type="submit" value="Generate Receipt">
</form>
</body>
</html>