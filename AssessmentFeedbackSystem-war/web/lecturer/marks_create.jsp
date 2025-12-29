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
    <title>Create Marks</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
            <form action="${pageContext.request.contextPath}/lecturer/marks.jsp" method="post">
            <button type="submit">Back</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/lecturer/dashboard.jsp" method="post">
            <button type="submit"> Home</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit" >Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Mark Students</h1>

        <form action="lecturer_CreateMarks" method="get">
            <div class="input-group">
                <label>Score</label>
                <input type="number" name="score" max =100 min=0 required>
            </div>

            <div class="input-group">
                <label>Feedback</label>
                <input type="text" name="feedback" required>
            </div>

            <div class="input-group">
                <label>Enrollment ID</label>
                <select name="enrollementIds" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select Enrollement ID--</option>
                    <% 
                        List<Long> enrollmentIds = (List<Long>) request.getAttribute("enrollmentIds");
                        if (enrollmentIds != null) {
                            for (Long enrollmentId : enrollmentIds) {
                    %>
                                <option value="<%= enrollmentId %>"><%= enrollmentId %></option>
                    <% 
                            }
                        }
                    %>
                </select>
            </div>
                
            <div class="input-group">
                <label>Assessment ID</label>
                <select name="assessmentIds" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select Assessment ID--</option>
                    <% 
                        List<Long> assessmentIds = (List<Long>) request.getAttribute("assessmentIds");
                        if (assessmentIds != null) {
                            for (Long assessmentId : assessmentIds) {
                    %>
                                <option value="<%= assessmentId %>"><%= assessmentId %></option>
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