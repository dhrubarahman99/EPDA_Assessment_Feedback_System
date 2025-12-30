<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.Mark"%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Results</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form-panels.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table-pages.css">
</head>
<body>

<%
    List<Mark> marks = (List<Mark>) request.getAttribute("marks");

    if (marks == null) {
        response.sendRedirect(request.getContextPath() + "/StudentResults");
        return;
    }

    String error = (String) request.getAttribute("error");
%>

<div class="dashboard-container">

    <div class="top-bar">
        <a href="${pageContext.request.contextPath}/student/dashboard.jsp"
           class="btn btn-secondary back-btn">Back</a>

        <h1>RESULTS</h1>

        <!-- Logout -->
        <form action="<%= request.getContextPath() %>/Logout" method="post">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>

    <% if (error != null) { %>
        <p class="error-msg"><%= error %></p>
    <% } %>

    <div class="panel">
        <h2 class="panel-title">Your Results</h2>

        <div class="table-wrap">
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Module Code</th>
                        <th>Module Name</th>
                        <th>Assessment</th>
                        <th>Score</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    if (marks.isEmpty()) {
                %>
                    <tr>
                        <td colspan="4">No results available yet.</td>
                    </tr>
                <%
                    } else {
                        for (Mark m : marks) {
                            String moduleCode = "-";
                            String moduleName = "-";
                            String assessmentTitle = "-";

                            if (m.getAssessment() != null && m.getAssessment().getModule() != null) {
                                moduleCode = m.getAssessment().getModule().getModuleCode();
                                moduleName = m.getAssessment().getModule().getModuleName();
                            }

                            if (m.getAssessment() != null) {
                                assessmentTitle = m.getAssessment().getTitle();
                            }
                %>
                    <tr>
                        <td><%= moduleCode %></td>
                        <td><%= moduleName %></td>
                        <td><%= assessmentTitle %></td>
                        <td><%= m.getScore() %></td>
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
