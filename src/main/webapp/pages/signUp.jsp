<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Sign up</title>
    <link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div>
    <article class="card-body Absolute-Center is-Responsive">
        <img id="logo-container" class="center-position" src="../img/logo.png"/>
        <h4 class="card-title mb-4 mt-1 center-position text-center-position">Sign up</h4>
        <form method="post">
            <input name="email" class="form-control form-group" placeholder="Email*" type="email" value="${email}">
            <input name="password" class="form-control form-group" placeholder="Password*" type="password">
            <input name="confirmPassword" class="form-control form-group" placeholder="Confirm password*"
                   type="password">
            <input name="firstName" class="form-control form-group" placeholder="First name" type="text" value="${firstName}">
            <input name="secondName" class="form-control form-group" placeholder="Second name" type="text" value="${secondName}">
            <input name="phoneNumber" class="form-control form-group" placeholder="Phone number" type="text" value="${phoneNumber}">
            <button type="submit" class="btn btn-primary btn-block"> Sign up</button>
        </form>
        <div class="text-center-position">
            Already have account? <a href="./login">Log in</a>
        </div>
        <c:if test="${errorMessage != null}">
            <div class="error text-center-position">Error: ${errorMessage}</div>
        </c:if>
    </article>
</div>
</body>
</html>