<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Admin"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>

    <div class="container">
    <h1> Users </h1>
    <c:forEach items="${users}" var="user">
        <div class="card">
            <h5 class="card-text"> <c:out value="${user.getUsername()}"/> </h5>
        </div>
    </c:forEach>
    </div>
</body>
</html>