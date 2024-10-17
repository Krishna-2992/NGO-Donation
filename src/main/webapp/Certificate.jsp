<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Certificate Generation</title>
</head>
<body>
    <h2>Generate Certificate</h2>
    <form action="generateCertificate" method="post">
        Name: <input type="text" name="name" required><br>
        Donor ID: <input type="text" name="donorId" required><br>
        Payment Mode: <input type="text" name="paymentMode" required><br>
        Date of Issue: <input type="date" name="dateOfIssue" required><br>
        <input type="submit" value="Generate Certificate">
    </form>

    <br><br>
    <button onclick="window.print()">Print Certificate</button>
    <button onclick="window.location.href='certificateDownload.jsp'">Download Certificate</button>
</body>
</html>