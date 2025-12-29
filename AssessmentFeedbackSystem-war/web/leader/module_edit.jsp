<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.Module"%>
<%@page import="entity.GradeScheme"%>
<%@page import="entity.Users"%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Module</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form-panels.css">
</head>
<body>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="<%= request.getContextPath() %>/LeaderModules" class="btn btn-secondary back-btn">Back</a>
        <h1>EDIT MODULE</h1>

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

        <%
            Module module = (Module) request.getAttribute("module");
        %>

        <form action="<%= request.getContextPath() %>/LeaderEditModule" method="post">

            <!-- MODULE ID -->
            <input type="hidden" name="id" value="<%= module.getId() %>">

            <!-- MODULE CODE -->
            <div class="form-row">
                <label class="form-label">Module Code</label>
                <input type="text"
                       class="form-input"
                       value="<%= module.getModuleCode() %>"
                       readonly>
            </div>

            <!-- MODULE NAME -->
            <div class="form-row">
                <label class="form-label">Module Name</label>
                <input type="text"
                       name="moduleName"
                       class="form-input"
                       value="<%= module.getModuleName() %>"
                       required>
            </div>

            <!-- GRADE SCHEME -->
            <div class="form-row">
                <label class="form-label">Grade Scheme</label>
                <select name="gradeSchemeId" class="form-select" required>

                    <%
                        List<GradeScheme> schemes =
                                (List<GradeScheme>) request.getAttribute("schemes");

                        for (GradeScheme gs : schemes) {
                    %>

                        <option value="<%= gs.getId() %>"
                        <%
                            if (module.getGradeScheme().getId().equals(gs.getId())) {
                        %>
                            selected
                        <%
                            }
                        %>>
                            <%= gs.getSchemeName() %>
                        </option>

                    <%
                        }
                    %>

                </select>
            </div>

            <!-- LECTURER -->
            <div class="form-row">
                <label class="form-label">Assigned Lecturer</label>
                <select name="lecturerId" class="form-select" required>

                    <%
                        List<Users> lecturers =
                                (List<Users>) request.getAttribute("lecturers");

                        for (Users u : lecturers) {
                    %>

                        <option value="<%= u.getId() %>"
                        <%
                            if (module.getLecturer().getId().equals(u.getId())) {
                        %>
                            selected
                        <%
                            }
                        %>>
                            <%= u.getName() %>
                        </option>

                    <%
                        }
                    %>

                </select>
            </div>

            <!-- BUTTONS -->
            <div class="btn-row">
                <button type="submit" class="btn btn-primary">
                    Update Module
                </button>

                <a href="<%= request.getContextPath() %>/LeaderModules" class="btn btn-secondary">
                    Cancel
                </a>
            </div>

        </form>
    </div>

</div>

</body>
</html>
