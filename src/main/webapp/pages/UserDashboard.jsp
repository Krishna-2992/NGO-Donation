<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../styles/userDashboard.css"> <!-- Link to your CSS file -->
</head>
<body class="bg-gray-100 min-h-screen">

    <div class="dashboard-container">
        <h1 class="dashboard-title">User  Dashboard</h1>

        <%
            int userId = (int) session.getAttribute("userId"); // Retrieve userId from session
            String userName = (String) session.getAttribute("userName");
            String email = (String) session.getAttribute("email");
            String phoneNumber = (String) session.getAttribute("phoneNumber");
            String address = (String) session.getAttribute("address");
        %>

        <div class="user-info">
            <p><strong>User ID:</strong> <%= userId %></p>
            <p><strong>Name:</strong> <%= userName != null ? userName : "N/A" %></p>
            <p><strong>Email:</strong> <%= email != null ? email : "N/A" %></p>
            <p><strong>Phone Number:</strong> <%= phoneNumber != null ? phoneNumber : "N/A" %></p>
            <p><strong>Address:</strong> <%= address != null ? address : "N/A" %></p>
        </div>

        <div class="button-container">
            <button class="btn" onclick="location.href='logout.jsp'">Logout</button> <!-- Example button -->
        </div>

    </div>

</body>
</html>