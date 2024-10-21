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
    <form action="Donation" method="post">


        <label for="userId">User  ID:</label>
        <input id="userId" name="userId" type="text" required><br>

        <label for="name">Donation ID:</label>
        <input id="Donation ID" name="Donation ID" type="text" required><br>

        <label for="donationAmount">Donation Amount:</label>
        <input id="donationAmount" name="donationAmount" type="text" required><br>

        <label for="donationDate">Donation Date:</label>
        <input id="donationDate" name="donationDate" type="date" required><br>



        <input type="submit" value="submit">
    </form>
</body>
</html>