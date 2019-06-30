<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Sign in</title>
    <link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div>
    <article class="card-body Absolute-Center is-Responsive">
        <img id="logo-container" class="center-position" src="../img/logo.png"/>
        <h4 class="card-title mb-4 mt-1 center-position text-center-position">Sign in</h4>
        <form method="post">
            <div class="form-group">
                <label>Your email</label>
                <input name="email" class="form-control" placeholder="Email" type="email">
            </div> <!-- form-group// -->
            <div class="form-group">
                <label>Your password</label>
                <input name="password" class="form-control" placeholder="******" type="password">
            </div> <!-- form-group// -->
            <div class="form-group">
                <label> <input type="checkbox"> Remember me </label>
                <a class="float-right" href="#">Forgot your password?</a>
                <!-- checkbox .// -->
            </div> <!-- form-group// -->
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Login</button>
            </div> <!-- form-group// -->
        </form>
        <div class="text-center-position">
            Don't have account? <a href="./signUp">Sign up</a>
        </div>
        <c:if test="${errorMessage != null}">
            <div class="error text-center-position">
                ${errorMessage}
            </div>
        </c:if>
    </article>
</div>
</body>
</html>