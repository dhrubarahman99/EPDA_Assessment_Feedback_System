<%-- 
    Document   : module_create
    Created on : Dec 24, 2025, 8:02:58 PM
    Author     : Dhruba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Module</title>

    <link rel="stylesheet" href="../css/dashboard.css">
    <link rel="stylesheet" href="../css/form-panels.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="modules.jsp" class="btn btn-secondary back-btn">Back</a>
        <h1>CREATE MODULE</h1>

        <form action="../logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <!-- FORM PANEL -->
    <div class="panel">
        <h2 class="panel-title">Module Information</h2>

        <form>

            <div class="form-row">
                <label class="form-label">Module Code</label>
                <input type="text" class="form-input" placeholder="e.g., CT027-3-3">
            </div>

            <div class="form-row">
                <label class="form-label">Module Name</label>
                <input type="text" class="form-input" placeholder="e.g., Enterprise Programming">
            </div>

            <div class="form-row">
                <label class="form-label">Grade Scheme</label>
                <select class="form-select">
                    <option selected disabled>Select grade scheme</option>
                    <option>APU Standard</option>
                    <option>Simple A–F</option>
                    <option>Custom Scheme</option>
                </select>
            </div>

            <div class="form-row">
                <label class="form-label">Assign Lecturer</label>
                <select class="form-select">
                    <option selected disabled>Select lecturer</option>
                    <option>Ms. Aisha</option>
                    <option>Dr. Amir</option>
                    <option>Mr. Lim</option>
                </select>
            </div>

            <div class="btn-row">
                <button type="button" class="btn btn-primary">Create Module</button>
                <a href="modules.jsp" class="btn btn-secondary">Cancel</a>
            </div>

        </form>
    </div>

</div>

</body>
</html>

