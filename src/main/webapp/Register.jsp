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
                <input type="text" id="name" name="name" value="Krishna" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="email" class="block mb-2">Email</label>
                <input type="email" id="email" name="email" value="krishna.agrawal@yash.com" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
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
                <input type="password" id="password" name="password" value="Krishna@123" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div class="col-span-full md:col-span-1">
                <label for="confirmPassword" class="block mb-2">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" value="Krishna@123" required class="w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded col-span-full md:col-span-1">
                Register
            </button>
        </form>
        <p class="mt-8 text-sm text-center">
            Already have an account? <a href="" class="text-blue-500 hover:underline">Login</a>
        </p>
    </div>
</body>
</html>
