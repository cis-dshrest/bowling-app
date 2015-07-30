<html>
<head>
  <title>Profile Page</title>
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
    <a href="profile.html">Profile</a>
    <br>
    <h1>Profile Page!</h1>
  
    <!--  Help module -->
    <div id="helpbox">
      <%@include file="help.jsp"%>
    </div>
  
  </div>

</body>
</html>