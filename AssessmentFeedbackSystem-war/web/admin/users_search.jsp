<%-- 
    Document   : users_search.jsp
    Created on : Dec 24, 2025
    Author     : liewj
--%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search_pages.css">
    <style>
        .hidden {
            display: none;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
        <form action="${pageContext.request.contextPath}/admin/users.jsp" method="get">
            <button type="submit">Back</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/admin/dashboard.jsp" method="get">
            <button type="submit">Home</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
    
    <!-- SEARCH USER FORM -->
    <div class="create-box">
        <h1>Search User</h1>
        <form action="${pageContext.request.contextPath}/admin_SearchUser" method="get">
            <div class="input-group">
                <label>Select User ID</label>
                <select name="userId" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select User ID--</option>
                    <% 
                        List<Long> userIds = (List<Long>) request.getAttribute("userIds");
                        if (userIds != null) {
                            for (Long userId : userIds) {
                    %>
                                <option value="<%= userId %>"><%= userId %></option>
                    <% 
                            }
                        }
                    %>
                </select>
            </div>
            <button type="submit" class="create-btn">Search</button>
        </form>
    </div>
    <!-- RESULTS SECTION WITH HARDCODED DATA -->
    <div class="create-box results-section">
        <h2>User Details</h2>
        <div class="table-wrap">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email </th>
                        <th>Password</th>
                        <th>Role</th>
                        <th>Leader ID</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${id}</td>
                        <td>${name}</td>
                        <td>${email}</td>
                        <td>${password}</td>
                        <td>${role}</td>
                        <td>${leader}</td>
                    </tr>
                   
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>