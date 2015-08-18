<html>
<head>
  <title>Play Game</title>
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
    <a href="/user/game/play">Play Game</a>
    <br>
    
  
    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>
  </div>

</body>
</html>