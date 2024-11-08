<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="../styles/register.css"> <!-- Link to the external CSS file -->
    <style>
        .error-message {
            color: red;
            font-size: 0.9em;
            margin-top: 5px;
        }
    </style>
    <script>
        function validateField(field, message) {
            const errorField = document.getElementById(field + 'Error');
            errorField.textContent = message;
            errorField.style.display = 'block';
        }

        function clearError(field) {
            const errorField = document.getElementById(field + 'Error');
            errorField.textContent = '';
            errorField.style.display = 'none';
        }

        function validateEmail() {
            const email = document.getElementById('email').value;
            const emailDomain = "@yash.com";
            clearError('email');
            if (!email.endsWith(emailDomain)) {
                validateField('email', "Email must be of domain " + emailDomain);
            }
        }

        function validateName() {
            const name = document.getElementById('name').value;
            const namePattern = /^.{5,20}$/; // Name must be 5 to 20 characters
            clearError('name');
            if (!namePattern.test(name)) {
                validateField('name', "Name must be between 5 to 20 characters long.");
            }
        }

        function validatePassword() {
            const password = document.getElementById('password').value;
            const passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/; // Password validation
            clearError('password');
            if (!passwordPattern.test(password)) {
                validateField('password', "Password must be at least 8 characters long, contain at least one uppercase letter, one number, and one special character.");
            }
        }

        function validateConfirmPassword() {
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirmPassword').value;
            clearError('confirmPassword');
            if (password !== confirmPassword) {
                validateField('confirmPassword', "Passwords do not match.");
            }
        }

        function validatePhoneNumber() {
            const phoneNumber = document.getElementById('phoneNumber').value;
            clearError('phoneNumber');
            if (phoneNumber.length !== 10 || isNaN(phoneNumber)) {
                validateField('phoneNumber', "Phone number must be 10 digits long.");
            }
        }

        function setupValidation() {
            document.getElementById('email').addEventListener('input', validateEmail);
            document.getElementById('name').addEventListener('input', validateName);
            document.getElementById('password').addEventListener('input', validatePassword);
            document.getElementById('confirmPassword').addEventListener('input', validateConfirmPassword);
            document.getElementById('phoneNumber').addEventListener('input', validatePhoneNumber);
        }

        document.addEventListener('DOMContentLoaded', setupValidation);
    </script>
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
                <div id="nameError" class="error-message" style="display: none;"></div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="krishna.agrawal@yash.com" required>
                <div id="emailError" class="error-message" style="display: none;"></div>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number</label>
                <input type="tel" id="phoneNumber" name="phoneNumber" value="7999609158" required>
                <div id="phoneNumberError" class="error-message" style="display: none;"></div>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <textarea id="address" name="address" required></textarea>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" value="Krishna@123" required>
                <div id="passwordError" class="error-message" style="display: none;"></div>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" value="Krishna@123" required>
                <div id="confirmPasswordError" class="error-message" style="display: none;"></div>
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