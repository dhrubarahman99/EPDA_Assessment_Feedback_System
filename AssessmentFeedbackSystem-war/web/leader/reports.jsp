<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.Module"%>

<!DOCTYPE html>
<html>
<head>
    <title>Leader Reports</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form-panels.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table-pages.css">
</head>
<body>

<%
    List<Module> modules = (List<Module>) request.getAttribute("modules");
    List<Long> studentCounts = (List<Long>) request.getAttribute("studentCounts");

    // prevent direct access
    if (modules == null || studentCounts == null) {
        response.sendRedirect(request.getContextPath() + "/LeaderReports");
        return;
    }

    String error = (String) request.getAttribute("error");
%>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="<%= request.getContextPath() %>/leader/dashboard.jsp" class="btn btn-secondary back-btn">Back</a>
        <h1>LEADER REPORTS</h1>

        <form action="<%= request.getContextPath() %>/Logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <!-- ERROR MESSAGE -->
    <%
        if (error != null) {
    %>
        <p class="error-msg"><%= error %></p>
    <%
        }
    %>

    <!-- TABLE PANEL -->
    <div class="panel">
        <div class="panel-header-row">
            <h2 class="panel-title">Module Summary</h2>

            <a class="btn btn-primary"
               href="<%= request.getContextPath() %>/LeaderReportsExportCSV">
                Export CSV
            </a>
        </div>

        <div class="table-wrap">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Module Code</th>
                        <th>Module Name</th>
                        <th>Lecturer</th>
                        <th>Grade Scheme</th>
                        <th>No. of Students</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        if (modules.isEmpty()) {
                    %>
                        <tr>
                            <td colspan="5">No modules found.</td>
                        </tr>
                    <%
                        } else {
                            for (int i = 0; i < modules.size(); i++) {
                                Module m = modules.get(i);
                                Long count = studentCounts.get(i);

                                String lecturerName = "-";
                                if (m.getLecturer() != null) {
                                    lecturerName = m.getLecturer().getName();
                                }

                                String schemeName = "-";
                                if (m.getGradeScheme() != null) {
                                    schemeName = m.getGradeScheme().getSchemeName();
                                }
                    %>
                        <tr>
                            <td><%= m.getModuleCode() %></td>
                            <td><%= m.getModuleName() %></td>
                            <td><%= lecturerName %></td>
                            <td><%= schemeName %></td>
                            <td><%= count %></td>
                        </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>

    </div>

</div>

</body>
</html>
