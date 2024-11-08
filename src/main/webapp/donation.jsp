<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Donation</title>
</head>
<body>
    <h1>Donation Form</h1>
    <form action="DonationController" method="post">

        <label for="userId">User  ID:</label>
        <input id="userId" name="userId" type="text" required><br>

        <label for="donationId">Donation ID:</label>
        <input id="donationId" name="donationId" type="text" required><br>

        <label for="donationAmount">Donation Amount:</label>
        <input id="donationAmount" name="donationAmount" type="number" step="0.01" required><br> <!-- Changed to number -->

        <label for="donationDate">Donation Date:</label>
        <input id="donationDate" name="donationDate" type="date" required><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>