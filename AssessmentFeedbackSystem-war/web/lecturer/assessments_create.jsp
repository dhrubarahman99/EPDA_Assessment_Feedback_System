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
    <title>Create Assessment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
            <form action="${pageContext.request.contextPath}/lecturer/assessments.jsp" method="post">
            <button type="submit">Back</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/lecturer/dashboard.jsp" method="post">
            <button type="submit"> Home</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit" >Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Create Assessment</h1>

        <form action="lecturer_CreateAssessment" method="get">
            <div class="input-group">
                <label>Title</label>
                <input type="text" name="title" required>
            </div>

            <div class="input-group">
                <label>Weightage</label>
                <input type="number" name="weightage" min = 0 max = 100 required>
            </div>

            <div class="input-group">
                <label>Module ID</label>
                <select name="moduleIds" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select Module ID--</option>
                    <% 
                        List<Long> moduleIds = (List<Long>) request.getAttribute("moduleIds");
                        if (moduleIds != null) {
                            for (Long moduleId : moduleIds) {
                    %>
                                <option value="<%= moduleId %>"><%= moduleId %></option>
                    <% 
                            }
                        }
                    %>
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

            <button type="submit" class="create-btn">Create</button>
        </form>
    </div>

</div>

</body>
</html>