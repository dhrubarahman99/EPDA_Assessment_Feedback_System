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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search_pages.css">
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
        <form action="${pageContext.request.contextPath}/lecturer/marks.jsp" method="get">
            <button type="submit">Back</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/lecturer/dashboard.jsp" method="get">
            <button type="submit">Home</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
    
    <!-- SEARCH USER FORM -->
    <div class="create-box">
        <h1>Search Marks</h1>
        <form action="SearchMarks" method="get">
            <div class="input-group">
                <label>Marks ID</label>
                <select name="marksIds" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select Marks ID--</option>
                    <% 
                        List<String> marksIds = (List<String>) request.getAttribute("marksIds");
                        if (marksIds != null) {
                            for (String marksId : marksIds) {
                    %>
                                <option value="<%= marksId %>"><%= marksId %></option>
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
        <h2>Mark Details</h2>
        <div class="table-wrap">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Score</th>
                        <th>Feedback </th>
                        <th>Enrollment ID</th>
                        <th>Assessment ID</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>100000</td>
                        <td>100</td>
                        <td>Very Good</td>
                        <td>1000</td>
                        <td>1000</td>
                    </tr>
                   
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>