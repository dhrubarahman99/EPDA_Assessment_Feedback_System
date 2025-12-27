<%-- 
    Document   : create_user.jsp
    Created on : Dec 24, 2025, 3:16:01 PM
    Author     : liewj
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Classes</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
            <form action="${pageContext.request.contextPath}/admin/classes.jsp" method="post">
            <button type="submit">Back</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/admin/dashboard.jsp" method="post">
            <button type="submit"> Home</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit" >Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Create Class</h1>

        <form action="${pageContext.request.contextPath}/admin_CreateClasses" method="get">
            <div class="input-group">
                <label>Class Name</label>
                <input type="text" name="name" required>
            </div>


            <div class="input-group">
                <label>Module</label>
                <select name="Module" required>
                            <% 
                              
                    List<Long> moduleIds = (List<Long>) request.getAttribute("moduleIds");
                    if (moduleIds != null) {
                        for (Long moduleId : moduleIds) {
                %>
                            <option value="<%= moduleId %>"><%= moduleId %></option>
                <% 
                        }
                    }
                %>
                </select>
            </div>
             <%
            String success = (String) request.getAttribute("success");
            if (success != null) {
        %>
            <p class="success-msg"><%= success %></p>
        <%
            }
        %>
            <button type="submit" class="create-btn">Create</button>
        </form>
    </div>

</div>

</body>
</html>