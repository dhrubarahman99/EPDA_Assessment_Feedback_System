<%-- 
    Document   : admin_dash.jsp
    Created on : Dec 24, 2025, 1:57:44 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lecturer Dashboard</title>
    <link rel="stylesheet" href="../css/dashboard.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <div></div>
        <h1>LECTURER DASHBOARD</h1>
        <form action="logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>

    <!-- DASHBOARD CARDS -->
    <div class="card-grid">

        <a href="assessments.jsp" class="card">
            <img src="../images/assessment.png" class="card-img">
            <h2>Assessments</h2>
            <p>Manage Assessments</p>
        </a>

        <a href="marks.jsp" class="card">
            <img src="../images/marks.png" class="card-img">
            <h2>Marks</h2>
            <p>Marks Assessments</p>
        </a>

        <a href="reports.jsp" class="card">
            <img src="../images/reports.png" class="card-img">
            <h2>Report</h2>
            <p>View Report</p>
        </a>

        <a href="profile.jsp" class="card">
            <img src="../images/profile.png" class="card-img">
            <h2>Profile</h2>
            <p>Edit Profile </p>
        </a>

    </div>
</div>

</body>
</html>