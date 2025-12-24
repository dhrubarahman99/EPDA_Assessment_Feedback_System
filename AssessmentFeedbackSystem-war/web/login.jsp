<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <form action="logout" method="post">
            <div class="input-group">
                <label>Username</label>
                <input type="text" name="username" required>
            </div>

            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

           
            <button type="submit" class="btn">SUBMIT</button>
        </form>
    </div>

    <!-- RIGHT PANEL -->
    <div class="image-box">
        <img src="images/login-illustration.png" alt="Login Illustration">
    </div>
</div>

</body>
</html>
