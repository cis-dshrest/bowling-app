<html>
<head>
<title>New Game</title>
</head>

<body>

  <!--  Navigation -->
  <%@include file="navigation.jsp"%>

  <br>
  <br>
  <a href="<%=request.getContextPath()%>">Home</a> >
  <a href="newgame.html">New Game</a>
  <br>
  <h2>New Game Page!</h2>
  
  <!--  Help module -->
  <div id="helpbox">
    <%@include file="help.jsp"%>
  </div>
  
</body>
</html>