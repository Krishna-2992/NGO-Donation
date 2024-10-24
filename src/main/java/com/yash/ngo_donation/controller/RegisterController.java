package com.yash.ngo_donation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ngo_donation.pojo.User;
import com.yash.ngo_donation.service.UserService;
import com.yash.ngo_donation.serviceImpl.UserServiceImpl;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public void init() {
		this.userService = new UserServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int userId = 1; 
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String role = "donor";
		
		User user = new User(userId, name, password, email, phoneNumber, address, role);
		userService.saveUser(user);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);		
	}


}