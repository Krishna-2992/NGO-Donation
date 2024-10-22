<%@ page import="java.util.List" %>
<%@ page import="com.yash.ngodonation.domain.User" %> <!-- Change to the actual package name of your User class -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../styles/adminDashboard.css"> <!-- Link to the external CSS file -->
</head>
<body>

    <div class="dashboard-container">
        <h1 class="dashboard-title">Admin Dashboard</h1>

        <%
            String userName = (String) session.getAttribute("userName");
            boolean userPresent = false;
            if (userName != null) {
                userPresent = true;
                out.println("<p class='welcome-message'>Welcome, " + userName + "</p>");
            } else {
                out.println("<p class='welcome-message'>Welcome, Guest</p>");
            }
        %>

        <form action="../adminController?action=getAllDonors" method="POST">
            <button type="submit" class="btn">Get All Donors</button>
        </form>
        <%
            List<User> usersList = (List<User>) session.getAttribute("usersList");
            if (usersList != null && !usersList.isEmpty()) {
                out.println("<ul class='user-list'>"); // Start an unordered list
                for (User  user : usersList) {
                    out.println("<li>" + user.getName() + " - " + user.getEmail() + "</li>"); // Display user name and email
                }
                out.println("</ul>"); // End the unordered list
            }
        %>

        <form action="../adminController?action=getDonorById" method="POST">
            <input type="text" name="userIdToSearch" placeholder="11">
            <button type="submit" class="btn">Get user by id</button>
        </form>


    </div>

</body>
</html>