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
        
        <form action="logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
    
    <!-- SEARCH USER FORM -->
    <div class="create-box">
        <h1>Search User</h1>
        <form action="SearchUser" method="get">
            <div class="input-group">
                <label>Select User ID</label>
                <select name="userId" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select User ID--</option>
                    <% 
                        List<String> userIds = (List<String>) request.getAttribute("userIds");
                        if (userIds != null) {
                            for (String userId : userIds) {
                    %>
                                <option value="<%= userId %>"><%= userId %></option>
                    <% 
                            }
                        }
                    %>
                </select>
            </div>
            
        </form>
    </div>
</div>

</body>
</html>