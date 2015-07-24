<html>
<head>
<title>Profile Page</title>
</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <br>
  <br>
  <a href="<%=request.getContextPath()%>">Home</a> >
  <a href="profile.html">Profile</a>
  <br>
  <h1>Profile Page!</h1>
    
  <!--  Help module -->
  <div id="helpbox">
    <%@include file="help.jsp"%>
  </div>
</body> 
</html>