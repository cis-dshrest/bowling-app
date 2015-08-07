<html>
<head>
  <title>View Game</title>
  <!-- javascript and css -->
  <%@include file="includes.jsp"%>
</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <br>
  <br>
  <a href="<%=request.getContextPath()%>">Home</a> >
  <a href="viewgame.html">View Game</a>
  <br>
  <h2>Sign In Page!</h2>

  <!--  Help module -->
  <div id="helpbox">
    <%@include file="help.jsp"%>
  </div>

</body>

</html>