<%--
  Created by IntelliJ IDEA.
  User: macuser
  Date: 12/20/18
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Ad"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Edit the Ad</h1>
    <c:choose>
        <c:when test="${failedAd}">
            <h2 style="color:red"> Please Fill In All Forms</h2>
        </c:when>
    </c:choose>
    <form action="/edit" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="new_title" class="form-control" type="text"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="new_description" class="form-control" type="text"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
