<%@ page import="java.util.List" %>
<%@ page import="com.yash.ngodonation.domain.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../styles/allUserTable.css"> <!-- Link to your CSS file -->
</head>
<body>

    <% List<User> usersList = (List<User>) session.getAttribute("usersList");%>

    <h1>Employee Information</h1>

    <% if (usersList != null && !usersList.isEmpty()) { %>
        <table class="user-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Department</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <% for (User  user : usersList) { %>
                    <tr>
                        <td><%= user.getUserId() %></td>
                        <td><%= user.getName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getPhoneNumber() %></td>
                        <td><%= user.getAddress() %></td>
                        <td><%= user.getRole() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p>No employee information available.</p>
    <% } %>

</body>
</html>