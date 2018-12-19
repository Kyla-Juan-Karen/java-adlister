<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <%--<div>--%>
        <%--<input type="text" placeholder="Search...">--%>
    <%--</div>--%>
    <%--Edit Profile Button--%>
    <button><a href="/profile/edit"> Edit Profile</a></button>


    <div>
        <h1> Your Ads: </h1>
        <c:forEach items="${users_ads}" var="ad">
            <h2><c:out value="${ad.getTitle()}"/></h2>
            <p> <c:out value="${ad.getDescription()}"/> </p>
            <form method="get">
                <input type="submit" name="update" value="Update Ad" >
            </form>
            <form method="post">
                <input type="submit" name="delete" value="Delete Ad">
            </form>
        </c:forEach>
    </div>
</body>
</html>
