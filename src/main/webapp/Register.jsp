<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center py-8 px-4">
    <div class="bg-white rounded-lg shadow-xl p-8 max-w-md w-full">
        <h1 class="text-3xl font-bold text-center mb-6">Create Your Account</h1>
        <form method="POST" action="register" class="space-y-6 grid-cols-1 md:grid-cols-2 gap-4">
            <div class="col-span-full md:col-span-1">
                <label for="userId" class="block mb-2">User ID</label>
                <input type="number" id="userId" name="userId" value="1" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="name" class="block mb-2">Name</label>
                <input type="text" id="name" name="name" value="Krishna" onInput="nameChange()" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            	<span id="name-error" class="text-red-500"></span>
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="email" class="block mb-2">Email</label>
                <input type="email" id="email" name="email" value="krishna.agrawal@yash.com" onChange="checkEmailValidation()" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            	<span id="email-error" class="text-red-500"></span>
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="phoneNumber" class="block mb-2">Phone Number</label>
                <input type="tel" id="phoneNumber" name="phoneNumber" value="7999609158" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="address" class="block mb-2">Address</label>
                <textarea id="address" name="address" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"></textarea>
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="password" class="block mb-2">Password</label>
                <input type="password" id="password" name="password" value="Krishna@123" onInput="checkPasswordPattern()" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
				<span id="password-error" class="text-red-500"></span>
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="confirmPassword" class="block mb-2">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" onInput="checkPasswordMatch()" value="Krishna@123" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            	<span id="password-match-error" class="text-red-500"></span>
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded col-span-full md:col-span-1">
                Register
            </button>
        </form>
        <p class="mt-8 text-sm text-center">
            Already have an account? <a href="" class="text-blue-500 hover:underline">Login</a>
        </p>
    </div>
    <script type="text/javascript">
    	function nameChange() {
    		const name = document.getElementById("name").value;
    		if(/\d/.test(name)) {
    			document.getElementById("name-error").innerHTML = "no number allowed in name"
    		}
    		else if(name.length > 20) {
    			document.getElementById("name-error").innerHTML = "name should not exceed 20 characters"
    		} else if(name.length < 6) {
    			document.getElementById("name-error").innerHTML = "name should be greater than 6 characters"
    		} else {
    			document.getElementById("name-error").innerHTML = ""
    		}
    	}
    	
    	function checkEmailValidation() {
    		const email = document.getElementById("email").value;
    		const domain = email.split("@")[1];
    		if(domain !== 'yash.com') {
    			document.getElementById("email-error").innerHTML = "only email domain allowed is yash.com"
    		} else {
    			document.getElementById("email-error").innerHTML = ""
    		}
    	}
    	
    	function checkPasswordPattern() {
    		console.log("checkPasswordPattern")
    		const password = document.getElementById("password").value;
    		if(password.length < 8) {
    			document.getElementById("password-error").innerHTML = "password must be atleast 8 char long";
    		} else {
    			document.getElementById("password-error").innerHTML = "";
    		}
    		// check min 8 characters
    		// check presence of a special character
    		// check presence of a capital letter
    		// check presence of a number
    		
    	}
    	
    	function checkPasswordMatch() {
    		const password = document.getElementById("password").value;
    		const confirmPassword = document.getElementById("confirmPassword").value;
    		if(password !== confirmPassword) {
    			document.getElementById("password-match-error").innerHTML = "passwords do not match";
    		} else {
    			document.getElementById("password-match-error").innerHTML = "";
    		}
    	}
    	
    	// password helper functions
    	function checkMin8(password) {
    		if(password.length > 8) return true
    		else return false
    	}
    	function checkSpecialCharacter(password) {
    		const specialCharacters = "!@#$%^&*()_+"
    		for(let char of specialCharacters) {
    			if(password.includes(char)) return true
    		}
    		return false
    	}
    	
    </script>
</body>
</html>
