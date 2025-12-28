

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.GradeScheme"%>
<%@page import="entity.Users"%>

<!DOCTYPE html>
<html>
<head>
    <title>Create Module</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form-panels.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="<%= request.getContextPath() %>/LeaderModules" class="btn btn-secondary back-btn">Back</a>
        <h1>CREATE MODULE</h1>

        <form action="<%= request.getContextPath() %>/Logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <!-- FORM PANEL -->
    <div class="panel">
        <h2 class="panel-title">Module Information</h2>

        <!-- ERROR MESSAGE -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div class="error-msg"><%= error %></div>
        <%
            }
        %>
        
        <!-- SUCCESS MESSAGE -->
        <%
            String success = (String) request.getAttribute("success");
            if (success != null) {
        %>
            <div class="success-msg"><%= success %></div>
        <%
            }
        %>


        <form action="<%= request.getContextPath() %>/LeaderCreateModule" method="post">

            <!-- MODULE CODE -->
            <div class="form-row">
                <label class="form-label">Module Code</label>
                <input type="text"
                       name="moduleCode"
                       class="form-input"
                       required
                       placeholder="e.g., CT027-3-3">
            </div>

            <!-- MODULE NAME -->
            <div class="form-row">
                <label class="form-label">Module Name</label>
                <input type="text"
                       name="moduleName"
                       class="form-input"
                       required
                       placeholder="e.g., Enterprise Programming">
            </div>

            <!-- GRADE SCHEME -->
            <div class="form-row">
                <label class="form-label">Grade Scheme</label>
                <select name="gradeSchemeId" class="form-select" required>
                    <option value="">Select grade scheme</option>

                    <%
                        List<GradeScheme> gradeSchemes =
                                (List<GradeScheme>) request.getAttribute("gradeSchemes");

                        if (gradeSchemes != null) {
                            for (GradeScheme gs : gradeSchemes) {
                    %>
                        <option value="<%= gs.getId() %>">
                            <%= gs.getSchemeName() %>
                        </option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>

            <!-- LECTURER -->
            <div class="form-row">
                <label class="form-label">Assign Lecturer</label>
                <select name="lecturerId" class="form-select" required>
                    <option value="">Select lecturer</option>

                    <%
                        List<Users> lecturers =
                                (List<Users>) request.getAttribute("lecturers");

                        if (lecturers != null) {
                            for (Users u : lecturers) {
                    %>
                        <option value="<%= u.getId() %>">
                            <%= u.getName() %>
                        </option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>

            <!-- BUTTONS -->
            <div class="btn-row">
                <button type="submit" class="btn btn-primary">
                    Create Module
                </button>

                <a href="modules.jsp" class="btn btn-secondary">
                    Cancel
                </a>
            </div>

        </form>
    </div>

</div>

</body>
</html>

