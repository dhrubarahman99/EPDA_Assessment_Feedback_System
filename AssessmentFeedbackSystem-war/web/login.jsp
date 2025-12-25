<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="container">

    <!-- LEFT PANEL -->
    <div class="login-box">
        <h1>WELCOME</h1>

        <form action="Login" method="post">

            <div class="input-group">
                <label>Email</label>
                <input type="email" name="email" required>
            </div>

            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>
            
            <%
                String err = request.getParameter("error");
                if ("invalid".equals(err)) {
            %>
                <p class="error-msg">Invalid email or password.</p>
            <%
                }
            %>

            <button type="submit" class="btn">Login</button>
        </form>
    </div>

    <!-- RIGHT PANEL -->
    <div class="image-box">
        <img src="images/login-illustration.png" alt="Login Illustration">
    </div>

</div>

</body>
</html>

