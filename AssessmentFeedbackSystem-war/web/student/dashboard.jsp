<%-- 
    Document   : admin_dash.jsp
    Created on : Dec 24, 2025, 1:57:44 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <div></div>
        <h1>STUDENT DASHBOARD</h1>
        <form action="Logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>

    <!-- DASHBOARD CARDS -->
    <div class="card-grid">

        <a href="profile.jsp" class="card">
            <img src="../images/assessment.png" class="card-img">
            <h2>Profile</h2>
            <p>View and edit information</p>
        </a>

        <a href="${pageContext.request.contextPath}/StudentResults" class="card">
            <img src="../images/results.png" class="card-img">
            <h2>Results</h2>
            <p>See my results</p>
        </a>
        

    </div>
</div>

</body>
</html>