<%-- 
    Document   : create_user.jsp
    Created on : Dec 24, 2025, 3:16:01 PM
    Author     : liewj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create GradeScheme</title>
    <link rel="stylesheet" href="../css/submenu.css">
</head>
<body>

<div class="container">

    <!-- HEADER BUTTONS -->
    <div class="header-buttons">
            <form action="gradescheme.jsp" method="post">
            <button type="submit">Back</button>
        </form>
        
        <form action="dashboard.jsp" method="post">
            <button type="submit"> Home</button>
        </form>
        
        <form action="../logout" method="post">
            <button type="submit" >Logout</button>
        </form>
    </div>

    <!-- CREATE USER FORM -->
    <div class="create-box">
        <h1>Create GradeScheme</h1>

        <form action="CreateGradeScheme" method="post">
            <div class="input-group">
                <label>Name</label>
                <input type="text" name="name" required>
            </div>

            <div class="input-group">
                <label>A MIN</label>
                <input type="number" name="aMin" required>
            </div>

            <div class="input-group">
                <label>B MIN</label>
                <input type="number" name="bMin" required>
            </div>

            <div class="input-group">
                <label>C MIN</label>
                <input type="number" name="cMin" required>
            </div>

            <div class="input-group">
                <label>D MIN</label>
                <input type="number" name="dMin" required>
            </div>

            

            <button type="submit" class="create-btn">Create</button>
        </form>
    </div>

</div>

</body>
</html>