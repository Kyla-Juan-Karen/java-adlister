<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="This Ad"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container">
        <h1> <c:out value="${this_ad.getTitle()}"/> </h1>
        <h3> By: <c:out value="${ads_user.getUsername()}"/> </h3>
        <p style="display:none"> <c:out value="${this_ad.getId()}"/> </p>
        <p> <c:out value="${this_ad.getDescription()}"/> </p>
       <c:choose>
           <c:when test="">
               <form class= "ad_btn" action="/edit" method="get">
                   <button type="submit" name="edit_this_ad" value="${this_ad.getTitle()}">Edit Ad</button>
               </form>
           </c:when>
       </c:choose>
    </div>
</body>
</html>