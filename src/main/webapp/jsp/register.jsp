<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="../styles/register.css"> <!-- Link to the external CSS file -->
</head>
<body class="bg-gray">

    <div class="form-container">
        <h1 class="form-title">Create Your Account</h1>
        <form method="POST" action="../register" class="form">
            <div class="form-group">
                <label for="userId">User  ID</label>
                <input type="number" id="userId" name="userId" value="1" required>
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" value="Krishna" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="krishna.agrawal@yash.com" required>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number</label>
                <input type="tel" id="phoneNumber" name="phoneNumber" value="7999609158" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <textarea id="address" name="address" required></textarea>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" value="Krishna@123" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" value="Krishna@123" required>
            </div>
            <button type="submit" class="btn">
                Register
            </button>
        </form>
        <p class="login-text">
            Already have an account? <a href="" class="login-link">Login</a>
        </p>
    </div>

</body>
</html>