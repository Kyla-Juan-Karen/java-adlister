<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>

         <form class= "ad_btn" action="/ad/page" method="get">
            <button class="ad_btn" type="submit" name="title_of_ad" value="${ad.getTitle()}"> View Ad </button>
         </form>
        <form method="get">
            <input type="submit" name="update" value="Update Ad" >
        </form>
        <form method="post">
            <input type="submit" name="delete" value="Delete Ad">
        </form>

        </div>
    </c:forEach>
</div>

</body>
</html>
