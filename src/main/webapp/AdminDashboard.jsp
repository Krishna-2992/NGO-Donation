<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body>
    <h2>Welcome Admin, <%= session.getAttribute("userName") %>
    <h3>UserId: <%= session.getAttribute("userId") %></h3>
    <h3>Email: <%= session.getAttribute("email") %></h3>
    <h3>Phone Number: <%= session.getAttribute("phoneNumber") %></h3>
    <h3>UserId: <%= session.getAttribute("address") %></h3>
</body>
</html>


