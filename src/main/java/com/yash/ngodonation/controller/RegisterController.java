package com.yash.ngodonation.controller;

import com.yash.ngodonation.domain.User;
import com.yash.ngodonation.service.UserService;
import com.yash.ngodonation.serviceimpl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public void init() {
        this.userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        User user = new User(name, email, password, phoneNumber, address);
        userService.saveUser(user);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
