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
    <title>Delete Marks</title>
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
        
        <form action="logout" method="post">
            <button type="submit" >Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Delete Marks</h1>

        <form action="DeleteMarks" method="post">
            <div class="input-group">
                <label>Marks ID</label>
                <select name="marksIds" id="userSelect" required onchange="loadUserDetails(this.value)">
                    <option value="">--Select Marks ID--</option>
                    <% 
                        List<String> marksIds = (List<String>) request.getAttribute("marksIds");
                        if (marksIds != null) {
                            for (String marksId : marksIds) {
                    %>
                                <option value="<%= marksId %>"><%= marksId %></option>
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