package com.yash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	    if (user != null && user.getName() != null) {	        
			HttpSession session = request.getSession();
			
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("phoneNumber", user.getPhoneNumber());
			session.setAttribute("address", user.getAddress());
			System.out.println("user role: " + user.getRole());
			String userRole = user.getRole();
			if(userRole.equals("admin")) {
				response.sendRedirect("AdminDashboard.jsp");
			} else if(userRole.equals("donor")) {
				System.out.println("user role: " + user.getRole());
				response.sendRedirect("UserDashboard.jsp");
			} else {
				System.out.println("user role is: " + userRole);
			}
	    } else {
	        request.setAttribute("error", "Invalid credentials!!!");
	        request.getRequestDispatcher("Login.jsp").forward(request, response);
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}