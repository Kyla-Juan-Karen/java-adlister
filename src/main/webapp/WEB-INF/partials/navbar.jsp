<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
          <c:choose>
              <%--This happens when you are LOGGED IN--%>
              <c:when test="${sessionScope.loggedIn}">
                  <li><a href="/profile">Profile</a></li>
                  <li><a href="/ads">Ads</a></li>
                  <li><a href="/ads/create">Create an Ad</a></li>
                  <li><a href="/logout">Logout</a></li>
                  <%--FOR ADMINS ONLY--%>
                  <c:choose>
                      <c:when test="${sessionScope.isAdmin}">
                        <li> <a href="/admin"> Admin Page </a></li>
                     </c:when>
                  </c:choose>
              </c:when>

              <%--This happens when you are LOGGED OUT--%>
              <c:otherwise>
                  <li><a href="/ads">Ads</a></li>
                  <li><a href="/register"> Register </a> </li>
                  <li><a href="/login">Login</a></li>
              </c:otherwise>
          </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
