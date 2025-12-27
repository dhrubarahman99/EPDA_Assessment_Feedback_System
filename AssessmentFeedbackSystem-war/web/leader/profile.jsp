<%-- 
    Document   : profile
    Created on : Dec 24, 2025, 7:10:38 PM
    Author     : Dhruba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Leader Profile</title>

    <!-- Existing dashboard styling -->
    <link rel="stylesheet" href="../css/dashboard.css">

    <!-- Reusable panels & forms styling -->
    <link rel="stylesheet" href="../css/form-panels.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="dashboard.jsp" class="btn btn-secondary back-btn">Back</a>
        <h1>PROFILE</h1>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>


    <div class="panel-grid">

        <!-- VIEW PROFILE PANEL -->
        <div class="panel">
            <h2 class="panel-title">Your Details</h2>

            <div class="info-row">
                <span class="info-label">Name</span>
                <div class="info-value">John Leader</div>
            </div>

            <div class="info-row">
                <span class="info-label">Email</span>
                <div class="info-value">john.leader@university.edu</div>
            </div>

            <div class="info-row">
                <span class="info-label">Role</span>
                <div class="info-value">LEADER</div>
            </div>

            <div class="info-row">
                <span class="info-label">User ID</span>
                <div class="info-value">1001</div>
            </div>

        </div>

        <!-- EDIT PROFILE PANEL -->
        <div class="panel">
            <h2 class="panel-title">Edit Profile</h2>

            <form>
                <div class="form-row">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-input" placeholder="Enter full name">
                </div>

                <div class="form-row">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-input" placeholder="Enter email address">
                </div>

                <div class="form-row">
                    <label class="form-label">New Password</label>
                    <input type="password" class="form-input"
                           placeholder="Leave blank to keep current password">
                </div>

                <div class="btn-row">
                    <button type="button" class="btn btn-primary">
                        Save Changes
                    </button>
                    <button type="button" class="btn btn-secondary">
                        Cancel
                    </button>
                </div>
            </form>

        </div>

    </div>
</div>

</body>
</html>

