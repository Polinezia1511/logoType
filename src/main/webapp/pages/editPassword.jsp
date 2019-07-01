<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change password</title>
    <link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
          rel="stylesheet">

    <script type="text/javascript" src="webjars/jquery/1.9.1/jquery.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="content-area">
        <a href="./fields"><img class="logo-in-header" src="../img/logo.png"/></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

        </div>
        <div class="form-inline my-2 my-lg-0 inline-element">
            <ul class="navbar-nav mr-auto navbar-right">
                <li class="nav-item active">
                    <a class="nav-link" href="./fields">Fields <span class="sr-only">Current</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Responses</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${firstAndSecondName}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="./editProfile">Edit profile</a>
                        <a class="dropdown-item" href="./editPassword">Change password</a>
                        <a class="dropdown-item" href="./logOut">Log out</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<article class="card-body Absolute-Center is-Responsive">
    <div class="card">
        <form method="post" class="card-body">
            <h5 class="card-title">Change password</h5>
            <input name="oldPassword" class="form-control form-group" placeholder="Old password*" type="password">
            <input name="password" class="form-control form-group" placeholder="Password*" type="password">
            <input name="confirmPassword" class="form-control form-group" placeholder="Confirm password*"
                   type="password">
            <button type="submit" class="btn btn-primary btn-block"> Edit password</button>
        </form>
        <c:if test="${errorMessage != null}">
            <div class="error text-center-position">Error: ${errorMessage}</div>
        </c:if>
        <c:if test="${successMessage != null}">
            <div class="success text-center-position">${successMessage}</div>
        </c:if>
    </div>
</article>
</body>
</html>