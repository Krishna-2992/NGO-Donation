<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download Certificate</title>
</head>
<body>
    <h2>Download Certificate</h2>
    <form action="downloadCertificate" method="get">
        Enter Certificate ID: <input type="text" name="certificateId" required><br><br>
        <input type="submit" value="Download Certificate">
    </form>
</body>
</html>