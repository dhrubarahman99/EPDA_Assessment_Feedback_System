<%-- 
    Document   : module_edit
    Created on : Dec 24, 2025, 8:04:02 PM
    Author     : Dhruba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Module</title>

    <link rel="stylesheet" href="../css/dashboard.css">
    <link rel="stylesheet" href="../css/form-panels.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="modules.jsp" class="btn btn-secondary back-btn">Back</a>
        <h1>EDIT MODULE</h1>

        <form action="../logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <!-- FORM PANEL -->
    <div class="panel">
        <h2 class="panel-title">Module Information</h2>

        <form>

            <!-- Module Code -->
            <div class="form-row">
                <label class="form-label">Module Code</label>
                <input
                    type="text"
                    class="form-input"
                    value="CT027-3-3"
                    readonly>
            </div>

            <!-- Module Name -->
            <div class="form-row">
                <label class="form-label">Module Name</label>
                <input
                    type="text"
                    class="form-input"
                    value="Enterprise Programming">
            </div>

            <!-- Grade Scheme -->
            <div class="form-row">
                <label class="form-label">Grade Scheme</label>
                <select class="form-select">
                    <option>APU Standard</option>
                    <option>Simple A–F</option>
                    <option>Custom Scheme</option>
                </select>
            </div>

            <!-- Lecturer -->
            <div class="form-row">
                <label class="form-label">Assigned Lecturer</label>
                <select class="form-select">
                    <option>Ms. Aisha</option>
                    <option>Dr. Amir</option>
                    <option>Mr. Lim</option>
                </select>
            </div>

            <!-- ACTION BUTTONS -->
            <div class="btn-row">
                <button type="button" class="btn btn-primary">Update Module</button>
                <button type="button" class="btn btn-danger">Delete Module</button>
                <a href="modules.jsp" class="btn btn-secondary">Cancel</a>
            </div>

        </form>
    </div>

</div>

</body>
</html>

