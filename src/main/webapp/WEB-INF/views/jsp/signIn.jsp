<html>
<head>
<title>Sign In Page</title>
</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <br>
  <br>
  <a href="<%=request.getContextPath()%>">Home</a> >
  <a href="signin.html">Sign In</a>
  <br>
  <h2>Sign In Page!</h2>
    
  <!--  Help module -->
  <div id="helpbox">
    <%@include file="help.jsp"%>
  </div>
  
</body> 
</html>