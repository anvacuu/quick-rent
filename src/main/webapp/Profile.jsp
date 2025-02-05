<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="module.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
</head>
<body>

<h2>User Profile</h2>

<%
    // Retrieve the customer object from the request attribute
    Customer customer = (Customer) request.getAttribute("customer");

    if (customer != null) {
%>
<p><strong>Email:</strong> <%= customer.getEmail() %></p>
<p><strong>Full Name:</strong> <%= customer.getFullName() %></p>
<p><strong>Phone Number:</strong> <%= customer.getPhone() %></p>
<p><strong>Date of Birth:</strong> <%= customer.getBirthDate() %></p>
<p><strong>Profile Image:</strong> <img src="<%= customer.getImage() %>" alt="Profile Image" width="100"></p>

<!-- Link to edit profile -->
<a href="editProfile.jsp">Edit Profile</a>
<%
} else {
%>
<p>No user found or session expired. Please <a href="login.jsp">Login</a> again to view your profile.</p>
<%
    }
%>

</body>
</html>
