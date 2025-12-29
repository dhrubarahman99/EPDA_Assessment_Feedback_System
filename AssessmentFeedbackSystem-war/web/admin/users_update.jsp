<%-- 
    Document   : create_user.jsp
    Created on : Dec 24, 2025, 3:16:01 PM
    Author     : liewj
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
            <form action="${pageContext.request.contextPath}/admin/users.jsp" method="post">
            <button type="submit">Back</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/admin/dashboard.jsp" method="post">
            <button type="submit"> Home</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit" >Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Update User</h1>

        <form action="${pageContext.request.contextPath}/admin_UpdateUser" method="get">
            <div class="input-group">
                <label>User ID</label>
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
            
            <div class="input-group">
                <label>Name</label>
                <input type="text" name="name" required>
            </div>

            <div class="input-group">
                <label>Email</label>
                <input type="email" name="email" required>
            </div>

            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

            <div class="input-group">
                <label>Role</label>
                <select name="role" required>
                    <option value="">--Select Role--</option>
                    <option value="Admin">Admin</option>
                    <option value="Academic Leader">Academic Leader</option>
                    <option value="Lecturer">Lecturer</option>
                    <option value="Student">Student</option>
                </select>
            </div>
            <%
            String success = (String) request.getAttribute("success");
            if (success != null) {
        %>
            <p class="success-msg"><%= success %></p>
        <%
            }
        %>
            <button type="submit" class="create-btn">Edit</button>
        </form>
    </div>

</div>

</body>
</html>