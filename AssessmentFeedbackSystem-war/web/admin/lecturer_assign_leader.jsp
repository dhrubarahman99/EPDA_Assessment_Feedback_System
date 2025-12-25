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
    <title>Assign Lecturer to Leader</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
        
        <form action="${pageContext.request.contextPath}/admin/dashboard.jsp" method="post">
            <button type="submit"> Home</button>
        </form>
        
        <form action="logout" method="post">
            <button type="submit" >Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Assign Lecturer to Leader</h1>

        <form action="LecturerAssignLeader" method="post">
            


            <div class="input-group">
                <label>Lecturer</label>
                <select name="Lecturer" required>
                            <% 
                              
                    List<String> lecturerIds = (List<String>) request.getAttribute("lecturerIds");
                    if (lecturerIds != null) {
                        for (String lecturerId : lecturerIds) {
                %>
                            <option value="<%= lecturerId %>"><%= lecturerId %></option>
                <% 
                        }
                    }
                %>
                </select>
            </div>
                
                
            <div class="input-group">
                <label>Leader</label>
                <select name="Leader" required>
                            <% 
                              
                    List<String> leaderIds = (List<String>) request.getAttribute("leaderIds");
                    if (leaderIds != null) {
                        for (String leaderId : leaderIds) {
                %>
                            <option value="<%= leaderId %>"><%= leaderId %></option>
                <% 
                        }
                    }
                %>
                </select>
            </div>

            <button type="submit" class="create-btn">Assign</button>
        </form>
    </div>

</div>

</body>
</html>