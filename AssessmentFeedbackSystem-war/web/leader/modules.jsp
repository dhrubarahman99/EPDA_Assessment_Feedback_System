<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.Module"%>

<!DOCTYPE html>
<html>
<head>
    <title>Modules</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form-panels.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table-pages.css">
</head>
<body>

<%
    // Data from servlet
    List<Module> modules = (List<Module>) request.getAttribute("modules");

    // Prevent direct JSP access
    if (modules == null) {
        response.sendRedirect(request.getContextPath() + "/LeaderModules");
        return;
    }

    // Messages
    String error = (String) request.getAttribute("error");

    // Preserve search + sort values
    String q = (String) request.getAttribute("q");
    String sort = (String) request.getAttribute("sort");

    if (q == null) {
        q = "";
    }

    if (sort == null) {
        sort = "asc";
    }
%>

<div class="dashboard-container">

    <!-- TOP BAR -->
    <div class="top-bar">
        <a href="${pageContext.request.contextPath}/leader/dashboard.jsp" class="btn btn-secondary back-btn">Back</a>
        <h1>MODULES</h1>
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

    <!-- TOOLBAR (Search + Sort) -->
    <div class="panel">
        <h2 class="panel-title">Module Management</h2>

        <form action="<%= request.getContextPath() %>/LeaderModules" method="get">

            <div class="toolbar">

                <div class="tool">
                    <label class="form-label">Search (Module Name)</label>
                    <input class="form-input"
                           type="text"
                           name="q"
                           value="<%= q %>"
                           placeholder="Enter module name">
                </div>

                <div class="tool">
                    <label class="form-label">Sort</label>
                    <select class="form-select" name="sort">
                        <option value="asc" <% if (sort.equals("asc")) { %>selected<% } %>>
                            Module Name (Ascending)
                        </option>
                        <option value="desc" <% if (sort.equals("desc")) { %>selected<% } %>>
                            Module Name (Descending)
                        </option>
                    </select>
                </div>

            </div>

            <div class="action-row">
                <a href="<%= request.getContextPath() %>/LeaderCreateModule" class="btn btn-primary">Create Module</a>
                <a href="<%= request.getContextPath() %>/LeaderModules" class="btn btn-secondary">Reset</a>
                <button type="submit" class="btn btn-primary">Apply</button>
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
                    <%
                        if (modules.isEmpty()) {
                    %>
                        <tr>
                            <td colspan="5">No modules found.</td>
                        </tr>
                    <%
                        } else {
                            for (Module m : modules) {
                    %>
                        <tr>
                            <td><%= m.getModuleCode() %></td>
                            <td><%= m.getModuleName() %></td>

                            <td>
                                <%
                                    if (m.getLecturer() != null) {
                                        out.print(m.getLecturer().getName());
                                    } else {
                                        out.print("-");
                                    }
                                %>
                            </td>

                            <td>
                                <%
                                    if (m.getGradeScheme() != null) {
                                        out.print(m.getGradeScheme().getSchemeName());
                                    } else {
                                        out.print("-");
                                    }
                                %>
                            </td>

                            <td>
                                <a href="<%= request.getContextPath() %>/LeaderEditModule?id=<%= m.getId() %>"
                                    class="btn btn-secondary btn-sm">
                                     Edit
                                 </a>
                                <form action="<%= request.getContextPath() %>/LeaderDeleteModule" method="post" style="display:inline;">
                                    <input type="hidden" name="id" value="<%= m.getId() %>">
                                    <button type="submit" class="btn btn-danger btn-sm"
                                            onclick="return confirm('Delete this module?');">
                                        Delete
                                    </button>
                                </form>
                            </td>
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
