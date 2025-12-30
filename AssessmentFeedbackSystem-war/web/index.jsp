<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Assessment Feedback System</title>

    <!-- Base styles (font, button, body centering) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

    <!-- Landing page specific styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>

<body>

    <div class="landing-container">

        <!-- LOGO -->
        <div class="logo-circle">
            <img src="<%= request.getContextPath() %>/images/logo.png"
                 alt="AFS Logo"
                 class="logo-img">
        </div>

        <!-- SYSTEM NAME -->
        <div class="system-title">
            ASSESSMENT FEEDBACK SYSTEM
        </div>

        <!-- LOGIN BUTTON -->
        <form action="login.jsp" method="get">
            <button type="submit" class="btn login-btn">
                Login
            </button>
        </form>

    </div>

</body>
</html>