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
        <form action="${pageContext.request.contextPath}/student/dashboard.jsp" method="get">
            <button type="submit">Home</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
    
    <!-- RESULTS SECTION WITH HARDCODED DATA -->
    <div class="create-box results-section">
        <h2>My Module Details</h2>
        <div class="table-wrap">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Assessment Name</th>
                        <th>Score</th>
                        <th>Grade</th>
                        <th>Feedback</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>CS test</td>
                        <td>80</td>
                        <td>A</td>
                        <td>Good</td>
                    </tr>
                    
                    <tr>
                        <td>AI test</td>
                        <td>90</td>
                         <td>A</td>
                         <td>Good</td>
                    </tr>
                    
                    <tr>
                        <td>EPDA test </td>
                        <td>95</td>
                        <td>A</td>
                        <td>Good</td>
                    </tr>
                   
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>