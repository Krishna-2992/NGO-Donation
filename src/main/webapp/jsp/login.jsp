<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="../styles/login.css"> <!-- Link to your CSS file -->
</head>
<body class="body">
    <div class="container">
        <h1 class="title">Welcome Back</h1>
        <form id="loginForm" class="form" action="../login" method="post">
            <input type="email" name="email" placeholder="Email" value="Shreyash@yash.com" required class="input">
            <input type="password" name="password" placeholder="Password" value="Shreyash@123" required class="input">
            <button type="submit" class="btn">Login</button>
        </form>
        <p class="signup-text">
            Don't have an account? <a href="#" class="signup-link">Sign Up</a>
        </p>
    </div>
</body>
</html>