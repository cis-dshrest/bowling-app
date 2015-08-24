<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
nav>ul { list-style-type:none;
    margin: 0;
    padding: 0;
  }
  
nav ul>li {
    display: inline;
}
</style>

<!-- static navbar -->
<nav class="navbar navbar-default navbar-static-top">
<div class="container">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="<%=request.getContextPath()%>">Exploratory Testing</a>
  </div>
  
  <div id="navbar" class="navbar-collapse collapse">
    <ul class="nav navbar-nav">
      
      <li><a href="/Exploration/about">About</a></li>
      <c:choose>
        <c:when test="${sessionScope.role != null}">
          <li><a href="/Exploration/user/profile">Profile</a></li>
          <li><a href="/Exploration/user/game/new">Create Game</a></li>
        </c:when>
        <c:otherwise>
          <li><a href="/Exploration/login">Sign In</a></li>
        </c:otherwise>
      </c:choose>
      <c:if test="${sessionScope.role == 'admin'}">
        <li><a href="/Exploration/admin/listusers">Edit Users</a></li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${sessionScope.role != null}">
        <li><a href="/Exploration/user/logout">Logout</a></li>
      </c:if>
    </ul>
    
  </div>
</div>
</nav>

