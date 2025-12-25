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
    <title>Search Assessment</title>
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
        <form action="${pageContext.request.contextPath}/lecturer/assessments.jsp" method="get">
            <button type="submit">Back</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/lecturer/dashboard.jsp" method="get">
            <button type="submit">Home</button>
        </form>
        
        <form action="logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
    
    <!-- SEARCH USER FORM -->
    <div class="create-box">
        <h1>Search Assessment</h1>
        <form action="SearchAsssessment" method="get">
            <div class="input-group">
                <label>Assessment ID</label>
                <select name="assessmentIds" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select Assessment ID--</option>
                    <% 
                        List<String> assessmentIds = (List<String>) request.getAttribute("assessmentIds");
                        if (assessmentIds != null) {
                            for (String assessmentId : assessmentIds) {
                    %>
                                <option value="<%= assessmentId %>"><%= assessmentId %></option>
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