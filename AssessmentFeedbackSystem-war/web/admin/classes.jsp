<%-- 
    Document   : admin_user_links
    Created on : Dec 24, 2025, 2:54:27 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Class Management</title>
    <link rel="stylesheet" href="../css/functions.css">
</head>
<body>

<div class="page-container">

    <!-- HEADER -->
    <div class="top-bar">
        <h1>CLASS MANAGEMENT</h1>

        <form action="Logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
        
        <form action="dashboard.jsp" method="post">
            <button type="submit" class="home-btn">Home</button>
        </form>
        
    </div>

    <!-- LINKS -->
    <div class="links-grid">

        <a href="../get_module_list" class="link-card">
            <h2>Create Classes</h2>
            <p>Add a new class</p>
        </a>

        <a href="classes_search.jsp" class="link-card">
            <h2>Search User</h2>
            <p>Search for existing class</p>
        </a>

        <a href="classes_update.jsp" class="link-card">
            <h2>Update Classes</h2>
            <p>Update class changes</p>
        </a>

        <a href="classes_delete.jsp" class="link-card danger">
            <h2>Delete Classes</h2>
            <p>Remove class from system</p>
        </a>

    </div>
</div>

</body>
</html>