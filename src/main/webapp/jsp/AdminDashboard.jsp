<%@ page import="java.util.List" %>
<%@ page import="com.yash.ngodonation.domain.User" %> <!-- Change to the actual package name of your User class -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../styles/adminDashboard.css">
</head>
<body>

    <div class="dashboard-container">
        <h1 class="dashboard-title">Admin Dashboard</h1>

        <%
            List<User> usersList = (List<User>) session.getAttribute("usersList");
            boolean showAllDonorTable = false;

            String userName = (String) session.getAttribute("userName");
            boolean userPresent = false;
            if (userName != null) {
                userPresent = true;
                out.println("<p class='welcome-message'>Welcome, " + userName + "</p>");
            } else {
                out.println("<p class='welcome-message'>Welcome, Guest</p>");
            }
        %>

        <% if (usersList != null && !usersList.isEmpty()) { %>
            <jsp:include page='allUsersTable.jsp' />
        <% } %>

        <form action="../adminController?action=getAllDonors" method="POST">
            <button type="submit" class="btn">Get All Donors</button>
        </form>

        <form action="../adminController?action=getDonorById" method="POST">
            <input type="text" name="userIdToSearch" placeholder="11">
            <button type="submit" class="btn">Get user by id</button>
        </form>


    </div>

</body>
</html>