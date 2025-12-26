<%-- 
    Document   : create_user.jsp
    Created on : Dec 24, 2025, 3:16:01 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
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

        <form action="${pageContext.request.contextPath}/Logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Create User</h1>

        <!-- ERROR MESSAGE -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p class="error-msg"><%= error %></p>
        <%
            }
        %>

        <form action="${pageContext.request.contextPath}/Register" method="post">

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
                    <option value="ADMIN">Admin</option>
                    <option value="LEADER">Academic Leader</option>
                    <option value="LECTURER">Lecturer</option>
                    <option value="STUDENT">Student</option>
                </select>
            </div>
            
        <!-- SUCCESS MESSAGE -->
        <%
            String success = (String) request.getAttribute("success");
            if (success != null) {
        %>
            <p class="success-msg"><%= success %></p>
        <%
            }
        %>
            
           
            <button type="submit" class="create-btn">Create</button>
        </form>

    </div>

</div>

</body>
</html>
