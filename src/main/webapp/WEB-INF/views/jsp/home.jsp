<html>
<head>
  <title>Home</title>
  <!-- javascript and css -->
  <%@include file="includes.jsp"%>
</head>

<body>
  <!--  Navigation -->
  <%@include file="navigation.jsp"%>
  
  <div class="container">
    <div class="jumbotron">
      <h1>Lets Explore!</h1>

      <h2>${welcomeMessage}</h2>
    
      <!--  Help module -->
      <%@include file="help.jsp"%>
      
    </div>

  </div>




</body>

</html>