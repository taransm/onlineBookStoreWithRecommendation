
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bookstore.data.User"%>
<%

User loggedInUser = (bookstore.data.User) session.getAttribute("LoggedInUser");

boolean isAdmin = loggedInUser.getRole().equalsIgnoreCase("Admin");
boolean isCustomer = loggedInUser.getRole().equalsIgnoreCase("Customer");

%>

<p>
    <br>
    <a  target="_blank" style="float: left;">
    <img src="<%=request.getContextPath()%>/image/FastBanner.png" height="40" alt="Students Book Store" style="margin-bottom: 10px;">
    </a>
</p>
<div style="text-align:right">
    Welcome, <%=loggedInUser.getUsername()%> 
    <a class="btn btn-info" href="<%=request.getContextPath()%>/logout">Log Out</a>
</div>
<p></p>
<div style="background-color:#003767; padding:3px; "></div>
<p></p>