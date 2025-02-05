package com.example.quickrent;

import dao.CustomerDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import module.Customer;
import util.EncryptionPasword;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("loginname");
        String password = request.getParameter("password");

        CustomerDao cd = new CustomerDao();
        password = EncryptionPasword.toSHA1(password);
        Customer c = cd.getCustomer(email, password);
        System.out.println("anh dai dien: " +c.getImage());
        if (c != null) {
            HttpSession http = request.getSession();
            http.setAttribute("username", c.getEmail());
            http.setAttribute("userImage", c.getImage());  // Lưu đường dẫn ảnh
            request.getRequestDispatcher("Header.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Email or password is incorrect!");
            request.getRequestDispatcher("Loggin.jsp").forward(request, response);
        }
    }

}
