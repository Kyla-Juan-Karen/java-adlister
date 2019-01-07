<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Admin"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp"/>

    <h1> Users </h1>
    <c:forEach items="${users}" var="user">
        <div class="card">
            <h5 class="card-text"> <c:out value="${user.getUsername()}"/> </h5>
        </div>
    </c:forEach>
</body>
</html>