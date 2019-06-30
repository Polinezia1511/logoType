<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Authentication Service</title>
    <link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div class="card">
    <article class="card-body Absolute-Center is-Responsive">
        <a href="" class="float-right btn btn-outline-primary">Sign up</a>
        <h4 class="card-title mb-4 mt-1">Sign in</h4>
        <form>
            <div class="form-group">
                <label>Your email</label>
                <input name="" class="form-control" placeholder="Email" type="email">
            </div> <!-- form-group// -->
            <div class="form-group">
                <a class="float-right" href="#">Forgot?</a>
                <label>Your password</label>
                <input class="form-control" placeholder="******" type="password">
            </div> <!-- form-group// -->
            <div class="form-group">
                <div class="checkbox">
                    <label> <input type="checkbox"> Save password </label>
                </div> <!-- checkbox .// -->
            </div> <!-- form-group// -->
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Login  </button>
            </div> <!-- form-group// -->
        </form>
    </article>
</div>
</body>
</html>