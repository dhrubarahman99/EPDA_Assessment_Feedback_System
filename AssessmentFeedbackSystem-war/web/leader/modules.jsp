<%-- 
    Document   : modules
    Created on : Dec 23, 2025, 2:53:23 PM
    Author     : Dhruba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modules</title>
    <link rel="stylesheet" href="../css/dashboard.css">
    <link rel="stylesheet" href="../css/form-panels.css">
    <link rel="stylesheet" href="../css/table-pages.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="dashboard.jsp" class="btn btn-secondary back-btn">Back</a>
        <h1>MODULES</h1>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <!-- TOOLBAR (Search + Sort + Filter) -->
    <div class="panel">
        <h2 class="panel-title">Module Management</h2>

        <form>
            <div class="toolbar">

                <div class="tool">
                    <label class="form-label">Search</label>
                    <input class="form-input" type="text" placeholder="Module code or name">
                </div>

                <div class="tool">
                    <label class="form-label">Sort</label>
                    <select class="form-select">
                        <option>Module Code (A–Z)</option>
                        <option>Module Name (A–Z)</option>
                        <option>Lecturer (A–Z)</option>
                    </select>
                </div>

                <div class="tool">
                    <label class="form-label">Lecturer</label>
                    <select class="form-select">
                        <option>All</option>
                        <option>Dr. Amir</option>
                        <option>Ms. Aisha</option>
                        <option>Mr. Lim</option>
                    </select>
                </div>

                <div class="tool">
                    <label class="form-label">Grade Scheme</label>
                    <select class="form-select">
                        <option>All</option>
                        <option>APU Standard</option>
                        <option>Simple A–F</option>
                    </select>
                </div>

            </div>

            <div class="action-row">
                <a href="module_create.jsp" class="btn btn-primary">Create Module</a>
                <button type="button" class="btn btn-secondary">Reset</button>
            </div>
        </form>
    </div>

    <!-- TABLE -->
    <div class="panel">
        <h2 class="panel-title">Modules List</h2>

        <div class="table-wrap">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Module Code</th>
                        <th>Module Name</th>
                        <th>Lecturer</th>
                        <th>Grade Scheme</th>
                        <th style="width: 180px;">Actions</th>
                    </tr>
                </thead>

                <tbody>
                    <!-- Placeholder rows (easy to replace with loop later) -->
                    <tr>
                        <td>CT027-3-3</td>
                        <td>Enterprise Programming</td>
                        <td>Ms. Aisha</td>
                        <td>APU Standard</td>
                        <td>
                            <a href="module_edit.jsp?id=1" class="btn btn-secondary btn-sm">Edit</a>
                            <button type="button" class="btn btn-danger btn-sm">Delete</button>
                        </td>
                    </tr>

                    <tr>
                        <td>AI101</td>
                        <td>Introduction to AI</td>
                        <td>Dr. Amir</td>
                        <td>Simple A–F</td>
                        <td>
                            <a href="module_edit.jsp?id=2" class="btn btn-secondary btn-sm">Edit</a>
                            <button type="button" class="btn btn-danger btn-sm">Delete</button>
                        </td>
                    </tr>

                    <tr>
                        <td>DS201</td>
                        <td>Data Structures</td>
                        <td>Mr. Lim</td>
                        <td>APU Standard</td>
                        <td>
                            <a href="module_edit.jsp?id=3" class="btn btn-secondary btn-sm">Edit</a>
                            <button type="button" class="btn btn-danger btn-sm">Delete</button>
                        </td>
                    </tr>

                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>

