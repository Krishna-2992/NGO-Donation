<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="styles/index.css">
    <link rel="stylesheet" type="text/css" href="../allUserTable.css">

</head>
<body>

    <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="navbar-left">
            <h1 class="navbar-title">NGO Donation</h1>
        </div>
        <div class="navbar-right">
            <a href="pages/login.jsp" class="button">Login</a>
            <a href="jsp/register.jsp" class="button">Register</a>
        </div>
    </nav>

    <h1 class="welcome-title">Welcome to the Home Page</h1>

    <form method="post" action="campaignController">
        <input type="submit" class="button" value="See campaign list">
    </form>
    <jsp:include page='components/allCampaignsTable.jsp' />

</body>
</html>