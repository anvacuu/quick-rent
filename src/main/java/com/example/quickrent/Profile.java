package com.example.quickrent;

import dao.CustomerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import module.Customer;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Profile", value = "/Profile")
public class Profile extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("username");
        CustomerDao dao = new CustomerDao();
        Customer c= dao.SelectCustomerByEmail(email);
        request.setAttribute("customer", c);
        request.getRequestDispatcher("Profile.jsp").forward(request, response);
    }

    public void destroy() {
    }
}