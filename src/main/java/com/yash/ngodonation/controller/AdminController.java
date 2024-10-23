package com.yash.ngodonation.controller;


import com.yash.ngodonation.domain.User;
import com.yash.ngodonation.service.UserService;
import com.yash.ngodonation.serviceimpl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminController")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService;
    int tempCount = 0;

    public void init() {
        this.userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside admin controller post method");
        String action = request.getParameter("action");
        System.out.println("action: " + action);

        switch(action) {
            case "getAllDonors":
                System.out.println("get all donors case");
                getAllUsers(request, response);
                break;
            case "getDonorById":
                System.out.println("get donor by id case");
                break;
        }



        response.sendRedirect("jsp/AdminDashboard.jsp");
//        request.getRequestDispatcher("jsp/AdminDashboard.jsp").forward(request, response);
    }

    public void getAllUsers(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("tempcount: " + tempCount++);

        List<User> usersList = null;
        usersList = userService.getAllUsers();

        System.out.println("donors: ");
        for(User user: usersList) {
            System.out.println(user.getName());
        }

        // setting the userList in a variable
        HttpSession session = request.getSession();
        session.setAttribute("usersList", usersList);
        session.setAttribute("showAllDonorTable" , true);
    }

}