<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <div class="container">
        <h1>Create a new Ad</h1>
       <c:choose>
           <c:when test="${failedAd}">
               <h2 style="color:red"> Please Fill In All Forms</h2>
           </c:when>
       </c:choose>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value="${sticky1}"/>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text">${sticky2}</textarea>
            </div>
            <select class="form-group" name="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.getCategoryId()}"> ${category.getCategory()} </option>
                </c:forEach>
            </select>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
