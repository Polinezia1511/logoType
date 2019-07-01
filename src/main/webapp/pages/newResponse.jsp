<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Sign in</title>
    <link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div class="card">
    <article class="card-body Absolute-Center is-Responsive">
        <form method="post">
            <c:forEach var="fieldWithOption" items="${fields}">
                <c:if test="${fieldWithOption.field.type eq 'SINGLE_LINE'}">
                    <div class="form-group">
                        <label>${fieldWithOption.field.label} ${fieldWithOption.field.required == true ? '*' : ''}</label>
                        <input name="${fieldWithOption.field.label}" class="form-control" placeholder="${fieldWithOption.field.label}" type="text">
                    </div>
                </c:if>
                <c:if test="${fieldWithOption.field.type eq 'MULTI_LINE'}">
                    <div class="form-group">
                        <label>${fieldWithOption.field.label} ${fieldWithOption.field.required == true ? '*' : ''}</label>
                        <textarea name="${fieldWithOption.field.label}" class="form-control" placeholder="${fieldWithOption.field.label}" type="text"></textarea>
                    </div>
                </c:if>
                <c:if test="${fieldWithOption.field.type eq 'COMBOBOX'}">
                    <div class="form-group">
                        <label>${fieldWithOption.field.label} ${fieldWithOption.field.required == true ? '*' : ''}</label>
                        <select name="${fieldWithOption.field.label}" class="form-control">
                            <c:forEach var="option" items="${fieldWithOption.options}">
                                <option name="${option}">${option}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:if>
                <c:if test="${fieldWithOption.field.type eq 'RADIO_BUTTON'}">
                    <div class="form-group">
                        <label>${fieldWithOption.field.label} ${fieldWithOption.field.required == true ? '*' : ''}</label><br>
                        <c:forEach var="option" items="${fieldWithOption.options}">
                            <input name="${option}" type="radio" >${option}<br>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${fieldWithOption.field.type eq 'CHECKBOX'}">
                    <div class="form-group">
                        <label>${fieldWithOption.field.label} ${fieldWithOption.field.required == true ? '*' : ''}</label><br>
                        <c:forEach var="option" items="${fieldWithOption.options}">
                            <input name="${option}" type="checkbox" >${option}<br>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${fieldWithOption.field.type eq 'DATE'}">
                    <div class="form-group">
                        <label>${fieldWithOption.field.label} ${fieldWithOption.field.required == true ? '*' : ''}</label>
                        <input name="${fieldWithOption.field.label}" class="form-control" placeholder="${fieldWithOption.field.label}" type="date"></input>
                    </div>
                </c:if>
            </c:forEach>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Send</button>
            </div>
        </form>
        <c:if test="${errorMessage != null}">
            <div class="error text-center-position">
                    ${errorMessage}
            </div>
        </c:if>
    </article>
</div>
</body>
</html>
