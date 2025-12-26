<%-- 
    Document   : admin_user_links
    Created on : Dec 24, 2025, 2:54:27 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Assessment Management</title>
    <link rel="stylesheet" href="../css/functions.css">
</head>
<body>

<div class="page-container">

    <!-- HEADER -->
    <div class="top-bar">
        <h1>ASSESSMENT MANAGEMENT</h1>

        <form action="Logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
        
        <form action="dashboard.jsp" method="post">
            <button type="submit" class="home-btn">Home</button>
        </form>
        
    </div>

    <!-- LINKS -->
    <div class="links-grid">

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=assessments_create" class="link-card">
            <h2>Create Assessments</h2>
            <p>Add a new assessments</p>
        </a>

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=assessments_search" class="link-card">
            <h2>Search Assessments</h2>
            <p>Search assessments</p>
        </a>

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=assessments_update" class="link-card">
            <h2>Update Assessments</h2>
            <p>Update assessments</p>
        </a>

        <a href="../lecturer_get_assessment_module_enrollment_marks_list?function=assessments_delete" class="link-card danger">
            <h2>Delete Assessments</h2>
            <p>Remove assessments from system</p>
        </a>

    </div>
</div>

</body>
</html>