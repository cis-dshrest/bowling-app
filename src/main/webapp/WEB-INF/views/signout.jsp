<html>
<head>
  <title>Sign Out</title>
  <!-- javascript and css -->
  <%@include file="includes.jsp"%>
</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <br>
  <br>
  <a href="<%=request.getContextPath()%>">Home</a> >
  <a href="signout.html">Sign Out</a>
  <br>
  <h2>Sign Out Page!</h2>

  <!--  Help module -->
  <div id="helpbox">
    <%@include file="help.jsp"%>
  </div>

</body>
</html>