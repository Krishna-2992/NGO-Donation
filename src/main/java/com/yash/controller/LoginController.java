package com.yash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pojo.User;
import com.yash.service.UserService;
import com.yash.serviceImpl.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UserService userService;
	
	public void init() {
		this.userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.getUser(email, password);
		
		PrintWriter out = response.getWriter();
		if(user.getName() != null) {
			out.println("User dashboard: " + user.getName());
		} 
		else {
			out.println("Invalid credentials!!!");
			out.println("Try logging In Again :(");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}