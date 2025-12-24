<%-- 
    Document   : admin_dash.jsp
    Created on : Dec 24, 2025, 1:57:44 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../css/dashboard.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <div></div>
        <h1>ADMIN DASHBOARD</h1>
        <form action="logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>

    <!-- DASHBOARD CARDS -->
    <div class="card-grid">

        <a href="users.jsp" class="card">
            <img src="../images/users.png" class="card-img">
            <h2>Users</h2>
            <p>Manage system users</p>
        </a>

        <a href="classes.jsp" class="card">
            <img src="../images/classes.png" class="card-img">
            <h2>Classes</h2>
            <p>View class groups</p>
        </a>

        <a href="gradescheme.jsp" class="card">
            <img src="../images/gradescheme.png" class="card-img">
            <h2>Grade Scheme</h2>
            <p>Configure grading</p>
        </a>

        <a href="reports.jsp" class="card">
            <img src="../images/reports.png" class="card-img">
            <h2>Reports</h2>
            <p>Generate reports</p>
        </a>

    </div>
</div>

</body>
</html>