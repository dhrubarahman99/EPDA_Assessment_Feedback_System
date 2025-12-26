<%-- 
    Document   : admin_user_links
    Created on : Dec 24, 2025, 2:54:27 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Marks Management</title>
    <link rel="stylesheet" href="../css/functions.css">
</head>
<body>

<div class="page-container">

    <!-- HEADER -->
    <div class="top-bar">
        <h1>MARKS MANAGEMENT</h1>

        <form action="Logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
        
        <form action="dashboard.jsp" method="post">
            <button type="submit" class="home-btn">Home</button>
        </form>
        
    </div>

    <!-- LINKS -->
    <div class="links-grid">

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=marks_create" class="link-card">
            <h2>Mark Students</h2>
            <p>Mark Students Assessments</p>
        </a>

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=marks_search" class="link-card">
            <h2>Search Marks</h2>
            <p>Search marks</p>
        </a>

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=marks_update" class="link-card">
            <h2>Update Marks</h2>
            <p>Update marks</p>
        </a>

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=marks_delete" class="link-card danger">
            <h2>Delete Marks</h2>
            <p>Remove marks from system</p>
        </a>

    </div>
</div>

</body>
</html>