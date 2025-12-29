<%-- 
    Document   : admin_user_links
    Created on : Dec 24, 2025, 2:54:27 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>GradeScheme Management</title>
    <link rel="stylesheet" href="../css/functions.css">
</head>
<body>

<div class="page-container">

    <!-- HEADER -->
    <div class="top-bar">
        <h1>GRADESCHEME MANAGEMENT</h1>

        <form action="../logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
        
        <form action="dashboard.jsp" method="post">
            <button type="submit" class="home-btn">Home</button>
        </form>
        
    </div>

    <!-- LINKS -->
    <div class="links-grid">

        <a href="gradescheme_create.jsp" class="link-card">
            <h2>Create GradeScheme</h2>
            <p>Add a new gradescheme</p>
        </a>

        <a href="../admin_get_gradescheme_list?function=gradescheme_search" class="link-card">
            <h2>Search GradeScheme</h2>
            <p>Search for existing gradescheme</p>
        </a>

        <a href="../admin_get_gradescheme_list?function=gradescheme_update" class="link-card">
            <h2>Update GradeScheme</h2>
            <p>Update gradescheme details</p>
        </a>

        <a href="../admin_get_gradescheme_list?function=gradescheme_delete" class="link-card danger">
            <h2>Delete GradeScheme</h2>
            <p>Remove gradescheme from system</p>
        </a>

    </div>
</div>

</body>
</html>