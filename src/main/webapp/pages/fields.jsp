<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fields</title>
    <link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
          rel="stylesheet">
    <script type="text/javascript" src="webjars/jquery/1.9.1/jquery.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link href="../css/main.css" rel="stylesheet">
    <script type="text/javascript" src="../js/main.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="content-area">
        <img class="logo-in-header" src="../img/logo.png"/>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

        </div>
        <div class="form-inline my-2 my-lg-0 inline-element">
            <ul class="navbar-nav mr-auto navbar-right">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Fields <span class="sr-only">Current</span></a>
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
<div class="content-area card">
    <div class="card-body">
        <h2 class="card-title inline-element">Fields</h2>
        <button id="add-field" type="button" class="btn btn-primary btn-block card-title button-add-field" data-toggle="modal"
                data-target="#myModal"><p class="big-letter"><b>+</b></p>ADD FIELD
        </button>
        <table class="table">
            <thead>
            <tr>
                <th>Label</th>
                <th>Type</th>
                <th>Required</th>
                <th>Is active</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="field" items="${fields}">
                <td>${field.label}</td>
                <td>${field.type}</td>
                <td>${field.required == true ? "true" : "false"}</td>
                <td>${field.isActive == true ? "true" : "false"}</td>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Add field</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <form method="post">
                <div class="modal-body">
                    <div class="form-group"><label class="inline-element">Label:</label>
                        <input name="label" type="text" class="form-control inline-element element-in-pop-up"><br><br>
                    </div>
                    <div class="form-group">
                        <label class="inline-element">Type:</label>
                        <select name="type" id="selectType" class="form-control inline-element element-in-pop-up"><br><br>
                            <c:forEach var="fieldType" items="${fieldTypes}">
                                <option name="${fieldType}">${fieldType}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <div id="optionsField" class="form-group"><label class="inline-element">Options:</label>
                        <textarea name="options" type="text" class="form-control inline-element element-in-pop-up"></textarea><br><br>
                    </div>
                    <div  class="form-check">
                        <label class="form-check-label">
                            <input name="required" class="form-check-input" type="checkbox"> Required
                        </label><br>
                        <label class="form-check-label">
                            <input name="isActive" class="form-check-input" type="checkbox"> Is active
                        </label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Add</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>