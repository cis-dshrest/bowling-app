<html>
<head>
  <title>Sign In</title>
  <!-- javascript and css -->
  <%@include file="includes.jsp"%>
</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>
  
  <div class="container">
  
    <br>
    <br>
    <a href="<%=request.getContextPath()%>">Home</a> >
    <a href="/Exploration/signin">Sign In</a>
    <br>
    <h2>Sign In Page!</h2>
    
    <br>
    
    <!-- Sign in -->
    <!-- ---------------------------------------------------------------------------------------------------- -->
    <form class="form-signin" action="/Exploration/signin" method="POST">
      <h2 class="form-signin-heading">Please sing in</h2>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="text" id="usernameText" class="form-control" placeholder="Username" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
      
      <button class="btn btn-lg btn-primary btn-block" style="width:auto;" type="submit">Sign in</button>
      <br>
    </form>
    
    <div class="center">
    <a href="/Exploration/resetaccount">Can't access your account?</a>
    <br>
    <br>
    <a href="<c:url value="/register" />">Register</a>
    </div>
    <!-- ---------------------------------------------------------------------------------------------------- -->
    
    <!--  Help module -->
    <div id="helpbox" class="center">
      <%@include file="help.jsp"%>
    </div>
    <!-- ---------------------------------------------------------------------------------------------------- -->
    
  </div>
</body>
</html>