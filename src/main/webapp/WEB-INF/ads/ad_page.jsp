<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="This Ad"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp"/>

    <h1> <c:out value="${this_ad.getTitle()}"/> </h1>
    <h3> By: <c:out value="${ads_user.getUsername()}"/> </h3>
    <p> <c:out value="${this_ad.getDescription()}"/> </p>
    <form class= "ad_btn" action="/update" method="post">
        <button type="submit" name="update_this_ad" value="${ad.getTitle()}">Update Ad</button>
    </form>
</body>
</html>