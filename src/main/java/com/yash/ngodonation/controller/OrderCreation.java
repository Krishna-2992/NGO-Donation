package com.yash.ngodonation.controller;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import com.razorpay.*;

@WebServlet("/OrderCreation")
public class OrderCreation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderCreation() {
        super();
    }

    // Handles the creation of the order (GET request)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = null;
        try {
            // Initialize Razorpay client with API keys
            RazorpayClient razorpay = new RazorpayClient("secret_key", "public_key");
            System.out.println("This is get");

            System.out.println("Request Method: " + request.getMethod());
            System.out.println("Content-Type: " + request.getContentType());

            // Log all received parameters
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap.isEmpty()) {
                System.out.println("No parameters received.");
            } else {
                parameterMap.forEach((key, value) -> {
                    System.out.println(key + ": " + Arrays.toString(value));
                });
            }

//            String name = request.getParameter("name");
//            String amountStr = request.getParameter("amount");
            
            // Fetch amount from request (input is in rupees, converting to paise)
            System.out.println(request.getParameter("name")); 
           
            int amount = Integer.parseInt(request.getParameter("amount")) * 100;
//            System.out.println(amount);

            // Create a JSON object to send in the order request
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount); // amount in paise
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "receipt#1");
            orderRequest.put("payment_capture", true); // Automatically capture payment

            // Create the order
            Order order = razorpay.Orders.create(orderRequest);
            orderId = order.get("id"); // Get the generated order ID

            
            response.setContentType("text/plain");
            response.getWriter().append(orderId);

        } catch (RazorpayException e) {
            e.printStackTrace();
            response.getWriter().append("Error creating order: " + e.getMessage());
        }
    }

    // Handles the verification of the payment (POST request)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Initialize Razorpay client with API keys
            RazorpayClient client = new RazorpayClient("secret_key", "public_key");

            System.out.println("This is poset");
            // Create a JSON object with the payment details
            JSONObject options = new JSONObject();
            options.put("razorpay_payment_id", request.getParameter("razorpay_payment_id"));
            options.put("razorpay_order_id", request.getParameter("razorpay_order_id"));
            options.put("razorpay_signature", request.getParameter("razorpay_signature"));
            String string = request.getParameter("razorpay_payment_id");
//            System.out.println(string);

            // Verify the payment signature
            boolean signatureValid = Utils.verifyPaymentSignature(options, "public_key");

            // If signature is valid, payment is successful
            if (signatureValid) {
                response.getWriter().append("PAYMENT SUCCESSFUL");
            } else {
                response.getWriter().append("PAYMENT FAILED: Invalid signature");
            }

        } catch (RazorpayException e) {
            e.printStackTrace();
            response.getWriter().append("Error verifying payment: " + e.getMessage());
        }
    }
}