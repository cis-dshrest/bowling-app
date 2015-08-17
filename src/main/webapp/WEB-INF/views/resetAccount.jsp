<html>
<head>
  <title>Reset Account</title>
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
    <a href="/Exploration/user/resetaccount">Reset Account</a>
    <br>
    <h2>Reset Account</h2>
  
    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>
    
  </div>

</body>
</html>