<html>
<head>
  <title>Sign In<title>
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
    <a href="signin.html">Sign In</a>
    <br>
    <h2>Sign In Page!</h2>
    
    <br>
    
    <!-- Sign in -->
    <!-- ---------------------------------------------------------------------------------------------------- -->
    <form class="form-signin" action="/Exploration/profile.html">
      <h2 class="form-signin-heading">Please sing in</h2>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <br>
      <button class="btn btn-lg btn-link">Forgot Password?</button>
      <button class="btn btn-lg btn-success">Register</button>
      
    </form>
    
    <!-- ---------------------------------------------------------------------------------------------------- -->
    
    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>
    <!-- ---------------------------------------------------------------------------------------------------- -->
    
  </div>
</body>
</html>