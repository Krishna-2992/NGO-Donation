package com.yash.ngodonation.controller;

import com.yash.ngodonation.domain.User;
import com.yash.ngodonation.service.UserService;
import com.yash.ngodonation.serviceimpl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public void init() {
        this.userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // extract the credentials from the request
        System.out.println("inside login controller get method");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // get the user details from the database
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
                response.sendRedirect("jsp/AdminDashboard.jsp");
            } else if(userRole.equals("donor")) {
                response.sendRedirect("jsp/UserDashboard.jsp");
            } else {
                System.out.println("user role is: " + userRole);
            }
        } else {
            request.setAttribute("error", "Invalid credentials!!!");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}