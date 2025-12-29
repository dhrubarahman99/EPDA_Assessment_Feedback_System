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
    <title>Update GradeScheme</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
            <form action="${pageContext.request.contextPath}/admin/gradescheme.jsp" method="post">
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
        <h1>Update GradeScheme</h1>

        <form action="${pageContext.request.contextPath}/admin_UpdateGradeScheme" method="get">
            <div class="input-group">
                <label>Select GradeScheme ID</label>
                <select name="gradeschemeId" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select GradeScheme ID--</option>
                    <% 
                        List<Long> gradeschemeIds = (List<Long>) request.getAttribute("gradeschemeIds");
                        if (gradeschemeIds != null) {
                            for (Long gradeschemeId : gradeschemeIds) {
                    %>
                                <option value="<%= gradeschemeId %>"><%= gradeschemeId %></option>
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
                <label>A MIN</label>
                <input type="number" name="aMin" required>
            </div>

            <div class="input-group">
                <label>B MIN</label>
                <input type="number" name="bMin" required>
            </div>

            <div class="input-group">
                <label>C MIN</label>
                <input type="number" name="cMin" required>
            </div>

            <div class="input-group">
                <label>D MIN</label>
                <input type="number" name="dMin" required>
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