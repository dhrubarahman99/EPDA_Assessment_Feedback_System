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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search_pages.css">
    <style>
        .hidden {
            display: none;
        }
        .results-section {
            margin-top: 30px;
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
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
    
    <!-- SEARCH USER FORM -->
    <div class="create-box">
        <h1>Search GradeScheme</h1>
        <form action="${pageContext.request.contextPath}/admin_SearchGradeScheme" method="get">
            <div class="input-group">
                <label>Select GradeScheme ID</label>
                <select name="gradeschemeId" id="userSelect" required>
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
            
            <button type="submit" class="create-btn">Search</button>
        </form>
    </div>
    
    <!-- RESULTS SECTION WITH HARDCODED DATA -->
    <div class="create-box results-section">
        <h2>GradeScheme Details</h2>
        <div class="table-wrap">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Scheme Name</th>
                        <th>A Min </th>
                        <th>B Min</th>
                        <th>C Min</th>
                        <th>D Min</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${id}</td>
                        <td>${name}</td>
                        <td>${aMin}</td>
                        <td>${bMin}</td>
                        <td>${cMin}</td>
                        <td>${dMin}</td>
                    </tr>
                   
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>