<%-- 
    Document   : admin_user_links
    Created on : Dec 24, 2025, 2:54:27 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" href="../css/functions.css">
</head>
<body>

<div class="page-container">

    <!-- HEADER -->
    <div class="top-bar">
        <h1>USER MANAGEMENT</h1>

        <form action="Logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
        
        <form action="dashboard.jsp" method="post">
            <button type="submit" class="home-btn">Home</button>
        </form>
        
    </div>

    <!-- LINKS -->
    <div class="links-grid">

        <a href="users_create.jsp" class="link-card">
            <h2>Create User</h2>
            <p>Add a new user</p>
        </a>

        <a href="../get_user_list?function=users_search" class="link-card">
            <h2>Search User</h2>
            <p>Search for existing user</p>
        </a>

        <a href="../get_user_list?function=users_update" class="link-card">
            <h2>Update User</h2>
            <p>Update user details</p>
        </a>

        <a href="users_delete.jsp" class="link-card danger">
            <h2>Delete User</h2>
            <p>Remove user from system</p>
        </a>

    </div>
</div>

</body>
</html>