<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 min-h-screen">
    <nav class="bg-white shadow-md fixed top-0 left-0 right-0 z-50">
	    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
	        <div class="flex justify-between items-center py-3 md:flex-no-wrap md:py-0">
	            <div class="flex-shrink-0 flex items-center">
	                <img src="logo.png" alt="Logo" class="h-8 w-auto">
	            </div>
	            <div class="hidden md:flex space-x-8">
	                <a href="#home" class="text-gray-600 hover:text-blue-500">Home</a>
	                <a href="#about" class="text-gray-600 hover:text-blue-500">About</a>
	                <a href="#contact" class="text-gray-600 hover:text-blue-500">Contact</a>
	            </div>
	            <div class="hidden md:flex space-x-4">
	                <form action="./Login.jsp" method="POST">
	                    <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Login</button>
	                </form>
	                <form action="./Register.jsp" method="POST">
	                    <button type="submit" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">Register</button>
	                </form>
	            </div>
	        </div>
	    </div>
    </nav>

	<!-- Mobile menu button -->
	<div id="mobile-menu-button" class="md:hidden ml-2 flex items-center">
	    <svg class="w-5 h-5" viewBox="0 0 20 20" fill="none">
	        <path d="M0 11a2 2 0 0 1 2-2h12a2 2 0 0 1 2-2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h8zm15.3 4.7l-1.8-1.8-4.3 4.3 1.8 1.8L19 14.9l-4.3-4.3z" />
	    </svg>
	</div>
	
	<!-- Mobile menu -->
	<div id="mobile-menu" class="hidden md:hidden fixed top-16 left-0 right-0 z-50 bg-white shadow-md">
	    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-4">
	        <div class="flex justify-between items-center pb-4 border-b">
	            <img src="logo.png" alt="Logo" class="h-8 w-auto">
	        </div>
	        <nav class="mt-6">
	            <div class="space-y-4">
	                <a href="#home" class="text-gray-600 hover:text-blue-500">Home</a>
	                <a href="#about" class="text-gray-600 hover:text-blue-500">About</a>
	                <a href="#contact" class="text-gray-600 hover:text-blue-500">Contact</a>
	            </div>
	        </nav>
	        <div class="mt-6 space-y-4">
	            <form action="./Login.jsp" method="POST">
	                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Login</button>
	            </form>
	            <form action="./Register.jsp" method="POST">
	                <button type="submit" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">Register</button>
	            </form>
	        </div>
	    </div>
	</div>
	
	<script>
	    const mobileMenuButton = document.querySelector('#mobile-menu-button');
	    const mobileMenu = document.getElementById('mobile-menu');
	
	    mobileMenuButton.addEventListener('click', () => {
	        mobileMenu.classList.toggle('hidden');
	    });
	</script>
    
</body>
</html>
