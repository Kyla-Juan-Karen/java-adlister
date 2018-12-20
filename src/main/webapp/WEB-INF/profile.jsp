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
           <div>
               <h2> <c:out value="${ad.getTitle()}"/> </h2>
               <p> <c:out value="${ad.getDescription()}"/> </p>
               <form class= "ad_btn" action="/ad/page" method="get">
                    <button class="ad_btn" type="submit" name="title_of_ad" value="${ad.getTitle()}"> View Ad </button>
               </form>
               <form class= "ad_btn" action="/delete" method="post">
                   <button type="submit" name="delete_this_ad" value="${ad.getTitle()}">Delete Ad</button>
               </form>
           </div>
        </c:forEach>
    </div>
</body>
</html>
