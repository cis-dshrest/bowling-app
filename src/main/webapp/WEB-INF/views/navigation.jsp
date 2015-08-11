
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
<%--       <li><a href="<%=request.getContextPath()%>">Home</a></li> --%>
      <li><a href="/Exploration/about">About</a></li>
      <li><a href="/Exploration/signin">Sign In</a></li>
      <li><a href="/admin">Admin</a></li>
<!--       <li><a href="newgame.html">New Game</a></li> -->
<!--       <li><a href="viewgame.html">View Game</a></li> -->
<!--       <li><a href="signout.html">Sign Out</a></li> -->
<!--       <li><a href="profile.html">Name</a></li> -->
    </ul>
  </div>
</div>
</nav>

