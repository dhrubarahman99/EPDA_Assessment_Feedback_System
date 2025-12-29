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
    <title>Delete Assessment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
            <form action="${pageContext.request.contextPath}/lecturer/assessments.jsp" method="post">
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
        <h1>Delete Assessment</h1>

        <form action="DeleteAssessment" method="post">
            <div class="input-group">
                <label>Assessment ID</label>
                <select name="assessmentIds" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select Assessment ID--</option>
                    <% 
                        List<String> assessmentIds = (List<String>) request.getAttribute("assessmentIds");
                        if (assessmentIds != null) {
                            for (String assessmentId : assessmentIds) {
                    %>
                                <option value="<%= assessmentId %>"><%= assessmentId %></option>
                    <% 
                            }
                        }
                    %>
                </select>
            </div>
            

            <button type="submit" class="create-btn">Delete</button>
        </form>
    </div>

</div>

</body>
</html>