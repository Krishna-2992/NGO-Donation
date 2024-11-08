<%@ page import="java.util.List" %>
<%@ page import="com.yash.ngodonation.domain.Campaign" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../styles/allUserTable.css"> <!-- Link to your CSS file -->
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .user-table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .user-table thead {
            background-color: #4CAF50;
            color: white;
        }

        .user-table th, .user-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tbody > tr:hover {
            background-color: #e1e1e1; /* Light gray background on hover */
        }

        .user-table th {
            position: sticky;
            top: 0; /* Makes the header sticky */
        }

        button {
            border: none;
            background-color: white;
            text-color: blue;
        }
    </style>
</head>
<body>

    <% List<Campaign> campaignList = (List<Campaign>) session.getAttribute("campaignList");%>
    <% if (campaignList != null && !campaignList.isEmpty()) { %>
    <h2>Campaign List</h2>
        <table id="donorsTable" class="user-table">
            <thead>
                <tr>
                    <th>Campaign ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Fund Raised</th>
                    <th>Target Amount</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </tr>
            </thead>
            <tbody>
                <% for (Campaign campaign : campaignList) {
                String campaignPage = "pages/campaign.jsp?id=" + campaign.getCampaignId(); %>
                    <tr>
                        <td><a href="<%= campaignPage %>"><%= campaign.getCampaignId() %></a></td>
                        <td><%= campaign.getTitle() %></td>
                        <td><%= campaign.getDescription() %></td>
                        <td><%= campaign.getFundRaised() %></td>
                        <td><%= campaign.getTargetAmount() %></td>
                        <td><%= campaign.getStartDate() %></td>
                        <td><%= campaign.getEndDate() %></td>
                    </tr>
                <% } %>
            </tbody>

        </table>
    <% } %>


</body>
</html>