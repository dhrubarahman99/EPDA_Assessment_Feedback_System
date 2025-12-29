<%-- 
    Document   : profile
    Created on : Dec 24, 2025, 7:10:38 PM
    Author     : Dhruba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Users"%>
<!DOCTYPE html>
<html>
<head>
    <title>Leader Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form-panels.css">
</head>
<body>

<%
    // Get user passed from servlet
    Users u = (Users) request.getAttribute("profileUser");

    // redirect to servlet if no session
    if (u == null) {
        response.sendRedirect(request.getContextPath() + "/LeaderProfile");
        return;
    }

    String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

<div class="dashboard-container">

    <div class="top-bar">
        <a href="${pageContext.request.contextPath}/leader/dashboard.jsp" class="btn btn-secondary back-btn">Back</a>
        <h1>PROFILE</h1>
        <form action="<%= request.getContextPath() %>/Logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <% if (error != null) { %>
        <p class="error-msg"><%= error %></p>
    <% } %>

    <% if (success != null) { %>
        <p class="success-msg"><%= success %></p>
    <% } %>

    <div class="panel-grid">

        <!-- VIEW PROFILE PANEL -->
        <div class="panel">
            <h2 class="panel-title">Your Details</h2>

            <div class="info-row">
                <span class="info-label">Name</span>
                <div class="info-value"><%= u.getName() %></div>
            </div>

            <div class="info-row">
                <span class="info-label">Email</span>
                <div class="info-value"><%= u.getEmail() %></div>
            </div>

            <div class="info-row">
                <span class="info-label">Role</span>
                <div class="info-value"><%= u.getRole() %></div>
            </div>

            <div class="info-row">
                <span class="info-label">User ID</span>
                <div class="info-value"><%= u.getId() %></div>
            </div>
        </div>

        <!-- EDIT PROFILE PANEL -->
        <div class="panel">
            <h2 class="panel-title">Edit Profile</h2>

            <form action="<%= request.getContextPath() %>/LeaderProfile" method="post">

                <div class="form-row">
                    <label class="form-label">Name</label>
                    <input type="text" name="name" class="form-input"
                           value="<%= u.getName() %>"
                           placeholder="Enter full name" required>
                </div>

                <div class="form-row">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-input"
                           value="<%= u.getEmail() %>"
                           placeholder="Enter email address" required>
                </div>

                <div class="form-row">
                    <label class="form-label">New Password</label>
                    <input type="password" name="newPassword" class="form-input"
                           placeholder="Leave blank to keep current password">
                </div>

                <div class="btn-row">
                    <button type="submit" class="btn btn-primary">Save Changes</button>
                    <a href="<%= request.getContextPath() %>/LeaderProfile" class="btn btn-secondary">Cancel</a>
                </div>

            </form>
        </div>

    </div>
</div>

</body>
</html>



