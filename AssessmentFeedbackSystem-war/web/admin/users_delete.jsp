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
    <title>Delete User</title>
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
        <h1>Delete User</h1>

        <form action="DeleteGradeScheme" method="post">
            <div class="input-group">
                <label>User ID</label>
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
            

            <button type="submit" class="create-btn">Delete</button>
        </form>
    </div>

</div>

</body>
</html>