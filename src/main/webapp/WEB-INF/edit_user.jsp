<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit User"/>
    </jsp:include>
</head>
    <jsp:include page="partials/navbar.jsp"/>

   <c:choose>
       <c:when test="${form_error}">
           <h3 style="color:red"> Something went wrong, yo! Make sure your passwords match 'n stuff, dude.</h3>
       </c:when>
   </c:choose>

    <form method="post">
        <label for="new_username"> New Username: </label>
        <input type="text" name="new_username" id="new_username"/>
        <label for="new_password"> New Password: </label>
        <input type="text" name="new_password" id="new_password"/>
        <label for="confirm_new_password"> Confirm New Password: </label>
        <input type="text" name="new_password" id="confirm_new_password"/>
        <label for="new_email"> New Email: </label>
        <input type="email" id="new_email" name="new_email">
        <button type="submit"> Done! </button>
    </form>



</html>