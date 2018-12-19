<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="container">
        <h1>Welcome to the Adlister!</h1>
        <%--<form action="search" method="get">--%>
            <%--<input type="text" placeholder="Search..." >--%>
        <%--</form>--%>
        <form action="/search" method="post">
            <input type="text" name="search" placeholder="Search...">
            <button type="submit">search</button>
        </form>
    </div>
</body>
</html>
