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
    <title>Search GradeScheme</title>
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
        <form action="${pageContext.request.contextPath}/admin/gradescheme.jsp" method="get">
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
        <h1>Search GradeScheme</h1>
        <form action="SearchGradeScheme" method="get">
            <div class="input-group">
                <label>Select GradeScheme ID</label>
                <select name="gradeschemeId" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select GradeScheme ID--</option>
                    <% 
                        List<String> gradeschemeIds = (List<String>) request.getAttribute("gradeschemeIds");
                        if (gradeschemeIds != null) {
                            for (String gradeschemeId : gradeschemeIds) {
                    %>
                                <option value="<%= gradeschemeId %>"><%= gradeschemeId %></option>
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