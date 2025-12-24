<%-- 
    Document   : dashboard
    Created on : Dec 23, 2025, 2:53:17 PM
    Author     : Dhruba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Leader Dashboard</title>
    <link rel="stylesheet" href="../css/dashboard.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <div></div>
        <h1>LEADER DASHBOARD</h1>
        <form action="logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>

    <!-- DASHBOARD CARDS -->
    <div class="card-grid">

        <a href="profile.jsp" class="card">
            <img src="../images/users.png" class="card-img">
            <h2>Profile</h2>
            <p>Edit your personal profile</p>
        </a>

        <a href="modules.jsp" class="card">
            <!-- Use an existing icon to avoid broken image -->
            <img src="../images/classes.png" class="card-img">
            <h2>Modules</h2>
            <p>Create, update, and assign lecturers</p>
        </a>

        <a href="reports.jsp" class="card">
            <img src="../images/reports.png" class="card-img">
            <h2>Reports</h2>
            <p>View reports and summary</p>
        </a>

    </div>
</div>

</body>
</html>

